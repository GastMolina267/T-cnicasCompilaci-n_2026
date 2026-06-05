package com.compilador;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.gui.TreeViewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    // Códigos de escape ANSI para colores
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -jar target/demo-1.0-jar-with-dependencies.jar <archivo.txt>");
            System.exit(1);
        }

        String inputFileName = args[0];
        System.out.println(GREEN + BOLD + "🚀 Iniciando compilación de: " + inputFileName + RESET);
        System.out.println("============================================================");

        try {
            // 1. ANÁLISIS LÉXICO
            System.out.println("\n=== 1. ANÁLISIS LÉXICO ===");
            CharStream inputLexico = CharStreams.fromFileName(inputFileName);
            MiLenguajeLexer lexer = new MiLenguajeLexer(inputLexico);
            
            // Recolectar tokens
            List<String> erroresLexicos = new ArrayList<>();
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, 
                                       int line, int charPositionInLine, String msg, RecognitionException e) {
                    erroresLexicos.add("❌ Error: ERROR LÉXICO en línea " + line + ":" + charPositionInLine + " - " + msg);
                }
            });

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();

            if (!erroresLexicos.isEmpty()) {
                System.out.println(RED + "\n❌ ERRORES LÉXICOS DETECTADOS:" + RESET);
                for (String err : erroresLexicos) {
                    System.out.println(RED + "   " + err + RESET);
                }
                System.out.println(RED + "\n❌ Compilación detenida debido a errores léxicos." + RESET);
                System.exit(1);
            }

            // Imprimir cantidad de tokens
            System.out.printf("   📊 Tokens procesados: %d\n", tokens.getTokens().size() - 1);
            System.out.println("✅ Análisis léxico completado sin errores.");

            // 2. ANÁLISIS SINTÁCTICO
            System.out.println("\n=== 2. ANÁLISIS SINTÁCTICO ===");
            MiLenguajeParser parser = new MiLenguajeParser(tokens);
            List<String> erroresSintacticos = new ArrayList<>();
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, 
                                       int line, int charPositionInLine, String msg, RecognitionException e) {
                    erroresSintacticos.add("❌ Error: ERROR SINTÁCTICO en línea " + line + ":" + charPositionInLine + " - " + msg);
                }
            });

            ParseTree tree = parser.programa();

            if (!erroresSintacticos.isEmpty()) {
                System.out.println(RED + "\n❌ ERRORES SINTÁCTICOS DETECTADOS:" + RESET);
                for (String err : erroresSintacticos) {
                    System.out.println(RED + "   " + err + RESET);
                }
                System.out.println(RED + "\n❌ Compilación detenida debido a errores sintácticos." + RESET);
                System.exit(1);
            }

            System.out.println("✅ Análisis sintáctico completado sin errores.");
            System.out.println("   📊 Árbol sintáctico generado correctamente.");

            // 3. VISUALIZACIÓN DEL AST
            System.out.println("\n=== 3. VISUALIZACIÓN DEL AST ===");
            try {
                mostrarArbolGrafico(tree, parser);
                System.out.println("   📊 Ventana del árbol sintáctico abierta.");
            } catch (Exception e) {
                System.out.println(YELLOW + "   ⚠️ No se pudo abrir la ventana gráfica (entorno headless): " + e.getMessage() + RESET);
            }

            // 4. ANÁLISIS SEMÁNTICO
            System.out.println("\n=== 4. ANÁLISIS SEMÁNTICO ===");
            SemanticVisitor semanticVisitor = new SemanticVisitor();
            semanticVisitor.visit(tree);

            // Imprimir Tabla de Símbolos
            System.out.println("\n=== TABLA DE SÍMBOLOS ===");
            System.out.printf("%-15s %-10s %-15s %-10s %-10s %-15s %s\n", 
                "NOMBRE", "TIPO", "CATEGORÍA", "LÍNEA", "COLUMNA", "ÁMBITO", "DETALLES");
            System.out.println("--------------------------------------------------------------------------------------------");
            for (Symbol s : semanticVisitor.getTablaSimbolos().getAllSymbols()) {
                String detalles = "";
                if (s.isArray()) {
                    detalles += "[arr:" + s.getSize() + "] ";
                }
                if (s.getCategoria().equals("funcion")) {
                    detalles += s.getParametroTipos().toString() + " ";
                }
                detalles += "[private]";
                System.out.printf("%-15s %-10s %-15s %-10d %-10d %-15s %s\n",
                    s.getNombre(), s.getTipo(), s.getCategoria(), s.getLinea(), s.getColumna(), s.getAmbito(), detalles);
            }
            System.out.println();

            // Imprimir Warnings
            List<String> warnings = semanticVisitor.getWarnings();
            if (!warnings.isEmpty()) {
                System.out.println(YELLOW + "⚠️ WARNINGS SEMÁNTICOS:" + RESET);
                for (String wrn : warnings) {
                    System.out.println(YELLOW + "   " + wrn + RESET);
                }
            }

            // Imprimir Errores
            List<String> erroresSemanticos = semanticVisitor.getErrores();
            if (!erroresSemanticos.isEmpty()) {
                System.out.println(RED + "❌ ERRORES SEMÁNTICOS:" + RESET);
                for (String err : erroresSemanticos) {
                    System.out.println(RED + "   " + err + RESET);
                }
                System.out.println(RED + "\n❌ Compilación detenida debido a errores semánticos." + RESET);
                System.exit(1);
            }

            System.out.println(GREEN + "✅ Análisis semántico completado sin errores." + RESET);

            // Determinar nombres de archivos de salida
            String baseName = inputFileName;
            int dotIndex = inputFileName.lastIndexOf('.');
            if (dotIndex > 0) {
                baseName = inputFileName.substring(0, dotIndex);
            }
            String fileIntermedio = baseName + "_codigo_intermedio.txt";
            String fileOptimizado = baseName + "_codigo_optimizado.txt";

            // 5. GENERACIÓN DE CÓDIGO INTERMEDIO
            System.out.println("\n=== 5. GENERACIÓN DE CÓDIGO INTERMEDIO ===");
            System.out.println("   🎯 Iniciando recorrido del AST con CodigoVisitor...");
            
            CodigoVisitor codigoVisitor = new CodigoVisitor();
            codigoVisitor.visit(tree);
            List<Instruccion> tacOriginal = codigoVisitor.getInstrucciones();

            // Imprimir TAC en consola y escribir archivo
            System.out.println("   📝 Código de tres direcciones generado:\n");
            try (PrintWriter out = new PrintWriter(new FileWriter(fileIntermedio))) {
                for (int i = 0; i < tacOriginal.size(); i++) {
                    String instStr = tacOriginal.get(i).toString();
                    if (!instStr.isEmpty()) {
                        String formattedLine = String.format("  %d: %s", i, instStr);
                        System.out.println(formattedLine);
                        out.println(formattedLine);
                    }
                }
            }
            System.out.println(GREEN + "\n✅ Código intermedio guardado en: " + fileIntermedio + RESET);

            // 6. OPTIMIZACIÓN DE CÓDIGO
            System.out.println("\n=== 6. OPTIMIZACIÓN DE CÓDIGO ===");
            System.out.println("   🔧 Aplicando optimizaciones al código intermedio...");
            
            List<Instruccion> tacOptimizado = Optimizador.optimizar(tacOriginal);

            // Imprimir TAC optimizado en consola y escribir archivo
            System.out.println("   📝 Código optimizado:\n");
            int nonCommentLinesOriginal = 0;
            for (Instruccion inst : tacOriginal) {
                if (!inst.toString().isEmpty() && !inst.getOp().equals("COMMENT")) {
                    nonCommentLinesOriginal++;
                }
            }

            int nonCommentLinesOptimized = 0;
            try (PrintWriter out = new PrintWriter(new FileWriter(fileOptimizado))) {
                int lineIndex = 0;
                for (Instruccion inst : tacOptimizado) {
                    String instStr = inst.toString();
                    if (!instStr.isEmpty()) {
                        String formattedLine = String.format("  %d: %s", lineIndex, instStr);
                        System.out.println(formattedLine);
                        out.println(formattedLine);
                        lineIndex++;
                        if (!inst.getOp().equals("COMMENT")) {
                            nonCommentLinesOptimized++;
                        }
                    }
                }
            }

            // Cálculo de métricas
            int diff = nonCommentLinesOriginal - nonCommentLinesOptimized;
            double reductionPercent = nonCommentLinesOriginal > 0 ? ((double) diff / nonCommentLinesOriginal) * 100 : 0.0;

            System.out.println(GREEN + "\n✅ Optimización completada:" + RESET);
            System.out.printf("   📊 Instrucciones originales: %d\n", nonCommentLinesOriginal);
            System.out.printf("   📊 Instrucciones optimizadas: %d\n", nonCommentLinesOptimized);
            System.out.printf("   📊 Instrucciones eliminadas: %d\n", diff);
            System.out.printf("   📊 Reducción de código: %.2f%%\n", reductionPercent);
            System.out.println(GREEN + "✅ Código optimizado guardado en: " + fileOptimizado + RESET);

            // 7. RESUMEN DE COMPILACIÓN
            System.out.println("\n=== 7. RESUMEN DE COMPILACIÓN ===");
            System.out.printf("   📁 Archivo procesado: %s\n", inputFileName);
            System.out.printf("   🔤 Tokens analizados: %d\n", tokens.getTokens().size() - 1);
            System.out.printf("   📊 Símbolos en tabla: %d\n", semanticVisitor.getTablaSimbolos().getAllSymbols().size());
            System.out.printf("   📝 Instrucciones generadas: %d\n", nonCommentLinesOriginal);
            System.out.printf("   🔧 Instrucciones optimizadas: %d\n", nonCommentLinesOptimized);
            System.out.printf("   📄 Archivo código intermedio: %s\n", fileIntermedio);
            System.out.printf("   📄 Archivo código optimizado: %s\n", fileOptimizado);

            System.out.println("\n" + GREEN + BOLD + "🎉 ¡COMPILACIÓN Y OPTIMIZACIÓN EXITOSA! 🎉" + RESET);

        } catch (IOException e) {
            System.err.println(RED + "❌ Error al leer el archivo: " + e.getMessage() + RESET);
        } catch (Exception e) {
            System.err.println(RED + "❌ Error inesperado: " + e.getMessage() + RESET);
            e.printStackTrace();
        }
    }

    private static void mostrarArbolGrafico(ParseTree tree, MiLenguajeParser parser) {
        // Crear una ventana para mostrar el árbol
        JFrame frame = new JFrame("Árbol Sintáctico - Expresión Aritmética");
        JPanel panel = new JPanel();
        
        // Crear visualizador de árbol
        TreeViewer viewer = new TreeViewer(Arrays.asList(
                parser.getRuleNames()), tree);
        viewer.setScale(1.5); // Escalar para mejor visualización
        
        panel.add(viewer);
        
        // Añadir scroll para árboles grandes
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}