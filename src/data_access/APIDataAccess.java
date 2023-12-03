package data_access;

import entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.search.SearchAPIDataAccessInterface;
import use_case.single_stock.SingleStockAPIDataAccessInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * DataAccessObject that is responsible for all API calls
 */
public class APIDataAccess implements SingleStockAPIDataAccessInterface, SearchAPIDataAccessInterface {
    private static final String API_KEY = "e8af6cedf9mshf35e68a5b040250p12fc53jsne75b26c51cd0";
    private final Map<String, Stock> searchHistories;

    public APIDataAccess() {
        searchHistories = new HashMap<>();
    }

    /**
     * Set the HistoricalPrice and Exchange for the given stock using responses from the api call time series
     * @param symbol the stock symbol required for the api call
     * @param interval the time interval required for the api call
     * @param outputSize the output size required for the api call
     * @param stock the stock that need to be updated
     * @throws Exception if reach the limited number of api calls per minute
     * @throws IOException if the parameter symbol is not a valid symbol
     */
    private String setHistoricalPrice(String symbol, String interval, int outputSize, Stock stock) throws Exception{
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/time_series?symbol=%s&interval=%s&outputsize=%s",
                        symbol, interval, outputSize))
                .addHeader("X-RapidAPI-Key", API_KEY)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        JSONObject responseBody = new JSONObject(response.body().string());

        if (responseBody.getString("status").equals("ok")) {
            JSONArray data = responseBody.getJSONArray("values");
            HistoricalPrice prices = new HistoricalPrice(outputSize);
            for (int i = 0; i < outputSize; i++)
                prices.addPrice(i, data.getJSONObject(i).getString("datetime"),
                        data.getJSONObject(i).getFloat("open"), data.getJSONObject(i).getFloat("close"),
                        data.getJSONObject(i).getFloat("high"), data.getJSONObject(i).getFloat("low"),
                        data.getJSONObject(i).getInt("volume"));
            stock.setHistoricalPrice(prices);
            return responseBody.getJSONObject("meta").getString("exchange");
        } else
            throw new IOException();
    }

    /**
     * Set the detailed info including stock name, currency, country and type for the given stock using response from
     * the api call stocks list.
     * @param symbol the stock symbol required for the api call
     * @param exchange the stock market exchange of the stock
     * @param stock the stock that need to be updated
     * @throws Exception if reach the limited number of api calls per minute
     */
    private void setInfo(String symbol, String exchange, Stock stock) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/stocks?symbol=%s&exchange=%s",
                        symbol, exchange))
                .addHeader("X-RapidAPI-Key", API_KEY)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        JSONObject responseBody = new JSONObject(response.body().string());

        if (responseBody.has("data")) {
            JSONObject info = responseBody.getJSONArray("data").getJSONObject(0);
            stock.setInfo(info.getString("name"), exchange, info.getString("currency"),
                    info.getString("country"), info.getString("type"));
        } else
            throw new Exception(responseBody.getString("message"));
    }

    /**
     * Set the current price for the given stock using response from the api call real-time price
     * @param symbol the stock symbol required for the api call
     * @param stock the stock that need to be updated
     * @throws Exception if reach the limited number of api calls per minute
     */
    private void setCurrentPrice(String symbol, Stock stock) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/price?symbol=%s",
                        symbol))
                .addHeader("X-RapidAPI-Key", API_KEY)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        JSONObject responseBody = new JSONObject(response.body().string());

        if (responseBody.has("price"))
            stock.setCurrentPrice(responseBody.getFloat("price"));
        else
            throw new Exception(responseBody.getString("message"));
    }

    /**
     * Using three api calls to search for the given stock symbol and store a corresponding Stock in the searchHistory
     * @param symbol the stock symbol that used to perform stock search
     * @param setting the user setting that customize the api calls
     * @return If symbol is valid, return null. Otherwise, return the error message based on the type of exception been
     * catch.
     */
    public String search(String symbol, UserSetting setting) {
        try {
            if (searchHistories.containsKey(symbol)) {
                setCurrentPrice(symbol, searchHistories.get(symbol));
            } else {
                Stock stock = new Stock(symbol);
                String exchange = setHistoricalPrice(symbol, setting.getInterval(), setting.getOutputSize(), stock);
                setInfo(symbol, exchange, stock);
                setCurrentPrice(symbol, stock);
                searchHistories.put(symbol, stock);
            }
            return null;
        } catch (IOException e) {
            return String.format("%s is not a valid symbol. Please enter a correct stock symbol.", symbol);
        } catch (Exception e) {
            return "Frequent request. Please try again in one minute.";
        }
    }

    /**
     *
     * @param symbol the stock symbol
     * @return the Stock with given stock symbol from currentUser's searchHistory
     */
    public Stock getStock(String symbol) {
        return searchHistories.get(symbol);
    }

    /**
     *
     * @param symbol the stock symbol
     * @return the stock name correspond to the given stock symbol
     */
    public String getName(String symbol) {
        return searchHistories.get(symbol).getName();
    }

    // For testing purpose only
    public Map<String, Stock> getSearchHistories() {
        return searchHistories;
    }
}
