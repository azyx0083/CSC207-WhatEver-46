package use_case.settings;

import entity.User;

public interface SettingsUserDataAccessInterface {
    User get(String username);
}
