package com.laamella.cc65plugin;

import com.intellij.openapi.fileTypes.*;
import com.laamella.cc65plugin.ca65.Ca65FileType;
import com.laamella.cc65plugin.ca65.Ca65IncludeFileType;
import com.laamella.cc65plugin.ld65.Ld65FileType;
import org.jetbrains.annotations.NotNull;

public class Cc65FileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(Ca65FileType.INSTANCE);
        fileTypeConsumer.consume(Ca65IncludeFileType.INSTANCE);
        fileTypeConsumer.consume(Ld65FileType.INSTANCE);
    }
}