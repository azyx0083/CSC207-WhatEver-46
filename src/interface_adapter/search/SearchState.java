package interface_adapter.search;

public class SearchState {
    private String name = "";
    private String nameError = null;
    private String symbol = "";
    private String symbolError = null;

    // Copy constructor
    public SearchState(SearchState copy) {
        name = copy.name;
        nameError = copy.nameError;
        symbol = copy.symbol;
        symbolError = copy.symbolError;
    }
    // Explicit default constructor
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
    public void setName(String name) {
        this.name = name;
    }
    public void setNameError(String nameError) {
        this.nameError = nameError;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public void setSymbolError(String symbolError) {
        this.symbolError = symbolError;
    }

    public String toString() {
        return "SearchState{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
