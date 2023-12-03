package use_case.settings;

import entity.User;

public interface SettingsUserDataAccessInterface {
    public User get(String username);
}
