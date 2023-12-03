package use_case.signup;
import data_access.InMemoryUserDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SignupTest {
    static InMemoryUserDataAccess inMemoryUserDataAccess;
    static SignupPresenter presenter;
    static SignupViewModel signupViewModel;
    static LoginViewModel loginViewModel;
    static String validUsername = "success";
    static String empty = "";
    static String inValidUsername = "something too long";
    static String validPassword = "11111111";
    static String validPassword2 = "22222222";
    static String inValidPassword = "11";

    @BeforeAll
    static void setUp(){
        inMemoryUserDataAccess = new InMemoryUserDataAccess();
        loginViewModel = new LoginViewModel();
        signupViewModel = new SignupViewModel();
        presenter = new SignupPresenter(new ViewManagerModel(), signupViewModel,loginViewModel);
    }

    @Test
    void testSuccessView(){
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess,presenter);
        interactor.execute(new SignupInputData(validUsername, validPassword, validPassword));
        assertNotNull(inMemoryUserDataAccess.getAccounts().keySet());
        assertNotNull(inMemoryUserDataAccess.get("success"));
    }

    @Test
    void testPasswordNotMatch(){
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess,presenter);
        interactor.execute(new SignupInputData("Fail", validPassword, validPassword2));
        assertEquals("Passwords don't match.", signupViewModel.getState().getError());
    }

    @Test
    void testPasswordInvalid(){
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess,presenter);
        interactor.execute(new SignupInputData("Fail", inValidPassword, inValidPassword));
        assertEquals("Invalid Password", signupViewModel.getState().getError());
    }

    @Test
    void testUsernameInvalid() {
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess, presenter);
        interactor.execute(new SignupInputData(inValidUsername, validPassword, validPassword));
        assertEquals("Invalid Username", signupViewModel.getState().getError());
    }

    @Test
    void testEmpty() {
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess, presenter);
        interactor.execute(new SignupInputData(empty, validPassword, validPassword));
        assertEquals("Invalid Username", signupViewModel.getState().getError());
        interactor.execute(new SignupInputData(validUsername, empty, empty));
        assertEquals("Invalid Password", signupViewModel.getState().getError());
    }

    @Test
    void testUserAlreadyExists(){
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess,presenter);
        interactor.execute(new SignupInputData(validUsername, validPassword, validPassword));
        assertEquals("User already exists", signupViewModel.getState().getError());
    }
}
