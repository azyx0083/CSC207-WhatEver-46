package interface_adapter.menu;

public class MenuState {
    private String stockSymbol;
    private String stockError = null;
    private String username;

    public MenuState() {

    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getStockError() {
        return stockError;
    }
    public String getUsername() {
        return username;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public void setStockError(String stockError) {
        this.stockError = stockError;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
