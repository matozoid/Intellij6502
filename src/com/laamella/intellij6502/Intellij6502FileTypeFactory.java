package com.laamella.intellij6502;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import com.laamella.intellij6502.asm.AssemblyFileType;
import com.laamella.intellij6502.sprites.SpritesProjectFileType;
import org.jetbrains.annotations.NotNull;

public class Intellij6502FileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(AssemblyFileType.INSTANCE);
        fileTypeConsumer.consume(SpritesProjectFileType.INSTANCE);
    }
}
