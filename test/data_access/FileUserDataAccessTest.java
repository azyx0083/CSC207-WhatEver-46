package data_access;

import entity.Stock;
import entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class FileUserDataAccessTest {
    static FileUserDataAccess fileUserDataAccess;
    static String path = "file.txt";
    static User validUser;

    @BeforeAll
    static void setUp() {
        fileUserDataAccess = new FileUserDataAccess(path);

        validUser = new User("aa", "aaaa", new HashMap<>(), "fwwqw", 12);
        Stock stock1 = new Stock("amzn");
        stock1.setInfo("amazon", "NYSE", "USD", "america", "common");
        validUser.getSetting().addFavouriteStock(stock1);

        Stock stock2 = new Stock("AAPL");
        stock2.setInfo("apple", "NYSE", "USD", "america", "common");
        validUser.getSetting().addFavouriteStock(stock2);
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