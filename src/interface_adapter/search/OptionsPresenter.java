package interface_adapter.search;


import interface_adapter.ViewManagerModel;
import use_case.search.OptionsOutputBoundary;
import use_case.search.OptionsOutputData;

public class OptionsPresenter implements OptionsOutputBoundary {
    private final OptionsViewModel optionsViewModel;
    private final ViewManagerModel viewManagerModel;

    public OptionsPresenter(OptionsViewModel optionsViewModel, ViewManagerModel viewManagerModel) {
        this.optionsViewModel = optionsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(OptionsOutputData data) {
        // Once success, switch to the search view.
        OptionsState optionsState = optionsViewModel.getState();
        optionsState.setName(data.getName());
        optionsState.setSymbol(data.getSymbol());
        this.optionsViewModel.setState(optionsState);
        optionsViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(optionsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        OptionsState optionsState = optionsViewModel.getState();
        optionsState.setSymbolError(error); //some method to put in here
        optionsViewModel.firePropertyChanged();
    }
}
