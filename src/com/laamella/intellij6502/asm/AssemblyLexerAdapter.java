package com.laamella.intellij6502.asm;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class AssemblyLexerAdapter extends FlexAdapter {
    public AssemblyLexerAdapter() {
        super(new AssemblyLexer((Reader) null));
    }
}