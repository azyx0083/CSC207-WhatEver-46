package use_case.signup;

public interface SignupInputBoundary {
    /**
     * Let the SignupInteractor execute the use case using given data
     * @param signupInputData contains the data needed for signup
     */
    void execute(SignupInputData signupInputData);

    /**
     * Switch the current View(whatever it is) to SignupView
     */
    void jumpToSignup();
}