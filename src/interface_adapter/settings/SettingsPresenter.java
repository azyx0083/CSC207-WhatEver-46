package interface_adapter.settings;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuViewModel;
import use_case.settings.SettingsOutputBoundary;
import use_case.settings.SettingsOutputData;

public class SettingsPresenter implements SettingsOutputBoundary {
    private final SettingsViewModel settingsViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructor class. Commits to memory the view models associated with settings.
     * @param viewManagerModel view manager model for all views
     * @param settingsViewModel view model for settings
     */
    public SettingsPresenter(ViewManagerModel viewManagerModel, SettingsViewModel settingsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.settingsViewModel = settingsViewModel;
    }
    @Override
    public void prepareSettingsView(SettingsOutputData settingsOutputData) {
        SettingsState state = settingsViewModel.getState();
        state.setInterval(settingsOutputData.getInterval());
        state.setDataSize(settingsOutputData.getDataSize());
        state.setFavorites(settingsOutputData.getFavorites());
        settingsViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(settingsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
