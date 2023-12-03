package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuPresenter;
import interface_adapter.menu.MenuViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;
import use_case.menu.MenuInputBoundary;
import use_case.menu.MenuInteractor;
import use_case.menu.MenuOutputBoundary;
import view.LoginView;

import java.io.IOException;

public class LoginUseCaseFactory {
    public static LoginView createLoginView(ViewManagerModel viewManagerModel,
                                            LoginViewModel loginViewModel,
                                            MenuViewModel menuViewModel,
                                            LoginUserDataAccessInterface apiDataAccess){
        LoginController loginController = createLoginUseCase(viewManagerModel,
                loginViewModel,menuViewModel,apiDataAccess);
        MenuOutputBoundary menuOutputBoundary = new MenuPresenter(viewManagerModel, menuViewModel);
        MenuInputBoundary menuInputBoundary = new MenuInteractor(menuOutputBoundary);
        MenuController menuController = MenuUseCaseFactory.createMenuController(menuInputBoundary);
        return new LoginView(loginViewModel,loginController,menuController);
    }

    public static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            MenuViewModel menuViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, menuViewModel, loginViewModel);

        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }
}