package com.laamella.intellij6502.asm.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.laamella.intellij6502.asm.AssemblyFileType;
import com.laamella.intellij6502.asm.AssemblyLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AssemblyFile extends PsiFileBase {
    public AssemblyFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, AssemblyLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return AssemblyFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "asm File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}