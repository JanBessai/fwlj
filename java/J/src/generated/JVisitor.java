// Generated from J.g4 by ANTLR 4.9.2
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JParser#x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX(JParser.XContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(JParser.TContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#l}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitL(JParser.LContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#eAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEAtom(JParser.EAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(JParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(JParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(JParser.EContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#mCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMCall(JParser.MCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(JParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#gens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGens(JParser.GensContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#gensT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGensT(JParser.GensTContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#mDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMDec(JParser.MDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#mH}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMH(JParser.MHContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(JParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#nudeE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNudeE(JParser.NudeEContext ctx);
}