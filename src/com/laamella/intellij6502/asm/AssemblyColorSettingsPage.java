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
                "        lda nn,y        ;and use it indirectly";
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
        return "Assembly";
    }
}