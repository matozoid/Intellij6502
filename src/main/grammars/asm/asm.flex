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

EOL=(\r|\n|\r\n)
WHITE_SPACE=[\ \t\f]
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
MANTISSA=[ep][0-9]+

%x BLOCK_COMMENT
%%

"in"                            { return IN; }
// Ugh
//"x"                          { return REPEAT; }
".comment"                      { yybegin(BLOCK_COMMENT); return COMMENT; }
"$"[0-9a-fA-F][0-9a-fA-F_\.]*{MANTISSA}?     { return HEX_NUMBER; }
[0-9][0-9_\.]*{MANTISSA}?                    { return NUMBER; }
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
":="                          { return COLON_IS; }
"("                           { return OPEN_PAREN; }
")"                           { return CLOSE_PAREN; }
"{"                           { return OPEN_BRACE; }
"}"                           { return CLOSE_BRACE; }
"["                           { return OPEN_BRACKET; }
"]"                           { return CLOSE_BRACKET; }
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
"%"[01][01_\.]*{MANTISSA}?      { return BINARY_NUMBER; }
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
[bslnp]?("\""[^\"]*"\"")+             { return STRING_DOUBLE_QUOTED; }
[bslnp]?("'"[^']*"'")+                { return STRING_SINGLE_QUOTED; }
{_6502_OPCODE}                { return OPCODE; }
{IDENTIFIER}                  { return IDENTIFIER; }
.                             { return TokenType.BAD_CHARACTER; }

<BLOCK_COMMENT> {
".endc"          { yybegin(YYINITIAL); return COMMENT; }
\n               { return COMMENT; }
.                { return COMMENT; }
}
