package interface_adapter.single_stock;

public class SingleStockTabularViewModel extends SingleStockViewModel{
    private String name = "";
    private String symbol = "";
    private String error = null;
    private Object[][] data = null;
    private String[] columnNames = null;

    public SingleStockTabularViewModel() {
        super();
    }

    public SingleStockTabularViewModel(String name, String symbol, Object[][] data, String[] columnNames) {
        super();
        this.name = name;
        this.symbol = symbol;
        this.error = null;
        this.data = data;
        this.columnNames = columnNames;
    }

    public String getError() {
        return error;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object[][] getData() {
        return data;
    }

    public String[] getColumnNames() {
        return columnNames;
    }
}
