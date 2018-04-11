package com.laamella.intellij6502

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import com.laamella.intellij6502.asm.AssemblyFileType

class Intellij6502FileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(AssemblyFileType.INSTANCE)
    }
}
