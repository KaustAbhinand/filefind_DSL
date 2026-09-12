package com.kaustabhinand.filefind.exec;

import com.kaustabhinand.filefind.model.ExprCondition;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Executor {

    public static List<String> execute(String searchpath, String filename, List<ExprCondition> conditions) {
        Path root = Paths.get(searchpath);
        if (!Files.isDirectory(root)) {
            System.out.println("Invalid search path: " + searchpath);
            return List.of();
        }

        List<String> results = Collections.synchronizedList(new ArrayList<>());
        collectFiles(root, results, filename, conditions);
        return results;
    }

    /**
     * Recursively walks a directory tree, evaluating files in parallel at
     * each level and recursing into subdirectories in parallel. Every
     * failure point (listing a directory, statting an entry, matching a
     * file) is caught locally so one inaccessible directory/file never
     * kills the rest of the walk - this is what lets it run fully
     * un-elevated against paths like C:\Users.
     */
    private static void collectFiles(Path dir, List<String> results, String filename, List<ExprCondition> conditions) {
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

        List<String> matched = files.parallelStream()
                .map(path -> {
                    try {
                        File file = path.toFile();
                        if (matches(file, filename, conditions)) {
                            return file.getAbsolutePath();
                        }
                    } catch (Exception e) {
                        // Skip files we can't read attributes for
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        results.addAll(matched);

        subDirs.parallelStream().forEach(sub -> {
            try {
                collectFiles(sub, results, filename, conditions);
            } catch (Exception e) {
                // Defensive: ensures a stray exception in recursion never bubbles up
            }
        });
    }

    public static boolean matches(File file, String filename, List<ExprCondition> conditions) {
        if (filename != null && !file.getName().equals(filename)) {
            return false;
        }

        for (ExprCondition condition : conditions) {
            switch (condition.Field) {

                case "ext":
                    String ext = getFileExtension(file);
                    if (!evaluateCondition(ext, condition.Operator, condition.Value)) {
                        return false;
                    }
                    break;

                case "contains":
                    if (!file.getName().contains(condition.Value)) {
                        return false;
                    }
                    break;

                case "size":
                    long size = file.length();
                    if (!evaluateCondition(String.valueOf(size), condition.Operator, condition.Value)) {
                        return false;
                    }
                    break;

                case "created":
                    long createdTime = file.lastModified();
                    if (condition.Value.equals("recently")) {
                        long targetTime = System.currentTimeMillis() - (15L * 24 * 60 * 60 * 1000);
                        if (createdTime < targetTime) {
                            return false;
                        }
                    } else {
                        long targetTime = Long.parseLong(condition.Value);
                        if (!evaluateCondition(String.valueOf(createdTime), condition.Operator, String.valueOf(targetTime))) {
                            return false;
                        }
                    }
                    break;

                case "date_modified":
                    long modifiedTime = file.lastModified();
                    if (!evaluateCondition(String.valueOf(modifiedTime), condition.Operator, condition.Value)) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    public static boolean evaluateCondition(String parameter, String Operator, String value) {
        switch (Operator) {
            case "=":
                try { return Long.parseLong(parameter) == Long.parseLong(value); }
                catch (NumberFormatException e) { return parameter.equals(value); }
            case "!=":
                return Long.parseLong(parameter) != Long.parseLong(value);
            case ">":
                return Long.parseLong(parameter) > Long.parseLong(value);
            case ">=":
                return Long.parseLong(parameter) >= Long.parseLong(value);
            case "<":
                return Long.parseLong(parameter) < Long.parseLong(value);
            case "<=":
                return Long.parseLong(parameter) <= Long.parseLong(value);
            default:
                return false;
        }
    }

    public static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndex = name.lastIndexOf('.');
        if (lastIndex > 0 && lastIndex < name.length() - 1) {
            return name.substring(lastIndex + 1);
        }
        return "";
    }
}