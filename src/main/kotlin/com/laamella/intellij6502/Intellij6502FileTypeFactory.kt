package com.laamella.intellij6502

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import com.laamella.intellij6502.asm.AssemblyFileType
import com.laamella.intellij6502.sprites.SpritesProjectFileType

class Intellij6502FileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(AssemblyFileType.INSTANCE)
        fileTypeConsumer.consume(SpritesProjectFileType.INSTANCE)
    }
}
