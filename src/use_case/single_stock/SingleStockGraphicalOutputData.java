package use_case.single_stock;

import entity.StockPriceDataset;

public class SingleStockGraphicalOutputData {
    private final String name;
    private final String symbol;
    private final StockPriceDataset dataset;

    public SingleStockGraphicalOutputData(String name, String symbol, StockPriceDataset dataset) {
        this.name = name;
        this.symbol = symbol;
        this.dataset = dataset;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public StockPriceDataset getDataset() {
        return dataset;
    }
}
