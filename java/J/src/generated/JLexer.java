// Generated from J.g4 by ANTLR 4.9.2
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, X=14, StringSingle=15, Number=16, 
		S=17, C=18, BlockComment=19, LineComment=20, Whitespace=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "IdUp", "IdLow", "IdChar", "CHAR", 
			"CHARInStringSingle", "X", "StringSingle", "Number", "S", "C", "BlockComment", 
			"LineComment", "Whitespace"
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


	public JLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "J.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00bd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\7\17S\n\17\f\17\16\17V\13\17\3\17\3\17\3\20\7\20[\n\20\f\20\16\20^\13"+
		"\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\7\24j\n\24\f\24"+
		"\16\24m\13\24\3\24\6\24p\n\24\r\24\16\24q\3\24\3\24\7\24v\n\24\f\24\16"+
		"\24y\13\24\5\24{\n\24\3\25\3\25\7\25\177\n\25\f\25\16\25\u0082\13\25\3"+
		"\25\3\25\3\26\3\26\7\26\u0088\n\26\f\26\16\26\u008b\13\26\3\27\3\27\7"+
		"\27\u008f\n\27\f\27\16\27\u0092\13\27\3\27\3\27\3\30\3\30\7\30\u0098\n"+
		"\30\f\30\16\30\u009b\13\30\3\31\3\31\3\31\3\31\3\31\7\31\u00a2\n\31\f"+
		"\31\16\31\u00a5\13\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\7\32"+
		"\u00b0\n\32\f\32\16\32\u00b3\13\32\3\32\5\32\u00b6\n\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\4\u00a3\u00b1\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\2\37\2!\2#\2%\2\'\20)\21+\22-\23/\24\61"+
		"\25\63\26\65\27\3\2\b\6\2\62;C\\aac|\4\2\f\f\"\u0080\4\2\"#%\u0080\5\2"+
		"/\60\62;aa\3\3\f\f\5\2\13\f\"\"..\2\u00c4\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2"+
		"\13?\3\2\2\2\rA\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23G\3\2\2\2\25I\3\2\2"+
		"\2\27K\3\2\2\2\31M\3\2\2\2\33O\3\2\2\2\35T\3\2\2\2\37\\\3\2\2\2!a\3\2"+
		"\2\2#c\3\2\2\2%e\3\2\2\2\'z\3\2\2\2)|\3\2\2\2+\u0085\3\2\2\2-\u008c\3"+
		"\2\2\2/\u0095\3\2\2\2\61\u009c\3\2\2\2\63\u00ab\3\2\2\2\65\u00b9\3\2\2"+
		"\2\678\7>\2\28\4\3\2\2\29:\7@\2\2:\6\3\2\2\2;<\7]\2\2<\b\3\2\2\2=>\7_"+
		"\2\2>\n\3\2\2\2?@\7~\2\2@\f\3\2\2\2AB\7\60\2\2B\16\3\2\2\2CD\7*\2\2D\20"+
		"\3\2\2\2EF\7+\2\2F\22\3\2\2\2GH\7<\2\2H\24\3\2\2\2IJ\7}\2\2J\26\3\2\2"+
		"\2KL\7\177\2\2L\30\3\2\2\2MN\7=\2\2N\32\3\2\2\2OP\7?\2\2P\34\3\2\2\2Q"+
		"S\7a\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2W"+
		"X\4C\\\2X\36\3\2\2\2Y[\7a\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2"+
		"\2]_\3\2\2\2^\\\3\2\2\2_`\4c|\2` \3\2\2\2ab\t\2\2\2b\"\3\2\2\2cd\t\3\2"+
		"\2d$\3\2\2\2ef\t\4\2\2f&\3\2\2\2gk\5\37\20\2hj\5!\21\2ih\3\2\2\2jm\3\2"+
		"\2\2ki\3\2\2\2kl\3\2\2\2l{\3\2\2\2mk\3\2\2\2np\7a\2\2on\3\2\2\2pq\3\2"+
		"\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2sw\4\62;\2tv\5!\21\2ut\3\2\2\2vy\3\2"+
		"\2\2wu\3\2\2\2wx\3\2\2\2x{\3\2\2\2yw\3\2\2\2zg\3\2\2\2zo\3\2\2\2{(\3\2"+
		"\2\2|\u0080\7$\2\2}\177\5%\23\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2"+
		"\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083"+
		"\u0084\7$\2\2\u0084*\3\2\2\2\u0085\u0089\4\62;\2\u0086\u0088\t\5\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a,\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u0090\7B\2\2\u008d\u008f"+
		"\5%\23\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\f"+
		"\2\2\u0094.\3\2\2\2\u0095\u0099\5\35\17\2\u0096\u0098\5!\21\2\u0097\u0096"+
		"\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\60\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7\61\2\2\u009d\u009e\7,\2"+
		"\2\u009e\u00a3\3\2\2\2\u009f\u00a2\5\61\31\2\u00a0\u00a2\13\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a7\7,\2\2\u00a7\u00a8\7\61\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\b\31"+
		"\2\2\u00aa\62\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac\u00ad\7\61\2\2\u00ad"+
		"\u00b1\3\2\2\2\u00ae\u00b0\13\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3"+
		"\2\2\2\u00b1\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b6\t\6\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\b\32\2\2\u00b8\64\3\2\2\2\u00b9\u00ba\t\7\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00bb\u00bc\b\33\2\2\u00bc\66\3\2\2\2\21\2T\\kqwz\u0080\u0089"+
		"\u0090\u0099\u00a1\u00a3\u00b1\u00b5\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}