grammar MiLenguaje;

// Regla parser mínima (requerida por ANTLR)
programa : unidad* EOF ;

unidad : declaracionFuncion
       | instruccion
       ;

instruccion : bloque
            | declaracion
            | asignacion
            | sentenciaIf
            | sentenciaWhile
            | sentenciaDoWhile
            | sentenciaFor
            | sentenciaSwitch
            | sentenciaReturn
            | sentenciaBreak
            | sentenciaContinue
            | sentenciaPrint
            | expr PYC
            | PYC 
            ;

bloque : LA instruccion* LC ;

declaracionFuncion : tipo ID PA parametros? PC bloque ;

parametros : parametro (COMA parametro)* ;

parametro : tipo ID ;

declaracion : tipo ID (CA INTEGER CC)? (IGUAL expr)? PYC ;

declaracion_sin_pyc : tipo ID (CA INTEGER CC)? (IGUAL expr)? ;

tipo : INT | CHAR | DOUBLE | VOID | BOOL ;

asignacion : lvalue IGUAL expr PYC ;

lvalue : ID | ID CA expr CC ;

asignacion_sin_pyc : lvalue IGUAL expr ;

sentenciaIf : IF PA expr PC instruccion (ELSE instruccion)? ;

sentenciaWhile : WHILE PA expr PC instruccion ;

sentenciaDoWhile : DO instruccion WHILE PA expr PC PYC ;

sentenciaFor : FOR PA (declaracion_sin_pyc | asignacion_sin_pyc | expr)? PYC expr? PYC (asignacion_sin_pyc | expr)? PC instruccion ;

sentenciaSwitch : SWITCH PA expr PC LA caseBlock* LC ;

caseBlock : CASE expr DOS_PUNTOS instruccion*
          | DEFAULT DOS_PUNTOS instruccion*
          ;

sentenciaReturn : RETURN expr? PYC ;

sentenciaBreak : BREAK PYC ;

sentenciaContinue : CONTINUE PYC ;

sentenciaPrint : PRINT PA (expr | STRING) PC PYC ;

// Expresiones con precedencia (de menor a mayor)
expr : lvalue IGUAL expr             # Assignment
     | expr OR expr                 # LogicalOr
     | expr AND expr                # LogicalAnd
     | expr EQL expr                # Equality
     | expr DISTINTO expr           # Inequality
     | expr (MAYOR | MAYOR_IGUAL | MENOR | MENOR_IGUAL) expr # Comparison
     | expr SUM expr                # Addition
     | expr RES expr                # Subtraction
     | expr MUL expr                # Multiplication
     | expr DIV expr                # Division
     | expr MOD expr                # Modulo
     | NOT expr                     # LogicalNot
     | RES expr                     # UnaryMinus
     | factor                       # Primary
     ;

factor : ID PA (expr (COMA expr)*)? PC # FunctionCall
       | ID CA expr CC             # ArrayAccess
       | ID                        # Identifier
       | INTEGER                   # IntLiteral
       | DECIMAL                   # DecLiteral
       | CHARACTER                 # CharLiteral
       | STRING                    # StringLiteral
       | PA expr PC                # ParenthesizedExpr
       ;

token : PA | PC | CA | CC | LA | LC | PYC | COMA | IGUAL | MAYOR | MAYOR_IGUAL 
      | MENOR | MENOR_IGUAL | EQL | DISTINTO | SUM | RES | MUL | DIV | MOD
      | OR | AND | NOT | FOR | WHILE | IF | ELSE | SWITCH | CASE | DEFAULT | BREAK | DO | CONTINUE | PRINT
      | INT | CHAR | DOUBLE | VOID | BOOL | RETURN | DOS_PUNTOS | ID | INTEGER | DECIMAL | CHARACTER | STRING | OTRO 
      ;

fragment LETRA : [A-Za-z];
fragment DIGITO : [0-9];

// TOKENS 
PA   : '(' ;
PC   : ')' ;
CA   : '[' ;
CC   : ']' ;
LA   : '{' ;
LC   : '}' ;

PYC  : ';' ;
COMA : ',' ;
DOS_PUNTOS : ':' ;

IGUAL : '=' ;
TRUE : 'true';
FALSE : 'false';
AND : 'and';
MAYOR  : '>' ;
MAYOR_IGUAL: '>=';
MENOR  : '<' ;
MENOR_IGUAL: '<=';
EQL  : '==';
DISTINTO  : '!=';

SUM  : '+' ;
RES  : '-' ;
MUL  : '*' ;
DIV  : '/' ;
MOD  : '%' ;

OR   : 'or' ;
NOT  : 'not'  ;

FOR  : 'for';
WHILE: 'while';

IF   : 'if' ;
ELSE : 'else' ;
SWITCH : 'switch' ;
CASE : 'case' ;
DEFAULT : 'default' ;
BREAK : 'break' ;
DO : 'do' ;
CONTINUE : 'continue' ;
PRINT : 'print' ;

INT     : 'int' ;
CHAR    : 'char' ;
DOUBLE  : 'double' ;
VOID    : 'void' ;
BOOL    : 'bool' ;

RETURN : 'return';

CASA : 'casa';

ID : (LETRA | '_') (LETRA | DIGITO | '_')*;

INTEGER : DIGITO+;
DECIMAL : INTEGER'.'INTEGER;
CHARACTER: '\'' (~['\r\n] | '\\' .) '\'' ;
STRING : '"' (~["\r\n] | '\\' .)* '"' ;

// Comentarios - Se ignoran durante el análisis
//COMENTARIO_LINEA : '//' ~[\r\n]*; sin ocultar
COMENTARIO_LINEA : '//' ~[\r\n]* -> skip;
COMENTARIO_BLOQUE : '/*' .*? '*/' -> skip;

WS : [ \r\n\t] -> skip ;
OTRO : . ;