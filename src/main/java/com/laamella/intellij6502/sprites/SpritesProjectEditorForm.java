package com.laamella.intellij6502.sprites;

import com.intellij.ui.components.JBViewport;

import javax.swing.*;
import java.awt.*;

public class SpritesProjectEditorForm {
    private JPanel rootPanel;
    private JBViewport editorViewport;
    private JPanel spritesContainer;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JBViewport getEditorViewport() {
        return editorViewport;
    }

    public JPanel getSpritesContainer() {
        return spritesContainer;
    }

    private void createUIComponents() {
        spritesContainer = new JPanel(new WrapLayout(FlowLayout.LEFT, 2, 2));
    }
}
