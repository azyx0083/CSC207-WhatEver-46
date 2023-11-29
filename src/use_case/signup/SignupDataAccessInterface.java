package use_case.signup;

import entity.User;

public interface SignupDataAccessInterface {
    void save(User user);
    boolean existsByName(String username);
}
