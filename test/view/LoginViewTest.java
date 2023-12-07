package view;

import app.factory.LoginUseCaseFactory;
import data_access.FileUserDataAccess;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_case.login.LoginInputBoundary;
import use_case.menu.MenuInputBoundary;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginViewTest {
    static LoginInputBoundary lib;
    static LoginViewModel loginViewModel;
    static LoginController loginController;
    static MenuInputBoundary mib;
    static MenuController menuController;
    static LoginView loginView;
    static User sampleUser;
    static ViewManagerModel viewManagerModel;
    static MenuViewModel menuViewModel;
    static FileUserDataAccess fileUserDataAccess;

    @BeforeAll
    static void setUp() {
        /*
        lib = null;
        loginController = new LoginController(lib);
        loginViewModel = new LoginViewModel();
        mib = null;
        menuController = new MenuController(mib);
        loginView = new LoginView(loginViewModel, loginController, menuController);
         */

        fileUserDataAccess = new FileUserDataAccess("file.txt");
        sampleUser = UserFactory.createUser("sample", "password", "1day", 10);
        fileUserDataAccess.save(sampleUser);
        loginViewModel = new LoginViewModel();
        viewManagerModel = new ViewManagerModel();
        menuViewModel = new MenuViewModel();
        loginView = LoginUseCaseFactory.createLoginView(viewManagerModel,loginViewModel,menuViewModel,
                fileUserDataAccess);
    }

    /*
    Tests whether the login button in the login view works.
     */
    @Test
    public void testLoginButtonPerformed() {
        // Manual user input
        String sampleUserName = "sample";
        String samplePassword = "password";
        loginView.usernameInputField.setText(sampleUserName);
        loginView.passwordInputField.setText(samplePassword);

        loginView.logIn.doClick(); // Click the Button
        LoginState loginState = loginViewModel.getState();

        // Check if the loginState has changed
        assertEquals(sampleUserName, loginState.getUsername());
        assertEquals(samplePassword, loginState.getPassword());
    }

    @Test
    public void testCancelButtonPerformed() {

        loginView.cancel.doClick(); // Click the Button




    }




}
