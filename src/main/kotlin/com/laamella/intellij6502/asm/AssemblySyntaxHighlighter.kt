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
        val STRING = createTextAttributesKey("Assembly_STRING", DefaultLanguageHighlighterColors.STRING)
        val NUMBER = createTextAttributesKey("Assembly_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val COMMENT = createTextAttributesKey("Assembly_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER = createTextAttributesKey("Assembly_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        val LABEL = createTextAttributesKey("Assembly_LABEL", DefaultLanguageHighlighterColors.LABEL)
        val OPCODE = createTextAttributesKey("Assembly_OPCODE", DefaultLanguageHighlighterColors.IDENTIFIER)

        private val highlights = HashMap<IElementType, Array<TextAttributesKey>>()

        init {
            val badCharKeys = arrayOf(BAD_CHARACTER)
            val separatorKeys = arrayOf(SEPARATOR)
            val commentKeys = arrayOf(COMMENT)
            val bracesKeys = arrayOf(BRACES)
            val identifierKeys = arrayOf(IDENTIFIER)
            val controlCommandKeys = arrayOf(CONTROL_COMMAND)
            val labelKeys = arrayOf(LABEL)
            val numberKeys = arrayOf(NUMBER)
            val stringKeys = arrayOf(STRING)
            val parensKeys = arrayOf(PARENS)
            val mnemonicKeys = arrayOf(OPCODE)

            highlights[AssemblyTypes.CONTROL_COMMAND_ADDR] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_AL] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ALIGN] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_AS] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ASSERT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_AUTSIZ] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_BEND] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_BINARY] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_BINCLUDE] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_BLOCK] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_BREAK] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_BYTE] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_CASE] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_CDEF] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_CERROR] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_CHAR] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_CHECK] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_CONTINUE] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_CPU] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_CWARN] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_DATABANK] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_DEFAULT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_DINT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_DPAGE] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_DSECTION] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_DSTRUCT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_DUNION] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_DWORD] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_EDEF] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ELSE] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ELSIF] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ENC] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_END] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ENDF] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ENDIF] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ENDM] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ENDP] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ENDS] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ENDSWITCH] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ENDU] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ENDWEAK] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_EOR] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_ERROR] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_FI] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_FILL] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_FOR] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_FUNCTION] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_GOTO] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_HERE] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_HIDEMAC] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_IF] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_IFEQ] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_IFMI] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_IFNE] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_IFPL] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_INCLUDE] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_LBL] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_LINT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_LOGICAL] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_LONG] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_MACRO] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_MANSIZ] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_NEXT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_NULL] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_OFFS] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_OPTION] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_PAGE] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_PEND] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_PROC] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_PROFF] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_PRON] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_PTEXT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_REPT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_RTA] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_SECTION] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_SEED] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_SEGMENT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_SEND] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_SHIFT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_SHIFTL] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_SHOWMAC] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_SINT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_STRUCT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_SWITCH] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_TEXT] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_UNION] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_VAR] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_WARN] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_WEAK] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_WORD] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_XL] = controlCommandKeys
            highlights[AssemblyTypes.CONTROL_COMMAND_XS] = controlCommandKeys

            highlights[AssemblyTypes.OPEN_PAREN] = parensKeys
            highlights[AssemblyTypes.CLOSE_PAREN] = parensKeys
            highlights[AssemblyTypes.OPEN_BRACE] = bracesKeys
            highlights[AssemblyTypes.CLOSE_BRACE] = bracesKeys
            highlights[AssemblyTypes.COMMENT] = commentKeys
            highlights[AssemblyTypes.IDENTIFIER] = identifierKeys
            highlights[AssemblyTypes.OPCODE] = mnemonicKeys
            highlights[AssemblyTypes.COMMA] = separatorKeys
            highlights[AssemblyTypes.EQUAL] = separatorKeys
            highlights[AssemblyTypes.STRING] = stringKeys
            highlights[AssemblyTypes.LABEL] = labelKeys
            highlights[AssemblyTypes.HEX_NUMBER] = numberKeys
            highlights[AssemblyTypes.NUMBER] = numberKeys
            highlights[AssemblyTypes.BINARY_NUMBER] = numberKeys
            highlights[TokenType.BAD_CHARACTER] = badCharKeys
        }
    }
}