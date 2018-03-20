package com.laamella.cc65plugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.laamella.cc65plugin.psi.Ca65Types;
import com.intellij.psi.TokenType;

%%

%class Ca65Lexer
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
EOL=(\r|\n|\r\n)
WHITE_SPACE=[\ \t\f]
COMMENT=";"[^\r\n]*
STRING="\""[^\"]*"\""
CONTROL_COMMAND="."[a-zA-Z_][a-zA-Z0-9_]*
LABEL=("@"?[a-zA-Z_][a-zA-Z0-9_]*)?":"
LOCAL_LABEL_REFERENCE="@"[a-zA-Z_][a-zA-Z0-9_]*
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

%%

{EOL}                           { return Ca65Types.EOL; }
({WHITE_SPACE})+                                     {return TokenType.WHITE_SPACE; }
"("                           { return Ca65Types.OPEN_PAREN; }
")"                           { return Ca65Types.CLOSE_PAREN; }
"{"                           { return Ca65Types.OPEN_BRACE; }
"}"                           { return Ca65Types.CLOSE_BRACE; }
","                           { return Ca65Types.COMMA; }
"-"                           { return Ca65Types.MINUS; }
"+"                           { return Ca65Types.PLUS; }
"*"                           { return Ca65Types.TIMES; }
"/"                           { return Ca65Types.DIV; }
"~"                           { return Ca65Types.TILDE; }
"^"                           { return Ca65Types.DAKJE; }
"|"                           { return Ca65Types.PIPE; }
"<="                           { return Ca65Types.LESS_EQUAL; }
">="                           { return Ca65Types.GREATER_EQUAL; }
"<<"                           { return Ca65Types.SHIFT_LEFT; }
">>"                           { return Ca65Types.SHIFT_RIGHT; }
"&"                           { return Ca65Types.AND; }
"&&"                           { return Ca65Types.BOOLEAN_AND; }
"||"                           { return Ca65Types.BOOLEAN_OR; }
"!"                           { return Ca65Types.BOOLEAN_NOT; }
"%"[01]+                           { return Ca65Types.BINARY_NUMBER; }
"<>"                           { return Ca65Types.NOT_EQUAL; }
"<"                           { return Ca65Types.LESS_THAN; }
">"                           { return Ca65Types.GREATER_THAN; }
"="                           { return Ca65Types.EQUAL; }
"#"                           { return Ca65Types.IMMEDIATE; }
"$"[0-9a-fA-F]+                           { return Ca65Types.HEX_NUMBER; }
[0-9]+                           { return Ca65Types.NUMBER; }
{COMMENT}                           { return Ca65Types.COMMENT; }
{STRING}                           { return Ca65Types.STRING; }
{MNEMONIC}                           { return Ca65Types.MNEMONIC; }
{LABEL}                           { return Ca65Types.LABEL; }
{LOCAL_LABEL_REFERENCE}             {return Ca65Types.LOCAL_LABEL_REFERENCE; }
{IDENTIFIER}                           { return Ca65Types.IDENTIFIER; }
{CONTROL_COMMAND}                           { return Ca65Types.CONTROL_COMMAND; }
.                                                           { return TokenType.BAD_CHARACTER; }