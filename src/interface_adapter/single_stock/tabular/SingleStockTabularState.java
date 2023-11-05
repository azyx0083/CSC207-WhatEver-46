package interface_adapter.single_stock.tabular;

import interface_adapter.single_stock.SingleStockState;

public class SingleStockTabularState extends SingleStockState {
    private final StockPriceTableModel data;

    public SingleStockTabularState(String title, String currentPrice, String detail, Object[][] data) {
        super(title, currentPrice, detail);
        this.data = new StockPriceTableModel(data);
    }

    public StockPriceTableModel getData() {
        return data;
    }
}
