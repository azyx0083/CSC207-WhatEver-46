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
    /**
     * Creates an instance of MenuView. Should only ever be called once.
     * @param viewManagerModel
     * @param menuViewModel
     * @return a new MenuView object
     */
    public static MenuView create(ViewManagerModel viewManagerModel, MenuViewModel menuViewModel) {
        MenuController menuController = createMenuController(viewManagerModel, menuViewModel);
        return new MenuView(menuController, menuViewModel);
    }

    /**
     * Helper method for MenuUseCaseFactory.create(). Static as other views may need a MenuController.
     * @param viewManagerModel master manager model
     * @param menuViewModel the menu view model
     * @return new MenuController object.
     */
    public static MenuController createMenuController(ViewManagerModel viewManagerModel, MenuViewModel menuViewModel) {
        MenuOutputBoundary menuOutputBoundary = new MenuPresenter(viewManagerModel, menuViewModel);
        MenuInputBoundary menuInputBoundary = new MenuInteractor(menuOutputBoundary);
        return new MenuController(menuInputBoundary);
    }
}
