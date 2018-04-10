package com.laamella.intellij6502.asm.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.laamella.intellij6502.asm.AssemblyFileType
import com.laamella.intellij6502.asm.AssemblyLanguage

import javax.swing.*

class AssemblyFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, AssemblyLanguage.INSTANCE) {

    override fun getFileType(): FileType {
        return AssemblyFileType.INSTANCE
    }

    override fun toString(): String {
        return "Assembler File"
    }
}