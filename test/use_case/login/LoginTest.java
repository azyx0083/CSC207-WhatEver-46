package use_case.login;
import data_access.APIDataAccess;
import data_access.InMemoryUserDataAccess;
import entity.User;
import entity.UserSetting;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuViewModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    static InMemoryUserDataAccess inMemoryUserDataAccess;
    static LoginViewModel loginViewModel;
    static MenuViewModel menuViewModel;
    static ViewManagerModel viewManagerModel;
    static LoginPresenter presenter;
    static String fail = "fail";
    static String success = "success";
    static String correctPassword = "11111";
    static String wrongPassword = "00000";

    @BeforeAll
    static void setUp(){
        loginViewModel = new LoginViewModel();
        menuViewModel = new MenuViewModel();
        viewManagerModel = new ViewManagerModel();
        inMemoryUserDataAccess = new InMemoryUserDataAccess();
        presenter = new LoginPresenter(viewManagerModel, menuViewModel, loginViewModel);
        inMemoryUserDataAccess.save(new User(success, correctPassword,new UserSetting("1day", 30)));
    }

    @Test
    void testSuccessView(){
        LoginInteractor interactor = new LoginInteractor(inMemoryUserDataAccess, presenter);
        interactor.execute(new LoginInputData(success, correctPassword));
        assertEquals("success", menuViewModel.getState().getUsername());
    }

    @Test
    void testUserDoesNotExist(){
        LoginInteractor interactor = new LoginInteractor(inMemoryUserDataAccess, presenter);
        interactor.execute(new LoginInputData(fail, correctPassword));
        assertEquals(fail + ": Account does not exist.", loginViewModel.getState().getUsernameError());
    }

    @Test
    void testPasswordDoesNotMatch(){
        LoginInteractor interactor = new LoginInteractor(inMemoryUserDataAccess, presenter);
        interactor.execute(new LoginInputData(success, wrongPassword));
        assertEquals("Incorrect password for " + success + ".",
                loginViewModel.getState().getUsernameError());
    }
}
