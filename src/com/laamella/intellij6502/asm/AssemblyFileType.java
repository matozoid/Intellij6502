package com.laamella.intellij6502.asm;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.laamella.intellij6502.Intellij6502Icons;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class AssemblyFileType extends LanguageFileType {
    public static final AssemblyFileType INSTANCE = new AssemblyFileType();

    private AssemblyFileType() {
        super(AssemblyLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "assembly file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return getName();
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "asm";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Intellij6502Icons.FILE;
    }
}