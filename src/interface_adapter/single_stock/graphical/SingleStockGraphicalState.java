package interface_adapter.single_stock.graphical;

import interface_adapter.single_stock.SingleStockState;

import java.util.HashMap;

public class SingleStockGraphicalState extends SingleStockState {
    private final StockPriceDataset data;

    public SingleStockGraphicalState(String title, String currentPrice, String detail, HashMap<String, Object[]> data) {
        super(title, currentPrice, detail);
        this.data = new StockPriceDataset(data);
    }

    public StockPriceDataset getData() {
        return data;
    }
}
