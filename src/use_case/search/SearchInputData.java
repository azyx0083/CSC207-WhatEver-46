package use_case.search;

public class SearchInputData {
    private final String name;
    private final String symbol;
    public SearchInputData(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }
    public String getSymbol(){return symbol;}
    public String getName(){return name;}
}
