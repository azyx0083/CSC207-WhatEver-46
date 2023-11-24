package data_access;

import entity.user_entities.User;
import use_case.logged_in.LoggedInDataAccessInterface;
import use_case.login.LoginDataAccessInterface;
import use_case.signup.SignupDataAccessInterface;

public class FileDataAccess implements SignupDataAccessInterface, LoginDataAccessInterface, LoggedInDataAccessInterface {
    public static void save(User user){}
}
