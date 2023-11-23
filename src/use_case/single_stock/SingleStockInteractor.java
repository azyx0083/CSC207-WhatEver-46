package use_case.single_stock;

import entity.Stock;

/**
 * The interactor for the SingleStock usecase
 */
public class SingleStockInteractor implements SingleStockInputBoundary {
    private final SingleStockOutputBoundary singleStockPresenter;
    private final SingleStockAPIDataAccessInterface singleStockAPIDataAccessObject;

    /**
     * Initialize a SingleStockInteractor
     * @param singleStockPresenter the presenter for the SingleStock usecase
     * @param singleStockAPIDataAccessObject the APIDataAccessObject for the SingleStock usecase
     */
    public SingleStockInteractor(SingleStockOutputBoundary singleStockPresenter,
                                 SingleStockAPIDataAccessInterface singleStockAPIDataAccessObject) {
        this.singleStockPresenter = singleStockPresenter;
        this.singleStockAPIDataAccessObject = singleStockAPIDataAccessObject;
    }


    /**
     * Lookup the stock with given stock symbol from the singleStockAPIDataAccessObject
     * Prepare the SingleStockOutputData using such stock and pass the outputData to singleStockPresenter for visualization
     * @param symbol a valid stock symbol
     */
    @Override
    public void execute(String symbol) {
        Stock stock = singleStockAPIDataAccessObject.getStock(symbol);
        SingleStockOutputData stockOutputData = new SingleStockOutputData(stock.getName(),
                stock.getSymbol(), stock.getCurrentPrice(), stock.getCurrency(), stock.getExchange(),
                stock.getCountry(), stock.getType(), stock.getHistoricalPrice());
        singleStockPresenter.prepareView(stockOutputData);
    }
}
