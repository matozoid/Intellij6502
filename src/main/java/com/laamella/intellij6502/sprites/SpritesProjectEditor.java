package com.laamella.intellij6502.sprites;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intellij.AppTopics;
import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileEditor.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.ui.UIUtil;
import com.laamella.intellij6502.sprites.model.SpritesProject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.*;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class SpritesProjectEditor implements FileEditor {
    private final Project project;
    private final VirtualFile file;
    private final SpritesProjectEditorForm form;
    private final SpritesProject spritesProject;
    private boolean modified = false;

    public SpritesProjectEditor(Project project, VirtualFile file) {
        this.project = project;
        this.file = file;

        form = new SpritesProjectEditorForm();
        try {
            byte[] bytes = file.contentsToByteArray();
            Gson gson = new GsonBuilder().create();
            try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                 Reader reader = new InputStreamReader(bais, "utf-8")) {
                spritesProject = gson.fromJson(reader, SpritesProject.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ApplicationManager.getApplication().getMessageBus().connect().subscribe(AppTopics.FILE_DOCUMENT_SYNC, new FileDocumentManagerAdapter() {
            @Override
            public void beforeAllDocumentsSaving() {
                try {
                    NewSpritesProjectAction.saveProjectFile(project, spritesProject, new File(file.getPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            BufferedImage image = UIUtil.createImage(48, 50, TYPE_INT_ARGB);

            // get the Graphics context for this single BufferedImage object
            Graphics g = image.getGraphics();

            g.drawString("Point is here", 0, 10);
            g.drawRect(0, 0, 47, 49);

            g.dispose();  // get rid of the Graphics context to save resources

            form.getSpritesContainer().add(new SpriteComponent(image));
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
        return modified;
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

    public static void main(final String args[]) throws IOException {
        JFrame frame = new JFrame("JToolBar Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SpritesProjectEditorForm form = new SpritesProjectEditor(null, null).form;
        frame.add(form.getRootPanel(), BorderLayout.CENTER);
        form.getSpritesContainer().setLayout(new WrapLayout(FlowLayout.LEFT));
        for (int i = 0; i < 10; i++) {
            BufferedImage image = UIUtil.createImage(48, 50, TYPE_INT_ARGB);

            // get the Graphics context for this single BufferedImage object
            Graphics g = image.getGraphics();

            g.drawString("Point is here", 0, 10);
            g.drawRect(0, 0, 47, 49);

            g.dispose();  // get rid of the Graphics context to save resources

            form.getSpritesContainer().add(new SpriteComponent(image));
        }
        frame.setSize(650, 650);
        frame.setVisible(true);
    }
}

