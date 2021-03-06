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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		X=18, StringSingle=19, Number=20, C=21, BlockComment=22, LineComment=23, 
		Whitespace=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"IdUp", "IdLow", "IdChar", "CHAR", "CHARInStringSingle", "X", "StringSingle", 
			"Number", "C", "BlockComment", "LineComment", "Whitespace"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00d3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\7"+
		"\23r\n\23\f\23\16\23u\13\23\3\23\3\23\3\24\7\24z\n\24\f\24\16\24}\13\24"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\7\30\u0089\n\30\f\30"+
		"\16\30\u008c\13\30\3\30\6\30\u008f\n\30\r\30\16\30\u0090\3\30\3\30\7\30"+
		"\u0095\n\30\f\30\16\30\u0098\13\30\5\30\u009a\n\30\3\31\3\31\7\31\u009e"+
		"\n\31\f\31\16\31\u00a1\13\31\3\31\3\31\3\32\3\32\7\32\u00a7\n\32\f\32"+
		"\16\32\u00aa\13\32\3\33\3\33\7\33\u00ae\n\33\f\33\16\33\u00b1\13\33\3"+
		"\34\3\34\3\34\3\34\3\34\7\34\u00b8\n\34\f\34\16\34\u00bb\13\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00c6\n\35\f\35\16\35\u00c9"+
		"\13\35\3\35\5\35\u00cc\n\35\3\35\3\35\3\36\3\36\3\36\3\36\4\u00b9\u00c7"+
		"\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\2\'\2)\2+\2-\2/\24\61\25\63\26\65\27\67\309\31;\32"+
		"\3\2\b\6\2\62;C\\aac|\4\2\f\f\"\u0080\4\2\"#%\u0080\5\2/\60\62;aa\3\3"+
		"\f\f\5\2\13\f\"\"..\2\u00d9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5D\3\2\2\2\7"+
		"I\3\2\2\2\tS\3\2\2\2\13U\3\2\2\2\rW\3\2\2\2\17Y\3\2\2\2\21\\\3\2\2\2\23"+
		"^\3\2\2\2\25`\3\2\2\2\27b\3\2\2\2\31d\3\2\2\2\33f\3\2\2\2\35h\3\2\2\2"+
		"\37j\3\2\2\2!l\3\2\2\2#n\3\2\2\2%s\3\2\2\2\'{\3\2\2\2)\u0080\3\2\2\2+"+
		"\u0082\3\2\2\2-\u0084\3\2\2\2/\u0099\3\2\2\2\61\u009b\3\2\2\2\63\u00a4"+
		"\3\2\2\2\65\u00ab\3\2\2\2\67\u00b2\3\2\2\29\u00c1\3\2\2\2;\u00cf\3\2\2"+
		"\2=>\7B\2\2>?\7v\2\2?@\7q\2\2@A\7v\2\2AB\7c\2\2BC\7n\2\2C\4\3\2\2\2DE"+
		"\7B\2\2EF\7c\2\2FG\7w\2\2GH\7z\2\2H\6\3\2\2\2IJ\7k\2\2JK\7p\2\2KL\7f\2"+
		"\2LM\7w\2\2MN\7e\2\2NO\7v\2\2OP\7k\2\2PQ\7q\2\2QR\7p\2\2R\b\3\2\2\2ST"+
		"\7*\2\2T\n\3\2\2\2UV\7+\2\2V\f\3\2\2\2WX\7=\2\2X\16\3\2\2\2YZ\7~\2\2Z"+
		"[\7/\2\2[\20\3\2\2\2\\]\7<\2\2]\22\3\2\2\2^_\7>\2\2_\24\3\2\2\2`a\7@\2"+
		"\2a\26\3\2\2\2bc\7]\2\2c\30\3\2\2\2de\7_\2\2e\32\3\2\2\2fg\7~\2\2g\34"+
		"\3\2\2\2hi\7\60\2\2i\36\3\2\2\2jk\7}\2\2k \3\2\2\2lm\7\177\2\2m\"\3\2"+
		"\2\2no\7?\2\2o$\3\2\2\2pr\7a\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2"+
		"\2tv\3\2\2\2us\3\2\2\2vw\4C\\\2w&\3\2\2\2xz\7a\2\2yx\3\2\2\2z}\3\2\2\2"+
		"{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\4c|\2\177(\3\2\2\2\u0080"+
		"\u0081\t\2\2\2\u0081*\3\2\2\2\u0082\u0083\t\3\2\2\u0083,\3\2\2\2\u0084"+
		"\u0085\t\4\2\2\u0085.\3\2\2\2\u0086\u008a\5\'\24\2\u0087\u0089\5)\25\2"+
		"\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\u009a\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008f\7a\2\2\u008e"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0096\4\62;\2\u0093\u0095\5)\25\2\u0094"+
		"\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2"+
		"\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u0086\3\2\2\2\u0099"+
		"\u008e\3\2\2\2\u009a\60\3\2\2\2\u009b\u009f\7$\2\2\u009c\u009e\5-\27\2"+
		"\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7$\2\2\u00a3"+
		"\62\3\2\2\2\u00a4\u00a8\4\62;\2\u00a5\u00a7\t\5\2\2\u00a6\u00a5\3\2\2"+
		"\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\64"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00af\5%\23\2\u00ac\u00ae\5)\25\2\u00ad"+
		"\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\66\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7\61\2\2\u00b3\u00b4"+
		"\7,\2\2\u00b4\u00b9\3\2\2\2\u00b5\u00b8\5\67\34\2\u00b6\u00b8\13\2\2\2"+
		"\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc"+
		"\u00bd\7,\2\2\u00bd\u00be\7\61\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\b\34"+
		"\2\2\u00c08\3\2\2\2\u00c1\u00c2\7\61\2\2\u00c2\u00c3\7\61\2\2\u00c3\u00c7"+
		"\3\2\2\2\u00c4\u00c6\13\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2"+
		"\u00c7\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00ca\u00cc\t\6\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00ce\b\35\2\2\u00ce:\3\2\2\2\u00cf\u00d0\t\7\2\2\u00d0\u00d1\3\2\2\2"+
		"\u00d1\u00d2\b\36\2\2\u00d2<\3\2\2\2\20\2s{\u008a\u0090\u0096\u0099\u009f"+
		"\u00a8\u00af\u00b7\u00b9\u00c7\u00cb\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}