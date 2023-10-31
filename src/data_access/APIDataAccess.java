package data_access;

import entity.*;
import org.json.JSONArray;
import use_case.single_stock.SingleStockAPIDataAccessInterface;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.HashMap;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;


public class APIDataAccess implements StockDataAccessInterface, SingleStockAPIDataAccessInterface  {
    final private String APIkey = "e8af6cedf9mshf35e68a5b040250p12fc53jsne75b26c51cd0";

    private Map<String, Object> timeSeries = new HashMap<String, Object>();

    private HttpResponse<String> response;

    public APIDataAccess() {
    }

    public APIDataAccess(String stockSymbol, String interval) {
        try {
            String uri = "https://twelve-data1.p.rapidapi.com/time_series?symbol=" + stockSymbol + "&interval=" + interval + "&outputsize=1&format=csv";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("X-RapidAPI-Key", APIkey)
                    .header("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String[] keyValues = response.body().split("\n");
            String[] keys = keyValues[0].split(";");
            String[] values = keyValues[1].split(";");
            timeSeries.put(keys[0], values[0]);
            for (int i = 1; i < 5; i++) {
                timeSeries.put(keys[i], Float.parseFloat(values[i]));
            }
            timeSeries.put(keys[5], Integer.parseInt(values[5]));
        } catch (InterruptedException | IOException e) {
            System.out.println("not sure ngl haha fix later..?");
        }

    }

    @Override
    public StockPrice getStockPrice() {
        return new StockPrice((String)timeSeries.get("datetime"),
                (float)timeSeries.get("high"),
                (float)timeSeries.get("low"),
                (float)timeSeries.get("open"),
                (float)timeSeries.get("close"),
                (int)timeSeries.get("volume"));
    }

    @Override
    public String validSymbol(String symbol) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/stocks?symbol=%s", symbol))
                .get()
                .addHeader("X-RapidAPI-Key", APIkey)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getString("status").equals("ok")) {
                JSONArray data = responseBody.getJSONArray("data");
                if (data.isEmpty()) {;
                    return null;
                } else {
                    return data.getJSONObject(0).getString("name");
                }
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Stock getStockData(String name, String symbol) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/time_series?symbol=%s&interval=1day&outputsize=7",
                        symbol))
                .get()
                .addHeader("X-RapidAPI-Key", APIkey)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            assert response.body() != null;
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getString("status").equals("ok")) {
                JSONArray data = responseBody.getJSONArray("values");
                StockPrice[] stockPrices = new StockPrice[7];
                for (Integer i = 0; i < 7; i++) {
                    JSONObject price = data.getJSONObject(i);
                    stockPrices[i] = new StockPrice(price.getString("datetime"), price.getFloat("high"),
                            price.getFloat("low"), price.getFloat("open"), price.getFloat("close"),
                            price.getInt("volume"));
                }
                Stock stock = new Stock(name, symbol, stockPrices);
                return stock;
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
