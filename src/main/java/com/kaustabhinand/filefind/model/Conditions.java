package com.kaustabhinand.filefind.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Function;
import java.util.regex.Pattern;

/** Builds the leaf conditions of an Expr tree. All matching semantics live here. */
public final class Conditions {
    private Conditions() {}

    // ---------- ext ----------

    public static Expr ext(String op, String value) {
        String wanted = value.startsWith(".") ? value.substring(1) : value;
        boolean eq = op.equals("=");
        return new Expr.Cond("ext " + op + " " + wanted,
                f -> f.extension().equalsIgnoreCase(wanted) == eq);
    }

    // ---------- name ----------

    public static Expr name(String op, String value) {
        boolean eq = op.equals("=");
        return new Expr.Cond("name " + op + " '" + value + "'",
                f -> f.name().equalsIgnoreCase(value) == eq);
    }

    public static Expr nameContains(String value) {
        String needle = value.toLowerCase();
        return new Expr.Cond("name contains '" + value + "'",
                f -> f.name().toLowerCase().contains(needle));
    }

    /**
     * Case-insensitive. Wildcards: % or * = any run of characters, ? = one character.
     * With no wildcards the pattern behaves like "contains".
     */
    public static Expr nameLike(String pattern) {
        if (pattern.indexOf('%') < 0 && pattern.indexOf('*') < 0 && pattern.indexOf('?') < 0) {
            String needle = pattern.toLowerCase();
            return new Expr.Cond("name like '" + pattern + "'",
                    f -> f.name().toLowerCase().contains(needle));
        }
        Pattern regex = globToRegex(pattern);
        return new Expr.Cond("name like '" + pattern + "'",
                f -> regex.matcher(f.name()).matches());
    }

    // ---------- size ----------

    public static Expr size(String op, double bytes) {
        return new Expr.Cond("size " + op + " " + bytes, f -> compare(f.size(), op, bytes));
    }

    // ---------- dates ----------

    public static Expr created(String op, Period span, String label) {
        return age("created", FileInfo::created, op, span, label);
    }

    public static Expr modified(String op, Period span, String label) {
        return age("date-modified", FileInfo::modified, op, span, label);
    }

    public static Expr createdRecently() {
        return age("created", FileInfo::created, "<=", Period.ofDays(15), "recently (15 days)");
    }

    /**
     * Operators compare the file's AGE to the span:
     *   created < 30 days   -> created within the last 30 days
     *   created > 30 days   -> created more than 30 days ago
     *   created = 30 days   -> created on the calendar day 30 days ago
     * The cutoff is fixed when the query is built, so every file is judged against the same "now".
     */
    private static Expr age(String field, Function<FileInfo, Instant> timeOf,
                            String op, Period span, String label) {
        ZonedDateTime cutoff = ZonedDateTime.now().minus(span);
        Instant cutoffInstant = cutoff.toInstant();
        LocalDate cutoffDate = cutoff.toLocalDate();
        ZoneId zone = cutoff.getZone();

        return new Expr.Cond(field + " " + op + " " + label, f -> {
            Instant t = timeOf.apply(f);
            return switch (op) {
                case "<"  -> t.isAfter(cutoffInstant);
                case "<=" -> !t.isBefore(cutoffInstant);
                case ">"  -> t.isBefore(cutoffInstant);
                case ">=" -> !t.isAfter(cutoffInstant);
                case "="  -> t.atZone(zone).toLocalDate().equals(cutoffDate);
                case "!=" -> !t.atZone(zone).toLocalDate().equals(cutoffDate);
                default   -> throw new IllegalArgumentException("Unknown operator: " + op);
            };
        });
    }

    // ---------- helpers ----------

    private static boolean compare(double a, String op, double b) {
        return switch (op) {
            case "="  -> a == b;
            case "!=" -> a != b;
            case ">"  -> a > b;
            case ">=" -> a >= b;
            case "<"  -> a < b;
            case "<=" -> a <= b;
            default   -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
    }

    private static Pattern globToRegex(String glob) {
        StringBuilder sb = new StringBuilder();
        for (char c : glob.toCharArray()) {
            switch (c) {
                case '%', '*' -> sb.append(".*");
                case '?'      -> sb.append('.');
                default       -> sb.append(Pattern.quote(String.valueOf(c)));
            }
        }
        return Pattern.compile(sb.toString(), Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    }
}