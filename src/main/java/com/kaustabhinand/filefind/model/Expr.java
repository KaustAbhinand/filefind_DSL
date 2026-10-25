package com.kaustabhinand.filefind.model;

import java.util.function.Predicate;

/** A boolean expression tree evaluated against one file. */
public interface Expr {
    boolean eval(FileInfo file);

    record Cond(String description, Predicate<FileInfo> test) implements Expr {
        public boolean eval(FileInfo f) { return test.test(f); }
        @Override public String toString() { return description; }
    }

    record Not(Expr operand) implements Expr {
        public boolean eval(FileInfo f) { return !operand.eval(f); }
        @Override public String toString() { return "not (" + operand + ")"; }
    }

    record And(Expr left, Expr right) implements Expr {
        public boolean eval(FileInfo f) { return left.eval(f) && right.eval(f); }
        @Override public String toString() { return "(" + left + " and " + right + ")"; }
    }

    record Or(Expr left, Expr right) implements Expr {
        public boolean eval(FileInfo f) { return left.eval(f) || right.eval(f); }
        @Override public String toString() { return "(" + left + " or " + right + ")"; }
    }
}