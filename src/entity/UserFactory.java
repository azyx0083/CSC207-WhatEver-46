package entity;

import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    public static User createUser(String username, String password, String interval, int outputSize) {
        Map<String, Stock> stocks = new HashMap<>();
        return new User(username, password, new UserSetting(interval, outputSize));
    }

    public static User createDefaultUser() {
        return new User(null, null, new UserSetting("1day", 30));
    }
}
