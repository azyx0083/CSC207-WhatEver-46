package view;

import data_access.FileUserDataAccess;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuPresenter;
import interface_adapter.menu.MenuViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_case.login.LoginInteractor;
import use_case.menu.MenuInputBoundary;
import use_case.menu.MenuInteractor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginViewTest {
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
        fileUserDataAccess = new FileUserDataAccess("file.txt");
        sampleUser = UserFactory.createUser("sample", "password", "1day", 10);
        fileUserDataAccess.save(sampleUser);
        loginViewModel = new LoginViewModel();
        viewManagerModel = new ViewManagerModel();
        menuViewModel = new MenuViewModel();
        loginView = LoginUseCaseFactory.createLoginView(viewManagerModel,loginViewModel,menuViewModel,
                fileUserDataAccess);

        Main.main(null);
        fileUserDataAccess = new FileUserDataAccess("file.txt");
        sampleUser = UserFactory.createUser("sample", "password", "1day", 10);
        fileUserDataAccess.save(sampleUser);
         */

        fileUserDataAccess = new FileUserDataAccess("file.txt");
        sampleUser = UserFactory.createUser("sample", "password", "1day", 10);
        fileUserDataAccess.save(sampleUser);

        loginViewModel = new LoginViewModel();
        viewManagerModel = new ViewManagerModel();
        menuViewModel = new MenuViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(viewManagerModel, menuViewModel, loginViewModel);
        LoginInteractor loginInteractor = new LoginInteractor(fileUserDataAccess, loginPresenter);
        loginController = new LoginController(loginInteractor);

        MenuPresenter menuPresenter = new MenuPresenter(viewManagerModel, menuViewModel);
        MenuInteractor menuInteractor = new MenuInteractor(menuPresenter);
        menuController = new MenuController(menuInteractor);
        loginView = new LoginView(loginViewModel, loginController, menuController);
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
