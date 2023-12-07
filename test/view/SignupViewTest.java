package view;

import app.factory.SignupUseCaseFactory;
import data_access.FileUserDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignupViewTest {
    static FileUserDataAccess fileUserDataAccess;
    static LoginViewModel loginViewModel;
    static MenuViewModel menuViewModel;
    static SignupViewModel signupViewModel;
    static ViewManagerModel viewManagerModel;
    static SignupView signupView;


    @BeforeAll
    static void setUp() {
        fileUserDataAccess = new FileUserDataAccess("file.txt");
        fileUserDataAccess.clear();
        loginViewModel = new LoginViewModel();
        menuViewModel = new MenuViewModel();
        signupViewModel = new SignupViewModel();
        viewManagerModel = new ViewManagerModel();
        signupView = SignupUseCaseFactory.createSignupView(viewManagerModel, signupViewModel, menuViewModel,
                loginViewModel, fileUserDataAccess);

        // Create the UI
        JFrame jf = new JFrame();
        jf.setContentPane(signupView);
        jf.pack();
        jf.setVisible(true);
    }

    // Tests whether the signup button in SignupView works.
    @Test
    public void testSignupButtonPerformed() {
        // Manual user input
        String sampleUserName = "sample";
        String samplePassword = "password";
        String sampleRepeatPassword = "password";
        simulateUserTyping(signupView.usernameInputField, sampleUserName);
        simulateUserTyping(signupView.passwordInputField, samplePassword);
        simulateUserTyping(signupView.repeatPasswordInputField, sampleRepeatPassword);

        // Test that the text are indeed in the username fields and password fields
        assertEquals(sampleUserName, signupView.usernameInputField.getText());
        assertEquals(samplePassword, new String(signupView.passwordInputField.getPassword()));
        assertEquals(sampleRepeatPassword, new String(signupView.repeatPasswordInputField.getPassword()));

        signupView.signUp.doClick(); // Click the button

        // Check if the SignupState changed
        SignupState signupState = signupViewModel.getState();
        assertEquals(sampleUserName, signupState.getUsername());
        assertEquals(samplePassword, signupState.getPassword());
        assertEquals(sampleRepeatPassword, signupState.getRepeatPassword());

        /*
        Check if the LoginState changed; A successful signup process would lead to a change in LoginState because
        a switch to the login view
         */
        LoginState loginState = loginViewModel.getState();
        assertEquals(sampleUserName, loginState.getUsername());
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

        signupView.cancel.doClick(); // Click the Button

        // Check(Ensure) that after clicking the button, the menuState has an empty stock symbol.
        MenuState menuState = menuViewModel.getState();
        assertEquals("", menuState.getStockSymbol());
    }
}
