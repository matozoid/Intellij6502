package com.laamella.cc65plugin.ca65;

import com.intellij.lang.Language;

public class Ca65Language extends Language {
    public static final Ca65Language INSTANCE = new Ca65Language();

    private Ca65Language() {
        super("ca65");
    }
}