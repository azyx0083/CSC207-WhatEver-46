package interface_adapter.search;


import interface_adapter.ViewManagerModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final ViewManagerModel viewManagerModel;

    public SearchPresenter(SearchViewModel searchViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
    }

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

    public void prepareFailView(String error) {
        SearchState searchState = searchViewModel.getState();
        searchState.setSymbolError(error); //some method to put in here
        searchViewModel.firePropertyChanged();
    }
}
