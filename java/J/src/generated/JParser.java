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
		T__9=10, T__10=11, T__11=12, T__12=13, X=14, StringSingle=15, Number=16, 
		S=17, C=18, BlockComment=19, LineComment=20, Whitespace=21;
	public static final int
		RULE_x = 0, RULE_t = 1, RULE_l = 2, RULE_eAtom = 3, RULE_num = 4, RULE_string = 5, 
		RULE_e = 6, RULE_mCall = 7, RULE_dec = 8, RULE_gens = 9, RULE_gensT = 10, 
		RULE_mDec = 11, RULE_mH = 12, RULE_prog = 13, RULE_nudeE = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"x", "t", "l", "eAtom", "num", "string", "e", "mCall", "dec", "gens", 
			"gensT", "mDec", "mH", "prog", "nudeE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<'", "'>'", "'['", "']'", "'|'", "'.'", "'('", "')'", "':'", 
			"'{'", "'}'", "';'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "X", "StringSingle", "Number", "S", "C", "BlockComment", 
			"LineComment", "Whitespace"
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
			setState(30);
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
			setState(32);
			match(C);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(33);
				match(T__0);
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C) {
					{
					{
					setState(34);
					t();
					}
					}
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(40);
				match(T__1);
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
		enterRule(_localctx, 4, RULE_l);
		int _la;
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				t();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(44);
					t();
					}
				}

				setState(47);
				match(T__2);
				setState(48);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(49);
					t();
					}
				}

				setState(52);
				match(T__2);
				setState(53);
				e();
				setState(54);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(56);
					t();
					}
				}

				setState(59);
				match(T__2);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==X) {
					{
					{
					setState(60);
					x();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66);
				match(T__4);
				setState(67);
				e();
				setState(68);
				match(T__3);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==C) {
					{
					setState(70);
					t();
					}
				}

				setState(73);
				match(T__2);
				setState(74);
				mCall();
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(75);
					match(T__5);
					setState(76);
					mCall();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82);
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
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case X:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				x();
				}
				break;
			case T__2:
			case C:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				l();
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				num();
				}
				break;
			case StringSingle:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
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
			setState(92);
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
			setState(94);
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
			setState(96);
			eAtom();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(97);
				match(T__5);
				setState(98);
				mCall();
				}
				}
				setState(103);
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
		enterRule(_localctx, 14, RULE_mCall);
		int _la;
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				x();
				setState(105);
				gensT();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				x();
				setState(108);
				gensT();
				setState(109);
				match(T__6);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << X) | (1L << StringSingle) | (1L << Number) | (1L << C))) != 0)) {
					{
					{
					setState(110);
					e();
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(116);
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
			setState(120);
			match(C);
			setState(121);
			gens();
			setState(122);
			match(T__8);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==C) {
				{
				{
				setState(123);
				t();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			match(T__9);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << S) | (1L << C))) != 0)) {
				{
				{
				setState(130);
				mDec();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
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
			setState(147);
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
				setState(139);
				match(T__0);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C) {
					{
					{
					setState(140);
					match(C);
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
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
		enterRule(_localctx, 20, RULE_gensT);
		int _la;
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case T__2:
			case T__3:
			case T__5:
			case T__6:
			case T__7:
			case T__11:
			case X:
			case StringSingle:
			case Number:
			case C:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__0);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C) {
					{
					{
					setState(151);
					t();
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
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
		enterRule(_localctx, 22, RULE_mDec);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				mH();
				setState(161);
				match(T__11);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				mH();
				setState(164);
				match(T__12);
				setState(165);
				e();
				setState(166);
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
		enterRule(_localctx, 24, RULE_mH);
		int _la;
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==S) {
					{
					setState(170);
					match(S);
					}
				}

				setState(173);
				gens();
				setState(174);
				t();
				setState(175);
				x();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==S) {
					{
					setState(177);
					match(S);
					}
				}

				setState(180);
				gens();
				setState(181);
				t();
				setState(182);
				x();
				setState(183);
				match(T__6);
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C) {
					{
					{
					setState(184);
					t();
					setState(185);
					x();
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192);
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
		enterRule(_localctx, 26, RULE_prog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(196);
					dec();
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(202);
			e();
			setState(203);
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
		enterRule(_localctx, 28, RULE_nudeE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			e();
			setState(206);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u00d3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3"+
		"\3\7\3&\n\3\f\3\16\3)\13\3\3\3\5\3,\n\3\3\4\3\4\5\4\60\n\4\3\4\3\4\3\4"+
		"\5\4\65\n\4\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\4\3\4\7\4@\n\4\f\4\16\4C\13"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4J\n\4\3\4\3\4\3\4\3\4\7\4P\n\4\f\4\16\4S\13"+
		"\4\3\4\3\4\5\4W\n\4\3\5\3\5\3\5\3\5\5\5]\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\b\7\bf\n\b\f\b\16\bi\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tr\n\t\f\t\16"+
		"\tu\13\t\3\t\3\t\5\ty\n\t\3\n\3\n\3\n\3\n\7\n\177\n\n\f\n\16\n\u0082\13"+
		"\n\3\n\3\n\7\n\u0086\n\n\f\n\16\n\u0089\13\n\3\n\3\n\3\13\3\13\3\13\7"+
		"\13\u0090\n\13\f\13\16\13\u0093\13\13\3\13\5\13\u0096\n\13\3\f\3\f\3\f"+
		"\7\f\u009b\n\f\f\f\16\f\u009e\13\f\3\f\5\f\u00a1\n\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00ab\n\r\3\16\5\16\u00ae\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u00b5\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00be\n"+
		"\16\f\16\16\16\u00c1\13\16\3\16\3\16\5\16\u00c5\n\16\3\17\7\17\u00c8\n"+
		"\17\f\17\16\17\u00cb\13\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\2\2\21\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\2\u00e1\2 \3\2\2\2\4\"\3\2\2"+
		"\2\6V\3\2\2\2\b\\\3\2\2\2\n^\3\2\2\2\f`\3\2\2\2\16b\3\2\2\2\20x\3\2\2"+
		"\2\22z\3\2\2\2\24\u0095\3\2\2\2\26\u00a0\3\2\2\2\30\u00aa\3\2\2\2\32\u00c4"+
		"\3\2\2\2\34\u00c9\3\2\2\2\36\u00cf\3\2\2\2 !\7\20\2\2!\3\3\2\2\2\"+\7"+
		"\24\2\2#\'\7\3\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2"+
		"(*\3\2\2\2)\'\3\2\2\2*,\7\4\2\2+#\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-W\5\4\3"+
		"\2.\60\5\4\3\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\7\5\2\2\62W\7"+
		"\6\2\2\63\65\5\4\3\2\64\63\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\7"+
		"\5\2\2\678\5\16\b\289\7\6\2\29W\3\2\2\2:<\5\4\3\2;:\3\2\2\2;<\3\2\2\2"+
		"<=\3\2\2\2=A\7\5\2\2>@\5\2\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2"+
		"BD\3\2\2\2CA\3\2\2\2DE\7\7\2\2EF\5\16\b\2FG\7\6\2\2GW\3\2\2\2HJ\5\4\3"+
		"\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\5\2\2LQ\5\20\t\2MN\7\b\2\2NP\5\20"+
		"\t\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7\6"+
		"\2\2UW\3\2\2\2V-\3\2\2\2V/\3\2\2\2V\64\3\2\2\2V;\3\2\2\2VI\3\2\2\2W\7"+
		"\3\2\2\2X]\5\2\2\2Y]\5\6\4\2Z]\5\n\6\2[]\5\f\7\2\\X\3\2\2\2\\Y\3\2\2\2"+
		"\\Z\3\2\2\2\\[\3\2\2\2]\t\3\2\2\2^_\7\22\2\2_\13\3\2\2\2`a\7\21\2\2a\r"+
		"\3\2\2\2bg\5\b\5\2cd\7\b\2\2df\5\20\t\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"gh\3\2\2\2h\17\3\2\2\2ig\3\2\2\2jk\5\2\2\2kl\5\26\f\2ly\3\2\2\2mn\5\2"+
		"\2\2no\5\26\f\2os\7\t\2\2pr\5\16\b\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3"+
		"\2\2\2tv\3\2\2\2us\3\2\2\2vw\7\n\2\2wy\3\2\2\2xj\3\2\2\2xm\3\2\2\2y\21"+
		"\3\2\2\2z{\7\24\2\2{|\5\24\13\2|\u0080\7\13\2\2}\177\5\4\3\2~}\3\2\2\2"+
		"\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2"+
		"\2\2\u0082\u0080\3\2\2\2\u0083\u0087\7\f\2\2\u0084\u0086\5\30\r\2\u0085"+
		"\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\r\2\2\u008b"+
		"\23\3\2\2\2\u008c\u0096\3\2\2\2\u008d\u0091\7\3\2\2\u008e\u0090\7\24\2"+
		"\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0096\7\4\2\2\u0095"+
		"\u008c\3\2\2\2\u0095\u008d\3\2\2\2\u0096\25\3\2\2\2\u0097\u00a1\3\2\2"+
		"\2\u0098\u009c\7\3\2\2\u0099\u009b\5\4\3\2\u009a\u0099\3\2\2\2\u009b\u009e"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a1\7\4\2\2\u00a0\u0097\3\2\2\2\u00a0\u0098\3\2"+
		"\2\2\u00a1\27\3\2\2\2\u00a2\u00a3\5\32\16\2\u00a3\u00a4\7\16\2\2\u00a4"+
		"\u00ab\3\2\2\2\u00a5\u00a6\5\32\16\2\u00a6\u00a7\7\17\2\2\u00a7\u00a8"+
		"\5\16\b\2\u00a8\u00a9\7\16\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a2\3\2\2\2"+
		"\u00aa\u00a5\3\2\2\2\u00ab\31\3\2\2\2\u00ac\u00ae\7\23\2\2\u00ad\u00ac"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\5\24\13\2"+
		"\u00b0\u00b1\5\4\3\2\u00b1\u00b2\5\2\2\2\u00b2\u00c5\3\2\2\2\u00b3\u00b5"+
		"\7\23\2\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2"+
		"\u00b6\u00b7\5\24\13\2\u00b7\u00b8\5\4\3\2\u00b8\u00b9\5\2\2\2\u00b9\u00bf"+
		"\7\t\2\2\u00ba\u00bb\5\4\3\2\u00bb\u00bc\5\2\2\2\u00bc\u00be\3\2\2\2\u00bd"+
		"\u00ba\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7\n\2\2\u00c3"+
		"\u00c5\3\2\2\2\u00c4\u00ad\3\2\2\2\u00c4\u00b4\3\2\2\2\u00c5\33\3\2\2"+
		"\2\u00c6\u00c8\5\22\n\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cc\u00cd\5\16\b\2\u00cd\u00ce\7\2\2\3\u00ce\35\3\2\2\2\u00cf\u00d0"+
		"\5\16\b\2\u00d0\u00d1\7\2\2\3\u00d1\37\3\2\2\2\33\'+/\64;AIQV\\gsx\u0080"+
		"\u0087\u0091\u0095\u009c\u00a0\u00aa\u00ad\u00b4\u00bf\u00c4\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}