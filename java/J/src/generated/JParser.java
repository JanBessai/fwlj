// Generated from J.g4 by ANTLR 4.9.2
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		X=18, StringSingle=19, Number=20, C=21, BlockComment=22, LineComment=23, 
		Whitespace=24;
	public static final int
		RULE_s = 0, RULE_induction = 1, RULE_h = 2, RULE_cs = 3, RULE_g = 4, RULE_x = 5, 
		RULE_t = 6, RULE_l = 7, RULE_eAtom = 8, RULE_num = 9, RULE_string = 10, 
		RULE_e = 11, RULE_mCall = 12, RULE_dec = 13, RULE_gens = 14, RULE_gensT = 15, 
		RULE_mDec = 16, RULE_mH = 17, RULE_prog = 18, RULE_nudeE = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"s", "induction", "h", "cs", "g", "x", "t", "l", "eAtom", "num", "string", 
			"e", "mCall", "dec", "gens", "gensT", "mDec", "mH", "prog", "nudeE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@total'", "'@aux'", "'induction'", "'('", "')'", "';'", "'|-'", 
			"':'", "'<'", "'>'", "'['", "']'", "'|'", "'.'", "'{'", "'}'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "X", "StringSingle", "Number", "C", 
			"BlockComment", "LineComment", "Whitespace"
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
	public String getGrammarFileName() { return "J.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SContext extends ParserRuleContext {
		public InductionContext induction() {
			return getRuleContext(InductionContext.class,0);
		}
		public List<HContext> h() {
			return getRuleContexts(HContext.class);
		}
		public HContext h(int i) {
			return getRuleContext(HContext.class,i);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(41);
				induction();
				}
			}

			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(44);
					h();
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class InductionContext extends ParserRuleContext {
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public InductionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_induction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterInduction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitInduction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitInduction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InductionContext induction() throws RecognitionException {
		InductionContext _localctx = new InductionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_induction);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__2);
				setState(51);
				match(T__3);
				setState(52);
				x();
				setState(53);
				e();
				setState(54);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(T__2);
				setState(57);
				match(T__3);
				setState(58);
				x();
				setState(59);
				match(T__4);
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

	public static class HContext extends ParserRuleContext {
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public CsContext cs() {
			return getRuleContext(CsContext.class,0);
		}
		public GContext g() {
			return getRuleContext(GContext.class,0);
		}
		public HContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_h; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterH(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitH(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitH(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HContext h() throws RecognitionException {
		HContext _localctx = new HContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_h);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(63);
				cs();
				}
				break;
			case 2:
				{
				setState(64);
				g();
				}
				break;
			case 3:
				{
				setState(65);
				cs();
				setState(66);
				match(T__5);
				setState(67);
				g();
				}
				break;
			}
			setState(71);
			match(T__6);
			setState(72);
			e();
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

	public static class CsContext extends ParserRuleContext {
		public TerminalNode C() { return getToken(JParser.C, 0); }
		public CsContext cs() {
			return getRuleContext(CsContext.class,0);
		}
		public CsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterCs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitCs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitCs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CsContext cs() throws RecognitionException {
		CsContext _localctx = new CsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(C);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==C) {
				{
				setState(75);
				cs();
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

	public static class GContext extends ParserRuleContext {
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public GContext g() {
			return getRuleContext(GContext.class,0);
		}
		public GContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterG(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitG(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitG(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GContext g() throws RecognitionException {
		GContext _localctx = new GContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_g);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			x();
			setState(79);
			match(T__7);
			setState(80);
			t();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==X) {
				{
				setState(81);
				g();
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

	public static class XContext extends ParserRuleContext {
		public TerminalNode X() { return getToken(JParser.X, 0); }
		public XContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitX(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitX(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XContext x() throws RecognitionException {
		XContext _localctx = new XContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_x);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(X);
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

	public static class TContext extends ParserRuleContext {
		public TerminalNode C() { return getToken(JParser.C, 0); }
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_t);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(C);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(87);
				match(T__8);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C) {
					{
					{
					setState(88);
					t();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(94);
				match(T__9);
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

	public static class LContext extends ParserRuleContext {
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public List<XContext> x() {
			return getRuleContexts(XContext.class);
		}
		public XContext x(int i) {
			return getRuleContext(XContext.class,i);
		}
		public List<MCallContext> mCall() {
			return getRuleContexts(MCallContext.class);
		}
		public MCallContext mCall(int i) {
			return getRuleContext(MCallContext.class,i);
		}
		public LContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_l; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LContext l() throws RecognitionException {
		LContext _localctx = new LContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_l);
		int _la;
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				t();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(98);
					t();
					}
				}

				setState(101);
				match(T__10);
				setState(102);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(103);
					t();
					}
				}

				setState(106);
				match(T__10);
				setState(107);
				e();
				setState(108);
				match(T__11);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(110);
					t();
					}
				}

				setState(113);
				match(T__10);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==X) {
					{
					{
					setState(114);
					x();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				match(T__12);
				setState(121);
				e();
				setState(122);
				match(T__11);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(124);
					t();
					}
				}

				setState(127);
				match(T__10);
				setState(128);
				mCall();
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(129);
					match(T__13);
					setState(130);
					mCall();
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				match(T__11);
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

	public static class EAtomContext extends ParserRuleContext {
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public LContext l() {
			return getRuleContext(LContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public EAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterEAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitEAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitEAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EAtomContext eAtom() throws RecognitionException {
		EAtomContext _localctx = new EAtomContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_eAtom);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case X:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				x();
				}
				break;
			case T__10:
			case C:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				l();
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				num();
				}
				break;
			case StringSingle:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				string();
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

	public static class NumContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(JParser.Number, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(Number);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode StringSingle() { return getToken(JParser.StringSingle, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(StringSingle);
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

	public static class EContext extends ParserRuleContext {
		public EAtomContext eAtom() {
			return getRuleContext(EAtomContext.class,0);
		}
		public List<MCallContext> mCall() {
			return getRuleContexts(MCallContext.class);
		}
		public MCallContext mCall(int i) {
			return getRuleContext(MCallContext.class,i);
		}
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EContext e() throws RecognitionException {
		EContext _localctx = new EContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_e);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			eAtom();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(151);
				match(T__13);
				setState(152);
				mCall();
				}
				}
				setState(157);
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

	public static class MCallContext extends ParserRuleContext {
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public GensTContext gensT() {
			return getRuleContext(GensTContext.class,0);
		}
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public MCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterMCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitMCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitMCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MCallContext mCall() throws RecognitionException {
		MCallContext _localctx = new MCallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_mCall);
		int _la;
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				x();
				setState(159);
				gensT();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				x();
				setState(162);
				gensT();
				setState(163);
				match(T__3);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << X) | (1L << StringSingle) | (1L << Number) | (1L << C))) != 0)) {
					{
					{
					setState(164);
					e();
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(170);
				match(T__4);
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

	public static class DecContext extends ParserRuleContext {
		public TerminalNode C() { return getToken(JParser.C, 0); }
		public GensContext gens() {
			return getRuleContext(GensContext.class,0);
		}
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public List<MDecContext> mDec() {
			return getRuleContexts(MDecContext.class);
		}
		public MDecContext mDec(int i) {
			return getRuleContext(MDecContext.class,i);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(C);
			setState(175);
			gens();
			setState(176);
			match(T__7);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==C) {
				{
				{
				setState(177);
				t();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
			match(T__14);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << X))) != 0)) {
				{
				{
				setState(184);
				mDec();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
			match(T__15);
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

	public static class GensContext extends ParserRuleContext {
		public List<TerminalNode> C() { return getTokens(JParser.C); }
		public TerminalNode C(int i) {
			return getToken(JParser.C, i);
		}
		public GensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gens; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterGens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitGens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitGens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GensContext gens() throws RecognitionException {
		GensContext _localctx = new GensContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_gens);
		int _la;
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(T__8);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C) {
					{
					{
					setState(194);
					match(C);
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(T__9);
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

	public static class GensTContext extends ParserRuleContext {
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public GensTContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gensT; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterGensT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitGensT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitGensT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GensTContext gensT() throws RecognitionException {
		GensTContext _localctx = new GensTContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_gensT);
		int _la;
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__10:
			case T__11:
			case T__13:
			case X:
			case StringSingle:
			case Number:
			case C:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				match(T__8);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C) {
					{
					{
					setState(205);
					t();
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(211);
				match(T__9);
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

	public static class MDecContext extends ParserRuleContext {
		public MHContext mH() {
			return getRuleContext(MHContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public MDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterMDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitMDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitMDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MDecContext mDec() throws RecognitionException {
		MDecContext _localctx = new MDecContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mDec);
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				mH();
				setState(215);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				mH();
				setState(218);
				match(T__16);
				setState(219);
				e();
				setState(220);
				match(T__5);
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

	public static class MHContext extends ParserRuleContext {
		public List<XContext> x() {
			return getRuleContexts(XContext.class);
		}
		public XContext x(int i) {
			return getRuleContext(XContext.class,i);
		}
		public GensContext gens() {
			return getRuleContext(GensContext.class,0);
		}
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public MHContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mH; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterMH(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitMH(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitMH(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MHContext mH() throws RecognitionException {
		MHContext _localctx = new MHContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_mH);
		int _la;
		try {
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0 || _la==T__1) {
					{
					setState(224);
					s();
					}
				}

				setState(227);
				x();
				setState(228);
				gens();
				setState(229);
				match(T__7);
				setState(230);
				t();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0 || _la==T__1) {
					{
					setState(232);
					s();
					}
				}

				setState(235);
				x();
				setState(236);
				gens();
				setState(237);
				match(T__3);
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==X) {
					{
					{
					setState(238);
					x();
					setState(239);
					match(T__7);
					setState(240);
					t();
					}
					}
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(247);
				match(T__4);
				setState(248);
				match(T__7);
				setState(249);
				t();
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

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JParser.EOF, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==C) {
				{
				{
				setState(253);
				dec();
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(259);
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

	public static class NudeEContext extends ParserRuleContext {
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JParser.EOF, 0); }
		public NudeEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nudeE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterNudeE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitNudeE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitNudeE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NudeEContext nudeE() throws RecognitionException {
		NudeEContext _localctx = new NudeEContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_nudeE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			e();
			setState(262);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u010b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\5\2-\n\2\3\2\7\2\60\n\2\f\2\16"+
		"\2\63\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3@\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4H\n\4\3\4\3\4\3\4\3\5\3\5\5\5O\n\5\3\6\3\6\3\6\3"+
		"\6\5\6U\n\6\3\7\3\7\3\b\3\b\3\b\7\b\\\n\b\f\b\16\b_\13\b\3\b\5\bb\n\b"+
		"\3\t\3\t\5\tf\n\t\3\t\3\t\3\t\5\tk\n\t\3\t\3\t\3\t\3\t\3\t\5\tr\n\t\3"+
		"\t\3\t\7\tv\n\t\f\t\16\ty\13\t\3\t\3\t\3\t\3\t\3\t\5\t\u0080\n\t\3\t\3"+
		"\t\3\t\3\t\7\t\u0086\n\t\f\t\16\t\u0089\13\t\3\t\3\t\5\t\u008d\n\t\3\n"+
		"\3\n\3\n\3\n\5\n\u0093\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\7\r\u009c\n\r"+
		"\f\r\16\r\u009f\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00a8\n\16"+
		"\f\16\16\16\u00ab\13\16\3\16\3\16\5\16\u00af\n\16\3\17\3\17\3\17\3\17"+
		"\7\17\u00b5\n\17\f\17\16\17\u00b8\13\17\3\17\3\17\7\17\u00bc\n\17\f\17"+
		"\16\17\u00bf\13\17\3\17\3\17\3\20\3\20\3\20\7\20\u00c6\n\20\f\20\16\20"+
		"\u00c9\13\20\3\20\5\20\u00cc\n\20\3\21\3\21\3\21\7\21\u00d1\n\21\f\21"+
		"\16\21\u00d4\13\21\3\21\5\21\u00d7\n\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u00e1\n\22\3\23\5\23\u00e4\n\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u00ec\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00f5"+
		"\n\23\f\23\16\23\u00f8\13\23\3\23\3\23\3\23\3\23\5\23\u00fe\n\23\3\24"+
		"\7\24\u0101\n\24\f\24\16\24\u0104\13\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\2\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\3\3\2\3\4\2\u011c"+
		"\2*\3\2\2\2\4?\3\2\2\2\6G\3\2\2\2\bL\3\2\2\2\nP\3\2\2\2\fV\3\2\2\2\16"+
		"X\3\2\2\2\20\u008c\3\2\2\2\22\u0092\3\2\2\2\24\u0094\3\2\2\2\26\u0096"+
		"\3\2\2\2\30\u0098\3\2\2\2\32\u00ae\3\2\2\2\34\u00b0\3\2\2\2\36\u00cb\3"+
		"\2\2\2 \u00d6\3\2\2\2\"\u00e0\3\2\2\2$\u00fd\3\2\2\2&\u0102\3\2\2\2(\u0107"+
		"\3\2\2\2*,\t\2\2\2+-\5\4\3\2,+\3\2\2\2,-\3\2\2\2-\61\3\2\2\2.\60\5\6\4"+
		"\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\3\3\2\2\2\63\61"+
		"\3\2\2\2\64\65\7\5\2\2\65\66\7\6\2\2\66\67\5\f\7\2\678\5\30\r\289\7\7"+
		"\2\29@\3\2\2\2:;\7\5\2\2;<\7\6\2\2<=\5\f\7\2=>\7\7\2\2>@\3\2\2\2?\64\3"+
		"\2\2\2?:\3\2\2\2@\5\3\2\2\2AH\5\b\5\2BH\5\n\6\2CD\5\b\5\2DE\7\b\2\2EF"+
		"\5\n\6\2FH\3\2\2\2GA\3\2\2\2GB\3\2\2\2GC\3\2\2\2GH\3\2\2\2HI\3\2\2\2I"+
		"J\7\t\2\2JK\5\30\r\2K\7\3\2\2\2LN\7\27\2\2MO\5\b\5\2NM\3\2\2\2NO\3\2\2"+
		"\2O\t\3\2\2\2PQ\5\f\7\2QR\7\n\2\2RT\5\16\b\2SU\5\n\6\2TS\3\2\2\2TU\3\2"+
		"\2\2U\13\3\2\2\2VW\7\24\2\2W\r\3\2\2\2Xa\7\27\2\2Y]\7\13\2\2Z\\\5\16\b"+
		"\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`b\7\f"+
		"\2\2aY\3\2\2\2ab\3\2\2\2b\17\3\2\2\2c\u008d\5\16\b\2df\5\16\b\2ed\3\2"+
		"\2\2ef\3\2\2\2fg\3\2\2\2gh\7\r\2\2h\u008d\7\16\2\2ik\5\16\b\2ji\3\2\2"+
		"\2jk\3\2\2\2kl\3\2\2\2lm\7\r\2\2mn\5\30\r\2no\7\16\2\2o\u008d\3\2\2\2"+
		"pr\5\16\b\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2sw\7\r\2\2tv\5\f\7\2ut\3\2\2"+
		"\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7\17\2\2{|\5\30"+
		"\r\2|}\7\16\2\2}\u008d\3\2\2\2~\u0080\5\16\b\2\177~\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7\r\2\2\u0082\u0087\5\32\16\2"+
		"\u0083\u0084\7\20\2\2\u0084\u0086\5\32\16\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\16\2\2\u008b\u008d\3\2\2\2\u008c"+
		"c\3\2\2\2\u008ce\3\2\2\2\u008cj\3\2\2\2\u008cq\3\2\2\2\u008c\177\3\2\2"+
		"\2\u008d\21\3\2\2\2\u008e\u0093\5\f\7\2\u008f\u0093\5\20\t\2\u0090\u0093"+
		"\5\24\13\2\u0091\u0093\5\26\f\2\u0092\u008e\3\2\2\2\u0092\u008f\3\2\2"+
		"\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\23\3\2\2\2\u0094\u0095"+
		"\7\26\2\2\u0095\25\3\2\2\2\u0096\u0097\7\25\2\2\u0097\27\3\2\2\2\u0098"+
		"\u009d\5\22\n\2\u0099\u009a\7\20\2\2\u009a\u009c\5\32\16\2\u009b\u0099"+
		"\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\31\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\5\f\7\2\u00a1\u00a2\5 \21"+
		"\2\u00a2\u00af\3\2\2\2\u00a3\u00a4\5\f\7\2\u00a4\u00a5\5 \21\2\u00a5\u00a9"+
		"\7\6\2\2\u00a6\u00a8\5\30\r\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2"+
		"\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00ad\7\7\2\2\u00ad\u00af\3\2\2\2\u00ae\u00a0\3\2\2\2\u00ae"+
		"\u00a3\3\2\2\2\u00af\33\3\2\2\2\u00b0\u00b1\7\27\2\2\u00b1\u00b2\5\36"+
		"\20\2\u00b2\u00b6\7\n\2\2\u00b3\u00b5\5\16\b\2\u00b4\u00b3\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bd\7\21\2\2\u00ba\u00bc\5\"\22\2\u00bb"+
		"\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\7\22\2\2\u00c1"+
		"\35\3\2\2\2\u00c2\u00cc\3\2\2\2\u00c3\u00c7\7\13\2\2\u00c4\u00c6\7\27"+
		"\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cc\7\f"+
		"\2\2\u00cb\u00c2\3\2\2\2\u00cb\u00c3\3\2\2\2\u00cc\37\3\2\2\2\u00cd\u00d7"+
		"\3\2\2\2\u00ce\u00d2\7\13\2\2\u00cf\u00d1\5\16\b\2\u00d0\u00cf\3\2\2\2"+
		"\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d7\7\f\2\2\u00d6\u00cd\3\2\2\2\u00d6"+
		"\u00ce\3\2\2\2\u00d7!\3\2\2\2\u00d8\u00d9\5$\23\2\u00d9\u00da\7\b\2\2"+
		"\u00da\u00e1\3\2\2\2\u00db\u00dc\5$\23\2\u00dc\u00dd\7\23\2\2\u00dd\u00de"+
		"\5\30\r\2\u00de\u00df\7\b\2\2\u00df\u00e1\3\2\2\2\u00e0\u00d8\3\2\2\2"+
		"\u00e0\u00db\3\2\2\2\u00e1#\3\2\2\2\u00e2\u00e4\5\2\2\2\u00e3\u00e2\3"+
		"\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\5\f\7\2\u00e6"+
		"\u00e7\5\36\20\2\u00e7\u00e8\7\n\2\2\u00e8\u00e9\5\16\b\2\u00e9\u00fe"+
		"\3\2\2\2\u00ea\u00ec\5\2\2\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00ee\5\f\7\2\u00ee\u00ef\5\36\20\2\u00ef\u00f6\7"+
		"\6\2\2\u00f0\u00f1\5\f\7\2\u00f1\u00f2\7\n\2\2\u00f2\u00f3\5\16\b\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00f0\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9"+
		"\u00fa\7\7\2\2\u00fa\u00fb\7\n\2\2\u00fb\u00fc\5\16\b\2\u00fc\u00fe\3"+
		"\2\2\2\u00fd\u00e3\3\2\2\2\u00fd\u00eb\3\2\2\2\u00fe%\3\2\2\2\u00ff\u0101"+
		"\5\34\17\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2"+
		"\u0102\u0103\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106"+
		"\7\2\2\3\u0106\'\3\2\2\2\u0107\u0108\5\30\r\2\u0108\u0109\7\2\2\3\u0109"+
		")\3\2\2\2!,\61?GNT]aejqw\177\u0087\u008c\u0092\u009d\u00a9\u00ae\u00b6"+
		"\u00bd\u00c7\u00cb\u00d2\u00d6\u00e0\u00e3\u00eb\u00f6\u00fd\u0102";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}