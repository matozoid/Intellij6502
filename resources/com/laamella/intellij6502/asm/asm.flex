package com.laamella.intellij6502.asm;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.laamella.intellij6502.asm.psi.AssemblyTypes;
import com.intellij.psi.TokenType;

%%

%class AssemblyLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%ignorecase
%eof{  return;
%eof}

MNEMONIC=(ADC|AND|ASL|BCC|BCS|BEQ|BIT|BMI|BNE|BPL|BRK|BVC|BVS|CLC|
          CLD|CLI|CLV|CMP|CPX|CPY|DEC|DEX|DEY|EOR|INC|INX|INY|JMP|
          JSR|LDA|LDX|LDY|LSR|NOP|ORA|PHA|PHP|PLA|PLP|ROL|ROR|RTI|
          RTS|SBC|SEC|SED|SEI|STA|STX|STY|TAX|TAY|TSX|TXA|TXS|TYA)

CONTROL_COMMAND="."(addr|al|align|as|assert|autsiz|bend|binary|binclude|block|break|byte|case|cdef|cerror|char|check|continue|cpu|cwarn|databank|default|dint|dpage|dsection|dstruct|dunion|dword|edef|else|elsif|enc|end|endf|endif|endm|endn|endp|ends|endswitch|endu|endweak|eor|error|fi|fill|for|function|goto|here|hidemac|if|ifeq|ifmi|ifne|ifpl|include|lbl|lint|logical|long|macro|mansiz|namespace|next|null|offs|option|page|pend|proc|proff|pron|ptext|rept|rta|section|seed|segment|send|shift|shiftl|showmac|sint|struct|switch|text|union|var|warn|weak|word|xl|xs)
USER_COMMAND=("."|"#")[a-zA-Z_][a-zA-Z0-9_]*
FUNCTION=(abs|acos|all|any|asin|atan|atan2|cbrt|ceil|cos|cosh|deg|exp|floor
//|format
|frac|hypot|len|log|log10|pow|rad|random|range|repr|round|sign|sin|sinh|size|sort|sqrt|tan|tanh|trunc)
TYPE=(address|bits|bool|bytes|code|dict|float|gap|int|list|str|tuple|type)
EOL=(\r|\n|\r\n)
WHITE_SPACE=[\ \t\f]
COMMENT=";"[^\r\n]*
STRING="\""[^\"]*"\""
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

%x BLOCK_COMMENT
%%

".comment"            { yybegin(BLOCK_COMMENT); return AssemblyTypes.COMMENT; }
<BLOCK_COMMENT>".endc" { yybegin(YYINITIAL); return AssemblyTypes.COMMENT; }
<BLOCK_COMMENT>\n   { return AssemblyTypes.COMMENT; }
<BLOCK_COMMENT>.    { return AssemblyTypes.COMMENT; }
"format"                        {return AssemblyTypes.FORMAT; }
^([a-zA-Z_][a-zA-Z0-9_]*:?|"+"|"-") {return AssemblyTypes.LABEL; }
"\\"[a-zA-Z_][a-zA-Z0-9_]*      { return AssemblyTypes.PARAMETER_USAGE; }
{EOL}                         { return AssemblyTypes.EOL; }
({WHITE_SPACE})+              { return TokenType.WHITE_SPACE; }
"("                           { return AssemblyTypes.OPEN_PAREN; }
")"                           { return AssemblyTypes.CLOSE_PAREN; }
"{"                           { return AssemblyTypes.OPEN_BRACE; }
"}"                           { return AssemblyTypes.CLOSE_BRACE; }
","                           { return AssemblyTypes.COMMA; }
"-"                           { return AssemblyTypes.MINUS; }
"+"                           { return AssemblyTypes.PLUS; }
"*"                           { return AssemblyTypes.TIMES; }
"/"                           { return AssemblyTypes.DIV; }
"~"                           { return AssemblyTypes.TILDE; }
"^"                           { return AssemblyTypes.DAKJE; }
"|"                           { return AssemblyTypes.PIPE; }
"<="                          { return AssemblyTypes.LESS_EQUAL; }
">="                          { return AssemblyTypes.GREATER_EQUAL; }
"<<"                          { return AssemblyTypes.SHIFT_LEFT; }
">>"                          { return AssemblyTypes.SHIFT_RIGHT; }
"&"                           { return AssemblyTypes.AND; }
"&&"                          { return AssemblyTypes.BOOLEAN_AND; }
"||"                          { return AssemblyTypes.BOOLEAN_OR; }
"!"                           { return AssemblyTypes.BOOLEAN_NOT; }
"%"[01]+                      { return AssemblyTypes.BINARY_NUMBER; }
"%"                           { return AssemblyTypes.MODULO; }
"<>"                          { return AssemblyTypes.NOT_EQUAL; }
"<"                           { return AssemblyTypes.LESS_THAN; }
">"                           { return AssemblyTypes.GREATER_THAN; }
"="                           { return AssemblyTypes.EQUAL; }
"#"                           { return AssemblyTypes.IMMEDIATE; }
"$"[0-9a-fA-F]+               { return AssemblyTypes.HEX_NUMBER; }
[0-9]+                        { return AssemblyTypes.NUMBER; }
{COMMENT}                     { return AssemblyTypes.COMMENT; }
{STRING}                      { return AssemblyTypes.STRING; }
{MNEMONIC}                    { return AssemblyTypes.MNEMONIC; }
{TYPE}                        { return AssemblyTypes.TYPE; }
{IDENTIFIER}                  { return AssemblyTypes.IDENTIFIER; }
{CONTROL_COMMAND}             { return AssemblyTypes.CONTROL_COMMAND; }
{USER_COMMAND}             { return AssemblyTypes.USER_COMMAND; }
{FUNCTION}                    { return AssemblyTypes.FUNCTION; }
.                             { return TokenType.BAD_CHARACTER; }