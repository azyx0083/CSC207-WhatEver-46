package interface_adapter.single_stock;

public class SingleStockState {
    private String name = "";
    private String symbol = "";
    private String error = null;

    public SingleStockState(String name, String symbol, String error) {
        this.name = name;
        this.symbol = symbol;
        this.error = error;
    }

    public SingleStockState() {
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
}
