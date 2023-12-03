package view;

import interface_adapter.menu.*;
import interface_adapter.search.*;
import interface_adapter.settings.SettingsController;
import view.helpers.TextButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "menu";
    final MenuViewModel menuViewModel;
    final SearchController searchController;
    final SettingsController settingsController;
    private final JLabel user;
    private final JTextField searchInputField = new JTextField(20);
    private final JButton search;
    private final JButton settings;

    /**
     * Constructor method. Makes the view layout and assigns buttons their functionalities.
     *
     * @param menuViewModel  The associated  MenuViewModel
     *                       /@param searchController The associated SearchController
     *                       /@param searchViewModel The associated SearchViewModel
     */
    public MenuView(MenuViewModel menuViewModel, SearchController searchController, SettingsController settingsController) {
        this.menuViewModel = menuViewModel;
        this.searchController = searchController;
        this.settingsController = settingsController;

        this.setSize(200, 200);

        menuViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(MenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        user = new JLabel("Signed in as: " + menuViewModel.getState().getUsername());
        user.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel searchLabel = new JLabel(MenuViewModel.SEARCH_LABEL);
        searchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        search = new JButton(MenuViewModel.SEARCH_BUTTON_LABEL);
        search.setAlignmentX(Component.CENTER_ALIGNMENT);
        search.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(search)) {
                            MenuState menuState = menuViewModel.getState();

                            searchController.execute(menuState.getStockSymbol());
                        }
                    }
                }
        );

        settings = new JButton(MenuViewModel.TO_SETTINGS_BUTTON_LABEL);
        settings.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(settings)) {
                            settingsController.goToSettings(menuViewModel.getState().getUsername());
                        }
                    }
                }
        );

        searchInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        MenuState currentState = menuViewModel.getState();
                        String text = searchInputField.getText() + e.getKeyChar();
                        currentState.setStockSymbol(text);
                        menuViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        TextButtonPanel searchPanel = new TextButtonPanel(searchLabel, searchInputField, search);

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.ipady = 10;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        this.add(title, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        this.add(user, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        this.add(searchPanel, constraints);

        constraints.gridy = 3;
        this.add(settings, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        MenuState state = (MenuState) evt.getNewValue();
        searchInputField.setText(null);
        if (state.getStockError() != null) {
            JOptionPane.showMessageDialog(this, state.getStockError());
            menuViewModel.getState().setStockError(null);
        }
    }
}
