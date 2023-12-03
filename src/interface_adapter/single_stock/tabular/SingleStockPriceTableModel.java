package interface_adapter.single_stock.tabular;

import interface_adapter.single_stock.SingleStockPriceData;

import javax.swing.table.AbstractTableModel;
import java.util.Map;

/**
 * Store the historical data of a Stock as TableModel
 */
public class SingleStockPriceTableModel extends AbstractTableModel implements SingleStockPriceData {
    // Need to have a TableModel to create a JTable
    // All current implementation of TableModel arrange the data by rows
    // But it is more convenient for us to have a TableModel that arrange by columns
    // SingleStockPriceTableModel extends AbstractTableModel to inherit all the methods except the getters
    // It also implements the SingleStockPriceData to provide the update functionality required for our program
    // Apply the Adapter design pattern
    private Map<String, Object[]> data;
    private final String[] columnNames = new String[]{"date", "open", "high", "low", "close", "volume"};

    /**
     * Initialize a SingleStockPriceTableModel
     */
    public SingleStockPriceTableModel() {
        super();
    }

    /**
     *
     * @return the number of rows of the table
     */
    @Override
    public int getRowCount() {
        return data.get(columnNames[0]).length;
    }

    /**
     *
     * @return the number of columns of the table
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     *
     * @param columnIndex  the column being queried
     * @return the column name at given index
     */
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    /**
     *
     * @param columnIndex  the column being queried
     * @return the column type at given index
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnNames[columnIndex].getClass();
    }

    /**
     *
     * @param rowIndex        the row whose value is to be queried
     * @param columnIndex     the column whose value is to be queried
     * @return the value at given index
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(columnNames[columnIndex])[rowIndex];
    }

    /**
     * Update the SingleStockPriceTableModel to store the new data
     * @param data the new data
     */
    @Override
    public SingleStockPriceTableModel updateData(Map<String, Object[]> data) {
        this.data = data;
        return this;
    }

    @Override
    public Map<String, Object[]> getData() {
        return this.data;
    }
}
