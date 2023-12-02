package use_case.search;

public class SearchInputData {
    private final String symbol;
    public SearchInputData(String symbol){
        this.symbol = symbol.toUpperCase();
    }
    public String getSymbol(){return symbol;}
}
