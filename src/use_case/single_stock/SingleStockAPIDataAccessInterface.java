package use_case.single_stock;

import entity.Stock;

public interface SingleStockAPIDataAccessInterface {
    String validSymbol(String symbol);

    Stock getStockData(String name, String symbol);
}
