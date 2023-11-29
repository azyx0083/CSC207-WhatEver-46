package interface_adapter.menu;

public class MenuState {
    private String stockSymbol;
    private String stockError = null;
    private boolean currentUser = false;
    private String username;

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
    public void setUsername(boolean hasUser, String username){
        this.currentUser = hasUser;
        this.username = username;
    }
    public boolean hasUser(){
        return this.currentUser;
    }
    public String getUsername(){
        return username;
    }
}
