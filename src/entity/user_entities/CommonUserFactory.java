package entity.user_entities;

public class CommonUserFactory implements UserFactory{
    public User create(String username, String password){ return new CommonUser(username, password);}
}
