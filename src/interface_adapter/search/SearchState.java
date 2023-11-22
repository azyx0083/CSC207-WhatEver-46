package interface_adapter.search;

public class SearchState {
    private String name = "";
    private String nameError = null;
    private String symbol = "";
    private String symbolError = null;
    private String userName = "";
    private String userNameError = null;

    public SearchState(SearchState copy) {
        name = copy.name;
        nameError = copy.nameError;
        symbol = copy.symbol;
        symbolError = copy.symbolError;
    }

    public SearchState() {}

    // The getters
    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }
    public String getNameError() {
        return nameError;
    }
    public String getSymbolError() {
        return symbolError;
    }

    // The Setters
    public String toString() {
        return "SearchState{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
