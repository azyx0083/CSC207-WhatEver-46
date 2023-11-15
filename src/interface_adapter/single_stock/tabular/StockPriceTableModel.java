package interface_adapter.single_stock.tabular;

import org.jetbrains.annotations.Nls;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.Map;

public class StockPriceTableModel implements TableModel {
    private final Map<String, Object[]> data;
    private final String[] columnNames = new String[]{"date", "open", "high", "low", "close", "volume"};

    public StockPriceTableModel(Map<String, Object[]> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.get(columnNames[1]).length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Nls
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnNames[columnIndex].getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(columnNames[columnIndex])[rowIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (isCellEditable(rowIndex, columnIndex))
            data.get(columnNames[columnIndex])[rowIndex] = aValue;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
