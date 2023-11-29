package entity.user_entities;

import entity.Stock;
import entity.User;

import java.util.Map;

public interface UserFactory {
    User create(String username, String password, Map<String, Stock> favouriteStocks,
                String interval, int outputSize);
}
