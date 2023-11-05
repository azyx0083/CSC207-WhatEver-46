package use_case.single_stock.tabular;

import entity.Stock;
import use_case.single_stock.SingleStockAPIDataAccessInterface;

public class SingleStockTabularInteractor implements SingleStockTabularInputBoundary {
    private final SingleStockTabularOutputBoundary singleStockPresenter;
    private final SingleStockAPIDataAccessInterface singleStockAPIDataAccessObject;

    public SingleStockTabularInteractor(SingleStockTabularOutputBoundary singleStockPresenter,
                                        SingleStockAPIDataAccessInterface singleStockAPIDataAccessObject) {
        this.singleStockPresenter = singleStockPresenter;
        this.singleStockAPIDataAccessObject = singleStockAPIDataAccessObject;
    }


    @Override
    public void execute() {
        Stock stock = singleStockAPIDataAccessObject.getStock();
        SingleStockTabularOutputData stockOutputData = new SingleStockTabularOutputData(stock.getName(),
                stock.getSymbol(), stock.getCurrentPrice(), stock.getCurrency(), stock.getExchange(),
                stock.getCountry(), stock.getType(), stock.getHistoricalPrices());
        singleStockPresenter.prepareView(stockOutputData);
    }
}
