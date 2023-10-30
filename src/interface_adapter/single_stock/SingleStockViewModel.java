package interface_adapter.single_stock;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SingleStockViewModel extends ViewModel {

    public static final String MENU_BUTTON_LABEL = "Menu";
    public static final String GRAPHICAL_BUTTON_LABEL = "Graphical Display";

    public static final String TABULAR_BUTTON_LABEL = "Tabular Display";

    public SingleStockViewModel() {
        super("tablular");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
