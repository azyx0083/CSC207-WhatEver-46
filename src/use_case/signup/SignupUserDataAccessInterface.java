package use_case.signup;

import entity.User;

/**
 * APIDataAccessInterface for signup use case
 */
public interface SignupUserDataAccessInterface {
    /**
     * save the user in file
     * @param user the user that need to save
     */
    void save(User user);
    boolean isValid(String username);
}
