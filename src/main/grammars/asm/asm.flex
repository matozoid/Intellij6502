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
"in"                          { return AssemblyTypes.IN; }
// Ugh
//"x"                          { return AssemblyTypes.REPEAT; }
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
"+="	                      { return AssemblyTypes.ADD_COMPOUND; }
"−="	                      { return AssemblyTypes.SUBTRACT_COMPOUND; }
"∗="	                      { return AssemblyTypes.MULTIPLY_COMPOUND; }
"/="	                      { return AssemblyTypes.DIVIDE_COMPOUND; }
"%="	                      { return AssemblyTypes.MODULO_COMPOUND; }
"∗∗="	                      { return AssemblyTypes.RAISE_TO_POWER_COMPOUND; }
"|="	                      { return AssemblyTypes.BINARY_OR_COMPOUND; }
"^="	                      { return AssemblyTypes.BINARY_XOR_COMPOUND; }
"&="	                      { return AssemblyTypes.BINARY_AND_COMPOUND; }
"||="	                      { return AssemblyTypes.LOGICAL_OR_COMPOUND; }
"&&="	                      { return AssemblyTypes.LOGICAL_AND_COMPOUND; }
"<<="	                      { return AssemblyTypes.SHIFT_LEFT_COMPOUND; }
">>="	                      { return AssemblyTypes.SHIFT_RIGHT_COMPOUND; }
"..="	                      { return AssemblyTypes.CONCAT_COMPOUND; }
"<?="	                      { return AssemblyTypes.SMALLER_COMPOUND; }
">?="	                      { return AssemblyTypes.GREATER_COMPOUND; }
"x="	                      { return AssemblyTypes.REPEAT_COMPOUND; }
".="	                      { return AssemblyTypes.MEMBER_COMPOUND; }
"("                           { return AssemblyTypes.OPEN_PAREN; }
")"                           { return AssemblyTypes.CLOSE_PAREN; }
"{"                           { return AssemblyTypes.OPEN_BRACE; }
"}"                           { return AssemblyTypes.CLOSE_BRACE; }
","                           { return AssemblyTypes.COMMA; }
".."                          { return AssemblyTypes.CONCAT; }
"."                           { return AssemblyTypes.DOT; }
":"                           { return AssemblyTypes.COLON; }
"?"                           { return AssemblyTypes.QUESTION; }
"-"                           { return AssemblyTypes.MINUS; }
"+"                           { return AssemblyTypes.PLUS; }
"!"                           { return AssemblyTypes.EXCLAMATION; }
"**"                          { return AssemblyTypes.POW; }
"*"                           { return AssemblyTypes.TIMES; }
"/"                           { return AssemblyTypes.DIV; }
"~"                           { return AssemblyTypes.TILDE; }
"^"                           { return AssemblyTypes.DAKJE; }
"|"                           { return AssemblyTypes.PIPE; }
"<>"                          { return AssemblyTypes.LOWER_WORD; }
">`"                          { return AssemblyTypes.HIGHER_WORD; }
"><"                          { return AssemblyTypes.LOWER_BYTE_SWAPPED_WORD; }
"`"                           { return AssemblyTypes.BANK_BYTE; }
"<=>"                         { return AssemblyTypes.COMPARE; }
"<="                          { return AssemblyTypes.LESS_EQUAL; }
">="                          { return AssemblyTypes.GREATER_EQUAL; }
"<<"                          { return AssemblyTypes.SHIFT_LEFT; }
">>"                          { return AssemblyTypes.SHIFT_RIGHT; }
"&"                           { return AssemblyTypes.AND; }
"&&"                          { return AssemblyTypes.BOOLEAN_AND; }
"||"                          { return AssemblyTypes.BOOLEAN_OR; }
"^^"                          { return AssemblyTypes.BOOLEAN_XOR; }
"<?"                          { return AssemblyTypes.BOOLEAN_LESS_THAN; }
">?"                          { return AssemblyTypes.BOOLEAN_GREATER_THAN; }
"%"[01]+                      { return AssemblyTypes.BINARY_NUMBER; }
"%"                           { return AssemblyTypes.MODULO; }
"=="                          { return AssemblyTypes.EQUAL; }
"!="                          { return AssemblyTypes.NOT_EQUAL; }
"<"                           { return AssemblyTypes.LESS; }
">"                           { return AssemblyTypes.GREATER; }
"="                           { return AssemblyTypes.IS; }
"#"                           { return AssemblyTypes.HEKJE; }
"@b"                          { return AssemblyTypes.FORCE_8_BIT_ADDRESS; }
"@w"                          { return AssemblyTypes.FORCE_16_BIT_ADDRESS; }
"@l"                          { return AssemblyTypes.FORCE_24_BIT_ADDRESS; }
{COMMENT}                     { return AssemblyTypes.COMMENT; }
{STRING}                      { return AssemblyTypes.STRING; }
{_6502_OPCODE}                { return AssemblyTypes.OPCODE; }
{TYPE}                        { return AssemblyTypes.TYPE; }
{IDENTIFIER}                  { return AssemblyTypes.IDENTIFIER; }
.                             { return TokenType.BAD_CHARACTER; }
