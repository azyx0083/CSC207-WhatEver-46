package data_access;

import entity.*;
import org.json.JSONArray;
import use_case.search.SearchAPIDataAccessInterface;
import use_case.single_stock.SingleStockAPIDataAccessInterface;

import java.io.IOException;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;


/**
 *
 */
public class APIDataAccess implements SingleStockAPIDataAccessInterface, SearchAPIDataAccessInterface {
    final private String APIkey = "e8af6cedf9mshf35e68a5b040250p12fc53jsne75b26c51cd0";
    private User currentUser = new DefaultUser();

    public APIDataAccess() {
    }

    /**
     * Set the HistoricalPrice and Exchange for the given stock using responses from the api call time series
     * @param symbol the stock symbol required for the api call
     * @param interval the time interval required for the api call
     * @param outputSize the output size required for the api call
     * @param stock the stock that need to be updated
     * @throws Exception if reach the limited number of api calls per minute
     * @throws IOException if the parameter symbol is not a valid symbol; throw an Exception
     */
    public void setHistoricalPrice(String symbol, String interval, int outputSize, Stock stock) throws Exception{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/time_series?symbol=%s&interval=%s&outputsize=%s",
                        symbol, interval, outputSize))
                .get()
                .addHeader("X-RapidAPI-Key", APIkey)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        assert response.body() != null;
        JSONObject responseBody = new JSONObject(response.body().string());

        if (responseBody.getString("status").equals("ok")) {
            JSONArray data = responseBody.getJSONArray("values");
            String exchange = responseBody.getJSONObject("meta").getString("exchange");
            stock.setExchange(exchange);
            stock.update();
            for (int i = 0; i < outputSize; i++) {
                JSONObject price = data.getJSONObject(i);
                StockPrice stockprice =  new StockPrice(price.getString("datetime"), price.getFloat("high"),
                        price.getFloat("low"), price.getFloat("open"), price.getFloat("close"),
                        price.getInt("volume"));
                // create the StockPrice object first before inject into Stock object
                // Dependency injection
                stock.addPrice(stockprice);
            }
        } else {
            throw new IOException();
        }
    }

    /**
     * Set the detailed info including stock name, currency, country and type for the given stock using response from
     * the api call stocks list.
     * @param symbol the stock symbol required for the api call
     * @param stock the stock that need to be updated
     * @throws Exception if reach the limited number of api calls per minute
     */
    private void setInfo(String symbol, Stock stock) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/stocks?symbol=%s&exchange=%s",
                        symbol, stock.getExchange()))
                .get()
                .addHeader("X-RapidAPI-Key", APIkey)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        assert response.body() != null;
        JSONObject responseBody = new JSONObject(response.body().string());

        if (responseBody.has("data")) {
            JSONArray data = responseBody.getJSONArray("data");
            JSONObject info = data.getJSONObject(0);
            stock.setName(info.getString("name"));
            stock.setCurrency(info.getString("currency"));
            stock.setCountry(info.getString("country"));
            stock.setType(info.getString("type"));
        } else {
            throw new Exception(responseBody.getString("message"));
        }
    }

    /**
     * Set the current price for the given stock using response from the api call real-time price
     * @param symbol the stock symbol required for the api call
     * @param stock the stock that need to be updated
     * @throws Exception if reach the limited number of api calls per minute
     */
    private void setCurrentPrice(String symbol, Stock stock) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/price?symbol=%s",
                        symbol))
                .get()
                .addHeader("X-RapidAPI-Key", APIkey)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        JSONObject responseBody = new JSONObject(response.body().string());
        if (responseBody.has("price")) {
            stock.setCurrentPrice(responseBody.getFloat("price"));

        } else {
            throw new Exception(responseBody.getString("message"));
        }
    }

    /**
     * Using three api calls to search for the given stock symbol and store a corresponding Stock in the searchHistory
     * for the currentUser.
     * @param symbol the stock symbol that used to perform stock search
     * @return If symbol is valid, return null. Otherwise, return the error message based on the type of exception been
     * catch.
     */
    public String search(String symbol) {
        try {
            Map<String, Stock> history = currentUser.getSearchHistories();
            if (history.containsKey(symbol)) {
                setCurrentPrice(symbol, history.get(symbol));
            } else {
                Stock stock = new Stock(symbol);
                setHistoricalPrice(symbol, currentUser.getInterval(), currentUser.getOutputSize(), stock);
                setInfo(symbol, stock);
                setCurrentPrice(symbol, stock);
                currentUser.getSearchHistories().put(symbol, stock);
            }
            return null;
        } catch (IOException e) {
            return String.format("%s is not a valid symbol. Please enter a correct stock symbol.", symbol);
        } catch (Exception e) {
            return "Frequent request. Please try again later.";
        }
    }

    /**
     *
     * @param symbol the stock symbol
     * @return the Stock with given stock symbol from currentUser's searchHistory
     */
    public Stock getStock(String symbol) {
        return currentUser.getSearchHistories().get(symbol);
    }

    /**
     *
     * @param symbol the stock symbol
     * @return the stock name correspond to the given stock symbol
     */
    public String getName(String symbol) {
        return currentUser.getSearchHistories().get(symbol).getName();
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
