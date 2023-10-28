package data_access;

import entity.StockDataAccessInterface;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class APIDataAccess implements StockDataAccessInterface {

    HttpResponse<String> response;
    public APIDataAccess() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://twelve-data1.p.rapidapi.com/stocks?exchange=NASDAQ&format=json"))
                    .header("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
                    .header("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            this.response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (InterruptedException | IOException e) {
            System.out.println("not sure ngl haha fix later..?");
        }

    }

    @Override
    public float getHigh() {
        return 0;
    }

    @Override
    public float getLow() {
        return 0;
    }

    @Override
    public float getOpen() {
        return 0;
    }

    @Override
    public float getClose() {
        return 0;
    }

    @Override
    public float getVolume() {
        return 0;
    }
}
