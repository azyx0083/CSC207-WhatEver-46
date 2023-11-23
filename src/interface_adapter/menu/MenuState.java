package interface_adapter.menu;

public class MenuState {
    private String stockSymbol;
    private String stockError = null;

    public MenuState() {

    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getStockError() {
        return stockError;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public void setStockError(String stockError) {
        this.stockError = stockError;
    }
}
