package use_case.signup;

public interface SignupOutputBoundary {
    /**
     * prepare a visualization of successful usecase
     * @param user the data required for prepare
     */
    void prepareSuccessView(SignupOutputData user);

    /**
     * prepare a visualization of failed usecase
     * @param error the message of error
     */
    void prepareFailView(String error);

    /**
     * Switch the current View(whatever it is) to SignupView
     */
    void jumpToSignup();
}