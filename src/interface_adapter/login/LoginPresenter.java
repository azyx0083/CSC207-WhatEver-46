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

    /**
     * initialize the LoginPresenter
     * @param viewManagerModel the ViewModel that using to switch between different Views
     * @param menuViewModel the ViewModel that contains all information required to prepare a MenuView
     * @param loginViewModel the ViewModel that contains all information required to prepare a LoginView
     */
    public LoginPresenter(ViewManagerModel viewManagerModel,
                          MenuViewModel menuViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.menuViewModel = menuViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * When the usecase succeed, presenter will pass the data to MenuView and switch current View to
     * MenuView
     * @param response the data required for prepare
     */
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

    /**
     * When the usecase failed, presenter will set up the error in LoginView by given message
     * @param error the message of error
     */
    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }

    /**
     * When called, Presenter will switch current View to LoginView and mention the ViewManager
     * Model that the property was changed
     */
    @Override
    public void jumpToLogin() {
        loginViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


}
