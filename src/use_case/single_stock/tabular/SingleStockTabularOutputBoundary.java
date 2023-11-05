package use_case.single_stock.tabular;

import use_case.single_stock.SingleStockOutputData;
import use_case.single_stock.graphical.SingleStockGraphicalOutputData;

public interface SingleStockTabularOutputBoundary {
    void prepareView(SingleStockTabularOutputData data);
}
