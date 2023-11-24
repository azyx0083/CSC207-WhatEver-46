package entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Represent a user.
 */
public class User {
    private final String username;
    private final String password;
    private final Map<String, Stock> favouriteStocks;
    private Map<String, Stock> searchHistories;
    private String interval;
    private int outputSize;

    /**
     * Initializing a User with given username, password, list of favourite stocks and customized setting of time interval
     * and output size.
     * @param username the username for the current user
     * @param password the password for the current user
     * @param favouriteStocks the list of favourite stocks for the current user
     * @param interval the customized setting of time interval for stock's historicalPrice
     * @param outputSize the customized setting of output size for stock's historicalPrice
     */
    User(String username, String password, Map<String, Stock> favouriteStocks,
         String interval, int outputSize) {
        this.username = username;
        this.password = password;
        this.favouriteStocks = favouriteStocks;
        this.searchHistories = new HashMap<>();
        this.interval = interval;
        this.outputSize = outputSize;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, Stock> getFavouriteStocks() {
        return favouriteStocks;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public int getOutputSize() {
        return outputSize;
    }

    public void setOutputSize(int outputSize) {
        this.outputSize = outputSize;
    }

    public Map<String, Stock> getSearchHistories() {
        return searchHistories;
    }

    public void setSearchHistories(Map<String, Stock> searchHistories) {
        this.searchHistories = searchHistories;
    }
}
