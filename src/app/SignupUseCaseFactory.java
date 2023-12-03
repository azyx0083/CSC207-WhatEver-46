package app;

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
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupUserDataAccessInterface;
import view.SignupView;

public class SignupUseCaseFactory {
    public static SignupView createSignupView(ViewManagerModel viewManagerModel,
                                    SignupViewModel signupViewModel,
                                    MenuViewModel menuViewModel,
                                    LoginViewModel loginViewModel,
                                    SignupUserDataAccessInterface apiDataAccess){
        SignupController controller = createSignupUseCase(viewManagerModel,loginViewModel,signupViewModel,
                apiDataAccess);
        MenuController menuController = MenuUseCaseFactory.createMenuController(viewManagerModel,menuViewModel);
        return new SignupView(controller,signupViewModel,menuController);

    }
    public static SignupController createSignupUseCase(ViewManagerModel viewManagerModel,
                                                       LoginViewModel loginViewModel,
                                                       SignupViewModel signupViewModel,
                                                       SignupUserDataAccessInterface apiDataAccess){
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel,loginViewModel);
        SignupInputBoundary signupInputBoundary = new SignupInteractor(apiDataAccess,signupOutputBoundary);
        return new SignupController(signupInputBoundary);
    }
}
