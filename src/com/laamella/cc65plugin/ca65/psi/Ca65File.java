package com.laamella.cc65plugin.ca65.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.laamella.cc65plugin.ca65.Ca65FileType;
import com.laamella.cc65plugin.ca65.Ca65Language;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class Ca65File extends PsiFileBase {
    public Ca65File(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, Ca65Language.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return Ca65FileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "ca65 File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}