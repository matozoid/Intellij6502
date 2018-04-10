package com.laamella.intellij6502.asm

import com.intellij.lang.Language

class AssemblyLanguage private constructor() : Language("asm") {
    companion object {
        val INSTANCE = AssemblyLanguage()
    }
}