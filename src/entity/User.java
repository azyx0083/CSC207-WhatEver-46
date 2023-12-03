package entity;

/**
 * Represent a user.
 */
public class User {
    private final String username;
    private final String password;
    private final UserSetting setting;

    /**
     * Initializing a User with given username, password, list of favourite stocks and customized setting of time interval
     * and output size.
     * @param username the username for the current user
     * @param password the password for the current user
     * @param setting the customized setting for the current user
     */
    public User(String username, String password, UserSetting setting) {
        this.username = username;
        this.password = password;
        this.setting = setting;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserSetting getSetting() {
        return setting;
    }
}
