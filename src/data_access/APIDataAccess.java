package data_access;

import entity.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.HashMap;
import java.util.Map;

public class APIDataAccess implements StockDataAccessInterface {
    final private String APIkey = "e8af6cedf9mshf35e68a5b040250p12fc53jsne75b26c51cd0";

    private Map<String, float> timeSeries = new HashMap<String, Object>();

    private HttpResponse<String> response;
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
            for (int i = 0; i < 6; i++) {
                timeSeries.put(keys[i], Float.parseFloat(values[i]));
            }
        } catch (InterruptedException | IOException e) {
            System.out.println("not sure ngl haha fix later..?");
        }

    }

    @Override
    public StockPrice getStockPrice() {
        return new StockPrice(timeSeries.get("high"), timeSeries.get("low"), timeSeries.get("open"), timeSeries.get("close"), (int)timeSeries.get("volume"));
    }
}
