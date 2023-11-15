package use_case.search;

public class SearchOutputData {
    private final String name;
    private final String symbol;
    public SearchOutputData(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }
    public String getName(){ return name;}
    public String getSymbol(){ return symbol;}
}
