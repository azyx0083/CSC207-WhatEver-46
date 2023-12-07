package use_case.login;

public interface LoginInputBoundary {
    /**
     * Let the LoginInteractor execute the use case using given data
     * @param loginInputData contains the data needed for login
     */
    void execute(LoginInputData loginInputData);

    /**
     * Switch the current View(whatever it is) to LoginView
     */
    void jumpToLogin();
}