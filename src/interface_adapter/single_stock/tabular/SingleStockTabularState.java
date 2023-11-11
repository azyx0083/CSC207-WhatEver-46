package interface_adapter.single_stock.tabular;

import interface_adapter.single_stock.SingleStockState;

import java.util.HashMap;

public class SingleStockTabularState extends SingleStockState {
    private final StockPriceTableModel data;

    public SingleStockTabularState(String symbol, String title, String currentPrice, String detail, HashMap<String, Object[]> data) {
        super(symbol, title, currentPrice, detail);
        this.data = new StockPriceTableModel(data);
    }

    public StockPriceTableModel getData() {
        return data;
    }
}
