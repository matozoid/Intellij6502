package com.laamella.intellij6502.sprites;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.laamella.intellij6502.sprites.model.SpritesProject;

import java.io.*;
import java.nio.charset.Charset;

public class NewSpritesProjectAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        final DataContext dataContext = e.getDataContext();
        final Project project = dataContext.getData(CommonDataKeys.PROJECT);
        VirtualFile selectedFile = dataContext.getData(CommonDataKeys.VIRTUAL_FILE);
        if (selectedFile == null || project == null) {
            return;
        }

        String fileName = Messages.showInputDialog(project, "Enter project name", "Name the New Sprites Project File", null);
        if (fileName == null || fileName.isEmpty()) {
            return;
        }
        if (!selectedFile.isDirectory()) {
            selectedFile = selectedFile.getParent();
        }
        if (selectedFile == null) {
            return;
        }
        final File f = new File(selectedFile.getPath(), fileName + ".spr");
        f.getParentFile().mkdirs();
        try {
            if (!f.createNewFile()) {
                return;
            }
        } catch (IOException ex) {
            Messages.showErrorDialog("The project file " + f.getName()
                    + " could not be created.\n" + ex.getMessage(), "Error");
            return;
        }

        ApplicationManager.getApplication().runWriteAction(() -> {
            try {
                saveProjectFile(project, new SpritesProject(), f);
            } catch (IOException ex) {
                Messages.showErrorDialog("The project file " + f.getName() + " could not be created.\n" + ex.getMessage(), "Error");
            }
        });
    }

    public static void saveProjectFile(Project project, SpritesProject spritesProject, File f) throws IOException {
        System.out.println("SAVING...");
        Gson gson = new GsonBuilder().create();
        String emptyProject = gson.toJson(spritesProject);
        Files.write(emptyProject, f, Charset.forName("utf-8"));
        VirtualFile v = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(f);
        if (v != null) {
            FileEditorManager.getInstance(project).openFile(v, true);
        }
        System.out.println("SAVED.");
    }
}
