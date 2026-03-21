grammar filefind;

// Parser Rules
query : FIND (STRING | FILE) EOF
      | FIND (STRING | FILE) FROM STRING EOF
      | FIND (STRING | FILE) WHERE expr EOF
      | FIND (STRING | FILE) FROM STRING WHERE expr EOF
      | FIND (STRING | FILE) FROM STRING BEGIN expr+ END EOF
      ;

expr  : EXT relop STRING
      | EXT relop STRING logop expr
      | EXT CONTAINS STRING
      | EXT CONTAINS STRING logop expr
      | SIZE relop NUMBER
      | SIZE relop NUMBER logop expr
      | CREATED relop time
      | CREATED relop time logop expr
      | CREATED EQ RECENTLY
      | DATE_MODIFIED relop time
      | DATE_MODIFIED relop time logop expr
      ;

relop : EQ | GTE | GT | LTE | LT | NEQ ;

logop : AND | OR | NOT | NOR ;

time  : NUMBER DAYS
      | NUMBER MONS
      | NUMBER YRS
      ;

// Lexer Rules
FIND          : 'find' ;
FROM          : 'from' ;
WHERE         : 'where' ;
EXT           : 'ext' ;
CREATED       : 'created' ;
DATE_MODIFIED : 'date-modified' ;
RECENTLY      : 'recently' ;
BEGIN         : 'begin' ;
END           : 'end' ;
SIZE          : 'size' ;
CONTAINS      : 'contains' ;
FILE          : 'file' ;
DAYS          : 'days' ;
MONS          : 'months' ;
YRS           : 'yrs' ;
AND           : 'and' ;
OR            : 'or' ;
NOT           : 'not' ;
NOR           : 'nor' ;
EQ            : '=' ;
GTE           : '>=' ;
GT            : '>' ;
LTE           : '<=' ;
LT            : '<' ;
NEQ           : '!=' ;
NUMBER        : [0-9]+ ('.' [0-9]+)? ;
STRING        : '"' (~["])* '"' ;
WS            : [ \t\n\r]+ -> skip ;