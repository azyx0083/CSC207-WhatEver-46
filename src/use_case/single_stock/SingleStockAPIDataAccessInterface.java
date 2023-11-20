package use_case.single_stock;

import entity.Stock;

/**
 * APIAccessInterface for the SingleStock usecase
 */
public interface SingleStockAPIDataAccessInterface {
    /**
     *
     * @param symbol a valid stock symbol
     * @return the Stock with given stock symbol
     */
    Stock getStock(String symbol);
}
