package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.signup.SignupState;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final MenuViewModel menuViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          MenuViewModel menuViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.menuViewModel = menuViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the menu view.

        MenuState menuState = menuViewModel.getState();
        menuState.setUsername(response.getUsername());
        menuViewModel.setState(menuState);
        menuViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(menuViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
