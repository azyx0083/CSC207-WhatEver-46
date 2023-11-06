package use_case.single_stock;

import entity.Stock;

public class SingleStockInteractor implements SingleStockInputBoundary {
    private final SingleStockOutputBoundary singleStockPresenter;
    private final SingleStockAPIDataAccessInterface singleStockAPIDataAccessObject;

    public SingleStockInteractor(SingleStockOutputBoundary singleStockPresenter,
                                 SingleStockAPIDataAccessInterface singleStockAPIDataAccessObject) {
        this.singleStockPresenter = singleStockPresenter;
        this.singleStockAPIDataAccessObject = singleStockAPIDataAccessObject;
    }


    @Override
    public void execute() {
        Stock stock = singleStockAPIDataAccessObject.getStock();
        SingleStockOutputData stockOutputData = new SingleStockOutputData(stock.getName(),
                stock.getSymbol(), stock.getCurrentPrice(), stock.getCurrency(), stock.getExchange(),
                stock.getCountry(), stock.getType(), stock.getHistoricalPrices());
        singleStockPresenter.prepareView(stockOutputData);
    }
}
