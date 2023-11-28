package use_case.search;

public class OptionsOutputData {
    private final String name;
    private final String symbol;

    /**
     * initialize the stock's name and symbol, store the data SearchInteractor and
     * SearchOutputBoundary needed.
     * @param name stock name
     * @param symbol symbol of stock
     */
    public OptionsOutputData(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * get the stock name
     * @return name of initialized stock
     */
    public String getName(){ return name;}

    /**
     * get the symbol of stock
     * @return symbol of initialized stock
     */
    public String getSymbol(){ return symbol;}
}