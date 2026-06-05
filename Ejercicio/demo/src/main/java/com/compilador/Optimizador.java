package com.compilador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Optimizador {

    public static List<Instruccion> optimizar(List<Instruccion> original) {
        List<Instruccion> current = new ArrayList<>();
        // Copiar la lista para evitar modificar la original
        for (Instruccion inst : original) {
            current.add(new Instruccion(inst.getOp(), inst.getArg1(), inst.getArg2(), inst.getResult()));
        }

        boolean changed = true;
        int passes = 0;
        while (changed && passes < 10) {
            changed = false;
            passes++;

            // Paso 1: Propagación/plegado de constantes y simplificación algebraica
            List<Instruccion> p1 = pass1(current);
            if (p1.size() != current.size() || !areEqual(p1, current)) {
                changed = true;
                current = p1;
            }

            // Paso 2: Eliminación de código muerto
            List<Instruccion> p2 = passDeadCode(current);
            if (p2.size() != current.size() || !areEqual(p2, current)) {
                changed = true;
                current = p2;
            }
        }
        return current;
    }

    private static boolean areEqual(List<Instruccion> l1, List<Instruccion> l2) {
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            Instruccion i1 = l1.get(i);
            Instruccion i2 = l2.get(i);
            if (!i1.getOp().equals(i2.getOp()) ||
                !i1.getArg1().equals(i2.getArg1()) ||
                !i1.getArg2().equals(i2.getArg2()) ||
                !i1.getResult().equals(i2.getResult())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBinaryOp(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("%") ||
               op.equals("and") || op.equals("or") || op.equals("==") || op.equals("!=") ||
               op.equals(">") || op.equals(">=") || op.equals("<") || op.equals("<=");
    }

    private static boolean isUnaryOp(String op) {
        return op.equals("not") || op.equals("u-");
    }

    private static boolean isConstant(String val) {
        return isInteger(val) || isDecimal(val) || val.equals("true") || val.equals("false") || val.startsWith("'") || val.startsWith("\"");
    }

    private static boolean isInteger(String s) {
        if (s == null || s.isEmpty()) return false;
        int start = (s.charAt(0) == '-') ? 1 : 0;
        if (start == 1 && s.length() == 1) return false;
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    private static boolean isDecimal(String s) {
        if (s == null || s.isEmpty()) return false;
        try {
            Double.parseDouble(s);
            return s.contains(".");
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String evaluateBinary(String op, String arg1, String arg2) {
        try {
            if (isInteger(arg1) && isInteger(arg2)) {
                long a1 = Long.parseLong(arg1);
                long a2 = Long.parseLong(arg2);
                switch (op) {
                    case "+": return String.valueOf(a1 + a2);
                    case "-": return String.valueOf(a1 - a2);
                    case "*": return String.valueOf(a1 * a2);
                    case "/": return a2 != 0 ? String.valueOf(a1 / a2) : null;
                    case "%": return a2 != 0 ? String.valueOf(a1 % a2) : null;
                    case "==": return String.valueOf(a1 == a2);
                    case "!=": return String.valueOf(a1 != a2);
                    case ">": return String.valueOf(a1 > a2);
                    case ">=": return String.valueOf(a1 >= a2);
                    case "<": return String.valueOf(a1 < a2);
                    case "<=": return String.valueOf(a1 <= a2);
                }
            } else if ((isInteger(arg1) || isDecimal(arg1)) && (isInteger(arg2) || isDecimal(arg2))) {
                double a1 = Double.parseDouble(arg1);
                double a2 = Double.parseDouble(arg2);
                switch (op) {
                    case "+": return String.valueOf(a1 + a2);
                    case "-": return String.valueOf(a1 - a2);
                    case "*": return String.valueOf(a1 * a2);
                    case "/": return a2 != 0.0 ? String.valueOf(a1 / a2) : null;
                    case "==": return String.valueOf(a1 == a2);
                    case "!=": return String.valueOf(a1 != a2);
                    case ">": return String.valueOf(a1 > a2);
                    case ">=": return String.valueOf(a1 >= a2);
                    case "<": return String.valueOf(a1 < a2);
                    case "<=": return String.valueOf(a1 <= a2);
                }
            } else if ((arg1.equals("true") || arg1.equals("false")) && (arg2.equals("true") || arg2.equals("false"))) {
                boolean a1 = Boolean.parseBoolean(arg1);
                boolean a2 = Boolean.parseBoolean(arg2);
                switch (op) {
                    case "and": return String.valueOf(a1 && a2);
                    case "or": return String.valueOf(a1 || a2);
                    case "==": return String.valueOf(a1 == a2);
                    case "!=": return String.valueOf(a1 != a2);
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    private static String evaluateUnary(String op, String arg) {
        try {
            if (op.equals("u-")) {
                if (isInteger(arg)) {
                    return String.valueOf(-Long.parseLong(arg));
                } else if (isDecimal(arg)) {
                    return String.valueOf(-Double.parseDouble(arg));
                }
            } else if (op.equals("not")) {
                if (arg.equals("true") || arg.equals("false")) {
                    return String.valueOf(!Boolean.parseBoolean(arg));
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    private static List<Instruccion> pass1(List<Instruccion> current) {
        List<Instruccion> resultList = new ArrayList<>();
        Map<String, String> constMap = new HashMap<>();

        for (Instruccion inst : current) {
            String op = inst.getOp();
            
            // Limpiar mapa de constantes en etiquetas o límites de funciones
            if (op.equals("LABEL") || op.equals("FUNC_START") || op.equals("FUNC_END")) {
                constMap.clear();
                resultList.add(new Instruccion(op, inst.getArg1(), inst.getArg2(), inst.getResult()));
                continue;
            }

            // Propagar constantes a los argumentos
            String arg1 = inst.getArg1();
            String arg2 = inst.getArg2();
            if (constMap.containsKey(arg1)) {
                arg1 = constMap.get(arg1);
            }
            if (constMap.containsKey(arg2)) {
                arg2 = constMap.get(arg2);
            }

            Instruccion propagated = new Instruccion(op, arg1, arg2, inst.getResult());

            // Plegado de constantes
            boolean folded = false;
            if (isBinaryOp(op)) {
                String foldedVal = evaluateBinary(op, arg1, arg2);
                if (foldedVal != null) {
                    propagated.setOp("=");
                    propagated.setArg1(foldedVal);
                    propagated.setArg2("");
                    folded = true;
                }
            } else if (isUnaryOp(op)) {
                String foldedVal = evaluateUnary(op, arg1);
                if (foldedVal != null) {
                    propagated.setOp("=");
                    propagated.setArg1(foldedVal);
                    propagated.setArg2("");
                    folded = true;
                }
            }

            // Simplificación algebraica
            if (!folded && isBinaryOp(op)) {
                if (op.equals("+")) {
                    if (arg1.equals("0")) {
                        propagated.setOp("=");
                        propagated.setArg1(arg2);
                        propagated.setArg2("");
                    } else if (arg2.equals("0")) {
                        propagated.setOp("=");
                        propagated.setArg1(arg1);
                        propagated.setArg2("");
                    }
                } else if (op.equals("-")) {
                    if (arg2.equals("0")) {
                        propagated.setOp("=");
                        propagated.setArg1(arg1);
                        propagated.setArg2("");
                    }
                } else if (op.equals("*")) {
                    if (arg1.equals("1")) {
                        propagated.setOp("=");
                        propagated.setArg1(arg2);
                        propagated.setArg2("");
                    } else if (arg2.equals("1")) {
                        propagated.setOp("=");
                        propagated.setArg1(arg1);
                        propagated.setArg2("");
                    } else if (arg1.equals("0") || arg2.equals("0")) {
                        propagated.setOp("=");
                        propagated.setArg1("0");
                        propagated.setArg2("");
                    } else if (arg1.equals("2")) {
                        propagated.setOp("+");
                        propagated.setArg1(arg2);
                        propagated.setArg2(arg2);
                    } else if (arg2.equals("2")) {
                        propagated.setOp("+");
                        propagated.setArg1(arg1);
                        propagated.setArg2(arg1);
                    }
                }
            }

            // Actualizar mapa de constantes si es asignación de constante
            String res = propagated.getResult();
            if (propagated.getOp().equals("=") && isConstant(propagated.getArg1())) {
                if (!res.isEmpty()) {
                    constMap.put(res, propagated.getArg1());
                }
            } else {
                if (!res.isEmpty()) {
                    constMap.remove(res);
                }
            }

            resultList.add(propagated);
        }
        return resultList;
    }

    private static List<Instruccion> passDeadCode(List<Instruccion> current) {
        List<Instruccion> resultList = new ArrayList<>();
        
        // 1. Eliminación de código inalcanzable (luego de goto/return)
        boolean unreachable = false;
        for (Instruccion inst : current) {
            String op = inst.getOp();
            if (op.equals("LABEL") || op.equals("FUNC_START") || op.equals("FUNC_END")) {
                unreachable = false;
            }

            if (!unreachable) {
                resultList.add(inst);
            }

            if (op.equals("GOTO") || op.equals("RETURN")) {
                unreachable = true;
            }
        }

        // 2. Eliminación de asignación redundante (x = x)
        List<Instruccion> cleanAssignments = new ArrayList<>();
        for (Instruccion inst : resultList) {
            if (inst.getOp().equals("=") && inst.getResult().equals(inst.getArg1())) {
                continue;
            }
            cleanAssignments.add(inst);
        }

        // 3. Eliminación de temporales no utilizados
        // Contar lecturas para temporales (t1, t2, ...)
        Map<String, Integer> refCounts = new HashMap<>();
        for (Instruccion inst : cleanAssignments) {
            String op = inst.getOp();
            if (op.equals("DECLARE") || op.equals("FUNC_START") || op.equals("FUNC_END") || op.equals("COMMENT")) {
                continue;
            }
            
            // Leer operandos
            addRef(inst.getArg1(), refCounts);
            addRef(inst.getArg2(), refCounts);
            
            if (op.equals("IF")) {
                addRef(inst.getResult(), refCounts);
            }
        }

        List<Instruccion> finalInstructions = new ArrayList<>();
        for (Instruccion inst : cleanAssignments) {
            String res = inst.getResult();
            if (res.matches("^t\\d+$")) {
                // Si es un temporal sin lecturas, descartar su asignación
                if (!refCounts.containsKey(res) || refCounts.get(res) == 0) {
                    // Asegurar que no sea una llamada CALL con efectos secundarios
                    if (!inst.getOp().equals("CALL")) {
                        continue;
                    } else {
                        // Si es llamada, mantenerla pero quitar asignación
                        inst.setResult("");
                    }
                }
            }
            finalInstructions.add(inst);
        }

        return finalInstructions;
    }

    private static void addRef(String operand, Map<String, Integer> refCounts) {
        if (operand != null && operand.matches("^t\\d+$")) {
            refCounts.put(operand, refCounts.getOrDefault(operand, 0) + 1);
        }
    }
}
