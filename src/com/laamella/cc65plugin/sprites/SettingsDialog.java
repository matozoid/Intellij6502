package com.laamella.cc65plugin.sprites;

import com.intellij.openapi.help.HelpManager;
import com.intellij.openapi.ui.DialogWrapper;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * Author: Dan N. Dromereschi
 * <p/>
 * Date: Sep 23, 2006
 * Time: 12:53:53 PM
 * <p/>
 * A helper class for the gridbag layout operations.
 */
class LayoutHelper {
    /** The GridBagConstraints for the GridbagLayout panels. */
    private GridBagConstraints c;

    /**
     * The class constructor.
     */
    public LayoutHelper() {
        c = new GridBagConstraints();
    }

    /**
     * Sets the grid parameters.
     * @param gridX the grid X value
     * @param gridY the grid Y value
     * @param gridW the grid width value
     * @param gridH the grid height value
     */
    public void set(int gridX, int gridY, int gridW, int gridH) {
        c.gridx = gridX;
        c.gridy = gridY;
        c.gridwidth = gridW;
        c.gridheight = gridH;
    }

    /**
     * Sets the weight parameters.
     * @param weightX the grid weight X value
     * @param weightY the grid weight Y value
     */
    public void setWeight(double weightX, double weightY) {
        c.weightx = weightX;
        c.weighty = weightY;
    }

    /**
     * Sets the grid and the weight parameters.
     * @param gridX the grid X value
     * @param gridY the grid Y value
     * @param gridW the grid width value
     * @param gridH the grid height value
     * @param weightX the grid weight X value
     * @param weightY the grid weight Y value
     */
    public void set(int gridX, int gridY, int gridW, int gridH, double weightX,
                    double weightY) {
        set(gridX, gridY, gridW, gridH);
        setWeight(weightX, weightY);
    }

    /**
     * Returns the <code>GridBagConstraints</code> constraints.
     * @return the <code>GridBagConstraints</code> constraints
     */
    public GridBagConstraints getConstraints() {
        return c;
    }
}

public class SettingsDialog extends DialogWrapper {
    /** The center panel. */
    private JPanel centerPanel = new JPanel();
    /** The north panel. */
    private JPanel northPanel = new JPanel();
    /** The image file types buttons group. */
    private ButtonGroup fileTypeGroup = new ButtonGroup();
    /** The image file types choices. */
    private JRadioButton[] fileTypeChoices;
    /** The available file types objects. */
    /** The file name label. */
    private JLabel fileNameLabel = new JLabel("File Name");
    /** The file name textfield. */
    private JTextField fileNameText = new JTextField("image");
    /** The available resolution objects. */
    /** The resolution buttons group. */
    private ButtonGroup resGroup = new ButtonGroup();
    /** The resolution choices. */
    private JRadioButton[] resChoices;
    /** The custom resolution choice. */
    private JRadioButton customRes = new JRadioButton("Other size");
    /** The custom width label. */
    private JLabel customWidthLabel = new JLabel("Width");
    /** The custom image width spinner. */
    private JSpinner customWidthSpinner = new JSpinner();
    /** The custom height label. */
    private JLabel customHeightLabel = new JLabel("Height");
    /** The custom image height spinner model. */
    /** The custom image height spinner. */
    private JSpinner customHeightSpinner = new JSpinner();

    /**
     * The class constructor.
     * @param canBeParent <code>true</code> if the dialog can be the parent of another dialog
     */
    public SettingsDialog(boolean canBeParent) {
        super(canBeParent);
        getHelpAction().setEnabled(true);
        setTitle("New Icon Image");
        init();
    }

    /**
     * Returns the supported actions.
     * @return the supported actions
     */
    protected Action[] getActions() {
        return new Action[]{getOKAction(), getCancelAction(), getHelpAction()};
    }

    /**
     * Creates and returns the north panel.
     * @return the north panel
     */
    protected JComponent createNorthPanel() {
        northPanel.setLayout(new GridBagLayout());
        northPanel.setPreferredSize(new Dimension(400, 140));
        northPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
                BorderFactory.createTitledBorder("Icon Image File")));
        LayoutHelper helper = new LayoutHelper();
        helper.getConstraints().anchor = GridBagConstraints.WEST;
        helper.getConstraints().fill = GridBagConstraints.HORIZONTAL;
        helper.getConstraints().insets = new Insets(5, 5, 5, 5);
        helper.set(0, 0, 1, 1);
        northPanel.add(fileNameLabel, helper.getConstraints());
        helper.set(1, 0, 2, 1, 1, 0);
        northPanel.add(fileNameText, helper.getConstraints());
        return northPanel;
    }

    /**
     * Creates and returns the center panel.
     * @return the center panel
     */
    protected JComponent createCenterPanel() {
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setPreferredSize(new Dimension(400, 150));
        centerPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
                BorderFactory.createTitledBorder("Icon Image Size")));
        LayoutHelper helper = new LayoutHelper();
        helper.getConstraints().anchor = GridBagConstraints.WEST;
        helper.getConstraints().fill = GridBagConstraints.HORIZONTAL;
        helper.getConstraints().insets = new Insets(5, 5, 5, 5);
        int newRow = 1;
        resGroup.add(customRes);
        customRes.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                setCustomEnabled(customRes.isSelected());
            }
        });
        helper.set(0, newRow, 3, 1, 1, 0);
        centerPanel.add(customRes, helper.getConstraints());
        resChoices[0].setSelected(true);
        helper.set(3, newRow, 1, 1, 1, 0);
        centerPanel.add(customWidthLabel, helper.getConstraints());
        helper.set(4, newRow, 1, 1, 1, 0);
        centerPanel.add(customWidthSpinner, helper.getConstraints());
        helper.set(5, newRow, 1, 1, 4, 0);
        centerPanel.add(new JLabel(""), helper.getConstraints());
        helper.set(6, newRow, 1, 1, 1, 0);
        centerPanel.add(customHeightLabel, helper.getConstraints());
        helper.set(7, newRow, 1, 1, 1, 0);
        centerPanel.add(customHeightSpinner, helper.getConstraints());
        helper.set(8, newRow, 1, 1, 4, 0);
        centerPanel.add(new JLabel(""), helper.getConstraints());
        setCustomEnabled(false);
        return centerPanel;
    }

    /**
     * Sets the custom resolution components enabled.
     * @param b <code>true</code> if the custom image size components should be enabled
     */
    private void setCustomEnabled(boolean b) {
        customWidthLabel.setEnabled(b);
        customWidthSpinner.setEnabled(b);
        customHeightLabel.setEnabled(b);
        customHeightSpinner.setEnabled(b);
    }

    /** The help action. */
    protected void doHelpAction() {
        HelpManager.getInstance().invokeHelp("com.iconeditor.Settings");
    }

    /**
     * Returns the image file name.
     * @return the image file name
     */
    public String getFileName() {
        return fileNameText.getText();
    }

}
