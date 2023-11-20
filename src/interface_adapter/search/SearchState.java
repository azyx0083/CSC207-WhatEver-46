package interface_adapter.search;

public class SearchState {
    private String name = "";
    private String symbol = "";

    public SearchState(SearchState copy) {
        name = copy.name;
        symbol = copy.symbol;
    }

    public SearchState() {}

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
