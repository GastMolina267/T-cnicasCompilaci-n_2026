package com.compilador;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.ArrayList;
import java.util.List;

public class SemanticVisitor extends MiLenguajeBaseVisitor<String> {
    private TablaSimbolos tablaSimbolos;
    private List<String> errores;
    private List<String> warnings;
    private String currentReturnType;
    private boolean hasReturnStatement;
    private int loopDepth;

    public SemanticVisitor() {
        this.tablaSimbolos = new TablaSimbolos();
        this.errores = new ArrayList<>();
        this.warnings = new ArrayList<>();
        this.currentReturnType = null;
        this.hasReturnStatement = false;
        this.loopDepth = 0;
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    public List<String> getErrores() {
        return errores;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    private void reportError(int line, int col, String msg) {
        errores.add("❌ Error: " + msg + " (línea " + line + ", columna " + col + ")");
    }

    private void reportWarning(int line, int col, String msg) {
        warnings.add("⚠️ Warning: " + msg + " (línea " + line + ", columna " + col + ")");
    }

    private Token getStartToken(ParseTree tree) {
        if (tree instanceof ParserRuleContext) {
            return ((ParserRuleContext) tree).getStart();
        } else if (tree instanceof TerminalNode) {
            return ((TerminalNode) tree).getSymbol();
        }
        return null;
    }

    private boolean isNumeric(String type) {
        if (type == null) return false;
        return type.equals("int") || type.equals("double") || type.equals("char") || type.equals("bool");
    }

    private boolean compatible(String target, String source) {
        if (target == null || source == null) return false;
        if (target.equals(source)) return true;
        if (isNumeric(target) && isNumeric(source)) return true;
        return false;
    }

    @Override
    public String visitPrograma(MiLenguajeParser.ProgramaContext ctx) {
        super.visitPrograma(ctx);
        
        // Verificar variables/parámetros declarados pero nunca utilizados
        for (Symbol s : tablaSimbolos.getAllSymbols()) {
            if ((s.getCategoria().equals("variable") || s.getCategoria().equals("parametro")) && !s.isUsado()) {
                reportWarning(s.getLinea(), s.getColumna(), 
                    "Variable '" + s.getNombre() + "' declarada pero nunca utilizada en el ámbito '" + s.getAmbito() + "'");
            }
        }
        return null;
    }

    @Override
    public String visitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx) {
        String type = ctx.tipo().getText();
        String id = ctx.ID().getText();
        Token idToken = ctx.ID().getSymbol();

        // Verificar si la función ya está declarada en el ámbito global
        Symbol existing = tablaSimbolos.getCurrentScope().getSimbolos().get(id);
        if (existing != null) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                "La función '" + id + "' ya está declarada en el ámbito '" + tablaSimbolos.getCurrentScope().getNombreScope() + "'");
        } else {
            Symbol fnSymbol = new Symbol(id, type, "funcion", idToken.getLine(), idToken.getCharPositionInLine(), "global");
            tablaSimbolos.insert(fnSymbol);
        }

        // Abrir ámbito local para la función
        tablaSimbolos.openScope(id);
        
        // Registrar parámetros en el ámbito local y firma de la función
        List<String> paramTypes = new ArrayList<>();
        if (ctx.parametros() != null) {
            for (MiLenguajeParser.ParametroContext pCtx : ctx.parametros().parametro()) {
                String pType = pCtx.tipo().getText();
                String pId = pCtx.ID().getText();
                Token pIdToken = pCtx.ID().getSymbol();
                
                paramTypes.add(pType);
                
                Symbol pSymbol = new Symbol(pId, pType, "parametro", pIdToken.getLine(), pIdToken.getCharPositionInLine(), id);
                boolean ok = tablaSimbolos.insert(pSymbol);
                if (!ok) {
                    reportError(pIdToken.getLine(), pIdToken.getCharPositionInLine(), 
                        "El parámetro '" + pId + "' ya está declarado en la función '" + id + "'");
                }
            }
        }
        
        // Actualizar firma en el símbolo global
        Symbol fnSymbolGlobal = tablaSimbolos.resolve(id);
        if (fnSymbolGlobal != null) {
            fnSymbolGlobal.setParametroTipos(paramTypes);
        }

        currentReturnType = type;
        hasReturnStatement = false;

        // Visitar instrucciones del cuerpo directamente para no duplicar el ámbito
        if (ctx.bloque() != null) {
            for (MiLenguajeParser.InstruccionContext inst : ctx.bloque().instruccion()) {
                visit(inst);
            }
        }

        // Verificar si falta retorno para funciones que no son void
        if (!type.equals("void") && !hasReturnStatement) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                "La función '" + id + "' de tipo no-void debe retornar un valor.");
        }

        tablaSimbolos.closeScope();
        currentReturnType = null;
        hasReturnStatement = false;

        return null;
    }

    @Override
    public String visitDeclaracion(MiLenguajeParser.DeclaracionContext ctx) {
        String type = ctx.tipo().getText();
        String id = ctx.ID().getText();
        Token idToken = ctx.ID().getSymbol();

        // Verificar si ya está declarada en este ámbito
        Symbol existing = tablaSimbolos.getCurrentScope().getSimbolos().get(id);
        if (existing != null) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                "La variable '" + id + "' ya está declarada en el ámbito '" + tablaSimbolos.getCurrentScope().getNombreScope() + "'");
            return null;
        }

        Symbol s = new Symbol(id, type, "variable", idToken.getLine(), idToken.getCharPositionInLine(), tablaSimbolos.getCurrentScope().getNombreScope());
        
        // Verificar si es un vector
        if (ctx.CA() != null) {
            int size = Integer.parseInt(ctx.INTEGER().getText());
            s.setSize(size);
        }

        // Verificar inicialización
        if (ctx.IGUAL() != null) {
            String initType = visit(ctx.expr());
            if (!compatible(type, initType)) {
                reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                    "Tipos incompatibles en la inicialización: no se puede asignar " + initType + " a " + type);
            }
            if (s.isArray()) {
                reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                    "No se puede inicializar directamente un array '" + id + "' con un valor simple");
            }
        }

        tablaSimbolos.insert(s);
        return null;
    }

    @Override
    public String visitDeclaracion_sin_pyc(MiLenguajeParser.Declaracion_sin_pycContext ctx) {
        String type = ctx.tipo().getText();
        String id = ctx.ID().getText();
        Token idToken = ctx.ID().getSymbol();

        Symbol existing = tablaSimbolos.getCurrentScope().getSimbolos().get(id);
        if (existing != null) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                "La variable '" + id + "' ya está declarada en el ámbito '" + tablaSimbolos.getCurrentScope().getNombreScope() + "'");
            return null;
        }

        Symbol s = new Symbol(id, type, "variable", idToken.getLine(), idToken.getCharPositionInLine(), tablaSimbolos.getCurrentScope().getNombreScope());
        if (ctx.CA() != null) {
            int size = Integer.parseInt(ctx.INTEGER().getText());
            s.setSize(size);
        }

        if (ctx.IGUAL() != null) {
            String initType = visit(ctx.expr());
            if (!compatible(type, initType)) {
                reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                    "Tipos incompatibles en la inicialización: no se puede asignar " + initType + " a " + type);
            }
        }

        tablaSimbolos.insert(s);
        return null;
    }

    @Override
    public String visitAsignacion(MiLenguajeParser.AsignacionContext ctx) {
        String ltype = visit(ctx.lvalue());
        String rtype = visit(ctx.expr());
        
        if (ltype != null && rtype != null) {
            if (!compatible(ltype, rtype)) {
                Token opToken = ctx.IGUAL().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), 
                    "Tipos incompatibles en la asignación: no se puede asignar " + rtype + " a " + ltype);
            }
        }
        return null;
    }

    @Override
    public String visitAsignacion_sin_pyc(MiLenguajeParser.Asignacion_sin_pycContext ctx) {
        String ltype = visit(ctx.lvalue());
        String rtype = visit(ctx.expr());
        
        if (ltype != null && rtype != null) {
            if (!compatible(ltype, rtype)) {
                Token opToken = ctx.IGUAL().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), 
                    "Tipos incompatibles en la asignación: no se puede asignar " + rtype + " a " + ltype);
            }
        }
        return null;
    }

    @Override
    public String visitLvalue(MiLenguajeParser.LvalueContext ctx) {
        String id = ctx.ID().getText();
        Token idToken = ctx.ID().getSymbol();
        Symbol s = tablaSimbolos.resolve(id);
        
        if (s == null) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                "Variable '" + id + "' no declarada en el ámbito '" + tablaSimbolos.getCurrentScope().getNombreScope() + "'");
            return "unknown";
        }
        
        s.setUsado(true);

        if (s.getCategoria().equals("funcion")) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                "No se puede asignar valor a '" + id + "' porque no es una variable");
            return "unknown";
        }

        if (ctx.expr() != null) { // Acceso a vector: arr[expr]
            if (!s.isArray()) {
                reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                    "La variable '" + id + "' no es un array");
                return s.getTipo();
            }
            String idxType = visit(ctx.expr());
            if (!idxType.equals("int")) {
                reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                    "El índice del array debe ser un entero (encontrado: " + idxType + ")");
            }
            return s.getTipo();
        }

        return s.getTipo();
    }

    @Override
    public String visitBloque(MiLenguajeParser.BloqueContext ctx) {
        tablaSimbolos.openScope("bloque_linea_" + ctx.getStart().getLine());
        super.visitBloque(ctx);
        tablaSimbolos.closeScope();
        return null;
    }

    @Override
    public String visitSentenciaIf(MiLenguajeParser.SentenciaIfContext ctx) {
        String condType = visit(ctx.expr());
        if (condType != null && !isNumeric(condType)) {
            Token start = ctx.expr().getStart();
            reportError(start.getLine(), start.getCharPositionInLine(), 
                "La condición del 'if' debe ser de tipo numérico o booleano");
        }
        
        visit(ctx.instruccion(0));
        if (ctx.instruccion(1) != null) {
            visit(ctx.instruccion(1));
        }
        return null;
    }

    @Override
    public String visitSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx) {
        String condType = visit(ctx.expr());
        if (condType != null && !isNumeric(condType)) {
            Token start = ctx.expr().getStart();
            reportError(start.getLine(), start.getCharPositionInLine(), 
                "La condición del 'while' debe ser de tipo numérico o booleano");
        }
        
        loopDepth++;
        visit(ctx.instruccion());
        loopDepth--;
        return null;
    }

    @Override
    public String visitSentenciaDoWhile(MiLenguajeParser.SentenciaDoWhileContext ctx) {
        loopDepth++;
        visit(ctx.instruccion());
        loopDepth--;

        String condType = visit(ctx.expr());
        if (condType != null && !isNumeric(condType)) {
            Token start = ctx.expr().getStart();
            reportError(start.getLine(), start.getCharPositionInLine(), 
                "La condición del 'do-while' debe ser de tipo numérico o booleano");
        }
        return null;
    }

    @Override
    public String visitSentenciaFor(MiLenguajeParser.SentenciaForContext ctx) {
        tablaSimbolos.openScope("for_linea_" + ctx.getStart().getLine());
        
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
        
        if (condTree != null) {
            String condType = visit(condTree);
            if (condType != null && !isNumeric(condType)) {
                Token start = getStartToken(condTree);
                if (start != null) {
                    reportError(start.getLine(), start.getCharPositionInLine(), 
                        "La condición del 'for' debe ser de tipo numérico o booleano");
                }
            }
        }
        
        if (stepTree != null) {
            visit(stepTree);
        }

        loopDepth++;
        visit(ctx.instruccion());
        loopDepth--;

        tablaSimbolos.closeScope();
        return null;
    }

    @Override
    public String visitSentenciaSwitch(MiLenguajeParser.SentenciaSwitchContext ctx) {
        String condType = visit(ctx.expr());
        if (condType != null && !isNumeric(condType)) {
            Token start = ctx.expr().getStart();
            reportError(start.getLine(), start.getCharPositionInLine(), 
                "La expresión del 'switch' debe ser de tipo escalar (int, char, bool)");
        }
        
        loopDepth++; // Tratamos switch como estructura que admite break
        for (MiLenguajeParser.CaseBlockContext c : ctx.caseBlock()) {
            visit(c);
        }
        loopDepth--;
        return null;
    }

    @Override
    public String visitCaseBlock(MiLenguajeParser.CaseBlockContext ctx) {
        if (ctx.expr() != null) {
            visit(ctx.expr());
        }
        for (MiLenguajeParser.InstruccionContext inst : ctx.instruccion()) {
            visit(inst);
        }
        return null;
    }

    @Override
    public String visitSentenciaReturn(MiLenguajeParser.SentenciaReturnContext ctx) {
        Token retToken = ctx.getStart();
        if (currentReturnType == null) {
            reportError(retToken.getLine(), retToken.getCharPositionInLine(), 
                "Sentencia 'return' fuera del cuerpo de una función");
            return null;
        }

        hasReturnStatement = true;

        if (ctx.expr() != null) {
            String exprType = visit(ctx.expr());
            if (!compatible(currentReturnType, exprType)) {
                reportError(retToken.getLine(), retToken.getCharPositionInLine(), 
                    "Tipo de retorno incompatible: se esperaba " + currentReturnType + " pero se retornó " + exprType);
            }
        } else {
            if (!currentReturnType.equals("void")) {
                reportError(retToken.getLine(), retToken.getCharPositionInLine(), 
                    "La función debe retornar un valor de tipo " + currentReturnType);
            }
        }
        return null;
    }

    @Override
    public String visitSentenciaBreak(MiLenguajeParser.SentenciaBreakContext ctx) {
        if (loopDepth <= 0) {
            Token t = ctx.getStart();
            reportError(t.getLine(), t.getCharPositionInLine(), "Sentencia 'break' fuera de un bucle o switch");
        }
        return null;
    }

    @Override
    public String visitSentenciaContinue(MiLenguajeParser.SentenciaContinueContext ctx) {
        if (loopDepth <= 0) {
            Token t = ctx.getStart();
            reportError(t.getLine(), t.getCharPositionInLine(), "Sentencia 'continue' fuera de un bucle");
        }
        return null;
    }

    @Override
    public String visitSentenciaPrint(MiLenguajeParser.SentenciaPrintContext ctx) {
        if (ctx.expr() != null) {
            visit(ctx.expr());
        }
        return null;
    }

    // --- Reglas de expresiones ---

    @Override
    public String visitAssignment(MiLenguajeParser.AssignmentContext ctx) {
        String ltype = visit(ctx.lvalue());
        String rtype = visit(ctx.expr());
        
        if (ltype != null && rtype != null) {
            if (!compatible(ltype, rtype)) {
                Token opToken = ctx.IGUAL().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), 
                    "Tipos incompatibles en la asignación: no se puede asignar " + rtype + " a " + ltype);
            }
        }
        return ltype;
    }

    @Override
    public String visitLogicalOr(MiLenguajeParser.LogicalOrContext ctx) {
        String t1 = visit(ctx.expr(0));
        String t2 = visit(ctx.expr(1));
        if (t1 != null && t2 != null) {
            if (!isNumeric(t1) || !isNumeric(t2)) {
                Token opToken = ctx.OR().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Operadores lógicos requieren operandos numéricos o booleanos");
            }
        }
        return "bool";
    }

    @Override
    public String visitLogicalAnd(MiLenguajeParser.LogicalAndContext ctx) {
        String t1 = visit(ctx.expr(0));
        String t2 = visit(ctx.expr(1));
        if (t1 != null && t2 != null) {
            if (!isNumeric(t1) || !isNumeric(t2)) {
                Token opToken = ctx.AND().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Operadores lógicos requieren operandos numéricos o booleanos");
            }
        }
        return "bool";
    }

    @Override
    public String visitEquality(MiLenguajeParser.EqualityContext ctx) {
        String t1 = visit(ctx.expr(0));
        String t2 = visit(ctx.expr(1));
        if (t1 != null && t2 != null) {
            if (!compatible(t1, t2)) {
                Token opToken = ctx.EQL().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Comparación de igualdad entre tipos incompatibles: " + t1 + " y " + t2);
            }
        }
        return "bool";
    }

    @Override
    public String visitInequality(MiLenguajeParser.InequalityContext ctx) {
        String t1 = visit(ctx.expr(0));
        String t2 = visit(ctx.expr(1));
        if (t1 != null && t2 != null) {
            if (!compatible(t1, t2)) {
                Token opToken = ctx.DISTINTO().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Comparación de desigualdad entre tipos incompatibles: " + t1 + " y " + t2);
            }
        }
        return "bool";
    }

    @Override
    public String visitComparison(MiLenguajeParser.ComparisonContext ctx) {
        String t1 = visit(ctx.expr(0));
        String t2 = visit(ctx.expr(1));
        if (t1 != null && t2 != null) {
            if (!isNumeric(t1) || !isNumeric(t2)) {
                Token opToken = getStartToken(ctx.getChild(1));
                if (opToken != null) {
                    reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Comparación de orden requiere operandos numéricos");
                }
            }
        }
        return "bool";
    }

    @Override
    public String visitAddition(MiLenguajeParser.AdditionContext ctx) {
        String t1 = visit(ctx.expr(0));
        String t2 = visit(ctx.expr(1));
        if (t1 != null && t2 != null) {
            if (!isNumeric(t1) || !isNumeric(t2)) {
                Token opToken = ctx.SUM().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Operación de suma requiere operandos numéricos");
                return "int";
            }
            if (t1.equals("double") || t2.equals("double")) {
                return "double";
            }
        }
        return "int";
    }

    @Override
    public String visitSubtraction(MiLenguajeParser.SubtractionContext ctx) {
        String t1 = visit(ctx.expr(0));
        String t2 = visit(ctx.expr(1));
        if (t1 != null && t2 != null) {
            if (!isNumeric(t1) || !isNumeric(t2)) {
                Token opToken = ctx.RES().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Operación de resta requiere operandos numéricos");
                return "int";
            }
            if (t1.equals("double") || t2.equals("double")) {
                return "double";
            }
        }
        return "int";
    }

    @Override
    public String visitMultiplication(MiLenguajeParser.MultiplicationContext ctx) {
        String t1 = visit(ctx.expr(0));
        String t2 = visit(ctx.expr(1));
        if (t1 != null && t2 != null) {
            if (!isNumeric(t1) || !isNumeric(t2)) {
                Token opToken = ctx.MUL().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Operación de multiplicación requiere operandos numéricos");
                return "int";
            }
            if (t1.equals("double") || t2.equals("double")) {
                return "double";
            }
        }
        return "int";
    }

    @Override
    public String visitDivision(MiLenguajeParser.DivisionContext ctx) {
        String t1 = visit(ctx.expr(0));
        String t2 = visit(ctx.expr(1));
        if (t1 != null && t2 != null) {
            if (!isNumeric(t1) || !isNumeric(t2)) {
                Token opToken = ctx.DIV().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Operación de división requiere operandos numéricos");
                return "int";
            }
            if (t1.equals("double") || t2.equals("double")) {
                return "double";
            }
        }
        return "int";
    }

    @Override
    public String visitModulo(MiLenguajeParser.ModuloContext ctx) {
        String t1 = visit(ctx.expr(0));
        String t2 = visit(ctx.expr(1));
        if (t1 != null && t2 != null) {
            if (!t1.equals("int") || !t2.equals("int")) {
                Token opToken = ctx.MOD().getSymbol();
                reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Operación de módulo (%) requiere operandos enteros (int)");
            }
        }
        return "int";
    }

    @Override
    public String visitLogicalNot(MiLenguajeParser.LogicalNotContext ctx) {
        String t = visit(ctx.expr());
        if (t != null && !isNumeric(t)) {
            Token opToken = ctx.NOT().getSymbol();
            reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Operador lógico 'not' requiere operando numérico o booleano");
        }
        return "bool";
    }

    @Override
    public String visitUnaryMinus(MiLenguajeParser.UnaryMinusContext ctx) {
        String t = visit(ctx.expr());
        if (t != null && !isNumeric(t)) {
            Token opToken = ctx.RES().getSymbol();
            reportError(opToken.getLine(), opToken.getCharPositionInLine(), "Operador unario '-' requiere operando numérico");
        }
        return t;
    }

    @Override
    public String visitPrimary(MiLenguajeParser.PrimaryContext ctx) {
        return visit(ctx.factor());
    }

    // --- Reglas de factores ---

    @Override
    public String visitFunctionCall(MiLenguajeParser.FunctionCallContext ctx) {
        String id = ctx.ID().getText();
        Token idToken = ctx.ID().getSymbol();
        Symbol s = tablaSimbolos.resolve(id);
        
        if (s == null) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), "La función '" + id + "' no ha sido declarada");
            return "unknown";
        }
        
        s.setUsado(true);

        if (!s.getCategoria().equals("funcion")) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), "'" + id + "' no es una función");
            return "unknown";
        }

        // Verificar cantidad y tipos de argumentos
        List<String> expectedTypes = s.getParametroTipos();
        List<MiLenguajeParser.ExprContext> args = new ArrayList<>();
        if (ctx.expr() != null) {
            args.addAll(ctx.expr());
        }

        if (expectedTypes.size() != args.size()) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), 
                "Número de argumentos incorrecto para la función '" + id + "': se esperaban " + expectedTypes.size() + " pero se pasaron " + args.size());
            return s.getTipo();
        }

        for (int i = 0; i < args.size(); i++) {
            String argType = visit(args.get(i));
            String expType = expectedTypes.get(i);
            if (argType != null && expType != null) {
                if (!compatible(expType, argType)) {
                    reportError(args.get(i).getStart().getLine(), args.get(i).getStart().getCharPositionInLine(), 
                        "Tipo de argumento incompatible para el parámetro " + (i + 1) + " de la función '" + id + "': se esperaba " + expType + " pero se pasó " + argType);
                }
            }
        }

        return s.getTipo();
    }

    @Override
    public String visitArrayAccess(MiLenguajeParser.ArrayAccessContext ctx) {
        String id = ctx.ID().getText();
        Token idToken = ctx.ID().getSymbol();
        Symbol s = tablaSimbolos.resolve(id);
        
        if (s == null) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), "Variable '" + id + "' no declarada");
            return "unknown";
        }
        
        s.setUsado(true);

        if (!s.isArray()) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), "La variable '" + id + "' no es un array");
            return s.getTipo();
        }

        String idxType = visit(ctx.expr());
        if (idxType != null && !idxType.equals("int")) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), "El índice del array debe ser un entero (encontrado: " + idxType + ")");
        }

        return s.getTipo();
    }

    @Override
    public String visitIdentifier(MiLenguajeParser.IdentifierContext ctx) {
        String id = ctx.ID().getText();
        Token idToken = ctx.ID().getSymbol();
        Symbol s = tablaSimbolos.resolve(id);
        
        if (s == null) {
            reportError(idToken.getLine(), idToken.getCharPositionInLine(), "Variable '" + id + "' no declarada");
            return "unknown";
        }
        
        s.setUsado(true);
        return s.getTipo();
    }

    @Override
    public String visitIntLiteral(MiLenguajeParser.IntLiteralContext ctx) {
        return "int";
    }

    @Override
    public String visitDecLiteral(MiLenguajeParser.DecLiteralContext ctx) {
        return "double";
    }

    @Override
    public String visitCharLiteral(MiLenguajeParser.CharLiteralContext ctx) {
        return "char";
    }

    @Override
    public String visitStringLiteral(MiLenguajeParser.StringLiteralContext ctx) {
        return "string";
    }

    @Override
    public String visitParenthesizedExpr(MiLenguajeParser.ParenthesizedExprContext ctx) {
        return visit(ctx.expr());
    }
}
