package use_case.search;

import entity.Stock;

public class SearchInteractor implements SearchInputBoundary{
    private final SearchOutputBoundary searchPresenter;
    private final SearchAPIDataAccessInterface searchAPIDataAccessObject;
    private final String stock;

    public SearchInteractor(SearchOutputBoundary searchPresenter,
                            SearchAPIDataAccessInterface searchAPIDataAccessObject, String stock){
        this.searchPresenter = searchPresenter;
        this.searchAPIDataAccessObject = searchAPIDataAccessObject;
        this.stock = stock;
    }
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
