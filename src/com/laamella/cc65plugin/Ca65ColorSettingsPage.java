package com.laamella.cc65plugin;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class Ca65ColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Separator", Ca65SyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("String", Ca65SyntaxHighlighter.STRING),
            new AttributesDescriptor("Identifier", Ca65SyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("Parentheses", Ca65SyntaxHighlighter.PARENS),
            new AttributesDescriptor("Braces", Ca65SyntaxHighlighter.BRACES),
            new AttributesDescriptor("Number", Ca65SyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Comment", Ca65SyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Label", Ca65SyntaxHighlighter.LABEL),
            new AttributesDescriptor("Command", Ca65SyntaxHighlighter.CONTROL_COMMAND),
            new AttributesDescriptor("Mnemonic", Ca65SyntaxHighlighter.MNEMONIC),
            new AttributesDescriptor("Bad character", Ca65SyntaxHighlighter.BAD_CHARACTER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return Ca65Icons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new Ca65SyntaxHighlighter();
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
                "            __MAIN = $1000       ; Apple DOS 3.3 binary file 4 byte prefix header \n" +
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