package interface_adapter.signup;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

public class SignupPresenter implements SignupOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Initialize the SignupPresenter
     * @param viewManagerModel the ViewModel that trigger the switch to a new view
     * @param signupViewModel the ViewModel that contains all information required to prepare a SignupView
     * @param loginViewModel the ViewModel that need to switched to
     */
    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * When the usecase success, presenter will pass the data to LoginView and
     * switch current View to LoginView
     * @param response the data that loginView needed
     */
    @Override
    public void prepareSuccessView(SignupOutputData response) {
        // On success, switch to the login view.
        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * When the usecase failed, presenter will set up the error that SignupView needed to show
     * @param error the type of error caused by the usecase
     */
    @Override
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setError(error);
        signupViewModel.firePropertyChanged();
    }

    @Override
    public void jumpToSignup() {
        viewManagerModel.setActiveView(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


}