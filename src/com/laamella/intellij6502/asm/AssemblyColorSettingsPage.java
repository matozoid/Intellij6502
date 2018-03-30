package com.laamella.intellij6502.asm;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.laamella.intellij6502.Intellij6502Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class AssemblyColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Separator", AssemblySyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("String", AssemblySyntaxHighlighter.STRING),
            new AttributesDescriptor("Identifier", AssemblySyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("Parentheses", AssemblySyntaxHighlighter.PARENS),
            new AttributesDescriptor("Braces", AssemblySyntaxHighlighter.BRACES),
            new AttributesDescriptor("Number", AssemblySyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Comment", AssemblySyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Label", AssemblySyntaxHighlighter.LABEL),
            new AttributesDescriptor("Command", AssemblySyntaxHighlighter.CONTROL_COMMAND),
            new AttributesDescriptor("Mnemonic", AssemblySyntaxHighlighter.MNEMONIC),
            new AttributesDescriptor("Bad character", AssemblySyntaxHighlighter.BAD_CHARACTER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return Intellij6502Icons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new AssemblySyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "           COUT = $FDED \n" +
                "\n" +
                ".macro ASC text \n" +
                "    .repeat .strlen(text), I \n" +
                "    .byte   .strat(text, I) | $80 \n" +
                "    .endrep \n" +
                ".endmacro \n" +
                "            __MAIN = $1000       ; Apple DOS 3.3 sprites file 4 byte prefix header \n" +
                "            .word __MAIN         ; 2 byte BLAOD address \n" +
                "            .word __END - __MAIN ; 2 byte BLOAD size \n" +
                "            .org  __MAIN         ; .org must come after header else offsets are wrong \n" +
                "            LDX    #0 \n" +
                "            LDA    MSG,X    ; load initial char \n" +
                "PRINTCHAR:  JSR    COUT \n" +
                "            INX \n" +
                "            LDA    MSG,X \n" +
                "            BNE    PRINTCHAR \n" +
                "            RTS \n" +
                "MSG: \n" +
                "            ASC \"Hello world, Apple!\" \n" +
                "            .byte $00 \n" +
                "__END: ";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Ca65";
    }
}