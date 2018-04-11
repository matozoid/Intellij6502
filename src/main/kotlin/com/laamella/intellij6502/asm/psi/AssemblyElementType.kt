package com.laamella.intellij6502.asm.psi

import com.intellij.psi.tree.IElementType
import com.laamella.intellij6502.asm.AssemblyLanguage
import org.jetbrains.annotations.*

class AssemblyElementType(@NonNls debugName: String) : IElementType(debugName, AssemblyLanguage.INSTANCE)