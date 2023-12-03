package interface_adapter.search;

import use_case.search.SearchInputBoundary;
import use_case.search.SearchInputData;

public class SearchController {
    final SearchInputBoundary userSearchCaseInteractor;

    /**
     * Constructs a SearchController.
     * @param userSearchCaseInteractor a SearchInputBoundary is assigned.
     */
    public SearchController(SearchInputBoundary userSearchCaseInteractor) {
        this.userSearchCaseInteractor = userSearchCaseInteractor;
    }

    /**
     * Carry out the search process.
     * @param symbol the unique ticker symbol that represents a stock.
     */
    public void execute(String symbol, String username) {
        SearchInputData searchInputData = new SearchInputData(symbol, username); // Assume that both are needed to search.
        userSearchCaseInteractor.execute(searchInputData);
    }
}