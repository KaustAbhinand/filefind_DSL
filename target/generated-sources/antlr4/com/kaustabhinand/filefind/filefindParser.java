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
		FIND=1, FROM=2, WHERE=3, BEGIN=4, END=5, FILE=6, EXT=7, NAME=8, SIZE=9, 
		CREATED=10, DATE_MODIFIED=11, RECENTLY=12, CONTAINS=13, LIKE=14, DAYS=15, 
		MONS=16, YRS=17, AND=18, OR=19, NOT=20, EQ=21, GTE=22, GT=23, LTE=24, 
		LT=25, NEQ=26, LPAREN=27, RPAREN=28, NUMBER=29, STRING=30, BAREWORD=31, 
		WS=32;
	public static final int
		RULE_query = 0, RULE_subject = 1, RULE_expr = 2, RULE_cond = 3, RULE_relop = 4, 
		RULE_nameop = 5, RULE_value = 6, RULE_time = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "subject", "expr", "cond", "relop", "nameop", "value", "time"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'find'", "'from'", "'where'", "'begin'", "'end'", "'file'", "'ext'", 
			"'name'", "'size'", "'created'", "'date-modified'", "'recently'", "'contains'", 
			"'like'", "'days'", "'months'", "'yrs'", "'and'", "'or'", "'not'", "'='", 
			"'>='", "'>'", "'<='", "'<'", "'!='", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FIND", "FROM", "WHERE", "BEGIN", "END", "FILE", "EXT", "NAME", 
			"SIZE", "CREATED", "DATE_MODIFIED", "RECENTLY", "CONTAINS", "LIKE", "DAYS", 
			"MONS", "YRS", "AND", "OR", "NOT", "EQ", "GTE", "GT", "LTE", "LT", "NEQ", 
			"LPAREN", "RPAREN", "NUMBER", "STRING", "BAREWORD", "WS"
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
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public TerminalNode EOF() { return getToken(filefindParser.EOF, 0); }
		public TerminalNode FROM() { return getToken(filefindParser.FROM, 0); }
		public TerminalNode STRING() { return getToken(filefindParser.STRING, 0); }
		public TerminalNode WHERE() { return getToken(filefindParser.WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				match(FIND);
				setState(17);
				subject();
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(18);
					match(FROM);
					setState(19);
					match(STRING);
					}
				}

				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(22);
					match(WHERE);
					setState(23);
					expr(0);
					}
				}

				setState(26);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(FIND);
				setState(29);
				subject();
				setState(30);
				match(FROM);
				setState(31);
				match(STRING);
				setState(32);
				match(BEGIN);
				setState(33);
				expr(0);
				setState(34);
				match(END);
				setState(35);
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
	public static class SubjectContext extends ParserRuleContext {
		public TerminalNode FILE() { return getToken(filefindParser.FILE, 0); }
		public TerminalNode STRING() { return getToken(filefindParser.STRING, 0); }
		public SubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitSubject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubjectContext subject() throws RecognitionException {
		SubjectContext _localctx = new SubjectContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_subject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_la = _input.LA(1);
			if ( !(_la==FILE || _la==STRING) ) {
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
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(filefindParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(filefindParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(filefindParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(filefindParser.RPAREN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondExprContext extends ExprContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitCondExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(filefindParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitOrExpr(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(42);
				match(NOT);
				setState(43);
				expr(5);
				}
				break;
			case LPAREN:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(LPAREN);
				setState(45);
				expr(0);
				setState(46);
				match(RPAREN);
				}
				break;
			case EXT:
			case NAME:
			case SIZE:
			case CREATED:
			case DATE_MODIFIED:
				{
				_localctx = new CondExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				cond();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(57);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(51);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(52);
						match(AND);
						setState(53);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(54);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(55);
						match(OR);
						setState(56);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModifiedCondContext extends CondContext {
		public TerminalNode DATE_MODIFIED() { return getToken(filefindParser.DATE_MODIFIED, 0); }
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public ModifiedCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitModifiedCond(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CreatedCondContext extends CondContext {
		public TerminalNode CREATED() { return getToken(filefindParser.CREATED, 0); }
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public CreatedCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitCreatedCond(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExtCondContext extends CondContext {
		public TerminalNode EXT() { return getToken(filefindParser.EXT, 0); }
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExtCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitExtCond(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NameCondContext extends CondContext {
		public TerminalNode NAME() { return getToken(filefindParser.NAME, 0); }
		public NameopContext nameop() {
			return getRuleContext(NameopContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NameCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitNameCond(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RecentCondContext extends CondContext {
		public TerminalNode CREATED() { return getToken(filefindParser.CREATED, 0); }
		public TerminalNode EQ() { return getToken(filefindParser.EQ, 0); }
		public TerminalNode RECENTLY() { return getToken(filefindParser.RECENTLY, 0); }
		public RecentCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitRecentCond(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SizeCondContext extends CondContext {
		public TerminalNode SIZE() { return getToken(filefindParser.SIZE, 0); }
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(filefindParser.NUMBER, 0); }
		public SizeCondContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitSizeCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cond);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ExtCondContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(EXT);
				setState(63);
				relop();
				setState(64);
				value();
				}
				break;
			case 2:
				_localctx = new NameCondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(NAME);
				setState(67);
				nameop();
				setState(68);
				value();
				}
				break;
			case 3:
				_localctx = new SizeCondContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				match(SIZE);
				setState(71);
				relop();
				setState(72);
				match(NUMBER);
				}
				break;
			case 4:
				_localctx = new CreatedCondContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				match(CREATED);
				setState(75);
				relop();
				setState(76);
				time();
				}
				break;
			case 5:
				_localctx = new RecentCondContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				match(CREATED);
				setState(79);
				match(EQ);
				setState(80);
				match(RECENTLY);
				}
				break;
			case 6:
				_localctx = new ModifiedCondContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				match(DATE_MODIFIED);
				setState(82);
				relop();
				setState(83);
				time();
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
		enterRule(_localctx, 8, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 132120576L) != 0)) ) {
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
	public static class NameopContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(filefindParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(filefindParser.NEQ, 0); }
		public TerminalNode CONTAINS() { return getToken(filefindParser.CONTAINS, 0); }
		public TerminalNode LIKE() { return getToken(filefindParser.LIKE, 0); }
		public NameopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof filefindVisitor ) return ((filefindVisitor<? extends T>)visitor).visitNameop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameopContext nameop() throws RecognitionException {
		NameopContext _localctx = new NameopContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_nameop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 69230592L) != 0)) ) {
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
		public TerminalNode NUMBER() { return getToken(filefindParser.NUMBER, 0); }
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
		enterRule(_localctx, 12, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3758096384L) != 0)) ) {
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
		enterRule(_localctx, 14, RULE_time);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(NUMBER);
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
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
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001 a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u0015\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000\u0019\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000&\b\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00022\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002:\b\u0002"+
		"\n\u0002\f\u0002=\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003V\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0000\u0001\u0004\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000"+
		"\u0005\u0002\u0000\u0006\u0006\u001e\u001e\u0001\u0000\u0015\u001a\u0003"+
		"\u0000\r\u000e\u0015\u0015\u001a\u001a\u0001\u0000\u001d\u001f\u0001\u0000"+
		"\u000f\u0011d\u0000%\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000"+
		"\u0000\u00041\u0001\u0000\u0000\u0000\u0006U\u0001\u0000\u0000\u0000\b"+
		"W\u0001\u0000\u0000\u0000\nY\u0001\u0000\u0000\u0000\f[\u0001\u0000\u0000"+
		"\u0000\u000e]\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0001\u0000\u0000"+
		"\u0011\u0014\u0003\u0002\u0001\u0000\u0012\u0013\u0005\u0002\u0000\u0000"+
		"\u0013\u0015\u0005\u001e\u0000\u0000\u0014\u0012\u0001\u0000\u0000\u0000"+
		"\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0018\u0001\u0000\u0000\u0000"+
		"\u0016\u0017\u0005\u0003\u0000\u0000\u0017\u0019\u0003\u0004\u0002\u0000"+
		"\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000"+
		"\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u0000\u0000\u0001"+
		"\u001b&\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0001\u0000\u0000\u001d"+
		"\u001e\u0003\u0002\u0001\u0000\u001e\u001f\u0005\u0002\u0000\u0000\u001f"+
		" \u0005\u001e\u0000\u0000 !\u0005\u0004\u0000\u0000!\"\u0003\u0004\u0002"+
		"\u0000\"#\u0005\u0005\u0000\u0000#$\u0005\u0000\u0000\u0001$&\u0001\u0000"+
		"\u0000\u0000%\u0010\u0001\u0000\u0000\u0000%\u001c\u0001\u0000\u0000\u0000"+
		"&\u0001\u0001\u0000\u0000\u0000\'(\u0007\u0000\u0000\u0000(\u0003\u0001"+
		"\u0000\u0000\u0000)*\u0006\u0002\uffff\uffff\u0000*+\u0005\u0014\u0000"+
		"\u0000+2\u0003\u0004\u0002\u0005,-\u0005\u001b\u0000\u0000-.\u0003\u0004"+
		"\u0002\u0000./\u0005\u001c\u0000\u0000/2\u0001\u0000\u0000\u000002\u0003"+
		"\u0006\u0003\u00001)\u0001\u0000\u0000\u00001,\u0001\u0000\u0000\u0000"+
		"10\u0001\u0000\u0000\u00002;\u0001\u0000\u0000\u000034\n\u0004\u0000\u0000"+
		"45\u0005\u0012\u0000\u00005:\u0003\u0004\u0002\u000567\n\u0003\u0000\u0000"+
		"78\u0005\u0013\u0000\u00008:\u0003\u0004\u0002\u000493\u0001\u0000\u0000"+
		"\u000096\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000"+
		"\u0000\u0000;<\u0001\u0000\u0000\u0000<\u0005\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000>?\u0005\u0007\u0000\u0000?@\u0003\b\u0004\u0000"+
		"@A\u0003\f\u0006\u0000AV\u0001\u0000\u0000\u0000BC\u0005\b\u0000\u0000"+
		"CD\u0003\n\u0005\u0000DE\u0003\f\u0006\u0000EV\u0001\u0000\u0000\u0000"+
		"FG\u0005\t\u0000\u0000GH\u0003\b\u0004\u0000HI\u0005\u001d\u0000\u0000"+
		"IV\u0001\u0000\u0000\u0000JK\u0005\n\u0000\u0000KL\u0003\b\u0004\u0000"+
		"LM\u0003\u000e\u0007\u0000MV\u0001\u0000\u0000\u0000NO\u0005\n\u0000\u0000"+
		"OP\u0005\u0015\u0000\u0000PV\u0005\f\u0000\u0000QR\u0005\u000b\u0000\u0000"+
		"RS\u0003\b\u0004\u0000ST\u0003\u000e\u0007\u0000TV\u0001\u0000\u0000\u0000"+
		"U>\u0001\u0000\u0000\u0000UB\u0001\u0000\u0000\u0000UF\u0001\u0000\u0000"+
		"\u0000UJ\u0001\u0000\u0000\u0000UN\u0001\u0000\u0000\u0000UQ\u0001\u0000"+
		"\u0000\u0000V\u0007\u0001\u0000\u0000\u0000WX\u0007\u0001\u0000\u0000"+
		"X\t\u0001\u0000\u0000\u0000YZ\u0007\u0002\u0000\u0000Z\u000b\u0001\u0000"+
		"\u0000\u0000[\\\u0007\u0003\u0000\u0000\\\r\u0001\u0000\u0000\u0000]^"+
		"\u0005\u001d\u0000\u0000^_\u0007\u0004\u0000\u0000_\u000f\u0001\u0000"+
		"\u0000\u0000\u0007\u0014\u0018%19;U";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}