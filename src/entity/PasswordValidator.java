package entity;

public class PasswordValidator {
    public boolean passwordIsValid(String password){return password != null && password.length() > 5;}
}
