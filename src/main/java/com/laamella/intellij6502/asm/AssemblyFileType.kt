package com.laamella.intellij6502.asm

import com.intellij.openapi.fileTypes.LanguageFileType
import com.laamella.intellij6502.Intellij6502Icons
import org.jetbrains.annotations.*

import javax.swing.*

class AssemblyFileType private constructor() : LanguageFileType(AssemblyLanguage.INSTANCE) {

    override fun getName(): String {
        return "assembly file"
    }

    override fun getDescription(): String {
        return name
    }

    override fun getDefaultExtension(): String {
        return "asm"
    }

    override fun getIcon(): Icon? {
        return Intellij6502Icons.FILE
    }

    companion object {
        val INSTANCE = AssemblyFileType()
    }
}