package interface_adapter.menu;

import interface_adapter.ViewManagerModel;
import use_case.menu.MenuOutputBoundary;
import view.MenuView;

public class MenuPresenter implements MenuOutputBoundary {
    final MenuViewModel menuViewModel;
    ViewManagerModel viewManagerModel;

    /**
     * Constructor class. Commits to memory the view models associated with menu.
     * @param viewManagerModel view manager model for all views
     * @param menuViewModel view model for menu
     */
    public MenuPresenter(ViewManagerModel viewManagerModel, MenuViewModel menuViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.menuViewModel = menuViewModel;
    }

    /**
     * Changes active view to menu view and fires property changed.
     */
    @Override
    public void prepareMenuView() {
        menuViewModel.getState().setStockSymbol("");
        menuViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(menuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
