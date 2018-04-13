package com.laamella.intellij6502.asm.execution;

import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ViceX64SettingsEditor extends SettingsEditor<ViceX64RunConfiguration> {

    @Override
    protected void resetEditorFrom(@NotNull ViceX64RunConfiguration s) {

    }

    @Override
    protected void applyEditorTo(@NotNull ViceX64RunConfiguration s) {

    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return new JLabel("Vice X64 Setting editor");
    }
}
