package use_case.single_stock;

import entity.Stock;

public class SingleStockOutputData {
    private final String name;
    private final String symbol;
    private final Object[][] data;
    private final String[] columnNames;

    public SingleStockOutputData(String name, String symbol, Object[][] data, String[] columnNames) {
        this.name = name;
        this.symbol = symbol;
        this.data = data;
        this.columnNames = columnNames;
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
