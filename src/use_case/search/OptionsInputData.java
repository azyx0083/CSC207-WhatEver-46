package use_case.search;

public class OptionsInputData {
    private final String symbol;
    public OptionsInputData(String symbol){
        this.symbol = symbol.toUpperCase();
    }
    public String getSymbol(){return symbol;}
}
