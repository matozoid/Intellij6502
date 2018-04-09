package com.laamella.intellij6502.sprites;

import com.intellij.openapi.fileTypes.UserBinaryFileType;
import com.laamella.intellij6502.Intellij6502Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SpritesProjectFileType extends UserBinaryFileType {
    public static final SpritesProjectFileType INSTANCE = new SpritesProjectFileType();

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
        return Intellij6502Icons.SPRITES_PROJECT;
    }
}
