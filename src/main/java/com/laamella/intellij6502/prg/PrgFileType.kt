package com.laamella.intellij6502.prg

import com.intellij.openapi.fileTypes.LanguageFileType
import com.laamella.intellij6502.Intellij6502Icons

import javax.swing.*

class PrgFileType private constructor() : LanguageFileType(PrgLanguage.INSTANCE) {

    override fun getName(): String {
        return "prg file"
    }

    override fun getDescription(): String {
        return name
    }

    override fun getDefaultExtension(): String {
        return "prg"
    }

    override fun getIcon(): Icon? {
        return Intellij6502Icons.ASM_FILE
    }

    companion object {
        val INSTANCE = PrgFileType()
    }
}