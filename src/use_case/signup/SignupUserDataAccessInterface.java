package use_case.signup;

import entity.User;

/**
 * FileDataAccessInterface contains methods Signup interactor need
 */
public interface SignupUserDataAccessInterface {
    /**
     * save the user in file
     * @param user the user that need to save
     */
    void save(User user);

    /**
     * Check if the username is in file
     * @param username name that want to check
     * @return True if in file, False if not
     */
    boolean isValid(String username);
}
