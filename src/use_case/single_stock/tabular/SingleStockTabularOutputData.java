package use_case.single_stock.tabular;

import use_case.single_stock.SingleStockOutputData;

public class SingleStockTabularOutputData extends SingleStockOutputData {
    private final Object[][] data;

    public SingleStockTabularOutputData(String name, String symbol, float currentPrice,
                                        String currency, String exchange, String country, String type,
                                        Object[][] data) {
        super(name, symbol, currentPrice, currency, exchange, country, type);
        this.data = data;
    }

    public Object[][] getData() {
        return data;
    }
}
