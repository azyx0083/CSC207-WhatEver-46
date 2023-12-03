package use_case.signup;
import data_access.APIDataAccess;
import data_access.InMemoryUserDataAccess;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_case.search.SearchFileUserDataAccessInterface;
import use_case.search.SearchInteractor;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class SignupTest {
    static InMemoryUserDataAccess inMemoryUserDataAccess;
    static SignupPresenter presenter;
    static SignupViewModel signupViewModel;
    static LoginViewModel loginViewModel;
    static UserFactory userFactory;
    @BeforeAll
    static void setUp(){
        inMemoryUserDataAccess = new InMemoryUserDataAccess();
        userFactory = new UserFactory();
        loginViewModel = new LoginViewModel();
        signupViewModel = new SignupViewModel();
        presenter = new SignupPresenter(new ViewManagerModel(), signupViewModel,loginViewModel);
        inMemoryUserDataAccess.save(new User("exists", "1","1day", 10));
    }

    @Test
    void testSuccessView(){
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess,presenter,userFactory);
        interactor.execute(new SignupInputData("success", "11", "11"));
        assertNotNull(inMemoryUserDataAccess.getAccounts().keySet());
        assertNotNull(inMemoryUserDataAccess.getAccounts().get("success"));
    }

    @Test
    void testPasswordNotMatch(){
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess,presenter,userFactory);
        interactor.execute(new SignupInputData("Fail", "1", "2"));
        assertEquals("Passwords don't match.", signupViewModel.getState().getUsernameError());
    }

    @Test
    void testPasswordInvalid(){
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess,presenter,userFactory);
        interactor.execute(new SignupInputData("Fail", null, null));
        assertEquals("Invalid Password", signupViewModel.getState().getUsernameError());
    }

    @Test
    void testUserAlreadyExists(){
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess,presenter,userFactory);
        interactor.execute(new SignupInputData("exists", "1", "1"));
        assertEquals("User already exists", signupViewModel.getState().getUsernameError());
    }
}
