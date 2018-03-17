package com.laamella.cc65plugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class Ca65LexerAdapter extends FlexAdapter {
    public Ca65LexerAdapter() {
        super(new Ca65Lexer((Reader) null));
    }
}