package com.laamella.cc65plugin.ca65;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class Ca65IncludeFileType extends LanguageFileType {
    public static final Ca65IncludeFileType INSTANCE = new Ca65IncludeFileType();

    private Ca65IncludeFileType() {
        super(Ca65Language.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "ca65 include file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "ca65 assembler include file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "inc";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Ca65Icons.FILE;
    }
}