package entity;

public class UserFactory {
    public static User createUser(String username, String password, String interval, int outputSize) {
        return new User(username, password, new UserSetting(interval, outputSize));
    }

    public static User createNewUser(String username, String password) {
        return new User(username, password, new UserSetting("1day", 30));
    }

    public static User createDefaultUser() {
        return new User(null, null, new UserSetting("1day", 30));
    }
}
