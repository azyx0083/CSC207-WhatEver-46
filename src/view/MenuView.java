package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.menu.*;
import interface_adapter.search.*;
import interface_adapter.settings.SettingsController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;
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
    final SignupController signupController;
    final LoginController loginController;
    private final JLabel user;
    private final JTextField searchInputField = new JTextField(20);
    private final JButton search;
    private final JButton settings;
    private final JButton signup;
    private final JButton login;
    private final JButton logout;
    private final JPanel beforeButtons;
    private final JPanel afterButtons;

    /**
     * Constructor method. Makes the view layout and assigns buttons their functionalities.
     *
     * @param menuViewModel  The associated  MenuViewModel
     *                       /@param searchController The associated SearchController
     *                       /@param searchViewModel The associated SearchViewModel
     */
    public MenuView(MenuViewModel menuViewModel, SearchController searchController, SettingsController settingsController,
                    SignupController signupController, LoginController loginController, LogoutController logoutController) {
        this.menuViewModel = menuViewModel;
        this.searchController = searchController;
        this.settingsController = settingsController;
        this.signupController = signupController;
        this.loginController = loginController;

        this.setSize(200, 200);

        menuViewModel.addPropertyChangeListener(this);

        beforeButtons = new JPanel();
        afterButtons = new JPanel();

        JLabel title = new JLabel(MenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(MenuViewModel.font2);


        user = new JLabel();
        user.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel searchLabel = new JLabel(MenuViewModel.SEARCH_LABEL);
        searchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchLabel.setFont(MenuViewModel.font3);

        search = new JButton(MenuViewModel.SEARCH_BUTTON_LABEL);
        beforeButtons.add(search);
        afterButtons.add(search);
        search.setAlignmentX(Component.CENTER_ALIGNMENT);
        search.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(search)) {
                            MenuState menuState = menuViewModel.getState();
                            if (menuState.getStockSymbol() != null)
                                searchController.execute(menuState.getStockSymbol(), menuState.getUsername());
                        }
                    }
                }
        );

        settings = new JButton(MenuViewModel.TO_SETTINGS_BUTTON_LABEL);
        afterButtons.add(settings);
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

        signup = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        beforeButtons.add(signup);
        signup.setAlignmentX(Component.CENTER_ALIGNMENT);
        signup.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(signup)){
                            signupController.jumpToSignup();
                        }
                    }
        });

        login = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);
        beforeButtons.add(login);
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        login.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(login)){
                            loginController.jumpToLogin();
                        }
                    }
        });

        logout = new JButton(MenuViewModel.LOG_OUT_LABEL);
        afterButtons.add(logout);
        logout.setAlignmentX(Component.CENTER_ALIGNMENT);
        logout.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(logout)){
                            logoutController.execute();
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
        this.add(beforeButtons, constraints);
        this.add(afterButtons, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        MenuState state = (MenuState) evt.getNewValue();
        searchInputField.setText(null);
        // popup for error
        if (state.getStockError() != null) {
            JOptionPane.showMessageDialog(this, state.getStockError());
            menuViewModel.getState().setStockError(null);
        }
        // Switch between guest and register
        if (state.getUsername() == null) {
            user.setVisible(false);
            beforeButtons.setVisible(true);
            afterButtons.setVisible(false);
        } else {
            user.setText("Signed in as: " + state.getUsername());
            user.setVisible(true);
            beforeButtons.setVisible(false);
            afterButtons.setVisible(true);
        }
        user.setText("Signed in as: " + menuViewModel.getState().getUsername());
        this.repaint();
    }
}
