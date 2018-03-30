package com.laamella.intellij6502.sprites;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class SpriteComponent extends JComponent {

    private BufferedImage image;

    public SpriteComponent(BufferedImage image) {
        this.image = image;
        Dimension size = new Dimension(image.getWidth(), image.getHeight());
        setSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
    }

    public void setImage(final BufferedImage image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0, 0, this);
    }

}
