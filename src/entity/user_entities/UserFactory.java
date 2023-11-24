package entity.user_entities;

public interface UserFactory {
    User create(String username, String password);
}
