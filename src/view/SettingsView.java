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
    JLabel favoriteStocks = new JLabel(SettingsViewModel.FAVORITE_STOCKS_LABEL);
    private final JTextField sizeInputField = new JTextField(20);
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

        interval.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataSize.setAlignmentX(Component.CENTER_ALIGNMENT);
        favoriteStocks.setAlignmentX(Component.CENTER_ALIGNMENT);
        sizeInputField.setAlignmentX(Component.CENTER_ALIGNMENT);
        apply.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnToMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
