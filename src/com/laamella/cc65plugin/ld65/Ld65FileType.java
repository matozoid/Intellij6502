package com.laamella.cc65plugin.ld65;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.laamella.cc65plugin.ca65.Ca65Icons;
import com.laamella.cc65plugin.ca65.Ca65Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class Ld65FileType extends LanguageFileType {
    public static final Ld65FileType INSTANCE = new Ld65FileType();

    private Ld65FileType() {
        super(Ca65Language.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "ld65 configuration file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "ld65 configuration file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "cfg";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Ca65Icons.FILE;
    }
}