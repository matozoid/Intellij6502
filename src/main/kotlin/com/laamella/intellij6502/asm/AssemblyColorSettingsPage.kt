package com.laamella.intellij6502.asm

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.laamella.intellij6502.Intellij6502Icons

import javax.swing.*

class AssemblyColorSettingsPage : ColorSettingsPage {

    override fun getIcon(): Icon? {
        return Intellij6502Icons.ASM_FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return AssemblySyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return "        .struct         ;anonymous structure\n" +
                "x       .byte 0         ;labels are visible\n" +
                "y       .byte 0         ;content compiled here\n" +
                "        .ends           ;useful inside unions\n" +
                "\n" +
                "nn_s    .struct col, row;named structure\n" +
                "x       .byte \\col      ;labels are not visible\n" +
                "y       .byte \\row      ;no content is compiled here\n" +
                "        .ends           ;it's just a definition\n" +
                "\n" +
                "nn      .dstruct nn_s, 1, 2;structure instance, content here\n" +
                "\n" +
                "        lda nn.x        ;direct field access\n" +
                "        ldy #nn_s.x     ;get offset of field\n" +
                "        lda nn,y        ;and use it indirectly"
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Assembly"
    }

    companion object {
        private val DESCRIPTORS = arrayOf(AttributesDescriptor("Separator", AssemblySyntaxHighlighter.SEPARATOR), AttributesDescriptor("String", AssemblySyntaxHighlighter.STRING), AttributesDescriptor("Identifier", AssemblySyntaxHighlighter.IDENTIFIER), AttributesDescriptor("Parentheses", AssemblySyntaxHighlighter.PARENS), AttributesDescriptor("Braces", AssemblySyntaxHighlighter.BRACES), AttributesDescriptor("Number", AssemblySyntaxHighlighter.NUMBER), AttributesDescriptor("Comment", AssemblySyntaxHighlighter.COMMENT), AttributesDescriptor("Label", AssemblySyntaxHighlighter.LABEL), AttributesDescriptor("Command", AssemblySyntaxHighlighter.CONTROL_COMMAND), AttributesDescriptor("Mnemonic", AssemblySyntaxHighlighter.MNEMONIC), AttributesDescriptor("Bad character", AssemblySyntaxHighlighter.BAD_CHARACTER))
    }
}