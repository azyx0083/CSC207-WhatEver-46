package app;

import data_access.APIDataAccess;
import entity.user_entities.CommonUserFactory;
import entity.user_entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuPresenter;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.menu.MenuInputBoundary;
import use_case.menu.MenuInteractor;
import use_case.menu.MenuOutputBoundary;
import use_case.signup.SignupDataAccessInterface;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.SignupView;

public class SignupUseCaseFactory {
    public static SignupView createSignupView(ViewManagerModel viewManagerModel,
                                    SignupViewModel signupViewModel,
                                    MenuViewModel menuViewModel,
                                    LoginViewModel loginViewModel,
                                    SignupDataAccessInterface apiDataAccess){
        SignupController controller = createSignupUseCase(viewManagerModel,loginViewModel,signupViewModel,
                apiDataAccess);
        MenuOutputBoundary menuOutputBoundary = new MenuPresenter(viewManagerModel, menuViewModel);
        MenuInputBoundary menuInputBoundary = new MenuInteractor(menuOutputBoundary);
        MenuController menuController = MenuUseCaseFactory.createMenuController(menuInputBoundary);
        return new SignupView(controller,signupViewModel,menuController);

    }
    public static SignupController createSignupUseCase(ViewManagerModel viewManagerModel,
                                                       LoginViewModel loginViewModel,
                                                       SignupViewModel signupViewModel,
                                                       SignupDataAccessInterface apiDataAccess){
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel,loginViewModel);
        UserFactory factory = new CommonUserFactory();
        SignupInputBoundary signupInputBoundary = new SignupInteractor(apiDataAccess,signupOutputBoundary,factory);
        return new SignupController(signupInputBoundary);
    }
}
