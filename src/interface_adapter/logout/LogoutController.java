package interface_adapter.logout;

import use_case.logout.LogoutInputBoundary;

public class LogoutController {
    final LogoutInputBoundary userLogoutInteractor;

    /**
     * Assigns a LogoutInputBoundary
     * @param userLogoutInteractor the user interactor for the logout use case.
     */
    public LogoutController(LogoutInputBoundary userLogoutInteractor) {
        this.userLogoutInteractor = userLogoutInteractor;
    }

    /**
     * Notify the userLogoutInteractor to execute the logout process.
     */
    public void execute() {
        userLogoutInteractor.execute();
    }
}
