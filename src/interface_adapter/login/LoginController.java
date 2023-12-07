package interface_adapter.login;

import use_case.login.LoginInputData;
import use_case.login.LoginInputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

/**
 * Controller for login usecase
 */
public class LoginController {

    final LoginInputBoundary loginUseCaseInteractor;

    /**
     * initialize a LoginController
     * @param loginUseCaseInteractor the interactor of login usecase that actual
     *                               data will send to
     */
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * construct a LoginInputData by given data and execute the interactor to let
     * the user login
     * @param username the name of user that want to log in
     * @param password corresponding password
     */
    public void execute(String username, String password) {
        LoginInputData loginInputData = new LoginInputData(
                username, password);

        loginUseCaseInteractor.execute(loginInputData);
    }

    /**
     * When called, switch the current View(whatever it is) to SignupView
     */
    public void jumpToLogin(){
        loginUseCaseInteractor.jumpToLogin();
    }
}
