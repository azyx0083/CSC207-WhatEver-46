package data_access;

import entity.DefaultUser;
import entity.User;
import use_case.logged_in.LoggedInDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupDataAccessInterface;

public class FileDataAccess implements SignupDataAccessInterface, LoginUserDataAccessInterface, LoggedInDataAccessInterface {
    public void save(User user){}

    @Override
    public User get(String username) {
        return new DefaultUser();
    }

    @Override
    public boolean existsByName(String username) {
        return username.isEmpty();
    }



}
