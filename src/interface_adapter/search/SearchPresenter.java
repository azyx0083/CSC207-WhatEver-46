package interface_adapter.search;


import interface_adapter.ViewManagerModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a SearchPresenter.
     * @param searchViewModel the view model of search use case.
     * @param viewManagerModel the model that manages all views.
     */
    public SearchPresenter(SearchViewModel searchViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view given that the search process succeeded.
     * @param data the output data of the search use case.
     */
    public void prepareSuccessView(SearchOutputData data) {
        // Once success, switch to the search view.
        SearchState searchState = searchViewModel.getState();
        searchState.setName(data.getName());
        searchState.setSymbol(data.getSymbol());
        this.searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view given that the search process failed.
     * @param error the error that causes the failure of the process.
     */
    public void prepareFailView(String error) {
        SearchState searchState = searchViewModel.getState();
        searchState.setSymbolError(error); //some method to put in here
        searchViewModel.firePropertyChanged();
    }
}
