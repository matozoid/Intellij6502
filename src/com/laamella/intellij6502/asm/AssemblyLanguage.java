package com.laamella.intellij6502.asm;

import com.intellij.lang.Language;

public class AssemblyLanguage extends Language {
    public static final AssemblyLanguage INSTANCE = new AssemblyLanguage();

    private AssemblyLanguage() {
        super("asm");
    }
}