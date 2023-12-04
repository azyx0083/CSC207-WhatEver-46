package interface_adapter.settings;

import interface_adapter.ViewManagerModel;
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

    /**
     * prepares settings view and fires associated property changes
     * @param settingsOutputData the outputdata to populate the settings view
     */
    @Override
    public void prepareSettingsView(SettingsOutputData settingsOutputData) {
        SettingsState state = settingsViewModel.getState();
        state.setInterval(settingsOutputData.getInterval());
        state.setDataSize(settingsOutputData.getDataSize());
        state.setUsername(settingsOutputData.getUsername());
//        state.setFavorites(settingsOutputData.getFavorites());
        state.setUsername(settingsOutputData.getUsername());
        settingsViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(settingsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
