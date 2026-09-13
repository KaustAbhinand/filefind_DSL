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

    /**
     * Evaluates whether a file matches the full condition list.
     *
     * Each ExprCondition is evaluated independently as a single boolean.
     * Conditions are then folded left-to-right using each condition's
     * JoinOp (the and/or/not/nor that follows it in the original query),
     * so "ext = pdf or ext = jpg" correctly matches either extension
     * instead of being (incorrectly) ANDed together.
     *
     * Fold semantics, applied pairwise left-to-right:
     *   AND: both sides true
     *   OR:  at least one side true
     *   NOT: left true and right false ("left and not right")
     *   NOR: neither side true
     */
    public static boolean matches(File file, String filename, List<ExprCondition> conditions) {
        if (filename != null && !file.getName().equals(filename)) {
            return false;
        }

        if (conditions.isEmpty()) {
            return true;
        }

        boolean result = evaluateSingle(file, conditions.get(0));

        for (int i = 0; i < conditions.size() - 1; i++) {
            ExprCondition current = conditions.get(i);
            ExprCondition next = conditions.get(i + 1);
            boolean nextResult = evaluateSingle(file, next);

            String joinOp = current.JoinOp;
            if (joinOp == null) {
                // No explicit operator between consecutive conditions defaults to AND
                joinOp = "and";
            }

            switch (joinOp) {
                case "and":
                    result = result && nextResult;
                    break;
                case "or":
                    result = result || nextResult;
                    break;
                case "not":
                    result = result && !nextResult;
                    break;
                case "nor":
                    result = !(result || nextResult);
                    break;
                default:
                    // Unknown operator - fail safe by treating as AND
                    result = result && nextResult;
                    break;
            }
        }

        return result;
    }

    /**
     * Evaluates a single condition against a file, independent of any
     * other conditions in the list.
     */
    private static boolean evaluateSingle(File file, ExprCondition condition) {
        switch (condition.Field) {

            case "ext":
                String ext = getFileExtension(file);
                return evaluateCondition(ext, condition.Operator, condition.Value);

            case "contains":
                return file.getName().contains(condition.Value);

            case "size":
                long size = file.length();
                return evaluateCondition(String.valueOf(size), condition.Operator, condition.Value);

            case "created":
                long createdTime = file.lastModified();
                if (condition.Value.equals("recently")) {
                    long targetTime = System.currentTimeMillis() - (15L * 24 * 60 * 60 * 1000);
                    return createdTime >= targetTime;
                } else {
                    long targetTime = Long.parseLong(condition.Value);
                    return evaluateCondition(String.valueOf(createdTime), condition.Operator, String.valueOf(targetTime));
                }

            case "date_modified":
                long modifiedTime = file.lastModified();
                return evaluateCondition(String.valueOf(modifiedTime), condition.Operator, condition.Value);

            default:
                return false;
        }
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