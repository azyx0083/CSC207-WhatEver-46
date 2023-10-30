package use_case.single_stock;

import entity.Stock;

import java.util.Objects;

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
        if (!singleStockAPIDataAccessObject.validSymbol(symbol)) {
            singleStockPresenter.prepareFailedView("Not a valid stock symbol.");
        }
        else {
            Stock stock = singleStockAPIDataAccessObject.getStockData(symbol);
            SingleStockOutputData stockOutputData = new SingleStockOutputData(stock);
            if (mode.equals("tabular")) {
                singleStockPresenter.prepareTabularView(stockOutputData);
            }
            else {
                singleStockPresenter.prepareGraphicalView(stockOutputData);
            }
        }

    }
}
