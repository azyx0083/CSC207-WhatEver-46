package interface_adapter.single_stock.tabular;

import interface_adapter.single_stock.SingleStockState;

import java.util.Map;

public class SingleStockTabularState extends SingleStockState {
    // We decide to make the table model as an instance variable instead SingleStockTabularState implements TableModel interface
    // Then all the method required to generate a table display will be separate from the state
    // Application of Single Responsibility Principle
    private final StockPriceTableModel data;

    public SingleStockTabularState(String symbol, String title, String currentPrice, String detail, Map<String, Object[]> data) {
        super(symbol, title, currentPrice, detail);
        this.data = new StockPriceTableModel(data);
    }

    public StockPriceTableModel getData() {
        return data;
    }
}
