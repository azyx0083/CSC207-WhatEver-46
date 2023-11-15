package interface_adapter.single_stock.graphical;

import interface_adapter.single_stock.SingleStockState;

import java.util.Map;

public class SingleStockGraphicalState extends SingleStockState {
    private final StockPriceDataset data;

    public SingleStockGraphicalState(String symbol, String title, String currentPrice, String detail, Map<String, Object[]> data) {
        super(symbol, title, currentPrice, detail);
        this.data = new StockPriceDataset(data);
    }

    public StockPriceDataset getData() {
        return data;
    }
}
