package com.laamella.cc65plugin.sprites;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

import static com.intellij.openapi.ui.DialogWrapper.OK_EXIT_CODE;

public class NewSpritesFileAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        ChooseFileNameDialog chooseFileNameDialog = new ChooseFileNameDialog(e.getProject());
        chooseFileNameDialog.show();
        if (chooseFileNameDialog.getExitCode() == OK_EXIT_CODE) {
            Messages.showErrorDialog(e.getProject(), "qfwef", chooseFileNameDialog.getFileName());
        }
    }
}

class ChooseFileNameDialog extends DialogWrapper {

    private final ChooseFileNameForm form;

    ChooseFileNameDialog(Project project) {
        super(project);
        form = new ChooseFileNameForm();
        init();
        setTitle("Choose Filename");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return form.getCenterPanel();
    }

    String getFileName() {
        return form.getFileNameField().getText();
    }
}