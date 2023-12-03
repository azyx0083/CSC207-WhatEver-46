package view;

import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuState;
import interface_adapter.settings.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SettingsView extends JPanel {
    public final String viewName = "settings";
    final SettingsController settingsController;
    final SettingsViewModel settingsViewModel;
    final MenuController menuController;
    JLabel interval = new JLabel(SettingsViewModel.INTERVAL_LABEL);
    JLabel dataSize = new JLabel(SettingsViewModel.DATA_SIZE_LABEL);
    private final JButton apply;
    private final JButton returnToMenu;

    public SettingsView(SettingsController settingsController, SettingsViewModel settingsViewModel, MenuController menuController) {
        this.settingsController = settingsController;
        this.settingsViewModel = settingsViewModel;
        this.menuController = menuController;

        this.setPreferredSize(new Dimension(400,200));


        apply = new JButton(SettingsViewModel.APPLY_BUTTON_LABEL);
        apply.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(apply)) {
                            SettingsState settingsState = settingsViewModel.getState();

                            settingsController.applyChanges(
                                    settingsState.getInterval(),
                                    settingsState.getDataSize(),
                                    settingsState.getFavorites(),
                                    settingsState.getUsername());
                        }
                    }
                }
        );
        returnToMenu = new JButton(SettingsViewModel.TO_MENU_BUTTON_LABEL);
        returnToMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(apply)) {
                            menuController.returnToMenu();
                        }
                    }
                }
        );

        String[] options = {"Option 1", "Option 2", "Option 3", "Option 4"};
        JComboBox<String> intervalDropdown = new JComboBox<>(options);
        intervalDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) intervalDropdown.getSelectedItem();
                settingsViewModel.getState().setInterval(selectedOption);
            }
        });

        Integer[] size = new Integer[100];
        for (int i = 0; i < size.length; i++) {
            size[i] = i + 1;
        }
        JComboBox<Integer> sizeDropdown = new JComboBox<>(size);
        sizeDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedOption = (int) intervalDropdown.getSelectedItem();
                settingsViewModel.getState().setDataSize(selectedOption);
            }
        });

        interval.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataSize.setAlignmentX(Component.CENTER_ALIGNMENT);
        apply.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnToMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.ipady = 10;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        this.add(interval, constraints);

        constraints.gridx = 1;
        this.add(intervalDropdown, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        this.add(dataSize, constraints);

        constraints.gridx = 1;
        this.add(sizeDropdown, constraints);

        constraints.gridy = 2;
        this.add(apply, constraints);

        constraints.gridx = 1;
        this.add(returnToMenu, constraints);
    }
}
