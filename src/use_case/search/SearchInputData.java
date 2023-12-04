package use_case.search;

public class SearchInputData {
    private final String symbol;
    private final String username;
    public SearchInputData(String symbol, String username){
        this.symbol = symbol.toUpperCase();
        this.username = username;
    }
    public String getSymbol(){return symbol;}
    public String getUsername(){return username;}
}
