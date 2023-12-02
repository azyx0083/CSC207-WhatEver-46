package use_case.search;

import entity.User;

import java.util.Map;

public interface SearchFileUserDataAccessInterface {
    void save(User user);
    Map<String, User> getAccounts();
    User get(String username);
}
