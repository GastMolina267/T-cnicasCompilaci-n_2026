package com.compilador;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CodigoVisitor extends MiLenguajeBaseVisitor<String> {
    private List<Instruccion> instrucciones;
    private int tempCounter;
    private int labelCounter;
    private Stack<String> loopStartLabels;
    private Stack<String> loopEndLabels;

    public CodigoVisitor() {
        this.instrucciones = new ArrayList<>();
        this.tempCounter = 1;
        this.labelCounter = 1;
        this.loopStartLabels = new Stack<>();
        this.loopEndLabels = new Stack<>();
    }

    public List<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    private String newTemp() {
        return "t" + (tempCounter++);
    }

    private String newLabel() {
        return "L" + (labelCounter++);
    }

    private void emit(String op, String arg1, String arg2, String result) {
        instrucciones.add(new Instruccion(op, arg1, arg2, result));
    }

    private void emitLabel(String label) {
        emit("LABEL", "", "", label);
    }

    private void emitComment(String comment) {
        emit("COMMENT", "", "", "// " + comment);
    }

    @Override
    public String visitPrograma(MiLenguajeParser.ProgramaContext ctx) {
        emitComment("Código de tres direcciones generado");
        emitLabel("PROGRAMA_INICIO");
        super.visitPrograma(ctx);
        emitLabel("PROGRAMA_FIN");
        return null;
    }

    @Override
    public String visitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx) {
        String id = ctx.ID().getText();
        emit("FUNC_START", "", "", "func_" + id);

        // Emitir parámetros dentro de la función
        if (ctx.parametros() != null) {
            for (MiLenguajeParser.ParametroContext pCtx : ctx.parametros().parametro()) {
                String pType = pCtx.tipo().getText();
                String pId = pCtx.ID().getText();
                emit("PARAM", pId + " " + pType, "", "");
            }
        }

        // Visitar instrucciones del cuerpo directamente
        if (ctx.bloque() != null) {
            for (MiLenguajeParser.InstruccionContext inst : ctx.bloque().instruccion()) {
                visit(inst);
            }
        }

        emit("FUNC_END", "", "", "func_" + id);
        return null;
    }

    @Override
    public String visitDeclaracion(MiLenguajeParser.DeclaracionContext ctx) {
        String id = ctx.ID().getText();
        String type = ctx.tipo().getText();
        String size = "-1";

        if (ctx.CA() != null) {
            size = ctx.INTEGER().getText();
        }

        emit("DECLARE", type, size, id);

        if (ctx.IGUAL() != null) {
            String rVal = visit(ctx.expr());
            emit("=", rVal, "", id);
        }

        return null;
    }

    @Override
    public String visitDeclaracion_sin_pyc(MiLenguajeParser.Declaracion_sin_pycContext ctx) {
        String id = ctx.ID().getText();
        String type = ctx.tipo().getText();
        String size = "-1";

        if (ctx.CA() != null) {
            size = ctx.INTEGER().getText();
        }

        emit("DECLARE", type, size, id);

        if (ctx.IGUAL() != null) {
            String rVal = visit(ctx.expr());
            emit("=", rVal, "", id);
        }

        return null;
    }

    @Override
    public String visitAsignacion(MiLenguajeParser.AsignacionContext ctx) {
        String rVal = visit(ctx.expr());
        
        MiLenguajeParser.LvalueContext lval = ctx.lvalue();
        String id = lval.ID().getText();
        
        if (lval.expr() != null) {
            // Escritura en vector: ID[idx] = rVal
            String idxVal = visit(lval.expr());
            emit("ARRAY_PUT", idxVal, rVal, id);
        } else {
            // Escritura de variable simple: ID = rVal
            emit("=", rVal, "", id);
        }
        
        return null;
    }

    @Override
    public String visitAsignacion_sin_pyc(MiLenguajeParser.Asignacion_sin_pycContext ctx) {
        String rVal = visit(ctx.expr());
        
        MiLenguajeParser.LvalueContext lval = ctx.lvalue();
        String id = lval.ID().getText();
        
        if (lval.expr() != null) {
            String idxVal = visit(lval.expr());
            emit("ARRAY_PUT", idxVal, rVal, id);
        } else {
            emit("=", rVal, "", id);
        }
        
        return null;
    }

    @Override
    public String visitLvalue(MiLenguajeParser.LvalueContext ctx) {
        String id = ctx.ID().getText();
        if (ctx.expr() != null) {
            // Lectura de vector
            String idxVal = visit(ctx.expr());
            String t = newTemp();
            emit("ARRAY_GET", id, idxVal, t);
            return t;
        }
        return id;
    }

    @Override
    public String visitSentenciaIf(MiLenguajeParser.SentenciaIfContext ctx) {
        String cond = visit(ctx.expr());
        String labelThen = newLabel();
        String labelEnd = newLabel();

        if (ctx.ELSE() != null) {
            String labelElse = newLabel();
            emit("IF", cond, "", labelThen);
            emit("GOTO", "", "", labelElse);
            
            emitLabel(labelThen);
            visit(ctx.instruccion(0));
            emit("GOTO", "", "", labelEnd);
            
            emitLabel(labelElse);
            visit(ctx.instruccion(1));
            
            emitLabel(labelEnd);
        } else {
            emit("IF", cond, "", labelThen);
            emit("GOTO", "", "", labelEnd);
            
            emitLabel(labelThen);
            visit(ctx.instruccion(0));
            
            emitLabel(labelEnd);
        }
        return null;
    }

    @Override
    public String visitSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx) {
        String labelCond = newLabel();
        String labelBody = newLabel();
        String labelEnd = newLabel();

        loopStartLabels.push(labelCond);
        loopEndLabels.push(labelEnd);

        emitLabel(labelCond);
        String cond = visit(ctx.expr());
        emit("IF", cond, "", labelBody);
        emit("GOTO", "", "", labelEnd);

        emitLabel(labelBody);
        visit(ctx.instruccion());
        emit("GOTO", "", "", labelCond);

        emitLabel(labelEnd);

        loopStartLabels.pop();
        loopEndLabels.pop();
        return null;
    }

    @Override
    public String visitSentenciaDoWhile(MiLenguajeParser.SentenciaDoWhileContext ctx) {
        String labelBody = newLabel();
        String labelCond = newLabel();
        String labelEnd = newLabel();

        loopStartLabels.push(labelCond);
        loopEndLabels.push(labelEnd);

        emitLabel(labelBody);
        visit(ctx.instruccion());

        emitLabel(labelCond);
        String cond = visit(ctx.expr());
        emit("IF", cond, "", labelBody);

        emitLabel(labelEnd);

        loopStartLabels.pop();
        loopEndLabels.pop();
        return null;
    }

    @Override
    public String visitSentenciaFor(MiLenguajeParser.SentenciaForContext ctx) {
        String labelCond = newLabel();
        String labelBody = newLabel();
        String labelStep = newLabel();
        String labelEnd = newLabel();

        loopStartLabels.push(labelStep);
        loopEndLabels.push(labelEnd);

        ParseTree initTree = null;
        ParseTree condTree = null;
        ParseTree stepTree = null;
        
        int firstSemi = -1;
        int secondSemi = -1;
        int cp = -1;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child.getText().equals(";")) {
                if (firstSemi == -1) firstSemi = i;
                else if (secondSemi == -1) secondSemi = i;
            } else if (child.getText().equals(")")) {
                cp = i;
            }
        }
        
        if (firstSemi > 2) {
            initTree = ctx.getChild(2);
        }
        if (secondSemi > firstSemi + 1) {
            condTree = ctx.getChild(firstSemi + 1);
        }
        if (cp > secondSemi + 1) {
            stepTree = ctx.getChild(secondSemi + 1);
        }

        if (initTree != null) {
            visit(initTree);
        }

        emitLabel(labelCond);
        
        String cond = "1";
        if (condTree != null) {
            cond = visit(condTree);
        }
        
        emit("IF", cond, "", labelBody);
        emit("GOTO", "", "", labelEnd);

        emitLabel(labelBody);
        visit(ctx.instruccion());

        emitLabel(labelStep);
        if (stepTree != null) {
            visit(stepTree);
        }

        emit("GOTO", "", "", labelCond);
        emitLabel(labelEnd);

        loopStartLabels.pop();
        loopEndLabels.pop();
        return null;
    }

    @Override
    public String visitSentenciaSwitch(MiLenguajeParser.SentenciaSwitchContext ctx) {
        String exprVal = visit(ctx.expr());
        String labelEnd = newLabel();
        loopEndLabels.push(labelEnd);

        // Recolectar información de los bloques case
        List<String> caseLabels = new ArrayList<>();
        List<String> caseExprs = new ArrayList<>();
        String defaultLabel = null;

        for (MiLenguajeParser.CaseBlockContext c : ctx.caseBlock()) {
            if (c.expr() != null) {
                String cLabel = newLabel();
                caseLabels.add(cLabel);
                String cVal = visit(c.expr());
                caseExprs.add(cVal);
            } else {
                defaultLabel = newLabel();
            }
        }

        if (defaultLabel == null) {
            defaultLabel = labelEnd;
        }

        // Emitir cadena de comparaciones
        int caseIdx = 0;
        for (MiLenguajeParser.CaseBlockContext c : ctx.caseBlock()) {
            if (c.expr() != null) {
                String tComp = newTemp();
                emit("==", exprVal, caseExprs.get(caseIdx), tComp);
                emit("IF", tComp, "", caseLabels.get(caseIdx));
                caseIdx++;
            }
        }
        emit("GOTO", "", "", defaultLabel);

        // Emitir cuerpos de los cases
        caseIdx = 0;
        for (MiLenguajeParser.CaseBlockContext c : ctx.caseBlock()) {
            if (c.expr() != null) {
                emitLabel(caseLabels.get(caseIdx));
                caseIdx++;
            } else {
                emitLabel(defaultLabel);
            }
            
            for (MiLenguajeParser.InstruccionContext inst : c.instruccion()) {
                visit(inst);
            }
        }

        emitLabel(labelEnd);
        loopEndLabels.pop();
        return null;
    }

    @Override
    public String visitSentenciaReturn(MiLenguajeParser.SentenciaReturnContext ctx) {
        String retVal = "";
        if (ctx.expr() != null) {
            retVal = visit(ctx.expr());
        }
        emit("RETURN", retVal, "", "");
        return null;
    }

    @Override
    public String visitSentenciaBreak(MiLenguajeParser.SentenciaBreakContext ctx) {
        if (!loopEndLabels.isEmpty()) {
            emit("GOTO", "", "", loopEndLabels.peek());
        }
        return null;
    }

    @Override
    public String visitSentenciaContinue(MiLenguajeParser.SentenciaContinueContext ctx) {
        if (!loopStartLabels.isEmpty()) {
            emit("GOTO", "", "", loopStartLabels.peek());
        }
        return null;
    }

    @Override
    public String visitSentenciaPrint(MiLenguajeParser.SentenciaPrintContext ctx) {
        String val = "";
        if (ctx.expr() != null) {
            val = visit(ctx.expr());
        } else if (ctx.STRING() != null) {
            val = ctx.STRING().getText();
        }
        emit("PRINT", val, "", "");
        return null;
    }

    // --- Visitores de expresiones ---

    @Override
    public String visitAssignment(MiLenguajeParser.AssignmentContext ctx) {
        String rVal = visit(ctx.expr());
        MiLenguajeParser.LvalueContext lval = ctx.lvalue();
        String id = lval.ID().getText();
        
        if (lval.expr() != null) {
            String idxVal = visit(lval.expr());
            emit("ARRAY_PUT", idxVal, rVal, id);
        } else {
            emit("=", rVal, "", id);
        }
        
        return rVal;
    }

    @Override
    public String visitLogicalOr(MiLenguajeParser.LogicalOrContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String t = newTemp();
        emit("or", left, right, t);
        return t;
    }

    @Override
    public String visitLogicalAnd(MiLenguajeParser.LogicalAndContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String t = newTemp();
        emit("and", left, right, t);
        return t;
    }

    @Override
    public String visitEquality(MiLenguajeParser.EqualityContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String t = newTemp();
        emit("==", left, right, t);
        return t;
    }

    @Override
    public String visitInequality(MiLenguajeParser.InequalityContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String t = newTemp();
        emit("!=", left, right, t);
        return t;
    }

    @Override
    public String visitComparison(MiLenguajeParser.ComparisonContext ctx) {
        String op = ctx.getChild(1).getText();
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String t = newTemp();
        emit(op, left, right, t);
        return t;
    }

    @Override
    public String visitAddition(MiLenguajeParser.AdditionContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String t = newTemp();
        emit("+", left, right, t);
        return t;
    }

    @Override
    public String visitSubtraction(MiLenguajeParser.SubtractionContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String t = newTemp();
        emit("-", left, right, t);
        return t;
    }

    @Override
    public String visitMultiplication(MiLenguajeParser.MultiplicationContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String t = newTemp();
        emit("*", left, right, t);
        return t;
    }

    @Override
    public String visitDivision(MiLenguajeParser.DivisionContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String t = newTemp();
        emit("/", left, right, t);
        return t;
    }

    @Override
    public String visitModulo(MiLenguajeParser.ModuloContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String t = newTemp();
        emit("%", left, right, t);
        return t;
    }

    @Override
    public String visitLogicalNot(MiLenguajeParser.LogicalNotContext ctx) {
        String val = visit(ctx.expr());
        String t = newTemp();
        emit("not", val, "", t);
        return t;
    }

    @Override
    public String visitUnaryMinus(MiLenguajeParser.UnaryMinusContext ctx) {
        String val = visit(ctx.expr());
        String t = newTemp();
        emit("u-", val, "", t);
        return t;
    }

    @Override
    public String visitPrimary(MiLenguajeParser.PrimaryContext ctx) {
        return visit(ctx.factor());
    }

    @Override
    public String visitParenthesizedExpr(MiLenguajeParser.ParenthesizedExprContext ctx) {
        return visit(ctx.expr());
    }

    // --- Visitores de factores ---

    @Override
    public String visitFunctionCall(MiLenguajeParser.FunctionCallContext ctx) {
        String id = ctx.ID().getText();
        
        List<String> argVals = new ArrayList<>();
        if (ctx.expr() != null) {
            for (MiLenguajeParser.ExprContext exp : ctx.expr()) {
                argVals.add(visit(exp));
            }
        }

        for (String argVal : argVals) {
            emit("PARAM", argVal, "", "");
        }

        String t = newTemp();
        emit("CALL", "func_" + id, String.valueOf(argVals.size()), t);
        return t;
    }

    @Override
    public String visitArrayAccess(MiLenguajeParser.ArrayAccessContext ctx) {
        String id = ctx.ID().getText();
        String idxVal = visit(ctx.expr());
        String t = newTemp();
        emit("ARRAY_GET", id, idxVal, t);
        return t;
    }

    @Override
    public String visitIdentifier(MiLenguajeParser.IdentifierContext ctx) {
        return ctx.ID().getText();
    }

    @Override
    public String visitIntLiteral(MiLenguajeParser.IntLiteralContext ctx) {
        return ctx.INTEGER().getText();
    }

    @Override
    public String visitDecLiteral(MiLenguajeParser.DecLiteralContext ctx) {
        return ctx.DECIMAL().getText();
    }

    @Override
    public String visitCharLiteral(MiLenguajeParser.CharLiteralContext ctx) {
        return ctx.CHARACTER().getText();
    }

    @Override
    public String visitStringLiteral(MiLenguajeParser.StringLiteralContext ctx) {
        return ctx.STRING().getText();
    }
}
