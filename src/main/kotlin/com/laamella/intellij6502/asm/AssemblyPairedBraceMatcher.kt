package com.laamella.intellij6502.asm

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.laamella.intellij6502.asm.psi.AssemblyTypes

class AssemblyPairedBraceMatcher : PairedBraceMatcher {
    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }

    override fun getPairs(): Array<BracePair> {
        return arrayOf(
                BracePair(AssemblyTypes.OPEN_BRACE, AssemblyTypes.CLOSE_BRACE, false),
                BracePair(AssemblyTypes.OPEN_BRACKET, AssemblyTypes.CLOSE_BRACKET, false),
                BracePair(AssemblyTypes.OPEN_PAREN, AssemblyTypes.CLOSE_PAREN, false))
    }

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
        return true
    }
}