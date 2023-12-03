package use_case.login;

import entity.User;

public interface LoginUserDataAccessInterface {
    boolean isValid(String identifier);

    void save(User user);

    User get(String username);
}
