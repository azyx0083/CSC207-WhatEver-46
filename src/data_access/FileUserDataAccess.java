package data_access;

import entity.User;
import entity.UserFactory;
import org.json.JSONObject;
//import use_case.search.SearchUserDataAccessInterface;
import use_case.settings.SettingsUserDataAccessInterface;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * DataAccessObject responsible for user tracking
 */
public class FileUserDataAccess implements /**SearchUserDataAccessInterface,**/ SettingsUserDataAccessInterface {
    // Have a separate DataAccessObject to interact with the Users because users and API serve different purposes
    // Apply the Single Responsibility Principle
    private Path filePath;
    private Map<String, User> accounts;

    /**
     * Initialize a FileUserDataAccessObject that read and write to the file with given path
     * @param jsonPath the String of the path that the FileDataAccessObject is going to interact with
     */
    public FileUserDataAccess(String jsonPath) {
        try {
            this.accounts = new HashMap<>();
            this.filePath = Path.of(jsonPath);
            JSONObject file = new JSONObject(Files.readString(filePath));
            for (String username : file.keySet()) {
                JSONObject user = file.getJSONObject(username);
                JSONObject setting = user.getJSONObject("setting");
                // Use of the factory design pattern to construct the User
                // FileUserDataAccess is independent of implementation of User
                accounts.put(username, UserFactory.createUser(username, user.getString("password"),
                        setting.getString("interval"), setting.getInt("outputSize")));
            }
        } catch (Exception ignored) {
            this.accounts = new HashMap<>();
            this.filePath = Path.of(jsonPath);
        }
    }

    /**
     * Save the new user
     * @param user the new user that need to be saved
     */
    public void save(User user) {
        accounts.put(user.getUsername(), user);
        this.save();
    }

    /**
     * Private helper that write all existing users to the file
     */
    private void save() {
        try {
            Files.writeString(filePath, new JSONObject(accounts).toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the Map with all existing users
     *         the keys are the String representation of username
     *         the values are the corresponding User
     *  For Testing Purpose only
     */
    public Map<String, User> getAccounts() {
        return accounts;
    }

    /**
     * Delete all users
     * For testing purpose only
     */
    public void clear() {
        this.accounts = new HashMap<>();
        save();
    }

    /**
     * @param username a valid username or null
     * @return the corresponding User if username is valid
     *         a DefaultUser if username is null
     */
    public User get(String username) {
        if (username == null)
            return UserFactory.createDefaultUser();
        return accounts.get(username);
    }

    /**
     * @param username a username
     * @return true if and only if this username matches with one of the existing user
     */
    public boolean isValid(String username) {
        return accounts.containsKey(username);
    }

}
