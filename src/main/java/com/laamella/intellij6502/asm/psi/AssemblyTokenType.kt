package com.laamella.intellij6502.asm.psi

import com.intellij.psi.tree.IElementType
import com.laamella.intellij6502.asm.AssemblyLanguage
import org.jetbrains.annotations.*

class AssemblyTokenType(@NonNls debugName: String) : IElementType(debugName, AssemblyLanguage.INSTANCE) {

    override fun toString(): String {
        return "AssemblyTokenType." + super.toString()
    }
}