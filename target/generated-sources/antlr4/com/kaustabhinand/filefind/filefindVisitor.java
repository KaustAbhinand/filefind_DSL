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
	 * Visit a parse tree produced by {@link filefindParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(filefindParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link filefindParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(filefindParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by {@link filefindParser#logop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogop(filefindParser.LogopContext ctx);
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