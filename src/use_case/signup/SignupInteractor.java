package use_case.signup;

import entity.*;
import interface_adapter.signup.SignupPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * The interactor for Signup use case.
 */
public class SignupInteractor implements SignupInputBoundary {
    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final PasswordValidator passwordValidator;
    final UsernameValidator usernameValidator;

    /**
     * initialize a signup interactor
     * @param signupDataAccessInterface the DAO object
     * @param signupOutputBoundary the signup presenter
     */
    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.passwordValidator = new PasswordValidator();
        this.usernameValidator = new UsernameValidator();
    }

    /**
     * Create a User object via userFactory if the password is valid and the repeatPassword is matching the
     * password. If added, call the presenter to prepare successView, otherwise prepare the failView and set
     * the error
     * @param signupInputData using to get the username, password and the repeatPassword
     */
    @Override
    public void execute(SignupInputData signupInputData) {
        if (!usernameValidator.usernameIsValid(signupInputData.getUsername())) {
            userPresenter.prepareFailView("Invalid Username");
        } else if (!passwordValidator.passwordIsValid(signupInputData.getPassword())) {
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

    /**
     * When called, Interactor will call the Presenter(by direct call OutputBoundary) and ask
     * it to switch current View(whatever current View is) to SignupView.
     */
    @Override
    public void jumpToSignup() {
        userPresenter.jumpToSignup();
    }
}