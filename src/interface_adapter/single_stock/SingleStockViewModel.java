package interface_adapter.single_stock;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SingleStockViewModel extends ViewModel {
    public static final String MENU_BUTTON_LABEL = "Menu";
    public static final String TABULAR_BUTTON_LABEL = "Table";
    public static final String GRAPHICAL_BUTTON_LABEL = "Graph";
    public SingleStockState state;

    public SingleStockViewModel(String viewName, SingleStockState state) {
        super(viewName);
        this.state = state;
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

    public void setState(SingleStockState state) {
        this.state = state;
    }
}
