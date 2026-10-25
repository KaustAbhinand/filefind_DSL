// This file turns the parse tree into a search path, an optional filename, and an Expr tree.
// Traverse the visitor pattern.

package com.kaustabhinand.filefind.eval;

import com.kaustabhinand.filefind.filefindBaseVisitor;
import com.kaustabhinand.filefind.filefindParser;
import com.kaustabhinand.filefind.model.Conditions;
import com.kaustabhinand.filefind.model.Expr;
import org.antlr.v4.runtime.tree.ParseTree;

import java.time.Period;

public class evalvisitor extends filefindBaseVisitor<Object> {
    private String searchpath = ".";   // current directory by default - avoids accidental full-tree scans
    private String filename = null;
    private Expr filter = null;

    public String getSearchPath() { return searchpath; }
    public String getFilename()   { return filename; }
    public Expr getFilter()       { return filter; }

    // ---------- query ----------

    @Override
    public Object visitQuery(filefindParser.QueryContext ctx) {
        // 'find <subject>': either the keyword 'file' or a quoted exact filename
        if (ctx.subject().STRING() != null) {
            filename = unquote(ctx.subject().STRING().getText());
        }
        // The only STRING directly under query is the 'from' path
        if (ctx.STRING() != null) {
            searchpath = unquote(ctx.STRING().getText());
        }
        // Covers both 'where expr' and 'begin expr end'
        if (ctx.expr() != null) {
            filter = (Expr) visit((ParseTree) ctx.expr());
        }
        return null;
    }

    // ---------- logical structure ----------

    @Override
    public Object visitNotExpr(filefindParser.NotExprContext ctx) {
        return new Expr.Not((Expr) visit(ctx.expr()));
    }

    @Override
    public Object visitAndExpr(filefindParser.AndExprContext ctx) {
        return new Expr.And((Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)));
    }

    @Override
    public Object visitOrExpr(filefindParser.OrExprContext ctx) {
        return new Expr.Or((Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)));
    }

    @Override
    public Object visitParenExpr(filefindParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Object visitCondExpr(filefindParser.CondExprContext ctx) {
        return visit(ctx.cond());
    }

    // ---------- conditions ----------

    @Override
    public Object visitExtCond(filefindParser.ExtCondContext ctx) {
        String op = ctx.relop().getText();
        if (!op.equals("=") && !op.equals("!=")) {
            throw new IllegalArgumentException(
                    "'ext' only supports '=' and '!=' (got '" + op + "').");
        }
        return Conditions.ext(op, unquote(ctx.value().getText()));
    }

    @Override
    public Object visitNameCond(filefindParser.NameCondContext ctx) {
        String op = ctx.nameop().getText();
        String value = unquote(ctx.value().getText());
        return switch (op) {
            case "="        -> Conditions.name("=", value);
            case "!="       -> Conditions.name("!=", value);
            case "contains" -> Conditions.nameContains(value);
            case "like"     -> Conditions.nameLike(value);
            default -> throw new IllegalArgumentException("Unknown name operator: " + op);
        };
    }

    @Override
    public Object visitSizeCond(filefindParser.SizeCondContext ctx) {
        return Conditions.size(ctx.relop().getText(),
                Double.parseDouble(ctx.NUMBER().getText()));
    }

    @Override
    public Object visitCreatedCond(filefindParser.CreatedCondContext ctx) {
        Span s = span(ctx.time());
        return Conditions.created(ctx.relop().getText(), s.period(), s.label());
    }

    @Override
    public Object visitRecentCond(filefindParser.RecentCondContext ctx) {
        return Conditions.createdRecently();
    }

    @Override
    public Object visitModifiedCond(filefindParser.ModifiedCondContext ctx) {
        Span s = span(ctx.time());
        return Conditions.modified(ctx.relop().getText(), s.period(), s.label());
    }

    // ---------- helpers ----------

    private record Span(Period period, String label) {}

    private static Span span(filefindParser.TimeContext t) {
        String raw = t.NUMBER().getText();
        int n;
        try {
            n = Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Time amounts must be whole numbers, got '" + raw + "'.");
        }
        if (t.MONS() != null) return new Span(Period.ofMonths(n), n + " months");
        if (t.YRS() != null)  return new Span(Period.ofYears(n),  n + " years");
        return new Span(Period.ofDays(n), n + " days");   // DAYS, or the default if the unit becomes optional
    }

    private static String unquote(String s) {
        if (s.length() >= 2 && s.startsWith("'") && s.endsWith("'")) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }
}

