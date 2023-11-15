package use_case.search;

import entity.Stock;

public class SearchInteractor implements SearchInputBoundary{
    private final SearchOutputBoundary searchPresenter;
    private final SearchAPIDataAccessInterface searchAPIDataAccessObject;
    private final String stock;

    /**
     * constructor
     * @param searchPresenter SearchOutputBoundary that SearchPresenter implements
     * @param searchAPIDataAccessObject SearchAPIDataAccessInterface that APIDataAccess implements,
     *                                  let the interactor has access to DAO
     * @param stock the stock symbol user wants to search
     */
    public SearchInteractor(SearchOutputBoundary searchPresenter,
                            SearchAPIDataAccessInterface searchAPIDataAccessObject, String stock){
        this.searchPresenter = searchPresenter;
        this.searchAPIDataAccessObject = searchAPIDataAccessObject;
        this.stock = stock;
    }

    /**
     * actual execute method when call interface. If the stock symbol was invalid, prepare the fail view,
     * otherwise prepare success view.
     */
    @Override
    public void execute() {
        Object search = searchAPIDataAccessObject.search(stock);
        if (search != null){
            searchPresenter.prepareFailView((String)search);
        } else {
            Stock stock = searchAPIDataAccessObject.getStock(stock);
            SearchOutputData searchOutputData = new SearchOutputData(stock.getName(),stock.getSymbol());
            searchPresenter.prepareSuccessView(searchOutputData);
        }
    }
}
