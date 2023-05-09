// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(CalculatorParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(CalculatorParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(CalculatorParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(CalculatorParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#exponentialExpression}.
	 * @param ctx the parse tree
	 */
	void enterExponentialExpression(CalculatorParser.ExponentialExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#exponentialExpression}.
	 * @param ctx the parse tree
	 */
	void exitExponentialExpression(CalculatorParser.ExponentialExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(CalculatorParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(CalculatorParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#numberExpression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(CalculatorParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#numberExpression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(CalculatorParser.NumberExpressionContext ctx);
}