package interface_adapter.single_stock.tabular;

import interface_adapter.ViewModel;
import interface_adapter.single_stock.SingleStockState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SingleStockTabularViewModel extends ViewModel {
    public static final String MENU_BUTTON_LABEL = "Menu";
    public static final String GRAPHICAL_BUTTON_LABEL = "Graph";

    private SingleStockTabularState state;

    public SingleStockTabularViewModel() {
        super("tabular");
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

    public void setState(SingleStockTabularState state) {
        this.state = state;
    }
}
