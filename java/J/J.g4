grammar J;
@header {package generated;}

fragment IdUp: '_'* ('A'..'Z');
fragment IdLow: '_'* 'a'..'z';
fragment IdChar: 'a'..'z' | 'A'..'Z' | '_' | '0'..'9';
fragment CHAR:
'A'..'Z'|'a'..'z'|'0'..'9' | '(' | ')' | '[' | ']' | '<' | '>' | '&' | '|' | '*' | '+' | '-' | '=' | '/' | '!' | '?' | ';' | ':' | ',' | '.' | ' ' | '~' | '@' | '#' | '$' | '%' | '`' | '^' | '_' | '\\' | '{' | '}' | '"' | '\'' | '\n';
fragment CHARInStringSingle:
'A'..'Z'|'a'..'z'|'0'..'9' | '(' | ')' | '[' | ']' | '<' | '>' |'&'|'|'|'*'|'+'|'-'|'=' | '/' | '!' | '?' | ';' | ':' | ',' | '.' | ' ' | '~' | '@' | '#' | '$' | '%' | '`' | '^' | '_' | '\\' | '{' | '}' |       '\'';//no \n and "
X: IdLow IdChar* | '_'+ ('0'..'9') IdChar*;
StringSingle: '"' CHARInStringSingle* '"';
Number: '0'..'9' ('.'|'_'|'-'|'0'..'9')*;
S: '@' CHARInStringSingle* '\n';
x: X;
C: IdUp IdChar*;
BlockComment: '/*' (BlockComment|.)*? '*/'	-> channel(HIDDEN) ; // nesting comments allowed
LineComment: '//' .*? ('\n'|EOF)				-> channel(HIDDEN) ;
Whitespace: ( ' ' | '\t' | '\n'| ',' )-> channel(HIDDEN);
t: C ('<'t*'>')?;
l: t
  | t? '[' ']'  
  | t? '[' e ']' 
  | t? '[' x* '|' e ']' 
  | t? '[' mCall ('.' mCall)* ']'
  ;
eAtom: x | l | num | string;
num: Number;
string:StringSingle;
e: eAtom ('.' mCall)*;
mCall: x gensT | x gensT '(' e* ')';
dec: C gens ':' t* '{' mDec* '}';
gens: | '<'C*'>';
gensT: | '<'t*'>';
mDec: mH ';'| mH '=' e ';';
mH: S? gens t x | S? gens t x '(' (t x)* ')';  
prog: dec* e EOF;
nudeE: e EOF;