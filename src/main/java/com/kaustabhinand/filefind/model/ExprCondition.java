package com.kaustabhinand.filefind.model;

public class ExprCondition {
    public String Field;
    public String Operator;
    public String Value;

    // The logical operator (and/or/not/nor) joining this condition to the
    // NEXT condition in the list. Null/absent for the first condition,
    // since there's nothing before it to join.
    public String JoinOp;

    public ExprCondition(String field, String operator, String value) {
        this.Field = field;
        this.Operator = operator;
        this.Value = value;
        this.JoinOp = null;
    }

    public ExprCondition(String field, String operator, String value, String joinOp) {
        this.Field = field;
        this.Operator = operator;
        this.Value = value;
        this.JoinOp = joinOp;
    }

    public String toString() {
        if (JoinOp != null) {
            return String.format("%s %s %s (joined by %s)", Field, Operator, Value, JoinOp);
        }
        return String.format("%s %s %s", Field, Operator, Value);
    }
}