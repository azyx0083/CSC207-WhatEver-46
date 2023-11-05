package interface_adapter.single_stock.tabular;

import org.jetbrains.annotations.Nls;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StockPriceTableModel implements TableModel {
    private final Object[][] data;

    public StockPriceTableModel(Object[][] data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.length - 1;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Nls
    @Override
    public String getColumnName(int columnIndex) {
        return (String) data[0][columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return data[0][columnIndex].getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex + 1][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex + 1][columnIndex] = aValue;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
