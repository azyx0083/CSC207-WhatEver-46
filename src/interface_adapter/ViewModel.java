package interface_adapter;

import java.beans.PropertyChangeListener;

public abstract class ViewModel {

    private String viewName;

    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    public abstract void firePropertyChanged();

    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}
