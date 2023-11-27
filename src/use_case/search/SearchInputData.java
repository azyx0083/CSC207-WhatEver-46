package use_case.search;

public class SearchInputData {
    private final String symbol;
    public SearchInputData(String name, String symbol){
        this.symbol = symbol;
    }
    public String getSymbol(){return symbol;}
}
