package interface_adapter.single_stock.graphical;

import interface_adapter.ViewModel;
import interface_adapter.single_stock.SingleStockState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SingleStockGraphicalViewModel extends ViewModel {
    public static final String MENU_BUTTON_LABEL = "Menu";
    public static final String TABULAR_BUTTON_LABEL = "Table";

    private SingleStockGraphicalState state;

    public SingleStockGraphicalViewModel() {
        super("graphical");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SingleStockState getState() {
        return state;
    }

    public void setState(SingleStockGraphicalState state) {
        this.state = state;
    }
}
