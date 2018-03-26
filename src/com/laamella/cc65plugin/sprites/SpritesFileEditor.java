package com.laamella.cc65plugin.sprites;

import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class SpritesFileEditor implements FileEditor {
    private final Project project;
    private final VirtualFile file;
    private final SpritesFileEditorForm form;

    public SpritesFileEditor(Project project, VirtualFile file) {
        this.project = project;
        this.file = file;

        form = new SpritesFileEditorForm();



        for (int i = 0; i < 10; i++) {
            BufferedImage image = UIUtil.createImage(48, 50, TYPE_INT_ARGB);

            // get the Graphics context for this single BufferedImage object
            Graphics g = image.getGraphics();

            g.drawString("Point is here", 0, 10);
            g.drawRect(0,0,47,49);

            g.dispose();  // get rid of the Graphics context to save resources

            form.getSpritesContainer().add(new ImageComponent(image));
        }


    }


    @NotNull
    @Override
    public JComponent getComponent() {
        return form.getRootPanel();
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
        return form.getRootPanel();
    }

    @NotNull
    @Override
    public String getName() {
        return "Sprite Editor";
    }

    @Override
    public void setState(@NotNull FileEditorState state) {

    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void selectNotify() {

    }

    @Override
    public void deselectNotify() {

    }

    @Override
    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {

    }

    @Nullable
    @Override
    public BackgroundEditorHighlighter getBackgroundHighlighter() {
        return null;
    }

    @Nullable
    @Override
    public FileEditorLocation getCurrentLocation() {
        return null;
    }

    @Override
    public void dispose() {

    }

    @Nullable
    @Override
    public <T> T getUserData(@NotNull Key<T> key) {
        return null;
    }

    @Override
    public <T> void putUserData(@NotNull Key<T> key, @Nullable T value) {

    }

    @Nullable
    @Override
    public VirtualFile getFile() {
        return file;
    }

    public static void main(final String args[]) {
        JFrame frame = new JFrame("JToolBar Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SpritesFileEditorForm form = new SpritesFileEditor(null, null).form;
        frame.add(form.getRootPanel(), BorderLayout.CENTER);
        form.getSpritesContainer().setLayout(new WrapLayout(FlowLayout.LEFT));
        for (int i = 0; i < 10; i++) {
            BufferedImage image = UIUtil.createImage(48, 50, TYPE_INT_ARGB);

            // get the Graphics context for this single BufferedImage object
            Graphics g = image.getGraphics();

            g.drawString("Point is here", 0, 10);
            g.drawRect(0,0,47,49);

            g.dispose();  // get rid of the Graphics context to save resources

            form.getSpritesContainer().add(new ImageComponent(image));
        }
        frame.setSize(650, 650);
        frame.setVisible(true);
    }
}

class ImageComponent extends JComponent {

    private BufferedImage image;

    public ImageComponent(BufferedImage image){
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