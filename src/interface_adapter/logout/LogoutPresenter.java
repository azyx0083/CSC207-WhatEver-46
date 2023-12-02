package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import use_case.logout.LogoutOutputBoundary;

public class LogoutPresenter implements LogoutOutputBoundary {
    private final MenuViewModel menuViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a LogoutPresenter.
     * @param menuViewModel the view model for menu.
     * @param viewManagerModel the model that manages all views.
     */
    public LogoutPresenter(MenuViewModel menuViewModel, ViewManagerModel viewManagerModel) {
        this.menuViewModel = menuViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view given that the logout process succeeded.
     */
    @Override
    public void prepareSuccessView() {
        MenuState menuState = menuViewModel.getState();
        menuState.setUsername(null); // clear the current user from menuState.
        this.menuViewModel.setState(menuState);
        menuViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(menuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
