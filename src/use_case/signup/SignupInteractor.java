package use_case.signup;

import entity.PasswordValidator;
import entity.Stock;
import entity.User;
import entity.UserFactory;
import interface_adapter.signup.SignupPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * The interactor for Signup use case.
 */
public class SignupInteractor implements SignupInputBoundary {
    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;

    /**
     * initialize a signup interactor
     * @param signupDataAccessInterface the DAO object
     * @param signupOutputBoundary the signup presenter
     */
    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
    }

    /**
     * Create a User object via userFactory if the password is valid and the repeatPassword is matching the
     * password. If added, call the presenter to prepare successView, otherwise prepare the failView and set
     * the error
     * @param signupInputData using to get the username, password and the repeatPassword
     */
    @Override
    public void execute(SignupInputData signupInputData) {
        PasswordValidator validator = new PasswordValidator();
        if (!validator.passwordIsValid(signupInputData.getPassword())) {
            userPresenter.prepareFailView("Invalid Password");
        } else if (userDataAccessObject.isValid(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {
            User user = UserFactory.createNewUser(signupInputData.getUsername(), signupInputData.getPassword());
            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }

    @Override
    public void jumpToSignup() {
        userPresenter.jumpToSignup();
    }
}