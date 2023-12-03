package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.settings.SettingsController;
import interface_adapter.settings.SettingsPresenter;
import interface_adapter.settings.SettingsViewModel;
import use_case.settings.*;
import view.SettingsView;

public class SettingsUseCaseFactory {
    public static SettingsView create(ViewManagerModel viewManagerModel, SettingsViewModel settingsViewModel,
                                      MenuViewModel menuViewModel, SettingsDataAccessInterface userAccess,
                                      APIDataAccess apiAccess) {
        SettingsController settingsController = createSettingsController(viewManagerModel, settingsViewModel,
                userAccess, apiAccess);
        MenuController menuController = MenuUseCaseFactory.createMenuController(viewManagerModel, menuViewModel);
        return new SettingsView(settingsController, settingsViewModel, menuController);
    }

    public static SettingsController createSettingsController(ViewManagerModel viewManagerModel,
                                                              SettingsViewModel settingsViewModel,
                                                              SettingsDataAccessInterface userAccess,
                                                              APIDataAccess apiAccess) {
        SettingsOutputBoundary presenter = new SettingsPresenter(viewManagerModel, settingsViewModel);
        SettingsInputBoundary interactor = new SettingsInteractor(presenter, userAccess, apiAccess);

        return new SettingsController(interactor);
    }
}
