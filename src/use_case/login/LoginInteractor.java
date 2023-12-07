package use_case.login;

import entity.PasswordValidator;
import entity.User;

/**
 * the interactor for Login use case
 */
public class LoginInteractor implements LoginInputBoundary {
    final LoginUserDataAccessInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    /**
     * initialize a login interactor
     * @param userDataAccessInterface the DAO object to let loginInteractor have access to
     *                                database
     * @param loginOutputBoundary the login presenter
     */
    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    /**
     * Check if the database have stored the info of the User that want to log in.
     * @param loginInputData Stored the info about the user
     */
    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.isValid(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String pwd = userDataAccessObject.get(username).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                User user = userDataAccessObject.get(loginInputData.getUsername());

                LoginOutputData loginOutputData = new LoginOutputData(user.getUsername(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }

    /**
     * When called, Interactor will call the Presenter(by direct call OutputBoundary) and ask
     * it to switch current View(whatever current View is) to LoginView.
     */
    @Override
    public void jumpToLogin() {
        loginPresenter.jumpToLogin();
    }
}
