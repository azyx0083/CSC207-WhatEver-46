package entity;

/**
 * Represent a default user (or guest user) when the client haven't logged in.
 */
public class DefaultUser extends User{
    /**
     * Initializing a default user with no username, password or favouriteStocks. The searchHistory initialize as an
     * empty HashMap, and all stock's historicalPrice would follow the default time interval of 1day and default output
     * size of 30.
     */
    public DefaultUser() {
        super(null, null, null,"1day", 30);
    }
}
