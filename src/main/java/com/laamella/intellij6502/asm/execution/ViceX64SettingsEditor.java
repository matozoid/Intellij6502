package com.laamella.intellij6502.asm.execution;

import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ViceX64SettingsEditor extends SettingsEditor<ViceX64RunConfiguration> {
    private LabeledComponent<TextFieldWithBrowseButton> executablePath = null;

    @Override
    protected void resetEditorFrom(@NotNull ViceX64RunConfiguration s) {
        executablePath.getComponent().setText(s.getExecutable());
    }

    @Override
    protected void applyEditorTo(@NotNull ViceX64RunConfiguration s) {
        s.setExecutable(executablePath.getComponent().getText());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        executablePath = new LabeledComponent<>();
        executablePath.setComponent(new TextFieldWithBrowseButton());
        return executablePath;
    }
}
