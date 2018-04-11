package com.laamella.intellij6502.asm

import com.intellij.lexer.FlexAdapter
import com.laamella.intellij6502.asm.AssemblyLexer

import java.io.Reader

class AssemblyLexerAdapter : FlexAdapter(AssemblyLexer(null as Reader?))