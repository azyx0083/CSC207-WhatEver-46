package interface_adapter.single_stock;

import entity.StockPrice;
import entity.StockPriceDataset;

public class SingleStockGraphicalViewModel extends SingleStockViewModel{
    private String name;
    private String symbol;
    private String error;
    private StockPriceDataset data;

    public SingleStockGraphicalViewModel(String name, String symbol, StockPriceDataset data) {
        super();
        this.name = name;
        this.symbol = symbol;
        this.error = null;
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setError(String error) {
        this.error = error;
    }

    public StockPriceDataset getData() {
        return data;
    }
}
