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
		T__9=10, T__10=11, T__11=12, X=13, StringSingle=14, Number=15, S=16, C=17, 
		BlockComment=18, LineComment=19, Whitespace=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "IdUp", "IdLow", "IdChar", "CHAR", "CHARInStringSingle", 
			"X", "StringSingle", "Number", "S", "C", "BlockComment", "LineComment", 
			"Whitespace"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00b9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\7\16O\n\16\f\16\16\16"+
		"R\13\16\3\16\3\16\3\17\7\17W\n\17\f\17\16\17Z\13\17\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\7\23f\n\23\f\23\16\23i\13\23\3\23\6\23"+
		"l\n\23\r\23\16\23m\3\23\3\23\7\23r\n\23\f\23\16\23u\13\23\5\23w\n\23\3"+
		"\24\3\24\7\24{\n\24\f\24\16\24~\13\24\3\24\3\24\3\25\3\25\7\25\u0084\n"+
		"\25\f\25\16\25\u0087\13\25\3\26\3\26\7\26\u008b\n\26\f\26\16\26\u008e"+
		"\13\26\3\26\3\26\3\27\3\27\7\27\u0094\n\27\f\27\16\27\u0097\13\27\3\30"+
		"\3\30\3\30\3\30\3\30\7\30\u009e\n\30\f\30\16\30\u00a1\13\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u00ac\n\31\f\31\16\31\u00af\13"+
		"\31\3\31\5\31\u00b2\n\31\3\31\3\31\3\32\3\32\3\32\3\32\4\u009f\u00ad\2"+
		"\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\2\35\2"+
		"\37\2!\2#\2%\17\'\20)\21+\22-\23/\24\61\25\63\26\3\2\b\6\2\62;C\\aac|"+
		"\4\2\f\f\"\u0080\4\2\"#%\u0080\5\2/\60\62;aa\3\3\f\f\5\2\13\f\"\"..\2"+
		"\u00c0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2"+
		"\79\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\r?\3\2\2\2\17A\3\2\2\2\21C\3\2\2\2"+
		"\23E\3\2\2\2\25G\3\2\2\2\27I\3\2\2\2\31K\3\2\2\2\33P\3\2\2\2\35X\3\2\2"+
		"\2\37]\3\2\2\2!_\3\2\2\2#a\3\2\2\2%v\3\2\2\2\'x\3\2\2\2)\u0081\3\2\2\2"+
		"+\u0088\3\2\2\2-\u0091\3\2\2\2/\u0098\3\2\2\2\61\u00a7\3\2\2\2\63\u00b5"+
		"\3\2\2\2\65\66\7>\2\2\66\4\3\2\2\2\678\7@\2\28\6\3\2\2\29:\7]\2\2:\b\3"+
		"\2\2\2;<\7_\2\2<\n\3\2\2\2=>\7~\2\2>\f\3\2\2\2?@\7\60\2\2@\16\3\2\2\2"+
		"AB\7*\2\2B\20\3\2\2\2CD\7+\2\2D\22\3\2\2\2EF\7<\2\2F\24\3\2\2\2GH\7}\2"+
		"\2H\26\3\2\2\2IJ\7\177\2\2J\30\3\2\2\2KL\7?\2\2L\32\3\2\2\2MO\7a\2\2N"+
		"M\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2ST\4C\\\2T"+
		"\34\3\2\2\2UW\7a\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2"+
		"ZX\3\2\2\2[\\\4c|\2\\\36\3\2\2\2]^\t\2\2\2^ \3\2\2\2_`\t\3\2\2`\"\3\2"+
		"\2\2ab\t\4\2\2b$\3\2\2\2cg\5\35\17\2df\5\37\20\2ed\3\2\2\2fi\3\2\2\2g"+
		"e\3\2\2\2gh\3\2\2\2hw\3\2\2\2ig\3\2\2\2jl\7a\2\2kj\3\2\2\2lm\3\2\2\2m"+
		"k\3\2\2\2mn\3\2\2\2no\3\2\2\2os\4\62;\2pr\5\37\20\2qp\3\2\2\2ru\3\2\2"+
		"\2sq\3\2\2\2st\3\2\2\2tw\3\2\2\2us\3\2\2\2vc\3\2\2\2vk\3\2\2\2w&\3\2\2"+
		"\2x|\7$\2\2y{\5#\22\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2"+
		"\2\2~|\3\2\2\2\177\u0080\7$\2\2\u0080(\3\2\2\2\u0081\u0085\4\62;\2\u0082"+
		"\u0084\t\5\2\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2"+
		"\2\2\u0085\u0086\3\2\2\2\u0086*\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008c"+
		"\7B\2\2\u0089\u008b\5#\22\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008f\u0090\7\f\2\2\u0090,\3\2\2\2\u0091\u0095\5\33\16\2\u0092\u0094"+
		"\5\37\20\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2"+
		"\u0095\u0096\3\2\2\2\u0096.\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7"+
		"\61\2\2\u0099\u009a\7,\2\2\u009a\u009f\3\2\2\2\u009b\u009e\5/\30\2\u009c"+
		"\u009e\13\2\2\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3"+
		"\2\2\2\u009f\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a2\u00a3\7,\2\2\u00a3\u00a4\7\61\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\b\30\2\2\u00a6\60\3\2\2\2\u00a7\u00a8\7\61\2\2\u00a8"+
		"\u00a9\7\61\2\2\u00a9\u00ad\3\2\2\2\u00aa\u00ac\13\2\2\2\u00ab\u00aa\3"+
		"\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\t\6\2\2\u00b1\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\b\31\2\2\u00b4\62\3\2\2\2\u00b5\u00b6"+
		"\t\7\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\b\32\2\2\u00b8\64\3\2\2\2\21"+
		"\2PXgmsv|\u0085\u008c\u0095\u009d\u009f\u00ad\u00b1\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}