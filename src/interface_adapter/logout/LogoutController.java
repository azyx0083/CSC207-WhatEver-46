package interface_adapter.logout;

import use_case.logout.LogoutInputBoundary;

public class LogoutController {
    final LogoutInputBoundary userLogoutInteractor;

    public LogoutController(LogoutInputBoundary userLogoutInteractor) {
        this.userLogoutInteractor = userLogoutInteractor;
    }

    public void execute() {
        userLogoutInteractor.execute();
    }
}
