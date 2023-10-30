package use_case.single_stock;

import entity.Stock;

public interface SingleStockAPIDataAccessInterface {
    boolean validSymbol(String symbol);

    Stock getStockData(String symbol);
}
