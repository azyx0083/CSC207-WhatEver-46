package use_case.single_stock;

public interface SingleStockOutputBoundary {
    void prepareTabularView(SingleStockTabularOutputData data);
    void prepareGraphicalView(SingleStockGraphicalOutputData data);
    void prepareFailedView(String error);
}
