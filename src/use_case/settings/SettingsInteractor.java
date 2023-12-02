package use_case.settings;

import use_case.menu.MenuOutputBoundary;

public class SettingsInteractor implements SettingsInputBoundary{
    final SettingsOutputBoundary settingsPresenter;

    public SettingsInteractor(SettingsOutputBoundary settingsPresenter) {
        this.settingsPresenter = settingsPresenter;
    }
    @Override
    public void applyChanges(SettingsInputData settingsInputData) {

    }
}
