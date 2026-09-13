// This file parses the input query - with the Visitor pattern.

package com.kaustabhinand.filefind.eval;

import com.kaustabhinand.filefind.model.ExprCondition;
import com.kaustabhinand.filefind.filefindBaseVisitor;
import com.kaustabhinand.filefind.filefindParser;

import java.util.*;
public class evalvisitor extends filefindBaseVisitor<Object> {
    private  String searchpath = ".";
    private  String filename = null;
    public String getSearchPath() {return searchpath;}
    public String getFilename() {return filename;}

    private List<ExprCondition> conditions = new ArrayList<>();
    public List<ExprCondition> getConditions() {return conditions;}

    @Override
    public Object visitQuery(filefindParser.QueryContext ctx) {
        // Implementation for visiting Query nodes

        if(ctx.FILE() != null) { // FILE keyword is given.
            if(ctx.FROM() != null) {
                if (ctx.STRING(0) == null) {
                    throw new IllegalArgumentException(
                            "Malformed query: expected a path after 'from'.");
                }
                searchpath = ctx.STRING(0).getText().replace("'", "");
            }

            else {
                searchpath = "."; // current directory, by default - avoids accidental full-tree scans
            }
        }

        else {
            if (ctx.STRING(0) == null) {
                throw new IllegalArgumentException(
                        "Malformed query: expected a quoted filename after 'find'.");
            }
            filename = ctx.STRING(0).getText().replace("'", "");

            if(ctx.FROM() != null) {
                if (ctx.STRING(1) == null) {
                    throw new IllegalArgumentException(
                            "Malformed query: expected a path after 'from'.");
                }
                searchpath = ctx.STRING(1).getText().replace("'", "");
            }
        }

        return visitChildren(ctx);
    }


    @Override
    public Object visitExpr(filefindParser.ExprContext ctx) {
        // The logop (and/or/not/nor) that joins THIS condition to the next
        // one, if this expr alternative has a trailing "logop expr".
        String joinOp = (ctx.logop() != null) ? ctx.logop().getText() : null;

        if(ctx.EXT() != null) { // Extension is given
            if (ctx.relop() == null || ctx.value() == null) {
                throw new IllegalArgumentException(
                        "Malformed query: 'ext' requires an operator and a value.");
            }
            String op = ctx.relop().getText();
            String value = ctx.value().getText().replace("'", "");
            conditions.add(new ExprCondition("ext", op, value, joinOp));
        }

        if(ctx.SIZE() != null) { // Size is given
            if (ctx.relop() == null || ctx.NUMBER() == null) {
                throw new IllegalArgumentException(
                        "Malformed query: 'size' requires an operator and a number.");
            }
            String op = ctx.relop().getText();
            String value = ctx.NUMBER().getText();
            conditions.add(new ExprCondition("size", op, value, joinOp));
        }

        if(ctx.CREATED() != null && ctx.RECENTLY() != null) { // Recently is given.
            conditions.add(new ExprCondition("created", "=", "recently", joinOp));
        }

        if(ctx.CREATED() != null && ctx.RECENTLY() == null) { // Time is mentioned.
            if (ctx.relop() == null || ctx.time() == null) {
                throw new IllegalArgumentException(
                        "Malformed query: 'created' requires an operator and a time value.");
            }
            String op = ctx.relop().getText();
            String time = ctx.time().getText();
            conditions.add(new ExprCondition("created", op, time, joinOp));
        }

        if(ctx.CONTAINS() != null) { // Contains is given.
            if (ctx.value() == null) {
                throw new IllegalArgumentException(
                        "Malformed query: 'contains' requires a value.");
            }
            String value = ctx.value().getText().replace("'", "");
            conditions.add(new ExprCondition("contains", "contains", value, joinOp));
        }

        if(ctx.DATE_MODIFIED() != null) { // Date modified is given.
            if (ctx.relop() == null || ctx.time() == null) {
                throw new IllegalArgumentException(
                        "Malformed query: 'date-modified' requires an operator and a time value.");
            }
            String op = ctx.relop().getText();
            String date_modified = ctx.time().getText();
            conditions.add(new ExprCondition("date_modified", op, date_modified, joinOp));
        }

        return visitChildren(ctx);
    }
}