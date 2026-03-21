// Generated from filefind.g4 by ANTLR 4.13.2
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
		NUMBER=26, STRING=27, WS=28;
	public static final int
		RULE_query = 0, RULE_expr = 1, RULE_relop = 2, RULE_logop = 3, RULE_time = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "expr", "relop", "logop", "time"
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
			"STRING", "WS"
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
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				match(FIND);
				setState(11);
				_la = _input.LA(1);
				if ( !(_la==FILE || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(12);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				match(FIND);
				setState(14);
				_la = _input.LA(1);
				if ( !(_la==FILE || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(15);
				match(FROM);
				setState(16);
				match(STRING);
				setState(17);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(18);
				match(FIND);
				setState(19);
				_la = _input.LA(1);
				if ( !(_la==FILE || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(20);
				match(WHERE);
				setState(21);
				expr();
				setState(22);
				match(EOF);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(24);
				match(FIND);
				setState(25);
				_la = _input.LA(1);
				if ( !(_la==FILE || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(26);
				match(FROM);
				setState(27);
				match(STRING);
				setState(28);
				match(WHERE);
				setState(29);
				expr();
				setState(30);
				match(EOF);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(32);
				match(FIND);
				setState(33);
				_la = _input.LA(1);
				if ( !(_la==FILE || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(34);
				match(FROM);
				setState(35);
				match(STRING);
				setState(36);
				match(BEGIN);
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(37);
					expr();
					}
					}
					setState(40); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1136L) != 0) );
				setState(42);
				match(END);
				setState(43);
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
		public TerminalNode STRING() { return getToken(filefindParser.STRING, 0); }
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
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(EXT);
				setState(48);
				relop();
				setState(49);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(EXT);
				setState(52);
				relop();
				setState(53);
				match(STRING);
				setState(54);
				logop();
				setState(55);
				expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				match(EXT);
				setState(58);
				match(CONTAINS);
				setState(59);
				match(STRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				match(EXT);
				setState(61);
				match(CONTAINS);
				setState(62);
				match(STRING);
				setState(63);
				logop();
				setState(64);
				expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				match(SIZE);
				setState(67);
				relop();
				setState(68);
				match(NUMBER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				match(SIZE);
				setState(71);
				relop();
				setState(72);
				match(NUMBER);
				setState(73);
				logop();
				setState(74);
				expr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(76);
				match(CREATED);
				setState(77);
				relop();
				setState(78);
				time();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(80);
				match(CREATED);
				setState(81);
				relop();
				setState(82);
				time();
				setState(83);
				logop();
				setState(84);
				expr();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(86);
				match(CREATED);
				setState(87);
				match(EQ);
				setState(88);
				match(RECENTLY);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(89);
				match(DATE_MODIFIED);
				setState(90);
				relop();
				setState(91);
				time();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(93);
				match(DATE_MODIFIED);
				setState(94);
				relop();
				setState(95);
				time();
				setState(96);
				logop();
				setState(97);
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
			setState(101);
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
			setState(103);
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
		enterRule(_localctx, 8, RULE_time);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(NUMBER);
				setState(106);
				match(DAYS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(NUMBER);
				setState(108);
				match(MONS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				match(NUMBER);
				setState(110);
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
		"\u0004\u0001\u001cr\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\'\b\u0000\u000b"+
		"\u0000\f\u0000(\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000.\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001d\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004p\b\u0004"+
		"\u0001\u0004\u0000\u0000\u0005\u0000\u0002\u0004\u0006\b\u0000\u0003\u0002"+
		"\u0000\f\f\u001b\u001b\u0001\u0000\u0014\u0019\u0001\u0000\u0010\u0013"+
		"}\u0000-\u0001\u0000\u0000\u0000\u0002c\u0001\u0000\u0000\u0000\u0004"+
		"e\u0001\u0000\u0000\u0000\u0006g\u0001\u0000\u0000\u0000\bo\u0001\u0000"+
		"\u0000\u0000\n\u000b\u0005\u0001\u0000\u0000\u000b\f\u0007\u0000\u0000"+
		"\u0000\f.\u0005\u0000\u0000\u0001\r\u000e\u0005\u0001\u0000\u0000\u000e"+
		"\u000f\u0007\u0000\u0000\u0000\u000f\u0010\u0005\u0002\u0000\u0000\u0010"+
		"\u0011\u0005\u001b\u0000\u0000\u0011.\u0005\u0000\u0000\u0001\u0012\u0013"+
		"\u0005\u0001\u0000\u0000\u0013\u0014\u0007\u0000\u0000\u0000\u0014\u0015"+
		"\u0005\u0003\u0000\u0000\u0015\u0016\u0003\u0002\u0001\u0000\u0016\u0017"+
		"\u0005\u0000\u0000\u0001\u0017.\u0001\u0000\u0000\u0000\u0018\u0019\u0005"+
		"\u0001\u0000\u0000\u0019\u001a\u0007\u0000\u0000\u0000\u001a\u001b\u0005"+
		"\u0002\u0000\u0000\u001b\u001c\u0005\u001b\u0000\u0000\u001c\u001d\u0005"+
		"\u0003\u0000\u0000\u001d\u001e\u0003\u0002\u0001\u0000\u001e\u001f\u0005"+
		"\u0000\u0000\u0001\u001f.\u0001\u0000\u0000\u0000 !\u0005\u0001\u0000"+
		"\u0000!\"\u0007\u0000\u0000\u0000\"#\u0005\u0002\u0000\u0000#$\u0005\u001b"+
		"\u0000\u0000$&\u0005\b\u0000\u0000%\'\u0003\u0002\u0001\u0000&%\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0005\t\u0000\u0000"+
		"+,\u0005\u0000\u0000\u0001,.\u0001\u0000\u0000\u0000-\n\u0001\u0000\u0000"+
		"\u0000-\r\u0001\u0000\u0000\u0000-\u0012\u0001\u0000\u0000\u0000-\u0018"+
		"\u0001\u0000\u0000\u0000- \u0001\u0000\u0000\u0000.\u0001\u0001\u0000"+
		"\u0000\u0000/0\u0005\u0004\u0000\u000001\u0003\u0004\u0002\u000012\u0005"+
		"\u001b\u0000\u00002d\u0001\u0000\u0000\u000034\u0005\u0004\u0000\u0000"+
		"45\u0003\u0004\u0002\u000056\u0005\u001b\u0000\u000067\u0003\u0006\u0003"+
		"\u000078\u0003\u0002\u0001\u00008d\u0001\u0000\u0000\u00009:\u0005\u0004"+
		"\u0000\u0000:;\u0005\u000b\u0000\u0000;d\u0005\u001b\u0000\u0000<=\u0005"+
		"\u0004\u0000\u0000=>\u0005\u000b\u0000\u0000>?\u0005\u001b\u0000\u0000"+
		"?@\u0003\u0006\u0003\u0000@A\u0003\u0002\u0001\u0000Ad\u0001\u0000\u0000"+
		"\u0000BC\u0005\n\u0000\u0000CD\u0003\u0004\u0002\u0000DE\u0005\u001a\u0000"+
		"\u0000Ed\u0001\u0000\u0000\u0000FG\u0005\n\u0000\u0000GH\u0003\u0004\u0002"+
		"\u0000HI\u0005\u001a\u0000\u0000IJ\u0003\u0006\u0003\u0000JK\u0003\u0002"+
		"\u0001\u0000Kd\u0001\u0000\u0000\u0000LM\u0005\u0005\u0000\u0000MN\u0003"+
		"\u0004\u0002\u0000NO\u0003\b\u0004\u0000Od\u0001\u0000\u0000\u0000PQ\u0005"+
		"\u0005\u0000\u0000QR\u0003\u0004\u0002\u0000RS\u0003\b\u0004\u0000ST\u0003"+
		"\u0006\u0003\u0000TU\u0003\u0002\u0001\u0000Ud\u0001\u0000\u0000\u0000"+
		"VW\u0005\u0005\u0000\u0000WX\u0005\u0014\u0000\u0000Xd\u0005\u0007\u0000"+
		"\u0000YZ\u0005\u0006\u0000\u0000Z[\u0003\u0004\u0002\u0000[\\\u0003\b"+
		"\u0004\u0000\\d\u0001\u0000\u0000\u0000]^\u0005\u0006\u0000\u0000^_\u0003"+
		"\u0004\u0002\u0000_`\u0003\b\u0004\u0000`a\u0003\u0006\u0003\u0000ab\u0003"+
		"\u0002\u0001\u0000bd\u0001\u0000\u0000\u0000c/\u0001\u0000\u0000\u0000"+
		"c3\u0001\u0000\u0000\u0000c9\u0001\u0000\u0000\u0000c<\u0001\u0000\u0000"+
		"\u0000cB\u0001\u0000\u0000\u0000cF\u0001\u0000\u0000\u0000cL\u0001\u0000"+
		"\u0000\u0000cP\u0001\u0000\u0000\u0000cV\u0001\u0000\u0000\u0000cY\u0001"+
		"\u0000\u0000\u0000c]\u0001\u0000\u0000\u0000d\u0003\u0001\u0000\u0000"+
		"\u0000ef\u0007\u0001\u0000\u0000f\u0005\u0001\u0000\u0000\u0000gh\u0007"+
		"\u0002\u0000\u0000h\u0007\u0001\u0000\u0000\u0000ij\u0005\u001a\u0000"+
		"\u0000jp\u0005\r\u0000\u0000kl\u0005\u001a\u0000\u0000lp\u0005\u000e\u0000"+
		"\u0000mn\u0005\u001a\u0000\u0000np\u0005\u000f\u0000\u0000oi\u0001\u0000"+
		"\u0000\u0000ok\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000p\t\u0001"+
		"\u0000\u0000\u0000\u0004(-co";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}