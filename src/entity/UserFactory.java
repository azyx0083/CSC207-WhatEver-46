package entity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    public static User createUser(String username, String password, String interval, int outputSize, JSONObject favouriteStocks) {
        Map<String, Stock> stocks = new HashMap<>();
        for (String symbol : favouriteStocks.keySet()) {
            JSONObject object = favouriteStocks.getJSONObject(symbol);
            Stock stock = new Stock(object.getString("symbol"));
            stock.setInfo(object.getString("name"), object.getString("exchange"),
                    object.getString("currency"), object.getString("country"), object.getString("type"));
            stocks.put(symbol, stock);
        }
        return new User(username, password, new UserSetting(stocks, interval, outputSize));
    }

    public static User createUser(String username, String password, String interval, int outputSize, Map<String, Stock> favouriteStocks) {
        return new User(username, password, new UserSetting(favouriteStocks, interval, outputSize));
    }

    public static DefaultUser createDefaultUser() {
        return new DefaultUser();
    }
}
