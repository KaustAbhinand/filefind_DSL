// Generated from com/kaustabhinand/filefind/filefind.g4 by ANTLR 4.13.2
package com.kaustabhinand.filefind;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class filefindParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FIND=1, FROM=2, WHERE=3, EXT=4, CREATED=5, DATE_MODIFIED=6, RECENTLY=7, 
		BEGIN=8, END=9, SIZE=10, CONTAINS=11, FILE=12, DAYS=13, MONS=14, YRS=15, 
		AND=16, OR=17, NOT=18, NOR=19, EQ=20, GTE=21, GT=22, LTE=23, LT=24, NEQ=25, 
		NUMBER=26, STRING=27, BAREWORD=28, WS=29;
	public static final int
		RULE_query = 0, RULE_expr = 1, RULE_relop = 2, RULE_logop = 3, RULE_value = 4, 
		RULE_time = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "expr", "relop", "logop", "value", "time"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'find'", "'from'", "'where'", "'ext'", "'created'", "'date-modified'", 
			"'recently'", "'begin'", "'end'", "'size'", "'contains'", "'file'", "'days'", 
			"'months'", "'yrs'", "'and'", "'or'", "'not'", "'nor'", "'='", "'>='", 
			"'>'", "'<='", "'<'", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FIND", "FROM", "WHERE", "EXT", "CREATED", "DATE_MODIFIED", "RECENTLY", 
			"BEGIN", "END", "SIZE", "CONTAINS", "FILE", "DAYS", "MONS", "YRS", "AND", 
			"OR", "NOT", "NOR", "EQ", "GTE", "GT", "LTE", "LT", "NEQ", "NUMBER", 
			"STRING", "BAREWORD", "WS"
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
	public String getGrammarFileName() { return "filefind.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public filefindParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QueryContext extends ParserRuleContext {
		public TerminalNode FIND() { return getToken(filefindParser.FIND, 0); }
		public TerminalNode EOF() { return getToken(filefindParser.EOF, 0); }
		public List<TerminalNode> STRING() { return getTokens(filefindParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(filefindParser.STRING, i);
		}
		public TerminalNode FILE() { return getToken(filefindParser.FILE, 0); }
		public TerminalNode FROM() { return getToken(filefindParser.FROM, 0); }
		public TerminalNode WHERE() { return getToken(filefindParser.WHERE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(filefindParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(filefindParser.END, 0); }
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				match(FIND);
				setState(13);
				_la = _input.LA(1);
				if ( !(_la==FILE || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(14);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(15);
				match(FIND);
				setState(16);
				_la = _input.LA(1);
				if ( !(_la==FILE || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(17);
				match(FROM);
				setState(18);
				match(STRING);
				setState(19);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(20);
				match(FIND);
				setState(21);
				_la = _input.LA(1);
				if ( !(_la==FILE || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(22);
				match(WHERE);
				setState(23);
				expr();
				setState(24);
				match(EOF);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(26);
				match(FIND);
				setState(27);
				_la = _input.LA(1);
				if ( !(_la==FILE || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(28);
				match(FROM);
				setState(29);
				match(STRING);
				setState(30);
				match(WHERE);
				setState(31);
				expr();
				setState(32);
				match(EOF);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(34);
				match(FIND);
				setState(35);
				_la = _input.LA(1);
				if ( !(_la==FILE || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(36);
				match(FROM);
				setState(37);
				match(STRING);
				setState(38);
				match(BEGIN);
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(39);
					expr();
					}
					}
					setState(42); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1136L) != 0) );
				setState(44);
				match(END);
				setState(45);
				match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode EXT() { return getToken(filefindParser.EXT, 0); }
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public LogopContext logop() {
			return getRuleContext(LogopContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CONTAINS() { return getToken(filefindParser.CONTAINS, 0); }
		public TerminalNode SIZE() { return getToken(filefindParser.SIZE, 0); }
		public TerminalNode NUMBER() { return getToken(filefindParser.NUMBER, 0); }
		public TerminalNode CREATED() { return getToken(filefindParser.CREATED, 0); }
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(filefindParser.EQ, 0); }
		public TerminalNode RECENTLY() { return getToken(filefindParser.RECENTLY, 0); }
		public TerminalNode DATE_MODIFIED() { return getToken(filefindParser.DATE_MODIFIED, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(EXT);
				setState(50);
				relop();
				setState(51);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(EXT);
				setState(54);
				relop();
				setState(55);
				value();
				setState(56);
				logop();
				setState(57);
				expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(EXT);
				setState(60);
				match(CONTAINS);
				setState(61);
				value();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				match(EXT);
				setState(63);
				match(CONTAINS);
				setState(64);
				value();
				setState(65);
				logop();
				setState(66);
				expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				match(SIZE);
				setState(69);
				relop();
				setState(70);
				match(NUMBER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
				match(SIZE);
				setState(73);
				relop();
				setState(74);
				match(NUMBER);
				setState(75);
				logop();
				setState(76);
				expr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(78);
				match(CREATED);
				setState(79);
				relop();
				setState(80);
				time();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				match(CREATED);
				setState(83);
				relop();
				setState(84);
				time();
				setState(85);
				logop();
				setState(86);
				expr();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(88);
				match(CREATED);
				setState(89);
				match(EQ);
				setState(90);
				match(RECENTLY);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(91);
				match(CREATED);
				setState(92);
				match(EQ);
				setState(93);
				match(RECENTLY);
				setState(94);
				logop();
				setState(95);
				expr();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(97);
				match(DATE_MODIFIED);
				setState(98);
				relop();
				setState(99);
				time();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(101);
				match(DATE_MODIFIED);
				setState(102);
				relop();
				setState(103);
				time();
				setState(104);
				logop();
				setState(105);
				expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelopContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(filefindParser.EQ, 0); }
		public TerminalNode GTE() { return getToken(filefindParser.GTE, 0); }
		public TerminalNode GT() { return getToken(filefindParser.GT, 0); }
		public TerminalNode LTE() { return getToken(filefindParser.LTE, 0); }
		public TerminalNode LT() { return getToken(filefindParser.LT, 0); }
		public TerminalNode NEQ() { return getToken(filefindParser.NEQ, 0); }
		public RelopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitRelop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 66060288L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogopContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(filefindParser.AND, 0); }
		public TerminalNode OR() { return getToken(filefindParser.OR, 0); }
		public TerminalNode NOT() { return getToken(filefindParser.NOT, 0); }
		public TerminalNode NOR() { return getToken(filefindParser.NOR, 0); }
		public LogopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitLogop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogopContext logop() throws RecognitionException {
		LogopContext _localctx = new LogopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_logop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(filefindParser.STRING, 0); }
		public TerminalNode BAREWORD() { return getToken(filefindParser.BAREWORD, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==BAREWORD) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class TimeContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(filefindParser.NUMBER, 0); }
		public TerminalNode DAYS() { return getToken(filefindParser.DAYS, 0); }
		public TerminalNode MONS() { return getToken(filefindParser.MONS, 0); }
		public TerminalNode YRS() { return getToken(filefindParser.YRS, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_time);
		try {
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(NUMBER);
				setState(116);
				match(DAYS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(NUMBER);
				setState(118);
				match(MONS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				match(NUMBER);
				setState(120);
				match(YRS);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001d|\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004"+
		"\u0000)\b\u0000\u000b\u0000\f\u0000*\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u00000\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001l\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005z\b\u0005\u0001\u0005\u0000\u0000"+
		"\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0004\u0002\u0000\f\f\u001b\u001b"+
		"\u0001\u0000\u0014\u0019\u0001\u0000\u0010\u0013\u0001\u0000\u001b\u001c"+
		"\u0087\u0000/\u0001\u0000\u0000\u0000\u0002k\u0001\u0000\u0000\u0000\u0004"+
		"m\u0001\u0000\u0000\u0000\u0006o\u0001\u0000\u0000\u0000\bq\u0001\u0000"+
		"\u0000\u0000\ny\u0001\u0000\u0000\u0000\f\r\u0005\u0001\u0000\u0000\r"+
		"\u000e\u0007\u0000\u0000\u0000\u000e0\u0005\u0000\u0000\u0001\u000f\u0010"+
		"\u0005\u0001\u0000\u0000\u0010\u0011\u0007\u0000\u0000\u0000\u0011\u0012"+
		"\u0005\u0002\u0000\u0000\u0012\u0013\u0005\u001b\u0000\u0000\u00130\u0005"+
		"\u0000\u0000\u0001\u0014\u0015\u0005\u0001\u0000\u0000\u0015\u0016\u0007"+
		"\u0000\u0000\u0000\u0016\u0017\u0005\u0003\u0000\u0000\u0017\u0018\u0003"+
		"\u0002\u0001\u0000\u0018\u0019\u0005\u0000\u0000\u0001\u00190\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b\u001c\u0007\u0000"+
		"\u0000\u0000\u001c\u001d\u0005\u0002\u0000\u0000\u001d\u001e\u0005\u001b"+
		"\u0000\u0000\u001e\u001f\u0005\u0003\u0000\u0000\u001f \u0003\u0002\u0001"+
		"\u0000 !\u0005\u0000\u0000\u0001!0\u0001\u0000\u0000\u0000\"#\u0005\u0001"+
		"\u0000\u0000#$\u0007\u0000\u0000\u0000$%\u0005\u0002\u0000\u0000%&\u0005"+
		"\u001b\u0000\u0000&(\u0005\b\u0000\u0000\')\u0003\u0002\u0001\u0000(\'"+
		"\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000"+
		"\u0000*+\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0005\t\u0000"+
		"\u0000-.\u0005\u0000\u0000\u0001.0\u0001\u0000\u0000\u0000/\f\u0001\u0000"+
		"\u0000\u0000/\u000f\u0001\u0000\u0000\u0000/\u0014\u0001\u0000\u0000\u0000"+
		"/\u001a\u0001\u0000\u0000\u0000/\"\u0001\u0000\u0000\u00000\u0001\u0001"+
		"\u0000\u0000\u000012\u0005\u0004\u0000\u000023\u0003\u0004\u0002\u0000"+
		"34\u0003\b\u0004\u00004l\u0001\u0000\u0000\u000056\u0005\u0004\u0000\u0000"+
		"67\u0003\u0004\u0002\u000078\u0003\b\u0004\u000089\u0003\u0006\u0003\u0000"+
		"9:\u0003\u0002\u0001\u0000:l\u0001\u0000\u0000\u0000;<\u0005\u0004\u0000"+
		"\u0000<=\u0005\u000b\u0000\u0000=l\u0003\b\u0004\u0000>?\u0005\u0004\u0000"+
		"\u0000?@\u0005\u000b\u0000\u0000@A\u0003\b\u0004\u0000AB\u0003\u0006\u0003"+
		"\u0000BC\u0003\u0002\u0001\u0000Cl\u0001\u0000\u0000\u0000DE\u0005\n\u0000"+
		"\u0000EF\u0003\u0004\u0002\u0000FG\u0005\u001a\u0000\u0000Gl\u0001\u0000"+
		"\u0000\u0000HI\u0005\n\u0000\u0000IJ\u0003\u0004\u0002\u0000JK\u0005\u001a"+
		"\u0000\u0000KL\u0003\u0006\u0003\u0000LM\u0003\u0002\u0001\u0000Ml\u0001"+
		"\u0000\u0000\u0000NO\u0005\u0005\u0000\u0000OP\u0003\u0004\u0002\u0000"+
		"PQ\u0003\n\u0005\u0000Ql\u0001\u0000\u0000\u0000RS\u0005\u0005\u0000\u0000"+
		"ST\u0003\u0004\u0002\u0000TU\u0003\n\u0005\u0000UV\u0003\u0006\u0003\u0000"+
		"VW\u0003\u0002\u0001\u0000Wl\u0001\u0000\u0000\u0000XY\u0005\u0005\u0000"+
		"\u0000YZ\u0005\u0014\u0000\u0000Zl\u0005\u0007\u0000\u0000[\\\u0005\u0005"+
		"\u0000\u0000\\]\u0005\u0014\u0000\u0000]^\u0005\u0007\u0000\u0000^_\u0003"+
		"\u0006\u0003\u0000_`\u0003\u0002\u0001\u0000`l\u0001\u0000\u0000\u0000"+
		"ab\u0005\u0006\u0000\u0000bc\u0003\u0004\u0002\u0000cd\u0003\n\u0005\u0000"+
		"dl\u0001\u0000\u0000\u0000ef\u0005\u0006\u0000\u0000fg\u0003\u0004\u0002"+
		"\u0000gh\u0003\n\u0005\u0000hi\u0003\u0006\u0003\u0000ij\u0003\u0002\u0001"+
		"\u0000jl\u0001\u0000\u0000\u0000k1\u0001\u0000\u0000\u0000k5\u0001\u0000"+
		"\u0000\u0000k;\u0001\u0000\u0000\u0000k>\u0001\u0000\u0000\u0000kD\u0001"+
		"\u0000\u0000\u0000kH\u0001\u0000\u0000\u0000kN\u0001\u0000\u0000\u0000"+
		"kR\u0001\u0000\u0000\u0000kX\u0001\u0000\u0000\u0000k[\u0001\u0000\u0000"+
		"\u0000ka\u0001\u0000\u0000\u0000ke\u0001\u0000\u0000\u0000l\u0003\u0001"+
		"\u0000\u0000\u0000mn\u0007\u0001\u0000\u0000n\u0005\u0001\u0000\u0000"+
		"\u0000op\u0007\u0002\u0000\u0000p\u0007\u0001\u0000\u0000\u0000qr\u0007"+
		"\u0003\u0000\u0000r\t\u0001\u0000\u0000\u0000st\u0005\u001a\u0000\u0000"+
		"tz\u0005\r\u0000\u0000uv\u0005\u001a\u0000\u0000vz\u0005\u000e\u0000\u0000"+
		"wx\u0005\u001a\u0000\u0000xz\u0005\u000f\u0000\u0000ys\u0001\u0000\u0000"+
		"\u0000yu\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z\u000b\u0001"+
		"\u0000\u0000\u0000\u0004*/ky";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}