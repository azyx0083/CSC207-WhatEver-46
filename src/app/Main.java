package app;

import data_access.*;
//TODO remove later; testing purposes only

public class Main {
    public static void main(String[] args) {
        APIDataAccess api = new APIDataAccess("AMZN", "1day");
        System.out.println(api.getStockPrice().getDate());
        System.out.println(api.getStockPrice().getHigh());
        System.out.println(api.getStockPrice().getLow());
        System.out.println(api.getStockPrice().getVolume());
        System.out.println(api.getStockPrice().getOpen());
        System.out.println(api.getStockPrice().getClose());
        //TODO also remove later; for testing
    }
}
