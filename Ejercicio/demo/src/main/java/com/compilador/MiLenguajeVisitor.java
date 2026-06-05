// Generated from com\compilador\MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiLenguajeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiLenguajeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(MiLenguajeParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#unidad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnidad(MiLenguajeParser.UnidadContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(MiLenguajeParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(MiLenguajeParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(MiLenguajeParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(MiLenguajeParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(MiLenguajeParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#declaracion_sin_pyc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion_sin_pyc(MiLenguajeParser.Declaracion_sin_pycContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(MiLenguajeParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(MiLenguajeParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(MiLenguajeParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#asignacion_sin_pyc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion_sin_pyc(MiLenguajeParser.Asignacion_sin_pycContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#sentenciaIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaIf(MiLenguajeParser.SentenciaIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#sentenciaWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#sentenciaDoWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaDoWhile(MiLenguajeParser.SentenciaDoWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#sentenciaFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaFor(MiLenguajeParser.SentenciaForContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#sentenciaSwitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaSwitch(MiLenguajeParser.SentenciaSwitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(MiLenguajeParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#sentenciaReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaReturn(MiLenguajeParser.SentenciaReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#sentenciaBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaBreak(MiLenguajeParser.SentenciaBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#sentenciaContinue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaContinue(MiLenguajeParser.SentenciaContinueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#sentenciaPrint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaPrint(MiLenguajeParser.SentenciaPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(MiLenguajeParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(MiLenguajeParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Modulo}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulo(MiLenguajeParser.ModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinus(MiLenguajeParser.UnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOr(MiLenguajeParser.LogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MiLenguajeParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalNot}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalNot(MiLenguajeParser.LogicalNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(MiLenguajeParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(MiLenguajeParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Primary}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MiLenguajeParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAnd(MiLenguajeParser.LogicalAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(MiLenguajeParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(MiLenguajeParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Inequality}
	 * labeled alternative in {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInequality(MiLenguajeParser.InequalityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link MiLenguajeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MiLenguajeParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayAccess}
	 * labeled alternative in {@link MiLenguajeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(MiLenguajeParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link MiLenguajeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MiLenguajeParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link MiLenguajeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(MiLenguajeParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecLiteral}
	 * labeled alternative in {@link MiLenguajeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecLiteral(MiLenguajeParser.DecLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharLiteral}
	 * labeled alternative in {@link MiLenguajeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(MiLenguajeParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link MiLenguajeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(MiLenguajeParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link MiLenguajeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpr(MiLenguajeParser.ParenthesizedExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken(MiLenguajeParser.TokenContext ctx);
}