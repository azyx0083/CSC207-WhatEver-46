package use_case.settings;

public interface SettingsInputBoundary {
    void applyChanges(SettingsInputData settingsInputData);
    void goToSettings(String username);
}
