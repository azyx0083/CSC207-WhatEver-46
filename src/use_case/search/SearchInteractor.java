package use_case.search;

import entity.UserFactory;

public class SearchInteractor implements SearchInputBoundary {
    private final SearchOutputBoundary searchPresenter;
    private final SearchAPIDataAccessInterface searchAPIDataAccessObject;

    /**
     * constructor
     * @param searchPresenter SearchOutputBoundary that SearchPresenter implements
     * @param searchAPIDataAccessObject SearchAPIDataAccessInterface that APIDataAccess implements,
     *                                  let the interactor has access to DAO
     *
     */
    public SearchInteractor(SearchOutputBoundary searchPresenter,
                            SearchAPIDataAccessInterface searchAPIDataAccessObject){
        this.searchPresenter = searchPresenter;
        this.searchAPIDataAccessObject = searchAPIDataAccessObject;
    }

    /**
     * actual execute method when call interface. If the stock symbol was invalid, prepare the fail view,
     * otherwise prepare success view.
     */
    @Override
    public void execute(SearchInputData searchInputData) {
        String search = searchAPIDataAccessObject.search(searchInputData.getSymbol(), UserFactory.createDefaultUser().getSetting());
        if (search != null){
            searchPresenter.prepareFailView(search);
        } else {
            SearchOutputData searchOutputData = new SearchOutputData(
                    searchAPIDataAccessObject.getName(searchInputData.getSymbol()), searchInputData.getSymbol());
            searchPresenter.prepareSuccessView(searchOutputData);
        }
    }
}
