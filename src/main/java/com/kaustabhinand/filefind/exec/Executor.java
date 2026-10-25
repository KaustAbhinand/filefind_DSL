package com.kaustabhinand.filefind.exec;

import com.kaustabhinand.filefind.model.Expr;
import com.kaustabhinand.filefind.model.FileInfo;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public class Executor {

    /**
     * Walks the tree and calls onMatch for every matching file as soon as it is found.
     * Returns the total number of matches.
     * onMatch may be called from several threads at once, so it must be thread-safe
     * (System.out::println is).
     */
    public static long execute(String searchpath, String filename, Expr filter,
                               Consumer<String> onMatch) {
        Path root = Paths.get(searchpath);
        if (!Files.isDirectory(root)) {
            throw new IllegalArgumentException("Invalid search path: " + searchpath);
        }

        AtomicLong count = new AtomicLong();
        Consumer<String> counting = hit -> {
            count.incrementAndGet();
            onMatch.accept(hit);
        };

        collectFiles(root, counting, filename, filter);
        return count.get();
    }

    private static void collectFiles(Path dir, Consumer<String> onMatch, String filename, Expr filter) {
        List<Path> subDirs = new ArrayList<>();
        List<Path> files = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                try {
                    if (Files.isDirectory(entry)) {
                        subDirs.add(entry);
                    } else {
                        files.add(entry);
                    }
                } catch (Exception e) {
                    // Can't stat this entry (broken junction, permission quirk) - skip it
                }
            }
        } catch (IOException | SecurityException | DirectoryIteratorException e) {
            // Can't list this directory at all (AccessDeniedException, etc.) - skip it entirely
            return;
        }

        files.parallelStream().forEach(path -> {
            try {
                if (matches(path, filename, filter)) {
                    onMatch.accept(path.toAbsolutePath().toString());
                }
            } catch (Exception e) {
                // Skip files we can't read attributes for
            }
        });

        subDirs.parallelStream().forEach(sub -> {
            try {
                collectFiles(sub, onMatch, filename, filter);
            } catch (Exception e) {
                // Defensive: a stray exception in recursion never bubbles up
            }
        });
    }

    /** Exact filename check (case-insensitive) first, then the filter tree, if any. */
    public static boolean matches(Path path, String filename, Expr filter) {
        if (filename != null && !path.getFileName().toString().equalsIgnoreCase(filename)) {
            return false;
        }
        return filter == null || filter.eval(new FileInfo(path));
    }
}