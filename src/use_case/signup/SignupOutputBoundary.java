package use_case.signup;

public interface SignupOutputBoundary {
    /**
     * prepare a visualization of successful usecase
     * @param user the data required for prepare
     */
    void prepareSuccessView(SignupOutputData user);

    /**
     * prepare a visualization of failed usecase
     * @param error the type of error caused by the usecase
     */
    void prepareFailView(String error);
    void jumpToSignup();
}