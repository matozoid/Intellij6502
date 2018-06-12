package com.laamella.intellij6502.asm

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.laamella.intellij6502.asm.psi.AssemblyTypes

import java.util.HashMap

import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

class AssemblySyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        return AssemblyLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return highlights.getOrDefault(tokenType, EMPTY_KEYS)
    }

    companion object {
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()

        val SEPARATOR = createTextAttributesKey("Assembly_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val IDENTIFIER = createTextAttributesKey("Assembly_KEY", DefaultLanguageHighlighterColors.IDENTIFIER)
        val CONTROL_COMMAND = createTextAttributesKey("Assembly_COMMAND", DefaultLanguageHighlighterColors.KEYWORD)
        val PARENS = createTextAttributesKey("Assembly_PARENS", DefaultLanguageHighlighterColors.PARENTHESES)
        val BRACES = createTextAttributesKey("Assembly_BRACES", DefaultLanguageHighlighterColors.BRACES)
        val BRACKETS = createTextAttributesKey("Assembly_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
        val STRING = createTextAttributesKey("Assembly_STRING", DefaultLanguageHighlighterColors.STRING)
        val NUMBER = createTextAttributesKey("Assembly_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val COMMENT = createTextAttributesKey("Assembly_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER = createTextAttributesKey("Assembly_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        val OPCODE = createTextAttributesKey("Assembly_OPCODE", DefaultLanguageHighlighterColors.IDENTIFIER)

        private val highlights = HashMap<IElementType, Array<TextAttributesKey>>()

        init {
            val badCharKeys = arrayOf(BAD_CHARACTER)
            val separatorKeys = arrayOf(SEPARATOR)
            val commentKeys = arrayOf(COMMENT)
            val bracesKeys = arrayOf(BRACES)
            val bracketsKeys = arrayOf(BRACKETS)
            val identifierKeys = arrayOf(IDENTIFIER)
//            val controlCommandKeys = arrayOf(CONTROL_COMMAND)
            val numberKeys = arrayOf(NUMBER)
            val stringKeys = arrayOf(STRING)
            val parensKeys = arrayOf(PARENS)
            val mnemonicKeys = arrayOf(OPCODE)

            highlights[AssemblyTypes.OPEN_PAREN] = parensKeys
            highlights[AssemblyTypes.CLOSE_PAREN] = parensKeys
            highlights[AssemblyTypes.OPEN_BRACE] = bracesKeys
            highlights[AssemblyTypes.CLOSE_BRACE] = bracesKeys
            highlights[AssemblyTypes.OPEN_BRACKET] = bracketsKeys
            highlights[AssemblyTypes.CLOSE_BRACKET] = bracketsKeys
            highlights[AssemblyTypes.COMMENT] = commentKeys
            highlights[AssemblyTypes.IDENTIFIER] = identifierKeys
            highlights[AssemblyTypes.OPCODE] = mnemonicKeys
            highlights[AssemblyTypes.COMMA] = separatorKeys
            highlights[AssemblyTypes.EQUAL] = separatorKeys
            highlights[AssemblyTypes.STRING_DOUBLE_QUOTED] = stringKeys
            highlights[AssemblyTypes.STRING_SINGLE_QUOTED] = stringKeys
            highlights[AssemblyTypes.HEX_NUMBER] = numberKeys
            highlights[AssemblyTypes.NUMBER] = numberKeys
            highlights[AssemblyTypes.BINARY_NUMBER] = numberKeys
            highlights[TokenType.BAD_CHARACTER] = badCharKeys
        }
    }
}