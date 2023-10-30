package interface_adapter.single_stock;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SingleStockViewModel extends ViewModel {
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String SEARCH_LABEL = "Search by stock symbol";

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String LOGIN_BUTTON_LABEL = "Log in";
    public static final String GRAPHICAL_BUTTON_LABEL = "Graphical Display";

    public static final String TABULAR_BUTTON_LABEL = "Tabular Display";
    private SingleStockState singleStockState = new SingleStockState();

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

    public SingleStockState getSingleStockState() {
        return singleStockState;
    }

    public void setSingleStockState(SingleStockState singleStockState) {
        this.singleStockState = singleStockState;
    }
}
