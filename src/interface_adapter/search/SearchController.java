package interface_adapter.search;

public class SearchController {
    final SearchInputBoundary userSearchCaseInteractor;
    public SearchController(SearchInputBoundary userSearchCaseInteractor) {
        this.userSearchCaseInteractor = userSearchCaseInteractor;
    }

    public void execute(String name, String symbol) {
        SearchInputData searchInputData = new SearchInputData(name, symbol); // Assume that both are needed to search.
        userSearchCaseInteractor.execute(searchInputData);
    }
}