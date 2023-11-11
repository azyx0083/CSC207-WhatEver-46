package use_case.single_stock;

import entity.Stock;

public interface SingleStockAPIDataAccessInterface {
    Stock getStock(String symbol);
}
