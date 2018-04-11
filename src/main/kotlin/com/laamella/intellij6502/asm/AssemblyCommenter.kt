package com.laamella.intellij6502.asm

import com.intellij.lang.Commenter

class AssemblyCommenter : Commenter {
    override fun getLineCommentPrefix(): String? {
        return ";"
    }

    override fun getBlockCommentPrefix(): String? {
        return ".comment"
    }

    override fun getBlockCommentSuffix(): String? {
        return ".endc"
    }

    override fun getCommentedBlockCommentPrefix(): String? {
        return null
    }

    override fun getCommentedBlockCommentSuffix(): String? {
        return null
    }
}