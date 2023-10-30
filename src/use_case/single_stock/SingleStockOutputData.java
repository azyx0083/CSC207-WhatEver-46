package use_case.single_stock;

import entity.Stock;

public class SingleStockOutputData {
    private final String name;
    private final String symbol;
    private final Object[][] data;
    private final String[] columnNames;

    public SingleStockOutputData(Stock stock) {
        name = stock.getName();
        symbol = stock.getSymbol();
        data = stock.getHistoricalPrices();
        columnNames = stock.getHistoricalDates();
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public Object[][] getData() {
        return data;
    }

    public String[] getColumnNames() {
        return columnNames;
    }
}
