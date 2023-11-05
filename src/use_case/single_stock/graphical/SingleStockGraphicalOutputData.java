package use_case.single_stock.graphical;

import interface_adapter.single_stock.graphical.StockPriceDataset;
import use_case.single_stock.SingleStockOutputData;

public class SingleStockGraphicalOutputData extends SingleStockOutputData {
    private final StockPriceDataset dataset;

    public SingleStockGraphicalOutputData(String name, String symbol, float currentPrice,
                                          String currency, String exchange, String country, String type,
                                          StockPriceDataset dataset) {
        super(name, symbol, currentPrice, currency, exchange, country, type);
        this.dataset = dataset;
    }

    public StockPriceDataset getDataset() {
        return dataset;
    }
}
