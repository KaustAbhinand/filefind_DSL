// Generated from com/kaustabhinand/filefind/filefind.g4 by ANTLR 4.13.2
package com.kaustabhinand.filefind;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link filefindParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface filefindVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link filefindParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(filefindParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link filefindParser#subject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject(filefindParser.SubjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link filefindParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(filefindParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link filefindParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(filefindParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link filefindParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(filefindParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondExpr}
	 * labeled alternative in {@link filefindParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpr(filefindParser.CondExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link filefindParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(filefindParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExtCond}
	 * labeled alternative in {@link filefindParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtCond(filefindParser.ExtCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NameCond}
	 * labeled alternative in {@link filefindParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameCond(filefindParser.NameCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SizeCond}
	 * labeled alternative in {@link filefindParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeCond(filefindParser.SizeCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CreatedCond}
	 * labeled alternative in {@link filefindParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatedCond(filefindParser.CreatedCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecentCond}
	 * labeled alternative in {@link filefindParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecentCond(filefindParser.RecentCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModifiedCond}
	 * labeled alternative in {@link filefindParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiedCond(filefindParser.ModifiedCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link filefindParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(filefindParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by {@link filefindParser#nameop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameop(filefindParser.NameopContext ctx);
	/**
	 * Visit a parse tree produced by {@link filefindParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(filefindParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link filefindParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(filefindParser.TimeContext ctx);
}