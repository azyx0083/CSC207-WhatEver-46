package data_access;

import entity.*;
import org.json.JSONArray;
import use_case.search.SearchAPIDataAccessInterface;
import use_case.single_stock.SingleStockAPIDataAccessInterface;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;


public class APIDataAccess implements SingleStockAPIDataAccessInterface, SearchAPIDataAccessInterface {
    final private String APIkey = "e8af6cedf9mshf35e68a5b040250p12fc53jsne75b26c51cd0";
    private static Stock stock;

    public APIDataAccess() {
    }

    @Override
    public String timeSeries(String symbol, String interval, int outputSize) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/time_series?symbol=%s&interval=%s&outputsize=%s",
                        symbol, interval, outputSize))
                .get()
                .addHeader("X-RapidAPI-Key", APIkey)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getString("status").equals("ok")) {
                JSONArray data = responseBody.getJSONArray("values");
                JSONObject meta = responseBody.getJSONObject("meta");
                String exchange = meta.getString("exchange");
                setInfo(symbol, exchange);
                setCurrentPrice(symbol);
                StockPrice[] stockPrices = new StockPrice[outputSize];
                for (int i = 0; i < outputSize; i++) {
                    JSONObject price = data.getJSONObject(i);
                    stockPrices[i] = new StockPrice(price.getString("datetime"), price.getFloat("high"),
                            price.getFloat("low"), price.getFloat("open"), price.getFloat("close"),
                            price.getInt("volume"));
                }
                stock.setHistoricalPrice(stockPrices);
                return null;

            } else {
                return String.format("%s is not a valid symbol. Please enter a correct stock symbol.", symbol);
            }
        } catch (Exception e) {
            return "Frequent request. Please try again later.";
        }
    }

    private void setInfo(String symbol, String exchange) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/stocks?symbol=%s&exchange=%s",
                        symbol, exchange))
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
            String name = info.getString("name");
            String currency = info.getString("currency");
            String country = info.getString("country");
            String type = info.getString("type");
            stock = new Stock(name, symbol, exchange, currency, country, type);
        } else {
            throw new IOException(responseBody.getString("message"));
        }
    }

    private void setCurrentPrice(String symbol) throws IOException {
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
            float price = responseBody.getFloat("price");
            stock.setCurrentPrice(price);

        } else {
            throw new IOException(responseBody.getString("message"));
        }
    }

    public Stock getStock() {
        return stock;
    }
}
