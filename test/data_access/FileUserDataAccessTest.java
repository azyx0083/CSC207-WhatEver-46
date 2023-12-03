package data_access;

import entity.User;
import entity.UserSetting;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileUserDataAccessTest {
    static FileUserDataAccess fileUserDataAccess;
    static String path = "file.txt";
    static User validUser;

    @BeforeAll
    static void setUp() {
        fileUserDataAccess = new FileUserDataAccess(path);

        validUser = new User("aa", "aaaa", new UserSetting("1day", 12));
    }

    @BeforeEach
    void clearUsers() {
        fileUserDataAccess.clear();
        assert fileUserDataAccess.getAccounts().isEmpty();
    }

    @Test
    void testSignUp() {
        // given the assumption that the user been saved must be valid
        // only check that the user been to the account Map and written to the file
        fileUserDataAccess.save(validUser);
        assert fileUserDataAccess.getAccounts().containsKey(validUser.getUsername());
        assert fileUserDataAccess.get(validUser.getUsername()).equals(validUser);
        FileUserDataAccess checker = new FileUserDataAccess(path);
        assert checker.isValid(validUser.getUsername());
    }
}