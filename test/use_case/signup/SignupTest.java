package use_case.signup;
import data_access.APIDataAccess;
import data_access.InMemoryUserDataAccess;
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
    }

    @Test
    void testSuccessView(){
        SignupInteractor interactor = new SignupInteractor(inMemoryUserDataAccess,presenter,userFactory)
    }
}
