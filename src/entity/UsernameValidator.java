package entity;

public class UsernameValidator {
    public boolean usernameIsValid(String username){return username != null && !username.isEmpty()  && username.length() <= 7;}
}
