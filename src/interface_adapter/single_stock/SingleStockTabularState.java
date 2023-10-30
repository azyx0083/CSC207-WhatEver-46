package interface_adapter.single_stock;

public class SingleStockTabularState extends SingleStockState{
    private Object[][] data;
    private String[] columnNames;

    public SingleStockTabularState(String name, String symbol, String error, Object[][] data, String[] columnNames) {
        super(name, symbol, error);
        this.data = data;
        this.columnNames = columnNames;
    }

    public Object[][] getData() {
        return data;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
}
