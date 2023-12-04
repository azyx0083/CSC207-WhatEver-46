package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

/**
 * Controller for signup usecase
 */
public class SignupController {

    final SignupInputBoundary userSignupUseCaseInteractor;

    /**
     * Initialize a SignupController
     * @param userSignupUseCaseInteractor the interactor of signup usecase
     */
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * execute the interactor to save the user
     * @param username the username of this usecase
     * @param password1 the password
     * @param password2 the repeated password
     */
    public void execute(String username, String password1, String password2) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2);

        userSignupUseCaseInteractor.execute(signupInputData);
    }

    /**
     * When called, switch the current View(whatever it is) to LoginView
     */
    public void jumpToSignup(){
        userSignupUseCaseInteractor.jumpToSignup();
    }
}