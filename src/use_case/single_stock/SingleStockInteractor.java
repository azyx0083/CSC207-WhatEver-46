package use_case.single_stock;

import entity.Stock;
import entity.StockPriceDataset;

public class SingleStockInteractor implements SingleStockInputBoundary{
    private final SingleStockOutputBoundary singleStockPresenter;
    private final SingleStockAPIDataAccessInterface singleStockAPIDataAccessObject;

    public SingleStockInteractor(SingleStockOutputBoundary singleStockPresenter,
                                 SingleStockAPIDataAccessInterface singleStockAPIDataAccessObject) {
        this.singleStockPresenter = singleStockPresenter;
        this.singleStockAPIDataAccessObject = singleStockAPIDataAccessObject;
    }


    @Override
    public void execute(String symbol, String mode) {
        String name = singleStockAPIDataAccessObject.validSymbol(symbol);
        if (name == null) {
            singleStockPresenter.prepareFailedView("Not a valid stock symbol.");
        }
        else {
            Stock stock = singleStockAPIDataAccessObject.getStockData(name, symbol);
            if (mode.equals("tabular")) {
                SingleStockTabularOutputData stockOutputData = new SingleStockTabularOutputData(stock.getName(),
                        stock.getSymbol(), stock.getHistoricalPrices(), stock.getHistoricalDates());
                singleStockPresenter.prepareTabularView(stockOutputData);
            }
            else {
                StockPriceDataset dataset = new StockPriceDataset(stock.getHistoricalPriceList());
                SingleStockGraphicalOutputData stockOutputData = new SingleStockGraphicalOutputData(stock.getName(),
                        stock.getSymbol(), dataset);
                singleStockPresenter.prepareGraphicalView(stockOutputData);
            }
        }

    }
}
