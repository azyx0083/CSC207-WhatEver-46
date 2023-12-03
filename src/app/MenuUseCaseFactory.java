package app;

import data_access.APIDataAccess;
import data_access.FileUserDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuPresenter;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchViewModel;
import interface_adapter.settings.SettingsController;
import interface_adapter.settings.SettingsViewModel;
import use_case.menu.MenuInputBoundary;
import use_case.menu.MenuInteractor;
import use_case.menu.MenuOutputBoundary;
import use_case.settings.SettingsUserDataAccessInterface;
import view.MenuView;

public class MenuUseCaseFactory {
    /**
     * Creates an instance of MenuView. Should only ever be called once.
     * @param viewManagerModel
     * @param menuViewModel
     * @return a new MenuView object
     */
    public static MenuView create(ViewManagerModel viewManagerModel, MenuViewModel menuViewModel,
                                  SearchViewModel searchViewModel, APIDataAccess apiDataAccess,
                                  SettingsUserDataAccessInterface userAccess, SettingsViewModel settingsViewModel,
                                  FileUserDataAccess fileUserDataAccess) {
        //MenuController menuController = createMenuController(viewManagerModel, menuViewModel);
        SearchController searchController = OptionsUseCaseFactory.createSearchUseCase(viewManagerModel, searchViewModel,
                menuViewModel, apiDataAccess, fileUserDataAccess);
        SettingsController settingsController = SettingsUseCaseFactory.createSettingsController(viewManagerModel, settingsViewModel,
                userAccess);
        return new MenuView(menuViewModel, searchController, settingsController);
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
