package com.laamella.intellij6502.asm

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR
import com.intellij.openapi.actionSystem.CommonDataKeys.PSI_FILE
import com.intellij.openapi.command.WriteCommandAction.writeCommandAction
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.SyntaxTraverser.psiTraverser
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.laamella.intellij6502.asm.psi.AssemblyAnyNumber
import com.laamella.intellij6502.asm.psi.AssemblyTypes.*
import java.lang.Integer.*

/**
 * Converts the number under the cursor from hex to binary to decimal and hex again.
 */
class ConvertNumericalBase : AnAction() {
    override fun update(e: AnActionEvent) {
        //Get required data keys
        val project = e.project
        val editor = e.getData(EDITOR)
        //Set visibility only in case of existing project and editor
        e.presentation.isVisible = project != null && editor != null
    }

    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getRequiredData(EDITOR)
        val project = e.project ?: return

        val psiFile = e.getData(PSI_FILE) ?: return
        val offset = editor.caretModel.currentCaret.offset
        // Take the node under the cursor:
        var element: LeafPsiElement = (psiFile.findElementAt(offset) ?: return) as? LeafPsiElement ?: return

        // If we're on EOL, try looking one character to the left:
        if (element.elementType == EOL) {
            element = (psiFile.findElementAt(offset - 1) ?: return) as? LeafPsiElement ?: return
        }

        val replacement: PsiElement? = when (element.elementType) {
            BINARY_NUMBER -> {
                // Convert binary to decimal
                val binary = element.text.substring(1)
                val number = parseInt(binary, 2)
                createNumberLeaf(project, "" + number)
            }
            NUMBER -> {
                // Convert decimal to hexadecimal
                val decimal = element.text
                val number = parseInt(decimal)
                createNumberLeaf(project, "$" + prepad(toHexString(number), 2))
            }
            HEX_NUMBER -> {
                // Convert hexadecimal to binary
                val hex = element.text.substring(1)
                val number = parseInt(hex, 16)
                createNumberLeaf(project, "%" + prepad(toBinaryString(number), 8))
            }
            else -> null

        }
        replacement?.let { writeCommandAction(project).run<RuntimeException> { element.replace(it) } }
    }

    fun prepad(s: String, i: Int): String {
        val misaligned = s.length % i
        if (misaligned == 0) {
            return s
        }
        val zeroesToAdd = i - misaligned
        return "00000000".substring(0, zeroesToAdd) + s
    }

    private fun createNumberLeaf(project: Project, number: String): PsiElement? {
        val fileFromText = PsiFileFactory.getInstance(project).createFileFromText(AssemblyLanguage.INSTANCE, "lda $number")
        return psiTraverser().withRoot(fileFromText).traverse()
                .filter(AssemblyAnyNumber::class.java)
                .map(PsiElement::getFirstChild)
                .first()
    }
}
