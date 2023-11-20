package interface_adapter.menu;

import interface_adapter.ViewManagerModel;
import use_case.menu.MenuOutputBoundary;
import view.MenuView;

public class MenuPresenter implements MenuOutputBoundary {
    final MenuViewModel menuViewModel;
    ViewManagerModel viewManagerModel;

    public MenuPresenter(ViewManagerModel viewManagerModel, MenuViewModel menuViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.menuViewModel = menuViewModel;
    }
    @Override
    public void prepareMenuView() {
        viewManagerModel.setActiveView(menuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
