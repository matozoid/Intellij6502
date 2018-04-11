package com.laamella.intellij6502.prg

import com.intellij.lang.Language

class PrgLanguage private constructor() : Language("prg") {
    companion object {
        val INSTANCE = PrgLanguage()
    }
}