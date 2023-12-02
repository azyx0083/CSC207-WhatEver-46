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

    public void applyChanges(String interval, int dataSize, String[] favorites) {
        SettingsInputData settingsInputData = new SettingsInputData(interval, dataSize, favorites);

        settingsInputBoundary.applyChanges(settingsInputData);
    }
}
