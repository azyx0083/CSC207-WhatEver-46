package interface_adapter.settings;

import use_case.settings.SettingsInputBoundary;
import use_case.settings.SettingsInputData;

public class SettingsController {
    final SettingsInputBoundary settingsInputBoundary;

    /**
     * Constructor; just assigns a SettingsInputBoundary.
     * @param settingsInputBoundary
     */
    public SettingsController(SettingsInputBoundary settingsInputBoundary) {
        this.settingsInputBoundary = settingsInputBoundary;
    }

    /**
     * calls the interactor to apply given changes to a user's settings
     * @param interval the interval each stock period encompasses
     * @param dataSize the number of periods to track
     * @param username user's username
     */
    public void applyChanges(String interval, int dataSize, String username) {
        SettingsInputData settingsInputData = new SettingsInputData(interval, dataSize, username);

        settingsInputBoundary.applyChanges(settingsInputData);
    }

    public void goToSettings(String username) {
        settingsInputBoundary.goToSettings(username);
    }
}
