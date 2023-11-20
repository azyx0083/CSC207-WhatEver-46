package interface_adapter.search;


public class SearchPresenter implements SearchOutputBoundary{
    private final SearchViewModel searchViewModel;

    public SearchPresenter(SearchViewModel searchViewModel) {
        this.searchViewModel = searchViewModel;
    }

    public void prepareSuccessView(SearchOutputData data) {

    }

    public void prepareFailView(String error) {
        SearchState searchState = searchViewModel.getState();
        searchState.  (error); //some method to put in here
        searchViewModel.firePropertyChanged();
    }
}
