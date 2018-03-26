package com.laamella.cc65plugin.sprites;

import com.intellij.openapi.fileTypes.UserBinaryFileType;
import com.laamella.cc65plugin.ca65.Ca65Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SpritesFileType extends UserBinaryFileType {
    public static final SpritesFileType INSTANCE = new SpritesFileType();

    @NotNull
    @Override
    public String getName() {
        return "C64 sprites sprites file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "C64 sprites sprites file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "spr";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Ca65Icons.FILE;
    }
}
