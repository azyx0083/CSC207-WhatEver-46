package use_case.menu;

public class MenuInputData{
    final private String stockSymbol;

    /**
     * To be used for the Search use case/
     * @param stockSymbol
     */
    public MenuInputData(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }
}
