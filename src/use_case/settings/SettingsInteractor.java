package use_case.settings;

import use_case.settings.SettingsOutputBoundary;

public class SettingsInteractor implements SettingsInputBoundary{
    final SettingsOutputBoundary settingsPresenter;

    public SettingsInteractor(SettingsOutputBoundary settingsPresenter) {
        this.settingsPresenter = settingsPresenter;
    }
    @Override
    public void applyChanges(SettingsInputData settingsInputData) {

    }

    @Override
    public void goToSettings(String username) {

    }
}
