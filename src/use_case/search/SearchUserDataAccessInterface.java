package use_case.search;

import entity.User;

public interface SearchUserDataAccessInterface {
    User get(String username);
}
