package com.laamella.cc65plugin;

import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;

public class Ca65FileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(Ca65FileType.INSTANCE);
        fileTypeConsumer.consume(Ca65IncludeFileType.INSTANCE);
    }
}