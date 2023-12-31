package data_access;

import entity.User;
import entity.UserFactory;
import use_case.login.LoginUserDataAccessInterface;
import use_case.search.SearchUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;
//import use_case.search.SearchUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * InMemory version of the UserDataAccessObject to test the usecase interactors
 */
public class InMemoryUserDataAccess implements SearchUserDataAccessInterface, SignupUserDataAccessInterface, LoginUserDataAccessInterface {
    // For the testing purpose only
    private final Map<String, User> accounts = new HashMap<>();

    /**
     * Save the new user
     * @param user the new user that need to be saved
     */
    public void save(User user) {
        accounts.put(user.getUsername(), user);
    }

    @Override
    public boolean isValid(String username) {
        return accounts.containsKey(username);
    }

    /**
     * @return the Map with all existing users
     *         the keys are the String representation of username
     *         the values are the corresponding User
     * For Testing Purpose only
     */
    public Map<String, User> getAccounts() {
        return accounts;
    }

    /**
     * @param username a valid username or null
     * @return the corresponding User, or a DefaultUser if the parameter is null
     */
    public User get(String username) {
        if (username == null)
            return UserFactory.createDefaultUser();
        return accounts.get(username);
    }
}
