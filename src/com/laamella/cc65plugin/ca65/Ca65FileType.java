package com.laamella.cc65plugin.ca65;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class Ca65FileType extends LanguageFileType {
    public static final Ca65FileType INSTANCE = new Ca65FileType();

    private Ca65FileType() {
        super(Ca65Language.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "ca65 file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "ca65 assembler file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "s";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Ca65Icons.FILE;
    }
}