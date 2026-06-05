package com.compilador;

public class Instruccion {
    private String op;
    private String arg1;
    private String arg2;
    private String result;

    public Instruccion(String op, String arg1, String arg2, String result) {
        this.op = op != null ? op : "";
        this.arg1 = arg1 != null ? arg1 : "";
        this.arg2 = arg2 != null ? arg2 : "";
        this.result = result != null ? result : "";
    }

    public String getOp() { return op; }
    public void setOp(String op) { this.op = op; }

    public String getArg1() { return arg1; }
    public void setArg1(String arg1) { this.arg1 = arg1; }

    public String getArg2() { return arg2; }
    public void setArg2(String arg2) { this.arg2 = arg2; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    @Override
    public String toString() {
        switch (op) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
            case "and":
            case "or":
            case "==":
            case "!=":
            case ">":
            case ">=":
            case "<":
            case "<=":
                return result + " = " + arg1 + " " + op + " " + arg2;
            case "not":
            case "u-":
                String opSym = op.equals("u-") ? "-" : "not ";
                return result + " = " + opSym + arg1;
            case "=":
                return result + " = " + arg1;
            case "DECLARE":
                if (!arg2.isEmpty() && !arg2.equals("-1")) {
                    return "DECLARE " + result + "[" + arg2 + "] " + arg1;
                } else {
                    return "DECLARE " + result + " " + arg1;
                }
            case "LABEL":
                return result + ":";
            case "GOTO":
                return "goto " + result;
            case "IF":
                return "if " + arg1 + " goto " + result;
            case "PARAM":
                return "PARAM " + arg1;
            case "CALL":
                if (result.isEmpty()) {
                    return "CALL " + arg1 + (arg2.isEmpty() ? "" : ", " + arg2);
                } else {
                    return result + " = CALL " + arg1 + (arg2.isEmpty() ? "" : ", " + arg2);
                }
            case "RETURN":
                if (arg1.isEmpty()) {
                    return "return";
                } else {
                    return "return " + arg1;
                }
            case "FUNC_START":
                return result + ":";
            case "FUNC_END":
                return ""; // Puede ignorarse o imprimirse como comentario
            case "ARRAY_GET":
                return result + " = " + arg1 + "[" + arg2 + "]";
            case "ARRAY_PUT":
                return result + "[" + arg1 + "] = " + arg2;
            case "PRINT":
                return "PRINT " + arg1;
            case "COMMENT":
                return result;
            default:
                return op + " " + arg1 + " " + arg2 + " " + result;
        }
    }
}
