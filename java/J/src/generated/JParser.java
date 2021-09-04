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
		T__9=10, T__10=11, T__11=12, X=13, StringSingle=14, Number=15, S=16, C=17, 
		BlockComment=18, LineComment=19, Whitespace=20;
	public static final int
		RULE_x = 0, RULE_t = 1, RULE_l = 2, RULE_eAtom = 3, RULE_num = 4, RULE_string = 5, 
		RULE_e = 6, RULE_mCall = 7, RULE_dec = 8, RULE_gens = 9, RULE_mDec = 10, 
		RULE_mH = 11, RULE_prog = 12, RULE_nudeE = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"x", "t", "l", "eAtom", "num", "string", "e", "mCall", "dec", "gens", 
			"mDec", "mH", "prog", "nudeE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<'", "'>'", "'['", "']'", "'|'", "'.'", "'('", "')'", "':'", 
			"'{'", "'}'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "X", "StringSingle", "Number", "S", "C", "BlockComment", "LineComment", 
			"Whitespace"
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
		enterRule(_localctx, 0, RULE_x);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
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
		enterRule(_localctx, 2, RULE_t);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(C);
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(31);
				match(T__0);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C) {
					{
					{
					setState(32);
					t();
					}
					}
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(38);
				match(T__1);
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
		enterRule(_localctx, 4, RULE_l);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				t();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(42);
					t();
					}
				}

				setState(45);
				match(T__2);
				setState(46);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(47);
					t();
					}
				}

				setState(50);
				match(T__2);
				setState(51);
				e();
				setState(52);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(54);
					t();
					}
				}

				setState(57);
				match(T__2);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==X) {
					{
					{
					setState(58);
					x();
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(64);
				match(T__4);
				setState(65);
				e();
				setState(66);
				match(T__3);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(68);
					t();
					}
				}

				setState(71);
				match(T__2);
				setState(72);
				mCall();
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(73);
					match(T__5);
					setState(74);
					mCall();
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(80);
				match(T__3);
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
		enterRule(_localctx, 6, RULE_eAtom);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case X:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				x();
				}
				break;
			case T__2:
			case C:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				l();
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				num();
				}
				break;
			case StringSingle:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
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
		enterRule(_localctx, 8, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
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
		enterRule(_localctx, 10, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
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
		enterRule(_localctx, 12, RULE_e);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			eAtom();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(95);
				match(T__5);
				setState(96);
				mCall();
				}
				}
				setState(101);
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
		enterRule(_localctx, 14, RULE_mCall);
		int _la;
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				x();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				x();
				setState(104);
				match(T__6);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << X) | (1L << StringSingle) | (1L << Number) | (1L << C))) != 0)) {
					{
					{
					setState(105);
					e();
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(111);
				match(T__7);
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
		enterRule(_localctx, 16, RULE_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(C);
			setState(116);
			gens();
			setState(117);
			match(T__8);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==C) {
				{
				{
				setState(118);
				t();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			match(T__9);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << S) | (1L << C))) != 0)) {
				{
				{
				setState(125);
				mDec();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			match(T__10);
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
		enterRule(_localctx, 18, RULE_gens);
		int _la;
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case C:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(T__0);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C) {
					{
					{
					setState(135);
					match(C);
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(T__1);
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
		enterRule(_localctx, 20, RULE_mDec);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				mH();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				mH();
				setState(146);
				match(T__11);
				setState(147);
				e();
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
		public GensContext gens() {
			return getRuleContext(GensContext.class,0);
		}
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public List<XContext> x() {
			return getRuleContexts(XContext.class);
		}
		public XContext x(int i) {
			return getRuleContext(XContext.class,i);
		}
		public TerminalNode S() { return getToken(JParser.S, 0); }
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
		enterRule(_localctx, 22, RULE_mH);
		int _la;
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==S) {
					{
					setState(151);
					match(S);
					}
				}

				setState(154);
				gens();
				setState(155);
				t();
				setState(156);
				x();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==S) {
					{
					setState(158);
					match(S);
					}
				}

				setState(161);
				gens();
				setState(162);
				t();
				setState(163);
				x();
				setState(164);
				match(T__6);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C) {
					{
					{
					setState(165);
					t();
					setState(166);
					x();
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(T__7);
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
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_prog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(177);
					dec();
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(183);
			e();
			setState(184);
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
		enterRule(_localctx, 26, RULE_nudeE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			e();
			setState(187);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u00c0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\7\3$\n\3"+
		"\f\3\16\3\'\13\3\3\3\5\3*\n\3\3\4\3\4\5\4.\n\4\3\4\3\4\3\4\5\4\63\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4:\n\4\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4H\n\4\3\4\3\4\3\4\3\4\7\4N\n\4\f\4\16\4Q\13\4\3\4\3\4"+
		"\5\4U\n\4\3\5\3\5\3\5\3\5\5\5[\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7\bd\n"+
		"\b\f\b\16\bg\13\b\3\t\3\t\3\t\3\t\7\tm\n\t\f\t\16\tp\13\t\3\t\3\t\5\t"+
		"t\n\t\3\n\3\n\3\n\3\n\7\nz\n\n\f\n\16\n}\13\n\3\n\3\n\7\n\u0081\n\n\f"+
		"\n\16\n\u0084\13\n\3\n\3\n\3\13\3\13\3\13\7\13\u008b\n\13\f\13\16\13\u008e"+
		"\13\13\3\13\5\13\u0091\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u0098\n\f\3\r\5\r"+
		"\u009b\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a2\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\7\r\u00ab\n\r\f\r\16\r\u00ae\13\r\3\r\3\r\5\r\u00b2\n\r\3\16\7\16\u00b5"+
		"\n\16\f\16\16\16\u00b8\13\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\2\2\20"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\2\2\u00cd\2\36\3\2\2\2\4 \3\2\2"+
		"\2\6T\3\2\2\2\bZ\3\2\2\2\n\\\3\2\2\2\f^\3\2\2\2\16`\3\2\2\2\20s\3\2\2"+
		"\2\22u\3\2\2\2\24\u0090\3\2\2\2\26\u0097\3\2\2\2\30\u00b1\3\2\2\2\32\u00b6"+
		"\3\2\2\2\34\u00bc\3\2\2\2\36\37\7\17\2\2\37\3\3\2\2\2 )\7\23\2\2!%\7\3"+
		"\2\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'"+
		"%\3\2\2\2(*\7\4\2\2)!\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+U\5\4\3\2,.\5\4\3\2"+
		"-,\3\2\2\2-.\3\2\2\2./\3\2\2\2/\60\7\5\2\2\60U\7\6\2\2\61\63\5\4\3\2\62"+
		"\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\5\2\2\65\66\5\16\b\2\66"+
		"\67\7\6\2\2\67U\3\2\2\28:\5\4\3\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;?\7\5"+
		"\2\2<>\5\2\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2"+
		"\2\2BC\7\7\2\2CD\5\16\b\2DE\7\6\2\2EU\3\2\2\2FH\5\4\3\2GF\3\2\2\2GH\3"+
		"\2\2\2HI\3\2\2\2IJ\7\5\2\2JO\5\20\t\2KL\7\b\2\2LN\5\20\t\2MK\3\2\2\2N"+
		"Q\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\6\2\2SU\3\2\2\2"+
		"T+\3\2\2\2T-\3\2\2\2T\62\3\2\2\2T9\3\2\2\2TG\3\2\2\2U\7\3\2\2\2V[\5\2"+
		"\2\2W[\5\6\4\2X[\5\n\6\2Y[\5\f\7\2ZV\3\2\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2"+
		"\2\2[\t\3\2\2\2\\]\7\21\2\2]\13\3\2\2\2^_\7\20\2\2_\r\3\2\2\2`e\5\b\5"+
		"\2ab\7\b\2\2bd\5\20\t\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\17\3"+
		"\2\2\2ge\3\2\2\2ht\5\2\2\2ij\5\2\2\2jn\7\t\2\2km\5\16\b\2lk\3\2\2\2mp"+
		"\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7\n\2\2rt\3\2\2\2s"+
		"h\3\2\2\2si\3\2\2\2t\21\3\2\2\2uv\7\23\2\2vw\5\24\13\2w{\7\13\2\2xz\5"+
		"\4\3\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\u0082"+
		"\7\f\2\2\177\u0081\5\26\f\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0085\u0086\7\r\2\2\u0086\23\3\2\2\2\u0087\u0091\3\2\2\2\u0088\u008c"+
		"\7\3\2\2\u0089\u008b\7\23\2\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2"+
		"\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008f\u0091\7\4\2\2\u0090\u0087\3\2\2\2\u0090\u0088\3\2\2\2\u0091"+
		"\25\3\2\2\2\u0092\u0098\5\30\r\2\u0093\u0094\5\30\r\2\u0094\u0095\7\16"+
		"\2\2\u0095\u0096\5\16\b\2\u0096\u0098\3\2\2\2\u0097\u0092\3\2\2\2\u0097"+
		"\u0093\3\2\2\2\u0098\27\3\2\2\2\u0099\u009b\7\22\2\2\u009a\u0099\3\2\2"+
		"\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\5\24\13\2\u009d"+
		"\u009e\5\4\3\2\u009e\u009f\5\2\2\2\u009f\u00b2\3\2\2\2\u00a0\u00a2\7\22"+
		"\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\5\24\13\2\u00a4\u00a5\5\4\3\2\u00a5\u00a6\5\2\2\2\u00a6\u00ac\7"+
		"\t\2\2\u00a7\u00a8\5\4\3\2\u00a8\u00a9\5\2\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00a7\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7\n\2\2\u00b0"+
		"\u00b2\3\2\2\2\u00b1\u009a\3\2\2\2\u00b1\u00a1\3\2\2\2\u00b2\31\3\2\2"+
		"\2\u00b3\u00b5\5\22\n\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2"+
		"\2\2\u00b9\u00ba\5\16\b\2\u00ba\u00bb\7\2\2\3\u00bb\33\3\2\2\2\u00bc\u00bd"+
		"\5\16\b\2\u00bd\u00be\7\2\2\3\u00be\35\3\2\2\2\31%)-\629?GOTZens{\u0082"+
		"\u008c\u0090\u0097\u009a\u00a1\u00ac\u00b1\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}