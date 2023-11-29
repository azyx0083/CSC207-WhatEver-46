package entity.user_entities;

import entity.Stock;
import entity.User;

import java.util.Map;

public class CommonUserFactory implements UserFactory{
    public User create(String username, String password, Map<String, Stock> favouriteStocks,
                       String interval, int outputSize){
        return new User(username, password,favouriteStocks,interval, outputSize);
    }
}
