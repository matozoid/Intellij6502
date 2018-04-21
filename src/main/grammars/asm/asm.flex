package com.laamella.intellij6502.asm;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.laamella.intellij6502.asm.psi.AssemblyTypes.*;
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

// 6502
_6502_STANDARD_OPCODE = ADC|AND|ASL|BCC|BCS|BEQ|BIT|BMI|BNE|BPL|BRK|BVC|BVS|CLC
            |CLD|CLI|CLV|CMP|CPX|CPY|DEC|DEX|DEY|EOR|INC|INX|INY|JMP
            |JSR|LDA|LDX|LDY|LSR|NOP|ORA|PHA|PHP|PLA|PLP|ROL|ROR|RTI
            |RTS|SBC|SEC|SED|SEI|STA|STX|STY|TAX|TAY|TSX|TXA|TXS|TYA
_6502_PSEUDO_OPCODE = ASL|BGE| BLT|GCC| GCS|GEQ| GGE|GLT| GMI|GNE| GPL|GVC| GVS|LSR| ROL|ROR| SHL|SHR
_6502_ILLEGAL_OPCODE =  ANC|ANE|ARR|ASR|DCP|ISB|JAM|LAX|LDS|NOP|RLA|RRA|SAX|SBX|SHA|SHS|SHX|SHY|SLO|SRE
_6502_ILLEGAL_PSEUDO_OPCODE = AHX|ALR|AXS|DCM|INS|ISC|LAE|LAS|LXA|TAS|XAA

_6502_OPCODE={_6502_STANDARD_OPCODE}|{_6502_PSEUDO_OPCODE}|{_6502_ILLEGAL_OPCODE}|{_6502_ILLEGAL_PSEUDO_OPCODE}

// 65DTV02
//_65DTV02_STANDARD_OPCODE = _6502_STANDARD_OPCODE|BRA|SAC|SIR
//_65DTV02_PSEUDO_OPCODE = GRA // and more from the 6502
//_65DTV02_OPCODE = _65DTV02_STANDARD_OPCODE|_65DTV02_PSEUDO_OPCODE

// 65C02
//_65C02_STANDARD_OPCODE = _6502_STANDARD_OPCODE|ADC|AND|BIT|BRA|CMP|DEC|EOR|INC|JMP|LDA|ORA|PHX|PHY|PLX|PLY|SBC|STA|STZ|TRB|TSB
//_65C02_PSEUDO_OPCODE = _6502_PSEUDO_OPCODE|CLR|DEA|GRA|INA
//_65C02_OPCODE = _65C02_STANDARD_OPCODE|_65C02_PSEUDO_OPCODE

// R65C02
//(BBR|BBS|NOP|RMB|SMB)

// W65C02
//(STP|WAI)

//(HLT)

// W65816
//(ADC|AND|BRL|CMP|COP|EOR|JMP|JSL|JSR|LDA|MVN|MVP|ORA|PEA|PEI|PER|PHB|PHD|PHK|PLB|PLD|REP|RTL|SBC|SEP|STA|STP|TCD|TCS|TDC|TSC|TXY|TYX|WAI|XBA|XCE)

//(CSP|CLP|HLT|JML|SWA|TAD|TAS|TDA|TSA)

// 65EL02
//(ADC|AND|CMP|DIV|ENT|EOR|JSR|LDA|MMU|MUL|NXA|NXT|ORA|PEA|PEI|PER|PHD|PLD|REA|REI|REP|RER|RHA|RHI|RHX|RHY|RLA|RLI|RLX|RLY|SBC|SEA|SEP|STA|STP|SWA|TAD|TDA|TIX|TRX|TXI|TXR|TXY|TYX|WAI|XBA|XCE|ZEA)

//(CLP|HLT)

// 65CE02
//(ASR|ASW|BCC|BCS|BEQ|BMI|BNE|BPL|BRA|BSR|BVC|BVS|CLE|CPZ|DEW|DEZ|INW|INZ|JSR|LDA|LDZ|NEG|PHW|PHZ|PLZ|ROW|RTS|SEE|STA|STX|STY|TAB|TAZ|TBA|TSY|TYS|TZA)

//(ASR|BGE|BLT|NEG|RTN)

//(CLR)

// CSG 4510
//(MAP)

//(EOM)

TYPE=address|bits|bool|bytes|code|dict|float|gap|int|list|str|tuple|type
EOL=(\r|\n|\r\n)
WHITE_SPACE=[\ \t\f]
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

%x BLOCK_COMMENT
%%

".addr"                           { return CONTROL_COMMAND_ADDR; }
".al"                           { return CONTROL_COMMAND_AL; }
".align"                           { return CONTROL_COMMAND_ALIGN; }
".as"                           { return CONTROL_COMMAND_AS; }
".assert"                           { return CONTROL_COMMAND_ASSERT; }
".autsiz"                           { return CONTROL_COMMAND_AUTSIZ; }
".bend"                           { return CONTROL_COMMAND_BEND; }
".binary"                           { return CONTROL_COMMAND_BINARY; }
".binclude"                           { return CONTROL_COMMAND_BINCLUDE; }
".block"                           { return CONTROL_COMMAND_BLOCK; }
".break"                           { return CONTROL_COMMAND_BREAK; }
".byte"                           { return CONTROL_COMMAND_BYTE; }
".case"                           { return CONTROL_COMMAND_CASE; }
".cdef"                           { return CONTROL_COMMAND_CDEF; }
".cerror"                           { return CONTROL_COMMAND_CERROR; }
".char"                           { return CONTROL_COMMAND_CHAR; }
".check"                           { return CONTROL_COMMAND_CHECK; }
".continue"                           { return CONTROL_COMMAND_CONTINUE; }
".cpu"                           { return CONTROL_COMMAND_CPU; }
".cwarn"                           { return CONTROL_COMMAND_CWARN; }
".databank"                           { return CONTROL_COMMAND_DATABANK; }
".default"                           { return CONTROL_COMMAND_DEFAULT; }
".dint"                           { return CONTROL_COMMAND_DINT; }
".dpage"                           { return CONTROL_COMMAND_DPAGE; }
".dsection"                           { return CONTROL_COMMAND_DSECTION; }
".dstruct"                           { return CONTROL_COMMAND_DSTRUCT; }
".dunion"                           { return CONTROL_COMMAND_DUNION; }
".dword"                           { return CONTROL_COMMAND_DWORD; }
".edef"                           { return CONTROL_COMMAND_EDEF; }
".else"                           { return CONTROL_COMMAND_ELSE; }
".elsif"                           { return CONTROL_COMMAND_ELSIF; }
".enc"                           { return CONTROL_COMMAND_ENC; }
".end"                           { return CONTROL_COMMAND_END; }
".endf"                           { return CONTROL_COMMAND_ENDF; }
".endif"                           { return CONTROL_COMMAND_ENDIF; }
".endm"                           { return CONTROL_COMMAND_ENDM; }
".endn"                           { return CONTROL_COMMAND_ENDN; }
".endp"                           { return CONTROL_COMMAND_ENDP; }
".ends"                           { return CONTROL_COMMAND_ENDS; }
".endswitch"                           { return CONTROL_COMMAND_ENDSWITCH; }
".endu"                           { return CONTROL_COMMAND_ENDU; }
".endweak"                           { return CONTROL_COMMAND_ENDWEAK; }
".eor"                           { return CONTROL_COMMAND_EOR; }
".error"                           { return CONTROL_COMMAND_ERROR; }
".fi"                           { return CONTROL_COMMAND_FI; }
".fill"                           { return CONTROL_COMMAND_FILL; }
".for"                           { return CONTROL_COMMAND_FOR; }
".function"                           { return CONTROL_COMMAND_FUNCTION; }
".goto"                           { return CONTROL_COMMAND_GOTO; }
".here"                           { return CONTROL_COMMAND_HERE; }
".hidemac"                           { return CONTROL_COMMAND_HIDEMAC; }
".if"                           { return CONTROL_COMMAND_IF; }
".ifeq"                           { return CONTROL_COMMAND_IFEQ; }
".ifmi"                           { return CONTROL_COMMAND_IFMI; }
".ifne"                           { return CONTROL_COMMAND_IFNE; }
".ifpl"                           { return CONTROL_COMMAND_IFPL; }
".include"                           { return CONTROL_COMMAND_INCLUDE; }
".lbl"                           { return CONTROL_COMMAND_LBL; }
".lint"                           { return CONTROL_COMMAND_LINT; }
".logical"                           { return CONTROL_COMMAND_LOGICAL; }
".long"                           { return CONTROL_COMMAND_LONG; }
".macro"                           { return CONTROL_COMMAND_MACRO; }
".mansiz"                           { return CONTROL_COMMAND_MANSIZ; }
".namespace"                           { return CONTROL_COMMAND_NAMESPACE; }
".next"                           { return CONTROL_COMMAND_NEXT; }
".null"                           { return CONTROL_COMMAND_NULL; }
".offs"                           { return CONTROL_COMMAND_OFFS; }
".option"                           { return CONTROL_COMMAND_OPTION; }
".page"                           { return CONTROL_COMMAND_PAGE; }
".pend"                           { return CONTROL_COMMAND_PEND; }
".proc"                           { return CONTROL_COMMAND_PROC; }
".proff"                           { return CONTROL_COMMAND_PROFF; }
".pron"                           { return CONTROL_COMMAND_PRON; }
".ptext"                           { return CONTROL_COMMAND_PTEXT; }
".rept"                           { return CONTROL_COMMAND_REPT; }
".rta"                           { return CONTROL_COMMAND_RTA; }
".section"                           { return CONTROL_COMMAND_SECTION; }
".seed"                           { return CONTROL_COMMAND_SEED; }
".segment"                           { return CONTROL_COMMAND_SEGMENT; }
".send"                           { return CONTROL_COMMAND_SEND; }
".shift"                           { return CONTROL_COMMAND_SHIFT; }
".shiftl"                           { return CONTROL_COMMAND_SHIFTL; }
".showmac"                           { return CONTROL_COMMAND_SHOWMAC; }
".sint"                           { return CONTROL_COMMAND_SINT; }
".struct"                           { return CONTROL_COMMAND_STRUCT; }
".switch"                           { return CONTROL_COMMAND_SWITCH; }
".text"                           { return CONTROL_COMMAND_TEXT; }
".union"                           { return CONTROL_COMMAND_UNION; }
".var"                           { return CONTROL_COMMAND_VAR; }
".warn"                           { return CONTROL_COMMAND_WARN; }
".weak"                           { return CONTROL_COMMAND_WEAK; }
".word"                           { return CONTROL_COMMAND_WORD; }
".xl"                           { return CONTROL_COMMAND_XL; }
".xs"                           { return CONTROL_COMMAND_XS; }
"abs("                          { return FUNCTION_ABS; }
"acos("                          { return FUNCTION_ACOS; }
"all("                          { return FUNCTION_ALL; }
"any("                          { return FUNCTION_ANY; }
"asin("                          { return FUNCTION_ASIN; }
"atan("                          { return FUNCTION_ATAN; }
"atan2("                          { return FUNCTION_ATAN2; }
"cbrt("                          { return FUNCTION_CBRT; }
"ceil("                          { return FUNCTION_CEIL; }
"cos("                          { return FUNCTION_COS; }
"cosh("                          { return FUNCTION_COSH; }
"deg("                          { return FUNCTION_DEG; }
"exp("                          { return FUNCTION_EXP; }
"floor("                          { return FUNCTION_FLOOR; }
"format("                          { return FUNCTION_FORMAT; }
"frac("                          { return FUNCTION_FRAC; }
"hypot("                          { return FUNCTION_HYPOT; }
"len("                          { return FUNCTION_LEN; }
"log("                          { return FUNCTION_LOG; }
"log10("                          { return FUNCTION_LOG10; }
"pow("                          { return FUNCTION_POW; }
"rad("                          { return FUNCTION_RAD; }
"random("                          { return FUNCTION_RANDOM; }
"range("                          { return FUNCTION_RANGE; }
"repr("                          { return FUNCTION_REPR; }
"round("                          { return FUNCTION_ROUND; }
"sign("                          { return FUNCTION_SIGN; }
"sin("                          { return FUNCTION_SIN; }
"sinh("                          { return FUNCTION_SINH; }
"size("                          { return FUNCTION_SIZE; }
"sort("                          { return FUNCTION_SORT; }
"sqrt("                          { return FUNCTION_SQRT; }
"tan("                          { return FUNCTION_TAN; }
"tanh("                          { return FUNCTION_TANH; }
"trunc("                          { return FUNCTION_TRUNC; }
"in"                            { return IN; }
// Ugh
//"x"                          { return REPEAT; }
".comment"                      { yybegin(BLOCK_COMMENT); return COMMENT; }
"$"[0-9a-fA-F]+                 { return HEX_NUMBER; }
[0-9]+                          { return NUMBER; }
"\\"{IDENTIFIER}                { return PARAMETER_USAGE; }
{EOL}                         { return EOL; }
({WHITE_SPACE})+              { return TokenType.WHITE_SPACE; }
"+="	                      { return ADD_COMPOUND; }
"−="	                      { return SUBTRACT_COMPOUND; }
"∗="	                      { return MULTIPLY_COMPOUND; }
"/="	                      { return DIVIDE_COMPOUND; }
"%="	                      { return MODULO_COMPOUND; }
"∗∗="	                      { return RAISE_TO_POWER_COMPOUND; }
"|="	                      { return BINARY_OR_COMPOUND; }
"^="	                      { return BINARY_XOR_COMPOUND; }
"&="	                      { return BINARY_AND_COMPOUND; }
"||="	                      { return LOGICAL_OR_COMPOUND; }
"&&="	                      { return LOGICAL_AND_COMPOUND; }
"<<="	                      { return SHIFT_LEFT_COMPOUND; }
">>="	                      { return SHIFT_RIGHT_COMPOUND; }
"..="	                      { return CONCAT_COMPOUND; }
"<?="	                      { return SMALLER_COMPOUND; }
">?="	                      { return GREATER_COMPOUND; }
"x="	                      { return REPEAT_COMPOUND; }
".="	                      { return MEMBER_COMPOUND; }
"("                           { return OPEN_PAREN; }
")"                           { return CLOSE_PAREN; }
"{"                           { return OPEN_BRACE; }
"}"                           { return CLOSE_BRACE; }
","                           { return COMMA; }
".."                          { return CONCAT; }
"."                           { return DOT; }
":"                           { return COLON; }
"?"                           { return QUESTION; }
"-"                           { return MINUS; }
"+"                           { return PLUS; }
"!"                           { return EXCLAMATION; }
"**"                          { return POW; }
"*"                           { return TIMES; }
"/"                           { return DIV; }
"~"                           { return TILDE; }
"^"                           { return DAKJE; }
"|"                           { return PIPE; }
"<>"                          { return LOWER_WORD; }
">`"                          { return HIGHER_WORD; }
"><"                          { return LOWER_BYTE_SWAPPED_WORD; }
"`"                           { return BANK_BYTE; }
"<=>"                         { return COMPARE; }
"<="                          { return LESS_EQUAL; }
">="                          { return GREATER_EQUAL; }
"<<"                          { return SHIFT_LEFT; }
">>"                          { return SHIFT_RIGHT; }
"&"                           { return AND; }
"&&"                          { return BOOLEAN_AND; }
"||"                          { return BOOLEAN_OR; }
"^^"                          { return BOOLEAN_XOR; }
"<?"                          { return BOOLEAN_LESS_THAN; }
">?"                          { return BOOLEAN_GREATER_THAN; }
"%"[01]+                      { return BINARY_NUMBER; }
"%"                           { return MODULO; }
"=="                          { return EQUAL; }
"!="                          { return NOT_EQUAL; }
"<"                           { return LESS; }
">"                           { return GREATER; }
"="                           { return IS; }
"#"                           { return HEKJE; }
"@b"                          { return FORCE_8_BIT_ADDRESS; }
"@w"                          { return FORCE_16_BIT_ADDRESS; }
"@l"                          { return FORCE_24_BIT_ADDRESS; }
";"[^\r\n]*                   { return COMMENT; }
"\""[^\"]*"\""                { return STRING; }
{_6502_OPCODE}                { return OPCODE; }
{TYPE}                        { return TYPE; }
{IDENTIFIER}                  { return IDENTIFIER; }
.                             { return TokenType.BAD_CHARACTER; }

<BLOCK_COMMENT> {
".endc"          { yybegin(YYINITIAL); return COMMENT; }
\n               { return COMMENT; }
.                { return COMMENT; }
}
