package view;

import app.factory.LoginUseCaseFactory;
import data_access.FileUserDataAccess;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginViewTest {
    static LoginViewModel loginViewModel;
    static LoginView loginView;
    static User sampleUser;
    static ViewManagerModel viewManagerModel;
    static MenuViewModel menuViewModel;
    static FileUserDataAccess fileUserDataAccess;

    @BeforeAll
    static void setUp() {
        fileUserDataAccess = new FileUserDataAccess("file.txt");
        fileUserDataAccess.clear();
        sampleUser = UserFactory.createUser("sample", "password", "1day", 10);
        fileUserDataAccess.save(sampleUser);
        loginViewModel = new LoginViewModel();
        viewManagerModel = new ViewManagerModel();
        menuViewModel = new MenuViewModel();
        loginView = LoginUseCaseFactory.createLoginView(viewManagerModel,loginViewModel,menuViewModel,
                fileUserDataAccess);

        // Create the UI
        JFrame jf = new JFrame();
        jf.setContentPane(loginView);
        jf.pack();
        jf.setVisible(true);
    }

    // Checks that the login view is set up with buttons
    @Test
    public void testSetUp() {
        // Checks that the buttons aren't null
        assertNotNull(loginView);
        assertNotNull(loginView.logIn);
        assertNotNull(loginView.cancel);
    }

    // Checks whether the login button in the login view works.
    @Test
    public void testLoginButtonPerformed() {
        // Manual user input
        String sampleUserName = "sample";
        String samplePassword = "password";
        simulateUserTyping(loginView.usernameInputField, sampleUserName);
        simulateUserTyping(loginView.passwordInputField, samplePassword);

        // Test that the text are indeed in the username fields and password fields
        assertEquals(sampleUserName, loginView.usernameInputField.getText());
        assertEquals(samplePassword, new String(loginView.passwordInputField.getPassword()));

        loginView.logIn.doClick(); // Click the Button
        LoginState loginState = loginViewModel.getState();

        // Check if the loginState has changed
        assertEquals(sampleUserName, loginState.getUsername());
        assertEquals(samplePassword, loginState.getPassword());
    }

    // Helper method to simulate user typing in the input fields
    private void simulateUserTyping(JTextField textField, String text) {
        for (char c : text.toCharArray()) {
            try {
                sleep(20); // One shall sleep more gentle into that night
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            simulateKeyPress(textField, c);
        }
    }

    // Helper method to create KeyEvents
    private void simulateKeyPress(JTextField textField, char c) {
        KeyEvent keyPressEvent = new KeyEvent(
                textField, // we are interacting with the textField
                KeyEvent.KEY_TYPED, //
                System.currentTimeMillis(), // say the event happened right now
                0, // no modifiers
                KeyEvent.VK_UNDEFINED, // for KEY_TYPED, the KeyCode is undefined per documentation
                c); // the character that is being typed
        SwingUtilities.invokeLater(() -> textField.dispatchEvent(keyPressEvent));
    }

    @Test
    public void testCancelButtonPerformed() {

        loginView.cancel.doClick(); // Click the Button

        // Check(Ensure) that after clicking the button, the menuState has an empty stock symbol.
        MenuState menuState = menuViewModel.getState();
        assertEquals("", menuState.getStockSymbol());
    }




}
