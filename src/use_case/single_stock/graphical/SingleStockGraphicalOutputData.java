package use_case.single_stock.graphical;

import interface_adapter.single_stock.graphical.StockPriceDataset;
import use_case.single_stock.SingleStockOutputData;

public class SingleStockGraphicalOutputData extends SingleStockOutputData {
    private final Object[][] data;

    public SingleStockGraphicalOutputData(String name, String symbol, float currentPrice,
                                          String currency, String exchange, String country, String type,
                                          Object[][] data) {
        super(name, symbol, currentPrice, currency, exchange, country, type);
        this.data = data;
    }

    public Object[][] getDataset() {
        return data;
    }
}
