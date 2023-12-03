package use_case.settings;

import entity.User;

public interface SettingsDataAccessInterface {
    public User get(String username);
}
