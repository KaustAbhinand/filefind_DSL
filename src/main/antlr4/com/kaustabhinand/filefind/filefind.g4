grammar filefind;

query   : FIND subject (FROM STRING)? (WHERE expr)? EOF
        | FIND subject FROM STRING BEGIN expr END EOF
        ;

subject : FILE | STRING ;

// Alternatives listed first bind tighter: NOT > AND > OR
expr    : NOT expr                 # NotExpr
        | expr AND expr            # AndExpr
        | expr OR expr             # OrExpr
        | LPAREN expr RPAREN       # ParenExpr
        | cond                     # CondExpr
        ;

cond    : EXT relop value          # ExtCond
        | NAME nameop value        # NameCond
        | SIZE relop NUMBER        # SizeCond
        | CREATED relop time       # CreatedCond
        | CREATED EQ RECENTLY      # RecentCond
        | DATE_MODIFIED relop time # ModifiedCond
        ;

relop   : EQ | GTE | GT | LTE | LT | NEQ ;
nameop  : EQ | NEQ | CONTAINS | LIKE ;
value   : STRING | BAREWORD | NUMBER ;
time    : NUMBER (DAYS | MONS | YRS) ;

// Lexer: keywords first, BAREWORD last
FIND : 'find' ;
FROM : 'from' ;
WHERE : 'where' ;
BEGIN : 'begin' ;
END : 'end' ;
FILE : 'file' ;
EXT : 'ext' ;
NAME : 'name' ;
SIZE : 'size' ;
CREATED : 'created' ;
DATE_MODIFIED : 'date-modified' ;
RECENTLY : 'recently' ;
CONTAINS : 'contains' ;
LIKE : 'like' ;
DAYS : 'days' ;
MONS : 'months' ;
YRS : 'yrs' ;
AND : 'and' ;     OR : 'or' ;       NOT : 'not' ;
EQ : '=' ;
GTE : '>=' ;
GT : '>' ;
LTE : '<=' ;
LT : '<' ;
NEQ : '!=' ;
LPAREN : '(' ;
RPAREN : ')' ;
NUMBER   : [0-9]+ ('.' [0-9]+)? ;
STRING   : '\'' (~['])* '\'' ;
BAREWORD : [a-zA-Z0-9_.-]+ ;
WS       : [ \t\r\n]+ -> skip ;