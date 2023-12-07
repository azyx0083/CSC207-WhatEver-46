package use_case.login;

import entity.User;

/**
 * FileDataAccessInterface contains methods Login interactor need
 */
public interface LoginUserDataAccessInterface {
    /**
     * Check if the username is in file
     * @param identifier name that want to check
     * @return True if in file, False if not
     */
    boolean isValid(String identifier);

    /**
     * save the user in file
     * @param user the user that need to save
     */
    void save(User user);

    /**
     * Get the user object with corresponding to given username
     * @param username user's name as an identifier
     * @return the Object corresponding with this identifier
     */
    User get(String username);
}
