package com.laamella.intellij6502.asm;

import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.FileTypeIndentOptionsProvider;

public class AssemblyFileTypeIndentOptionsProvider implements FileTypeIndentOptionsProvider {
    @Override
    public CommonCodeStyleSettings.IndentOptions createIndentOptions() {
        return CommonCodeStyleSettings.IndentOptions.DEFAULT_INDENT_OPTIONS;
    }

    @Override
    public FileType getFileType() {
        return AssemblyFileType.Companion.getINSTANCE();
    }

    @Override
    public IndentOptionsEditor createOptionsEditor() {
        return new IndentOptionsEditor();
    }

    @Override
    public String getPreviewText() {
        return "blabla";
    }

    @Override
    public void prepareForReformat(PsiFile psiFile) {

    }
}
