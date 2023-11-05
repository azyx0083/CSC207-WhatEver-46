package interface_adapter.single_stock.graphical;

import interface_adapter.single_stock.SingleStockState;
import interface_adapter.single_stock.tabular.StockPriceTableModel;

public class SingleStockGraphicalState extends SingleStockState {
    private final StockPriceDataset data;

    public SingleStockGraphicalState(String title, String currentPrice, String detail, Object[][] data) {
        super(title, currentPrice, detail);
        this.data = new StockPriceDataset(data);
    }

    public StockPriceDataset getData() {
        return data;
    }
}
