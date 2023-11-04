package use_case.search;

import entity.Stock;

public interface SearchAPIDataAccessInterface {
    String timeSeries(String symbol, String interval, int outputSize);

    Stock getStock();
}
