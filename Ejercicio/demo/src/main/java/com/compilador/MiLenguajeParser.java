// Generated from com\compilador\MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiLenguajeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PA=1, PC=2, CA=3, CC=4, LA=5, LC=6, PYC=7, COMA=8, DOS_PUNTOS=9, IGUAL=10, 
		TRUE=11, FALSE=12, AND=13, MAYOR=14, MAYOR_IGUAL=15, MENOR=16, MENOR_IGUAL=17, 
		EQL=18, DISTINTO=19, SUM=20, RES=21, MUL=22, DIV=23, MOD=24, OR=25, NOT=26, 
		FOR=27, WHILE=28, IF=29, ELSE=30, SWITCH=31, CASE=32, DEFAULT=33, BREAK=34, 
		DO=35, CONTINUE=36, PRINT=37, INT=38, CHAR=39, DOUBLE=40, VOID=41, BOOL=42, 
		RETURN=43, ID=44, INTEGER=45, DECIMAL=46, CHARACTER=47, STRING=48, COMENTARIO_LINEA=49, 
		COMENTARIO_BLOQUE=50, WS=51, OTRO=52;
	public static final int
		RULE_programa = 0, RULE_unidad = 1, RULE_instruccion = 2, RULE_bloque = 3, 
		RULE_declaracionFuncion = 4, RULE_parametros = 5, RULE_parametro = 6, 
		RULE_declaracion = 7, RULE_declaracion_sin_pyc = 8, RULE_tipo = 9, RULE_asignacion = 10, 
		RULE_lvalue = 11, RULE_asignacion_sin_pyc = 12, RULE_sentenciaIf = 13, 
		RULE_sentenciaWhile = 14, RULE_sentenciaDoWhile = 15, RULE_sentenciaFor = 16, 
		RULE_sentenciaSwitch = 17, RULE_caseBlock = 18, RULE_sentenciaReturn = 19, 
		RULE_sentenciaBreak = 20, RULE_sentenciaContinue = 21, RULE_sentenciaPrint = 22, 
		RULE_expr = 23, RULE_factor = 24, RULE_token = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "unidad", "instruccion", "bloque", "declaracionFuncion", 
			"parametros", "parametro", "declaracion", "declaracion_sin_pyc", "tipo", 
			"asignacion", "lvalue", "asignacion_sin_pyc", "sentenciaIf", "sentenciaWhile", 
			"sentenciaDoWhile", "sentenciaFor", "sentenciaSwitch", "caseBlock", "sentenciaReturn", 
			"sentenciaBreak", "sentenciaContinue", "sentenciaPrint", "expr", "factor", 
			"token"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "','", "':'", 
			"'='", "'true'", "'false'", "'and'", "'>'", "'>='", "'<'", "'<='", "'=='", 
			"'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'or'", "'not'", "'for'", 
			"'while'", "'if'", "'else'", "'switch'", "'case'", "'default'", "'break'", 
			"'do'", "'continue'", "'print'", "'int'", "'char'", "'double'", "'void'", 
			"'bool'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", "DOS_PUNTOS", 
			"IGUAL", "TRUE", "FALSE", "AND", "MAYOR", "MAYOR_IGUAL", "MENOR", "MENOR_IGUAL", 
			"EQL", "DISTINTO", "SUM", "RES", "MUL", "DIV", "MOD", "OR", "NOT", "FOR", 
			"WHILE", "IF", "ELSE", "SWITCH", "CASE", "DEFAULT", "BREAK", "DO", "CONTINUE", 
			"PRINT", "INT", "CHAR", "DOUBLE", "VOID", "BOOL", "RETURN", "ID", "INTEGER", 
			"DECIMAL", "CHARACTER", "STRING", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", 
			"WS", "OTRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiLenguaje.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiLenguajeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiLenguajeParser.EOF, 0); }
		public List<UnidadContext> unidad() {
			return getRuleContexts(UnidadContext.class);
		}
		public UnidadContext unidad(int i) {
			return getRuleContext(UnidadContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << LA) | (1L << PYC) | (1L << RES) | (1L << NOT) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << SWITCH) | (1L << BREAK) | (1L << DO) | (1L << CONTINUE) | (1L << PRINT) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << BOOL) | (1L << RETURN) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
				{
				{
				setState(52);
				unidad();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnidadContext extends ParserRuleContext {
		public DeclaracionFuncionContext declaracionFuncion() {
			return getRuleContext(DeclaracionFuncionContext.class,0);
		}
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public UnidadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unidad; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitUnidad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnidadContext unidad() throws RecognitionException {
		UnidadContext _localctx = new UnidadContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_unidad);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				declaracionFuncion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				instruccion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstruccionContext extends ParserRuleContext {
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public SentenciaIfContext sentenciaIf() {
			return getRuleContext(SentenciaIfContext.class,0);
		}
		public SentenciaWhileContext sentenciaWhile() {
			return getRuleContext(SentenciaWhileContext.class,0);
		}
		public SentenciaDoWhileContext sentenciaDoWhile() {
			return getRuleContext(SentenciaDoWhileContext.class,0);
		}
		public SentenciaForContext sentenciaFor() {
			return getRuleContext(SentenciaForContext.class,0);
		}
		public SentenciaSwitchContext sentenciaSwitch() {
			return getRuleContext(SentenciaSwitchContext.class,0);
		}
		public SentenciaReturnContext sentenciaReturn() {
			return getRuleContext(SentenciaReturnContext.class,0);
		}
		public SentenciaBreakContext sentenciaBreak() {
			return getRuleContext(SentenciaBreakContext.class,0);
		}
		public SentenciaContinueContext sentenciaContinue() {
			return getRuleContext(SentenciaContinueContext.class,0);
		}
		public SentenciaPrintContext sentenciaPrint() {
			return getRuleContext(SentenciaPrintContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruccion);
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				bloque();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				declaracion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				asignacion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				sentenciaIf();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				sentenciaWhile();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(69);
				sentenciaDoWhile();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(70);
				sentenciaFor();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(71);
				sentenciaSwitch();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(72);
				sentenciaReturn();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(73);
				sentenciaBreak();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(74);
				sentenciaContinue();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(75);
				sentenciaPrint();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(76);
				expr(0);
				setState(77);
				match(PYC);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(79);
				match(PYC);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LA() { return getToken(MiLenguajeParser.LA, 0); }
		public TerminalNode LC() { return getToken(MiLenguajeParser.LC, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(LA);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << LA) | (1L << PYC) | (1L << RES) | (1L << NOT) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << SWITCH) | (1L << BREAK) | (1L << DO) | (1L << CONTINUE) | (1L << PRINT) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << BOOL) | (1L << RETURN) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
				{
				{
				setState(83);
				instruccion();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(LC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionFuncionContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public DeclaracionFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionFuncion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDeclaracionFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionFuncionContext declaracionFuncion() throws RecognitionException {
		DeclaracionFuncionContext _localctx = new DeclaracionFuncionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracionFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			tipo();
			setState(92);
			match(ID);
			setState(93);
			match(PA);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << BOOL))) != 0)) {
				{
				setState(94);
				parametros();
				}
			}

			setState(97);
			match(PC);
			setState(98);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MiLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MiLenguajeParser.COMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			parametro();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(101);
				match(COMA);
				setState(102);
				parametro();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			tipo();
			setState(109);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public TerminalNode CA() { return getToken(MiLenguajeParser.CA, 0); }
		public TerminalNode INTEGER() { return getToken(MiLenguajeParser.INTEGER, 0); }
		public TerminalNode CC() { return getToken(MiLenguajeParser.CC, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			tipo();
			setState(112);
			match(ID);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CA) {
				{
				setState(113);
				match(CA);
				setState(114);
				match(INTEGER);
				setState(115);
				match(CC);
				}
			}

			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(118);
				match(IGUAL);
				setState(119);
				expr(0);
				}
			}

			setState(122);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracion_sin_pycContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode CA() { return getToken(MiLenguajeParser.CA, 0); }
		public TerminalNode INTEGER() { return getToken(MiLenguajeParser.INTEGER, 0); }
		public TerminalNode CC() { return getToken(MiLenguajeParser.CC, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Declaracion_sin_pycContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_sin_pyc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDeclaracion_sin_pyc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracion_sin_pycContext declaracion_sin_pyc() throws RecognitionException {
		Declaracion_sin_pycContext _localctx = new Declaracion_sin_pycContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaracion_sin_pyc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			tipo();
			setState(125);
			match(ID);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CA) {
				{
				setState(126);
				match(CA);
				setState(127);
				match(INTEGER);
				setState(128);
				match(CC);
				}
			}

			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(131);
				match(IGUAL);
				setState(132);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiLenguajeParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(MiLenguajeParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(MiLenguajeParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(MiLenguajeParser.VOID, 0); }
		public TerminalNode BOOL() { return getToken(MiLenguajeParser.BOOL, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << BOOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsignacionContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			lvalue();
			setState(138);
			match(IGUAL);
			setState(139);
			expr(0);
			setState(140);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode CA() { return getToken(MiLenguajeParser.CA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CC() { return getToken(MiLenguajeParser.CC, 0); }
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_lvalue);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(ID);
				setState(144);
				match(CA);
				setState(145);
				expr(0);
				setState(146);
				match(CC);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Asignacion_sin_pycContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Asignacion_sin_pycContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion_sin_pyc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitAsignacion_sin_pyc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asignacion_sin_pycContext asignacion_sin_pyc() throws RecognitionException {
		Asignacion_sin_pycContext _localctx = new Asignacion_sin_pycContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_asignacion_sin_pyc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			lvalue();
			setState(151);
			match(IGUAL);
			setState(152);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaIfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiLenguajeParser.IF, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiLenguajeParser.ELSE, 0); }
		public SentenciaIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaIf; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaIfContext sentenciaIf() throws RecognitionException {
		SentenciaIfContext _localctx = new SentenciaIfContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sentenciaIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(IF);
			setState(155);
			match(PA);
			setState(156);
			expr(0);
			setState(157);
			match(PC);
			setState(158);
			instruccion();
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(159);
				match(ELSE);
				setState(160);
				instruccion();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaWhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiLenguajeParser.WHILE, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public SentenciaWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaWhile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaWhileContext sentenciaWhile() throws RecognitionException {
		SentenciaWhileContext _localctx = new SentenciaWhileContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sentenciaWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(WHILE);
			setState(164);
			match(PA);
			setState(165);
			expr(0);
			setState(166);
			match(PC);
			setState(167);
			instruccion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaDoWhileContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(MiLenguajeParser.DO, 0); }
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(MiLenguajeParser.WHILE, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public SentenciaDoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaDoWhile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaDoWhileContext sentenciaDoWhile() throws RecognitionException {
		SentenciaDoWhileContext _localctx = new SentenciaDoWhileContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sentenciaDoWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(DO);
			setState(170);
			instruccion();
			setState(171);
			match(WHILE);
			setState(172);
			match(PA);
			setState(173);
			expr(0);
			setState(174);
			match(PC);
			setState(175);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiLenguajeParser.FOR, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public List<TerminalNode> PYC() { return getTokens(MiLenguajeParser.PYC); }
		public TerminalNode PYC(int i) {
			return getToken(MiLenguajeParser.PYC, i);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public Declaracion_sin_pycContext declaracion_sin_pyc() {
			return getRuleContext(Declaracion_sin_pycContext.class,0);
		}
		public List<Asignacion_sin_pycContext> asignacion_sin_pyc() {
			return getRuleContexts(Asignacion_sin_pycContext.class);
		}
		public Asignacion_sin_pycContext asignacion_sin_pyc(int i) {
			return getRuleContext(Asignacion_sin_pycContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SentenciaForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaFor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaForContext sentenciaFor() throws RecognitionException {
		SentenciaForContext _localctx = new SentenciaForContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sentenciaFor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(FOR);
			setState(178);
			match(PA);
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(179);
				declaracion_sin_pyc();
				}
				break;
			case 2:
				{
				setState(180);
				asignacion_sin_pyc();
				}
				break;
			case 3:
				{
				setState(181);
				expr(0);
				}
				break;
			}
			setState(184);
			match(PYC);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << RES) | (1L << NOT) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
				{
				setState(185);
				expr(0);
				}
			}

			setState(188);
			match(PYC);
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(189);
				asignacion_sin_pyc();
				}
				break;
			case 2:
				{
				setState(190);
				expr(0);
				}
				break;
			}
			setState(193);
			match(PC);
			setState(194);
			instruccion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaSwitchContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(MiLenguajeParser.SWITCH, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public TerminalNode LA() { return getToken(MiLenguajeParser.LA, 0); }
		public TerminalNode LC() { return getToken(MiLenguajeParser.LC, 0); }
		public List<CaseBlockContext> caseBlock() {
			return getRuleContexts(CaseBlockContext.class);
		}
		public CaseBlockContext caseBlock(int i) {
			return getRuleContext(CaseBlockContext.class,i);
		}
		public SentenciaSwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaSwitch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaSwitch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaSwitchContext sentenciaSwitch() throws RecognitionException {
		SentenciaSwitchContext _localctx = new SentenciaSwitchContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sentenciaSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(SWITCH);
			setState(197);
			match(PA);
			setState(198);
			expr(0);
			setState(199);
			match(PC);
			setState(200);
			match(LA);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(201);
				caseBlock();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
			match(LC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaseBlockContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(MiLenguajeParser.CASE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOS_PUNTOS() { return getToken(MiLenguajeParser.DOS_PUNTOS, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public TerminalNode DEFAULT() { return getToken(MiLenguajeParser.DEFAULT, 0); }
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitCaseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_caseBlock);
		int _la;
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(CASE);
				setState(210);
				expr(0);
				setState(211);
				match(DOS_PUNTOS);
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << LA) | (1L << PYC) | (1L << RES) | (1L << NOT) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << SWITCH) | (1L << BREAK) | (1L << DO) | (1L << CONTINUE) | (1L << PRINT) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << BOOL) | (1L << RETURN) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
					{
					{
					setState(212);
					instruccion();
					}
					}
					setState(217);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(DEFAULT);
				setState(219);
				match(DOS_PUNTOS);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << LA) | (1L << PYC) | (1L << RES) | (1L << NOT) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << SWITCH) | (1L << BREAK) | (1L << DO) | (1L << CONTINUE) | (1L << PRINT) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << BOOL) | (1L << RETURN) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
					{
					{
					setState(220);
					instruccion();
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiLenguajeParser.RETURN, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SentenciaReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaReturn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaReturnContext sentenciaReturn() throws RecognitionException {
		SentenciaReturnContext _localctx = new SentenciaReturnContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sentenciaReturn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(RETURN);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << RES) | (1L << NOT) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
				{
				setState(229);
				expr(0);
				}
			}

			setState(232);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaBreakContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MiLenguajeParser.BREAK, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public SentenciaBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaBreak; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaBreakContext sentenciaBreak() throws RecognitionException {
		SentenciaBreakContext _localctx = new SentenciaBreakContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sentenciaBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(BREAK);
			setState(235);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContinueContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MiLenguajeParser.CONTINUE, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public SentenciaContinueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaContinue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaContinue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContinueContext sentenciaContinue() throws RecognitionException {
		SentenciaContinueContext _localctx = new SentenciaContinueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_sentenciaContinue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(CONTINUE);
			setState(238);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaPrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(MiLenguajeParser.PRINT, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING() { return getToken(MiLenguajeParser.STRING, 0); }
		public SentenciaPrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaPrint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaPrintContext sentenciaPrint() throws RecognitionException {
		SentenciaPrintContext _localctx = new SentenciaPrintContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_sentenciaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(PRINT);
			setState(241);
			match(PA);
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(242);
				expr(0);
				}
				break;
			case 2:
				{
				setState(243);
				match(STRING);
				}
				break;
			}
			setState(246);
			match(PC);
			setState(247);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AdditionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SUM() { return getToken(MiLenguajeParser.SUM, 0); }
		public AdditionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(MiLenguajeParser.MUL, 0); }
		public MultiplicationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModuloContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MOD() { return getToken(MiLenguajeParser.MOD, 0); }
		public ModuloContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitModulo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryMinusContext extends ExprContext {
		public TerminalNode RES() { return getToken(MiLenguajeParser.RES, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitUnaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalOrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(MiLenguajeParser.OR, 0); }
		public LogicalOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLogicalOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentContext extends ExprContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalNotContext extends ExprContext {
		public TerminalNode NOT() { return getToken(MiLenguajeParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LogicalNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLogicalNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtractionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RES() { return getToken(MiLenguajeParser.RES, 0); }
		public SubtractionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MAYOR() { return getToken(MiLenguajeParser.MAYOR, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(MiLenguajeParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR() { return getToken(MiLenguajeParser.MENOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(MiLenguajeParser.MENOR_IGUAL, 0); }
		public ComparisonContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryContext extends ExprContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public PrimaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalAndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(MiLenguajeParser.AND, 0); }
		public LogicalAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLogicalAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(MiLenguajeParser.DIV, 0); }
		public DivisionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQL() { return getToken(MiLenguajeParser.EQL, 0); }
		public EqualityContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InequalityContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DISTINTO() { return getToken(MiLenguajeParser.DISTINTO, 0); }
		public InequalityContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitInequality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				_localctx = new AssignmentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(250);
				lvalue();
				setState(251);
				match(IGUAL);
				setState(252);
				expr(14);
				}
				break;
			case 2:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(254);
				match(NOT);
				setState(255);
				expr(3);
				}
				break;
			case 3:
				{
				_localctx = new UnaryMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(RES);
				setState(257);
				expr(2);
				}
				break;
			case 4:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				factor();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(291);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(261);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(262);
						match(OR);
						setState(263);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new LogicalAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(264);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(265);
						match(AND);
						setState(266);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(267);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(268);
						match(EQL);
						setState(269);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new InequalityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(270);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(271);
						match(DISTINTO);
						setState(272);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(273);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(274);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAYOR) | (1L << MAYOR_IGUAL) | (1L << MENOR) | (1L << MENOR_IGUAL))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(275);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new AdditionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(276);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(277);
						match(SUM);
						setState(278);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new SubtractionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(280);
						match(RES);
						setState(281);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new MultiplicationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(282);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(283);
						match(MUL);
						setState(284);
						expr(7);
						}
						break;
					case 9:
						{
						_localctx = new DivisionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(285);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(286);
						match(DIV);
						setState(287);
						expr(6);
						}
						break;
					case 10:
						{
						_localctx = new ModuloContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(288);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(289);
						match(MOD);
						setState(290);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayAccessContext extends FactorContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode CA() { return getToken(MiLenguajeParser.CA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CC() { return getToken(MiLenguajeParser.CC, 0); }
		public ArrayAccessContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierContext extends FactorContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public IdentifierContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecLiteralContext extends FactorContext {
		public TerminalNode DECIMAL() { return getToken(MiLenguajeParser.DECIMAL, 0); }
		public DecLiteralContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDecLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiteralContext extends FactorContext {
		public TerminalNode CHARACTER() { return getToken(MiLenguajeParser.CHARACTER, 0); }
		public CharLiteralContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitCharLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends FactorContext {
		public TerminalNode STRING() { return getToken(MiLenguajeParser.STRING, 0); }
		public StringLiteralContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralContext extends FactorContext {
		public TerminalNode INTEGER() { return getToken(MiLenguajeParser.INTEGER, 0); }
		public IntLiteralContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedExprContext extends FactorContext {
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public ParenthesizedExprContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitParenthesizedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends FactorContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MiLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MiLenguajeParser.COMA, i);
		}
		public FunctionCallContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_factor);
		int _la;
		try {
			setState(323);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new FunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(ID);
				setState(297);
				match(PA);
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << RES) | (1L << NOT) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
					{
					setState(298);
					expr(0);
					setState(303);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(299);
						match(COMA);
						setState(300);
						expr(0);
						}
						}
						setState(305);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(308);
				match(PC);
				}
				break;
			case 2:
				_localctx = new ArrayAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				match(ID);
				setState(310);
				match(CA);
				setState(311);
				expr(0);
				setState(312);
				match(CC);
				}
				break;
			case 3:
				_localctx = new IdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				match(ID);
				}
				break;
			case 4:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(315);
				match(INTEGER);
				}
				break;
			case 5:
				_localctx = new DecLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(316);
				match(DECIMAL);
				}
				break;
			case 6:
				_localctx = new CharLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(317);
				match(CHARACTER);
				}
				break;
			case 7:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(318);
				match(STRING);
				}
				break;
			case 8:
				_localctx = new ParenthesizedExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(319);
				match(PA);
				setState(320);
				expr(0);
				setState(321);
				match(PC);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenContext extends ParserRuleContext {
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public TerminalNode CA() { return getToken(MiLenguajeParser.CA, 0); }
		public TerminalNode CC() { return getToken(MiLenguajeParser.CC, 0); }
		public TerminalNode LA() { return getToken(MiLenguajeParser.LA, 0); }
		public TerminalNode LC() { return getToken(MiLenguajeParser.LC, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public TerminalNode COMA() { return getToken(MiLenguajeParser.COMA, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public TerminalNode MAYOR() { return getToken(MiLenguajeParser.MAYOR, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(MiLenguajeParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR() { return getToken(MiLenguajeParser.MENOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(MiLenguajeParser.MENOR_IGUAL, 0); }
		public TerminalNode EQL() { return getToken(MiLenguajeParser.EQL, 0); }
		public TerminalNode DISTINTO() { return getToken(MiLenguajeParser.DISTINTO, 0); }
		public TerminalNode SUM() { return getToken(MiLenguajeParser.SUM, 0); }
		public TerminalNode RES() { return getToken(MiLenguajeParser.RES, 0); }
		public TerminalNode MUL() { return getToken(MiLenguajeParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MiLenguajeParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MiLenguajeParser.MOD, 0); }
		public TerminalNode OR() { return getToken(MiLenguajeParser.OR, 0); }
		public TerminalNode AND() { return getToken(MiLenguajeParser.AND, 0); }
		public TerminalNode NOT() { return getToken(MiLenguajeParser.NOT, 0); }
		public TerminalNode FOR() { return getToken(MiLenguajeParser.FOR, 0); }
		public TerminalNode WHILE() { return getToken(MiLenguajeParser.WHILE, 0); }
		public TerminalNode IF() { return getToken(MiLenguajeParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(MiLenguajeParser.ELSE, 0); }
		public TerminalNode SWITCH() { return getToken(MiLenguajeParser.SWITCH, 0); }
		public TerminalNode CASE() { return getToken(MiLenguajeParser.CASE, 0); }
		public TerminalNode DEFAULT() { return getToken(MiLenguajeParser.DEFAULT, 0); }
		public TerminalNode BREAK() { return getToken(MiLenguajeParser.BREAK, 0); }
		public TerminalNode DO() { return getToken(MiLenguajeParser.DO, 0); }
		public TerminalNode CONTINUE() { return getToken(MiLenguajeParser.CONTINUE, 0); }
		public TerminalNode PRINT() { return getToken(MiLenguajeParser.PRINT, 0); }
		public TerminalNode INT() { return getToken(MiLenguajeParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(MiLenguajeParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(MiLenguajeParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(MiLenguajeParser.VOID, 0); }
		public TerminalNode BOOL() { return getToken(MiLenguajeParser.BOOL, 0); }
		public TerminalNode RETURN() { return getToken(MiLenguajeParser.RETURN, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(MiLenguajeParser.DOS_PUNTOS, 0); }
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode INTEGER() { return getToken(MiLenguajeParser.INTEGER, 0); }
		public TerminalNode DECIMAL() { return getToken(MiLenguajeParser.DECIMAL, 0); }
		public TerminalNode CHARACTER() { return getToken(MiLenguajeParser.CHARACTER, 0); }
		public TerminalNode STRING() { return getToken(MiLenguajeParser.STRING, 0); }
		public TerminalNode OTRO() { return getToken(MiLenguajeParser.OTRO, 0); }
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_token);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << PC) | (1L << CA) | (1L << CC) | (1L << LA) | (1L << LC) | (1L << PYC) | (1L << COMA) | (1L << DOS_PUNTOS) | (1L << IGUAL) | (1L << AND) | (1L << MAYOR) | (1L << MAYOR_IGUAL) | (1L << MENOR) | (1L << MENOR_IGUAL) | (1L << EQL) | (1L << DISTINTO) | (1L << SUM) | (1L << RES) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << OR) | (1L << NOT) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << ELSE) | (1L << SWITCH) | (1L << CASE) | (1L << DEFAULT) | (1L << BREAK) | (1L << DO) | (1L << CONTINUE) | (1L << PRINT) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << BOOL) | (1L << RETURN) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING) | (1L << OTRO))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 23:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\66\u014a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\3\3\3\5\3A"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4S\n\4\3\5\3\5\7\5W\n\5\f\5\16\5Z\13\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6b\n"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7j\n\7\f\7\16\7m\13\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\5\tw\n\t\3\t\3\t\5\t{\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u0084\n\n\3\n\3\n\5\n\u0088\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u0097\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00a4\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u00b9\n\22"+
		"\3\22\3\22\5\22\u00bd\n\22\3\22\3\22\3\22\5\22\u00c2\n\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00cd\n\23\f\23\16\23\u00d0\13"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u00d8\n\24\f\24\16\24\u00db\13"+
		"\24\3\24\3\24\3\24\7\24\u00e0\n\24\f\24\16\24\u00e3\13\24\5\24\u00e5\n"+
		"\24\3\25\3\25\5\25\u00e9\n\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\5\30\u00f7\n\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0106\n\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0126\n\31"+
		"\f\31\16\31\u0129\13\31\3\32\3\32\3\32\3\32\3\32\7\32\u0130\n\32\f\32"+
		"\16\32\u0133\13\32\5\32\u0135\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0146\n\32\3\33\3\33\3\33"+
		"\2\3\60\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2"+
		"\5\3\2(,\3\2\20\23\5\2\3\f\17\62\66\66\2\u0169\29\3\2\2\2\4@\3\2\2\2\6"+
		"R\3\2\2\2\bT\3\2\2\2\n]\3\2\2\2\ff\3\2\2\2\16n\3\2\2\2\20q\3\2\2\2\22"+
		"~\3\2\2\2\24\u0089\3\2\2\2\26\u008b\3\2\2\2\30\u0096\3\2\2\2\32\u0098"+
		"\3\2\2\2\34\u009c\3\2\2\2\36\u00a5\3\2\2\2 \u00ab\3\2\2\2\"\u00b3\3\2"+
		"\2\2$\u00c6\3\2\2\2&\u00e4\3\2\2\2(\u00e6\3\2\2\2*\u00ec\3\2\2\2,\u00ef"+
		"\3\2\2\2.\u00f2\3\2\2\2\60\u0105\3\2\2\2\62\u0145\3\2\2\2\64\u0147\3\2"+
		"\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2"+
		"\2;9\3\2\2\2<=\7\2\2\3=\3\3\2\2\2>A\5\n\6\2?A\5\6\4\2@>\3\2\2\2@?\3\2"+
		"\2\2A\5\3\2\2\2BS\5\b\5\2CS\5\20\t\2DS\5\26\f\2ES\5\34\17\2FS\5\36\20"+
		"\2GS\5 \21\2HS\5\"\22\2IS\5$\23\2JS\5(\25\2KS\5*\26\2LS\5,\27\2MS\5.\30"+
		"\2NO\5\60\31\2OP\7\t\2\2PS\3\2\2\2QS\7\t\2\2RB\3\2\2\2RC\3\2\2\2RD\3\2"+
		"\2\2RE\3\2\2\2RF\3\2\2\2RG\3\2\2\2RH\3\2\2\2RI\3\2\2\2RJ\3\2\2\2RK\3\2"+
		"\2\2RL\3\2\2\2RM\3\2\2\2RN\3\2\2\2RQ\3\2\2\2S\7\3\2\2\2TX\7\7\2\2UW\5"+
		"\6\4\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\"+
		"\7\b\2\2\\\t\3\2\2\2]^\5\24\13\2^_\7.\2\2_a\7\3\2\2`b\5\f\7\2a`\3\2\2"+
		"\2ab\3\2\2\2bc\3\2\2\2cd\7\4\2\2de\5\b\5\2e\13\3\2\2\2fk\5\16\b\2gh\7"+
		"\n\2\2hj\5\16\b\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\r\3\2\2\2m"+
		"k\3\2\2\2no\5\24\13\2op\7.\2\2p\17\3\2\2\2qr\5\24\13\2rv\7.\2\2st\7\5"+
		"\2\2tu\7/\2\2uw\7\6\2\2vs\3\2\2\2vw\3\2\2\2wz\3\2\2\2xy\7\f\2\2y{\5\60"+
		"\31\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7\t\2\2}\21\3\2\2\2~\177\5\24\13"+
		"\2\177\u0083\7.\2\2\u0080\u0081\7\5\2\2\u0081\u0082\7/\2\2\u0082\u0084"+
		"\7\6\2\2\u0083\u0080\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0086\7\f\2\2\u0086\u0088\5\60\31\2\u0087\u0085\3\2\2\2\u0087\u0088\3"+
		"\2\2\2\u0088\23\3\2\2\2\u0089\u008a\t\2\2\2\u008a\25\3\2\2\2\u008b\u008c"+
		"\5\30\r\2\u008c\u008d\7\f\2\2\u008d\u008e\5\60\31\2\u008e\u008f\7\t\2"+
		"\2\u008f\27\3\2\2\2\u0090\u0097\7.\2\2\u0091\u0092\7.\2\2\u0092\u0093"+
		"\7\5\2\2\u0093\u0094\5\60\31\2\u0094\u0095\7\6\2\2\u0095\u0097\3\2\2\2"+
		"\u0096\u0090\3\2\2\2\u0096\u0091\3\2\2\2\u0097\31\3\2\2\2\u0098\u0099"+
		"\5\30\r\2\u0099\u009a\7\f\2\2\u009a\u009b\5\60\31\2\u009b\33\3\2\2\2\u009c"+
		"\u009d\7\37\2\2\u009d\u009e\7\3\2\2\u009e\u009f\5\60\31\2\u009f\u00a0"+
		"\7\4\2\2\u00a0\u00a3\5\6\4\2\u00a1\u00a2\7 \2\2\u00a2\u00a4\5\6\4\2\u00a3"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\35\3\2\2\2\u00a5\u00a6\7\36\2"+
		"\2\u00a6\u00a7\7\3\2\2\u00a7\u00a8\5\60\31\2\u00a8\u00a9\7\4\2\2\u00a9"+
		"\u00aa\5\6\4\2\u00aa\37\3\2\2\2\u00ab\u00ac\7%\2\2\u00ac\u00ad\5\6\4\2"+
		"\u00ad\u00ae\7\36\2\2\u00ae\u00af\7\3\2\2\u00af\u00b0\5\60\31\2\u00b0"+
		"\u00b1\7\4\2\2\u00b1\u00b2\7\t\2\2\u00b2!\3\2\2\2\u00b3\u00b4\7\35\2\2"+
		"\u00b4\u00b8\7\3\2\2\u00b5\u00b9\5\22\n\2\u00b6\u00b9\5\32\16\2\u00b7"+
		"\u00b9\5\60\31\2\u00b8\u00b5\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3"+
		"\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\7\t\2\2\u00bb"+
		"\u00bd\5\60\31\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3"+
		"\2\2\2\u00be\u00c1\7\t\2\2\u00bf\u00c2\5\32\16\2\u00c0\u00c2\5\60\31\2"+
		"\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3"+
		"\3\2\2\2\u00c3\u00c4\7\4\2\2\u00c4\u00c5\5\6\4\2\u00c5#\3\2\2\2\u00c6"+
		"\u00c7\7!\2\2\u00c7\u00c8\7\3\2\2\u00c8\u00c9\5\60\31\2\u00c9\u00ca\7"+
		"\4\2\2\u00ca\u00ce\7\7\2\2\u00cb\u00cd\5&\24\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7\b\2\2\u00d2%\3\2\2\2\u00d3\u00d4"+
		"\7\"\2\2\u00d4\u00d5\5\60\31\2\u00d5\u00d9\7\13\2\2\u00d6\u00d8\5\6\4"+
		"\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da"+
		"\3\2\2\2\u00da\u00e5\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\7#\2\2\u00dd"+
		"\u00e1\7\13\2\2\u00de\u00e0\5\6\4\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3"+
		"\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e4\u00d3\3\2\2\2\u00e4\u00dc\3\2\2\2\u00e5\'\3\2\2\2"+
		"\u00e6\u00e8\7-\2\2\u00e7\u00e9\5\60\31\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\7\t\2\2\u00eb)\3\2\2\2\u00ec"+
		"\u00ed\7$\2\2\u00ed\u00ee\7\t\2\2\u00ee+\3\2\2\2\u00ef\u00f0\7&\2\2\u00f0"+
		"\u00f1\7\t\2\2\u00f1-\3\2\2\2\u00f2\u00f3\7\'\2\2\u00f3\u00f6\7\3\2\2"+
		"\u00f4\u00f7\5\60\31\2\u00f5\u00f7\7\62\2\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\7\4\2\2\u00f9\u00fa\7\t"+
		"\2\2\u00fa/\3\2\2\2\u00fb\u00fc\b\31\1\2\u00fc\u00fd\5\30\r\2\u00fd\u00fe"+
		"\7\f\2\2\u00fe\u00ff\5\60\31\20\u00ff\u0106\3\2\2\2\u0100\u0101\7\34\2"+
		"\2\u0101\u0106\5\60\31\5\u0102\u0103\7\27\2\2\u0103\u0106\5\60\31\4\u0104"+
		"\u0106\5\62\32\2\u0105\u00fb\3\2\2\2\u0105\u0100\3\2\2\2\u0105\u0102\3"+
		"\2\2\2\u0105\u0104\3\2\2\2\u0106\u0127\3\2\2\2\u0107\u0108\f\17\2\2\u0108"+
		"\u0109\7\33\2\2\u0109\u0126\5\60\31\20\u010a\u010b\f\16\2\2\u010b\u010c"+
		"\7\17\2\2\u010c\u0126\5\60\31\17\u010d\u010e\f\r\2\2\u010e\u010f\7\24"+
		"\2\2\u010f\u0126\5\60\31\16\u0110\u0111\f\f\2\2\u0111\u0112\7\25\2\2\u0112"+
		"\u0126\5\60\31\r\u0113\u0114\f\13\2\2\u0114\u0115\t\3\2\2\u0115\u0126"+
		"\5\60\31\f\u0116\u0117\f\n\2\2\u0117\u0118\7\26\2\2\u0118\u0126\5\60\31"+
		"\13\u0119\u011a\f\t\2\2\u011a\u011b\7\27\2\2\u011b\u0126\5\60\31\n\u011c"+
		"\u011d\f\b\2\2\u011d\u011e\7\30\2\2\u011e\u0126\5\60\31\t\u011f\u0120"+
		"\f\7\2\2\u0120\u0121\7\31\2\2\u0121\u0126\5\60\31\b\u0122\u0123\f\6\2"+
		"\2\u0123\u0124\7\32\2\2\u0124\u0126\5\60\31\7\u0125\u0107\3\2\2\2\u0125"+
		"\u010a\3\2\2\2\u0125\u010d\3\2\2\2\u0125\u0110\3\2\2\2\u0125\u0113\3\2"+
		"\2\2\u0125\u0116\3\2\2\2\u0125\u0119\3\2\2\2\u0125\u011c\3\2\2\2\u0125"+
		"\u011f\3\2\2\2\u0125\u0122\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2"+
		"\2\2\u0127\u0128\3\2\2\2\u0128\61\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b"+
		"\7.\2\2\u012b\u0134\7\3\2\2\u012c\u0131\5\60\31\2\u012d\u012e\7\n\2\2"+
		"\u012e\u0130\5\60\31\2\u012f\u012d\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0134"+
		"\u012c\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0146\7\4"+
		"\2\2\u0137\u0138\7.\2\2\u0138\u0139\7\5\2\2\u0139\u013a\5\60\31\2\u013a"+
		"\u013b\7\6\2\2\u013b\u0146\3\2\2\2\u013c\u0146\7.\2\2\u013d\u0146\7/\2"+
		"\2\u013e\u0146\7\60\2\2\u013f\u0146\7\61\2\2\u0140\u0146\7\62\2\2\u0141"+
		"\u0142\7\3\2\2\u0142\u0143\5\60\31\2\u0143\u0144\7\4\2\2\u0144\u0146\3"+
		"\2\2\2\u0145\u012a\3\2\2\2\u0145\u0137\3\2\2\2\u0145\u013c\3\2\2\2\u0145"+
		"\u013d\3\2\2\2\u0145\u013e\3\2\2\2\u0145\u013f\3\2\2\2\u0145\u0140\3\2"+
		"\2\2\u0145\u0141\3\2\2\2\u0146\63\3\2\2\2\u0147\u0148\t\4\2\2\u0148\65"+
		"\3\2\2\2\359@RXakvz\u0083\u0087\u0096\u00a3\u00b8\u00bc\u00c1\u00ce\u00d9"+
		"\u00e1\u00e4\u00e8\u00f6\u0105\u0125\u0127\u0131\u0134\u0145";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}