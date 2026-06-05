package com.compilador;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Symbol {
    private String nombre;
    private String tipo;
    private String categoria; // "variable", "parametro", "funcion"
    private int linea;
    private int columna;
    private String ambito;
    private int size; // -1 si no es un array
    private List<String> parametroTipos; // Para funciones
    private boolean usado;

    public Symbol(String nombre, String tipo, String categoria, int linea, int columna, String ambito) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.categoria = categoria;
        this.linea = linea;
        this.columna = columna;
        this.ambito = ambito;
        this.size = -1;
        this.parametroTipos = new ArrayList<>();
        this.usado = false;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getCategoria() { return categoria; }
    public int getLinea() { return linea; }
    public int getColumna() { return columna; }
    public String getAmbito() { return ambito; }
    
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
    public boolean isArray() { return size >= 0; }

    public List<String> getParametroTipos() { return parametroTipos; }
    public void setParametroTipos(List<String> parametroTipos) { this.parametroTipos = parametroTipos; }

    public boolean isUsado() { return usado; }
    public void setUsado(boolean usado) { this.usado = usado; }
}

class Scope {
    private String nombreScope;
    private Scope parent;
    private Map<String, Symbol> simbolos;

    public Scope(String nombreScope, Scope parent) {
        this.nombreScope = nombreScope;
        this.parent = parent;
        this.simbolos = new LinkedHashMap<>();
    }

    public String getNombreScope() { return nombreScope; }
    public Scope getParent() { return parent; }
    public Map<String, Symbol> getSimbolos() { return simbolos; }

    public boolean insert(Symbol s) {
        if (simbolos.containsKey(s.getNombre())) {
            return false;
        }
        simbolos.put(s.getNombre(), s);
        return true;
    }

    public Symbol resolve(String name) {
        Symbol s = simbolos.get(name);
        if (s != null) {
            return s;
        }
        if (parent != null) {
            return parent.resolve(name);
        }
        return null;
    }
}

public class TablaSimbolos {
    private Scope currentScope;
    private List<Symbol> allSymbols;

    public TablaSimbolos() {
        this.currentScope = new Scope("global", null);
        this.allSymbols = new ArrayList<>();
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    public void openScope(String name) {
        currentScope = new Scope(name, currentScope);
    }

    public void closeScope() {
        if (currentScope.getParent() != null) {
            currentScope = currentScope.getParent();
        }
    }

    public boolean insert(Symbol s) {
        boolean success = currentScope.insert(s);
        if (success) {
            allSymbols.add(s);
        }
        return success;
    }

    public Symbol resolve(String name) {
        return currentScope.resolve(name);
    }

    public List<Symbol> getAllSymbols() {
        return allSymbols;
    }

    public void markAsUsed(String name) {
        Symbol s = resolve(name);
        if (s != null) {
            s.setUsado(true);
        }
    }
}
