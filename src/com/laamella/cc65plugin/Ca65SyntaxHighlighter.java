package com.laamella.cc65plugin;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.laamella.cc65plugin.psi.Ca65Types;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class Ca65SyntaxHighlighter extends SyntaxHighlighterBase {
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("Ca65_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("Ca65_KEY", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey CONTROL_COMMAND =
            createTextAttributesKey("Ca65_COMMAND", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey PARENS =
            createTextAttributesKey("Ca65_PARENS", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACES =
            createTextAttributesKey("Ca65_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("Ca65_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("Ca65_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("Ca65_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("Ca65_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey LABEL =
            createTextAttributesKey("Ca65_LABEL", DefaultLanguageHighlighterColors.LABEL);
    public static final TextAttributesKey MNEMONIC =
            createTextAttributesKey("Ca65_MNEMONIC", DefaultLanguageHighlighterColors.IDENTIFIER);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new Ca65LexerAdapter();
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

        highlights.put(Ca65Types.OPEN_PAREN, PARENS_KEYS);
        highlights.put(Ca65Types.CLOSE_PAREN, PARENS_KEYS);
        highlights.put(Ca65Types.OPEN_BRACE, BRACES_KEYS);
        highlights.put(Ca65Types.CLOSE_BRACE, BRACES_KEYS);
        highlights.put(Ca65Types.COMMENT, COMMENT_KEYS);
        highlights.put(Ca65Types.IDENTIFIER, IDENTIFIER_KEYS);
        highlights.put(Ca65Types.MNEMONIC, MNEMONIC_KEYS);
        highlights.put(Ca65Types.CONTROL_COMMAND, CONTROL_COMMAND_KEYS);
        highlights.put(Ca65Types.COMMA, SEPARATOR_KEYS);
        highlights.put(Ca65Types.EQUAL, SEPARATOR_KEYS);
        highlights.put(Ca65Types.STRING, STRING_KEYS);
        highlights.put(Ca65Types.LABEL, LABEL_KEYS);
        highlights.put(Ca65Types.HEX_NUMBER, NUMBER_KEYS);
        highlights.put(Ca65Types.NUMBER, NUMBER_KEYS);
        highlights.put(Ca65Types.BINARY_NUMBER, NUMBER_KEYS);
        highlights.put(TokenType.BAD_CHARACTER, BAD_CHAR_KEYS);
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return highlights.getOrDefault(tokenType, EMPTY_KEYS);
    }
}