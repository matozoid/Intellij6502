package com.laamella.intellij6502.asm;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.laamella.intellij6502.asm.psi.AssemblyTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class AssemblySyntaxHighlighter extends SyntaxHighlighterBase {
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("Assembly_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("Assembly_KEY", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey CONTROL_COMMAND =
            createTextAttributesKey("Assembly_COMMAND", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey PARENS =
            createTextAttributesKey("Assembly_PARENS", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACES =
            createTextAttributesKey("Assembly_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("Assembly_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("Assembly_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("Assembly_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("Assembly_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey LABEL =
            createTextAttributesKey("Assembly_LABEL", DefaultLanguageHighlighterColors.LABEL);
    public static final TextAttributesKey MNEMONIC =
            createTextAttributesKey("Assembly_MNEMONIC", DefaultLanguageHighlighterColors.IDENTIFIER);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new AssemblyLexerAdapter();
    }

    private static final Map<IElementType, TextAttributesKey[]> highlights = new HashMap<>();

    static {
        final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
        final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
        final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
        final TextAttributesKey[] BRACES_KEYS = new TextAttributesKey[]{BRACES};
        final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
        final TextAttributesKey[] CONTROL_COMMAND_KEYS = new TextAttributesKey[]{CONTROL_COMMAND};
        final TextAttributesKey[] LABEL_KEYS = new TextAttributesKey[]{LABEL};
        final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
        final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
        final TextAttributesKey[] PARENS_KEYS = new TextAttributesKey[]{PARENS};
        final TextAttributesKey[] MNEMONIC_KEYS = new TextAttributesKey[]{MNEMONIC};

        highlights.put(AssemblyTypes.CONTROL_COMMAND_ADDR, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_AL, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ALIGN, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_AS, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ASSERT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_AUTSIZ, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_BEND, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_BINARY, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_BINCLUDE, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_BLOCK, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_BREAK, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_BYTE, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_CASE, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_CDEF, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_CERROR, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_CHAR, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_CHECK, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_CONTINUE, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_CPU, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_CWARN, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_DATABANK, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_DEFAULT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_DINT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_DPAGE, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_DSECTION, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_DSTRUCT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_DUNION, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_DWORD, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_EDEF, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ELSE, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ELSIF, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ENC, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_END, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ENDF, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ENDIF, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ENDM, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ENDP, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ENDS, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ENDSWITCH, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ENDU, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ENDWEAK, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_EOR, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_ERROR, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_FI, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_FILL, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_FOR, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_FUNCTION, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_GOTO, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_HERE, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_HIDEMAC, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_IF, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_IFEQ, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_IFMI, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_IFNE, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_IFPL, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_INCLUDE, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_LBL, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_LINT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_LOGICAL, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_LONG, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_MACRO, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_MANSIZ, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_NEXT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_NULL, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_OFFS, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_OPTION, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_PAGE, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_PEND, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_PROC, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_PROFF, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_PRON, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_PTEXT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_REPT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_RTA, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_SECTION, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_SEED, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_SEGMENT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_SEND, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_SHIFT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_SHIFTL, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_SHOWMAC, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_SINT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_STRUCT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_SWITCH, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_TEXT, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_UNION, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_VAR, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_WARN, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_WEAK, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_WORD, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_XL, CONTROL_COMMAND_KEYS);
        highlights.put(AssemblyTypes.CONTROL_COMMAND_XS, CONTROL_COMMAND_KEYS);

        highlights.put(AssemblyTypes.OPEN_PAREN, PARENS_KEYS);
        highlights.put(AssemblyTypes.CLOSE_PAREN, PARENS_KEYS);
        highlights.put(AssemblyTypes.OPEN_BRACE, BRACES_KEYS);
        highlights.put(AssemblyTypes.CLOSE_BRACE, BRACES_KEYS);
        highlights.put(AssemblyTypes.COMMENT, COMMENT_KEYS);
        highlights.put(AssemblyTypes.IDENTIFIER, IDENTIFIER_KEYS);
        highlights.put(AssemblyTypes.MNEMONIC, MNEMONIC_KEYS);
        highlights.put(AssemblyTypes.COMMA, SEPARATOR_KEYS);
        highlights.put(AssemblyTypes.EQUAL, SEPARATOR_KEYS);
        highlights.put(AssemblyTypes.STRING, STRING_KEYS);
        highlights.put(AssemblyTypes.LABEL, LABEL_KEYS);
        highlights.put(AssemblyTypes.HEX_NUMBER, NUMBER_KEYS);
        highlights.put(AssemblyTypes.NUMBER, NUMBER_KEYS);
        highlights.put(AssemblyTypes.BINARY_NUMBER, NUMBER_KEYS);
        highlights.put(TokenType.BAD_CHARACTER, BAD_CHAR_KEYS);
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return highlights.getOrDefault(tokenType, EMPTY_KEYS);
    }
}