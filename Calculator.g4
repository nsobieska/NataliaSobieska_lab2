grammar Calculator;

expression: additiveExpression;
additiveExpression: multiplicativeExpression ((PLUS | MINUS) multiplicativeExpression)*;
multiplicativeExpression: exponentialExpression ((MULTI | DIV) exponentialExpression)*;
exponentialExpression: primaryExpression (EXP primaryExpression)*;
primaryExpression: numberExpression | SQRT primaryExpression | LPAREN additiveExpression RPAREN;
numberExpression:  MINUS INT| INT;
LPAREN: '(';
RPAREN: ')';
INT: [0-9]+ ;
PLUS: '+' ;
MINUS: '-' ;
MULTI: '*' ;
DIV: '/' ;
SQRT: 'sqrt';
EXP: '^';
INTEGRAL: 'cal';
WS : [ \t\r\n]+ -> skip ;