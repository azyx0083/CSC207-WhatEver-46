package use_case.single_stock.graphical;

import entity.Stock;
import use_case.single_stock.SingleStockAPIDataAccessInterface;

public class SingleStockGraphicalInteractor implements SingleStockGraphicalInputBoundary{
    private final SingleStockAPIDataAccessInterface singleStockAPIDataAccessObject;
    private final SingleStockGraphicalOutputBoundary singleStockGraphicalPresenter;

    public SingleStockGraphicalInteractor(SingleStockAPIDataAccessInterface singleStockAPIDataAccessObject,
                                          SingleStockGraphicalOutputBoundary singleStockGraphicalPresenter) {
        this.singleStockAPIDataAccessObject = singleStockAPIDataAccessObject;
        this.singleStockGraphicalPresenter = singleStockGraphicalPresenter;
    }

    @Override
    public void execute() {
        Stock stock = singleStockAPIDataAccessObject.getStock();
        SingleStockGraphicalOutputData singleStockGraphicalOutputData = new SingleStockGraphicalOutputData(stock.getName(),
                stock.getSymbol(), stock.getCurrentPrice(), stock.getCurrency(), stock.getExchange(), stock.getCountry(),
                stock.getType(), stock.getHistoricalPrices());
        singleStockGraphicalPresenter.prepareView(singleStockGraphicalOutputData);
    }
}
