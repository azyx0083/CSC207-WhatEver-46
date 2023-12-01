package use_case.single_stock;

public class SingleStockInputData {
    private final String symbol;

    public SingleStockInputData(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
