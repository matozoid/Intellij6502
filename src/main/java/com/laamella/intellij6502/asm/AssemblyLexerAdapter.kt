package com.laamella.intellij6502.asm

import com.intellij.lexer.FlexAdapter

import java.io.Reader

class AssemblyLexerAdapter : FlexAdapter(AssemblyLexer(null as Reader?))