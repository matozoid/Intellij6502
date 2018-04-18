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

TYPE=(address|bits|bool|bytes|code|dict|float|gap|int|list|str|tuple|type)
EOL=(\r|\n|\r\n)
WHITE_SPACE=[\ \t\f]
COMMENT=";"[^\r\n]*
STRING="\""[^\"]*"\""
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

%x BLOCK_COMMENT
%%

".addr"                           { return AssemblyTypes.CONTROL_COMMAND_ADDR; }
".al"                           { return AssemblyTypes.CONTROL_COMMAND_AL; }
".align"                           { return AssemblyTypes.CONTROL_COMMAND_ALIGN; }
".as"                           { return AssemblyTypes.CONTROL_COMMAND_AS; }
".assert"                           { return AssemblyTypes.CONTROL_COMMAND_ASSERT; }
".autsiz"                           { return AssemblyTypes.CONTROL_COMMAND_AUTSIZ; }
".bend"                           { return AssemblyTypes.CONTROL_COMMAND_BEND; }
".binary"                           { return AssemblyTypes.CONTROL_COMMAND_BINARY; }
".binclude"                           { return AssemblyTypes.CONTROL_COMMAND_BINCLUDE; }
".block"                           { return AssemblyTypes.CONTROL_COMMAND_BLOCK; }
".break"                           { return AssemblyTypes.CONTROL_COMMAND_BREAK; }
".byte"                           { return AssemblyTypes.CONTROL_COMMAND_BYTE; }
".case"                           { return AssemblyTypes.CONTROL_COMMAND_CASE; }
".cdef"                           { return AssemblyTypes.CONTROL_COMMAND_CDEF; }
".cerror"                           { return AssemblyTypes.CONTROL_COMMAND_CERROR; }
".char"                           { return AssemblyTypes.CONTROL_COMMAND_CHAR; }
".check"                           { return AssemblyTypes.CONTROL_COMMAND_CHECK; }
".continue"                           { return AssemblyTypes.CONTROL_COMMAND_CONTINUE; }
".cpu"                           { return AssemblyTypes.CONTROL_COMMAND_CPU; }
".cwarn"                           { return AssemblyTypes.CONTROL_COMMAND_CWARN; }
".databank"                           { return AssemblyTypes.CONTROL_COMMAND_DATABANK; }
".default"                           { return AssemblyTypes.CONTROL_COMMAND_DEFAULT; }
".dint"                           { return AssemblyTypes.CONTROL_COMMAND_DINT; }
".dpage"                           { return AssemblyTypes.CONTROL_COMMAND_DPAGE; }
".dsection"                           { return AssemblyTypes.CONTROL_COMMAND_DSECTION; }
".dstruct"                           { return AssemblyTypes.CONTROL_COMMAND_DSTRUCT; }
".dunion"                           { return AssemblyTypes.CONTROL_COMMAND_DUNION; }
".dword"                           { return AssemblyTypes.CONTROL_COMMAND_DWORD; }
".edef"                           { return AssemblyTypes.CONTROL_COMMAND_EDEF; }
".else"                           { return AssemblyTypes.CONTROL_COMMAND_ELSE; }
".elsif"                           { return AssemblyTypes.CONTROL_COMMAND_ELSIF; }
".enc"                           { return AssemblyTypes.CONTROL_COMMAND_ENC; }
".end"                           { return AssemblyTypes.CONTROL_COMMAND_END; }
".endf"                           { return AssemblyTypes.CONTROL_COMMAND_ENDF; }
".endif"                           { return AssemblyTypes.CONTROL_COMMAND_ENDIF; }
".endm"                           { return AssemblyTypes.CONTROL_COMMAND_ENDM; }
".endn"                           { return AssemblyTypes.CONTROL_COMMAND_ENDN; }
".endp"                           { return AssemblyTypes.CONTROL_COMMAND_ENDP; }
".ends"                           { return AssemblyTypes.CONTROL_COMMAND_ENDS; }
".endswitch"                           { return AssemblyTypes.CONTROL_COMMAND_ENDSWITCH; }
".endu"                           { return AssemblyTypes.CONTROL_COMMAND_ENDU; }
".endweak"                           { return AssemblyTypes.CONTROL_COMMAND_ENDWEAK; }
".eor"                           { return AssemblyTypes.CONTROL_COMMAND_EOR; }
".error"                           { return AssemblyTypes.CONTROL_COMMAND_ERROR; }
".fi"                           { return AssemblyTypes.CONTROL_COMMAND_FI; }
".fill"                           { return AssemblyTypes.CONTROL_COMMAND_FILL; }
".for"                           { return AssemblyTypes.CONTROL_COMMAND_FOR; }
".function"                           { return AssemblyTypes.CONTROL_COMMAND_FUNCTION; }
".goto"                           { return AssemblyTypes.CONTROL_COMMAND_GOTO; }
".here"                           { return AssemblyTypes.CONTROL_COMMAND_HERE; }
".hidemac"                           { return AssemblyTypes.CONTROL_COMMAND_HIDEMAC; }
".if"                           { return AssemblyTypes.CONTROL_COMMAND_IF; }
".ifeq"                           { return AssemblyTypes.CONTROL_COMMAND_IFEQ; }
".ifmi"                           { return AssemblyTypes.CONTROL_COMMAND_IFMI; }
".ifne"                           { return AssemblyTypes.CONTROL_COMMAND_IFNE; }
".ifpl"                           { return AssemblyTypes.CONTROL_COMMAND_IFPL; }
".include"                           { return AssemblyTypes.CONTROL_COMMAND_INCLUDE; }
".lbl"                           { return AssemblyTypes.CONTROL_COMMAND_LBL; }
".lint"                           { return AssemblyTypes.CONTROL_COMMAND_LINT; }
".logical"                           { return AssemblyTypes.CONTROL_COMMAND_LOGICAL; }
".long"                           { return AssemblyTypes.CONTROL_COMMAND_LONG; }
".macro"                           { return AssemblyTypes.CONTROL_COMMAND_MACRO; }
".mansiz"                           { return AssemblyTypes.CONTROL_COMMAND_MANSIZ; }
".namespace"                           { return AssemblyTypes.CONTROL_COMMAND_NAMESPACE; }
".next"                           { return AssemblyTypes.CONTROL_COMMAND_NEXT; }
".null"                           { return AssemblyTypes.CONTROL_COMMAND_NULL; }
".offs"                           { return AssemblyTypes.CONTROL_COMMAND_OFFS; }
".option"                           { return AssemblyTypes.CONTROL_COMMAND_OPTION; }
".page"                           { return AssemblyTypes.CONTROL_COMMAND_PAGE; }
".pend"                           { return AssemblyTypes.CONTROL_COMMAND_PEND; }
".proc"                           { return AssemblyTypes.CONTROL_COMMAND_PROC; }
".proff"                           { return AssemblyTypes.CONTROL_COMMAND_PROFF; }
".pron"                           { return AssemblyTypes.CONTROL_COMMAND_PRON; }
".ptext"                           { return AssemblyTypes.CONTROL_COMMAND_PTEXT; }
".rept"                           { return AssemblyTypes.CONTROL_COMMAND_REPT; }
".rta"                           { return AssemblyTypes.CONTROL_COMMAND_RTA; }
".section"                           { return AssemblyTypes.CONTROL_COMMAND_SECTION; }
".seed"                           { return AssemblyTypes.CONTROL_COMMAND_SEED; }
".segment"                           { return AssemblyTypes.CONTROL_COMMAND_SEGMENT; }
".send"                           { return AssemblyTypes.CONTROL_COMMAND_SEND; }
".shift"                           { return AssemblyTypes.CONTROL_COMMAND_SHIFT; }
".shiftl"                           { return AssemblyTypes.CONTROL_COMMAND_SHIFTL; }
".showmac"                           { return AssemblyTypes.CONTROL_COMMAND_SHOWMAC; }
".sint"                           { return AssemblyTypes.CONTROL_COMMAND_SINT; }
".struct"                           { return AssemblyTypes.CONTROL_COMMAND_STRUCT; }
".switch"                           { return AssemblyTypes.CONTROL_COMMAND_SWITCH; }
".text"                           { return AssemblyTypes.CONTROL_COMMAND_TEXT; }
".union"                           { return AssemblyTypes.CONTROL_COMMAND_UNION; }
".var"                           { return AssemblyTypes.CONTROL_COMMAND_VAR; }
".warn"                           { return AssemblyTypes.CONTROL_COMMAND_WARN; }
".weak"                           { return AssemblyTypes.CONTROL_COMMAND_WEAK; }
".word"                           { return AssemblyTypes.CONTROL_COMMAND_WORD; }
".xl"                           { return AssemblyTypes.CONTROL_COMMAND_XL; }
".xs"                           { return AssemblyTypes.CONTROL_COMMAND_XS; }
"abs("                          { return AssemblyTypes.FUNCTION_ABS; }
"acos("                          { return AssemblyTypes.FUNCTION_ACOS; }
"all("                          { return AssemblyTypes.FUNCTION_ALL; }
"any("                          { return AssemblyTypes.FUNCTION_ANY; }
"asin("                          { return AssemblyTypes.FUNCTION_ASIN; }
"atan("                          { return AssemblyTypes.FUNCTION_ATAN; }
"atan2("                          { return AssemblyTypes.FUNCTION_ATAN2; }
"cbrt("                          { return AssemblyTypes.FUNCTION_CBRT; }
"ceil("                          { return AssemblyTypes.FUNCTION_CEIL; }
"cos("                          { return AssemblyTypes.FUNCTION_COS; }
"cosh("                          { return AssemblyTypes.FUNCTION_COSH; }
"deg("                          { return AssemblyTypes.FUNCTION_DEG; }
"exp("                          { return AssemblyTypes.FUNCTION_EXP; }
"floor("                          { return AssemblyTypes.FUNCTION_FLOOR; }
"format("                          { return AssemblyTypes.FUNCTION_FORMAT; }
"frac("                          { return AssemblyTypes.FUNCTION_FRAC; }
"hypot("                          { return AssemblyTypes.FUNCTION_HYPOT; }
"len("                          { return AssemblyTypes.FUNCTION_LEN; }
"log("                          { return AssemblyTypes.FUNCTION_LOG; }
"log10("                          { return AssemblyTypes.FUNCTION_LOG10; }
"pow("                          { return AssemblyTypes.FUNCTION_POW; }
"rad("                          { return AssemblyTypes.FUNCTION_RAD; }
"random("                          { return AssemblyTypes.FUNCTION_RANDOM; }
"range("                          { return AssemblyTypes.FUNCTION_RANGE; }
"repr("                          { return AssemblyTypes.FUNCTION_REPR; }
"round("                          { return AssemblyTypes.FUNCTION_ROUND; }
"sign("                          { return AssemblyTypes.FUNCTION_SIGN; }
"sin("                          { return AssemblyTypes.FUNCTION_SIN; }
"sinh("                          { return AssemblyTypes.FUNCTION_SINH; }
"size("                          { return AssemblyTypes.FUNCTION_SIZE; }
"sort("                          { return AssemblyTypes.FUNCTION_SORT; }
"sqrt("                          { return AssemblyTypes.FUNCTION_SQRT; }
"tan("                          { return AssemblyTypes.FUNCTION_TAN; }
"tanh("                          { return AssemblyTypes.FUNCTION_TANH; }
"trunc("                          { return AssemblyTypes.FUNCTION_TRUNC; }
".comment"                      { yybegin(BLOCK_COMMENT); return AssemblyTypes.COMMENT; }
<BLOCK_COMMENT>".endc"          { yybegin(YYINITIAL); return AssemblyTypes.COMMENT; }
<BLOCK_COMMENT>\n               { return AssemblyTypes.COMMENT; }
<BLOCK_COMMENT>.                { return AssemblyTypes.COMMENT; }
"$"[0-9a-fA-F]+               { return AssemblyTypes.HEX_NUMBER; }
[0-9]+              { return AssemblyTypes.NUMBER; }
^([a-zA-Z_][a-zA-Z0-9_]*:?|"+"|"-") {return AssemblyTypes.LABEL; }
"\\"[a-zA-Z_][a-zA-Z0-9_]*      { return AssemblyTypes.PARAMETER_USAGE; }
{EOL}                         { return AssemblyTypes.EOL; }
({WHITE_SPACE})+              { return TokenType.WHITE_SPACE; }
"("                           { return AssemblyTypes.OPEN_PAREN; }
")"                           { return AssemblyTypes.CLOSE_PAREN; }
"{"                           { return AssemblyTypes.OPEN_BRACE; }
"}"                           { return AssemblyTypes.CLOSE_BRACE; }
","                           { return AssemblyTypes.COMMA; }
"."                           { return AssemblyTypes.DOT; }
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
"<"                           { return AssemblyTypes.LESS; }
">"                           { return AssemblyTypes.GREATER; }
"="                           { return AssemblyTypes.EQUAL; }
"#"                           { return AssemblyTypes.HEKJE; }
{COMMENT}                     { return AssemblyTypes.COMMENT; }
{STRING}                      { return AssemblyTypes.STRING; }
{MNEMONIC}                    { return AssemblyTypes.MNEMONIC; }
{TYPE}                        { return AssemblyTypes.TYPE; }
{IDENTIFIER}                  { return AssemblyTypes.IDENTIFIER; }
.                             { return TokenType.BAD_CHARACTER; }