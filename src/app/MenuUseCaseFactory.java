package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuPresenter;
import interface_adapter.menu.MenuViewModel;
import use_case.menu.MenuInputBoundary;
import use_case.menu.MenuInteractor;
import use_case.menu.MenuOutputBoundary;
import view.MenuView;

public class MenuUseCaseFactory {
    public static MenuView create(ViewManagerModel viewManagerModel, MenuViewModel menuViewModel) {
        MenuOutputBoundary menuOutputBoundary = new MenuPresenter(viewManagerModel, menuViewModel);
        MenuInputBoundary menuInputBoundary = new MenuInteractor(menuOutputBoundary);
        MenuController menuController = new MenuController(menuInputBoundary);
        return new MenuView(menuController, menuViewModel);
    }
}
