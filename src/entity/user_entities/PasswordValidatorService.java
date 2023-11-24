package entity.user_entities;

public class PasswordValidatorService implements PasswordValidator{
    public boolean passwordIsValid(String password){ return password != null;}
}
