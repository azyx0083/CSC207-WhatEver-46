package interface_adapter.search;

import use_case.search.SearchInputBoundary;
import use_case.search.SearchInputData;

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