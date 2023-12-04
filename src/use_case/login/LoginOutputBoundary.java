package use_case.login;

public interface LoginOutputBoundary {
    /**
     * prepare a visualization of succeed usecase
     * @param user the data required for prepare
     */
    void prepareSuccessView(LoginOutputData user);

    /**
     * prepare a visualization of failed usecase
     * @param error the message of error
     */
    void prepareFailView(String error);

    /**
     * Switch the current View(whatever it is) to LoginView
     */
    void jumpToLogin();
}
