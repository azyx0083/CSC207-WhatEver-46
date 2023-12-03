package use_case.search;

import entity.User;

import java.util.Map;

public interface SearchFileUserDataAccessInterface {
    User get(String username);
}
