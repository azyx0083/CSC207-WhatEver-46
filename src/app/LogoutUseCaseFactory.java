package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.menu.MenuViewModel;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;

public class LogoutUseCaseFactory {
    public static LogoutController createLogoutUseCase(MenuViewModel menuViewModel, ViewManagerModel viewManagerModel) {
        LogoutOutputBoundary logoutPresenter = new LogoutPresenter(menuViewModel, viewManagerModel);
        LogoutInputBoundary logoutInteractor = new LogoutInteractor(logoutPresenter);
        return new LogoutController(logoutInteractor);
    }

}
