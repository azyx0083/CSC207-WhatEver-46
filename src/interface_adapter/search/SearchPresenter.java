package interface_adapter.search;


public class SearchPresenter implements SearchOutputBoundary{
    private final SearchViewModel searchViewModel;

    public SearchPresenter(SearchViewModel searchViewModel) {
        this.searchViewModel = searchViewModel;
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
