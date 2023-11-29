package data_access;

import entity.User;
import use_case.logged_in.LoggedInDataAccessInterface;
import use_case.login.LoginDataAccessInterface;
import use_case.signup.SignupDataAccessInterface;

public class FileDataAccess implements SignupDataAccessInterface, LoginDataAccessInterface, LoggedInDataAccessInterface {
    public void save(User user){}

    @Override
    public boolean existsByName(String username) {
        return username.isEmpty();
    }

}
