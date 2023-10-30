package use_case.single_stock;

public interface SingleStockOutputBoundary {
    void prepareTabularView(SingleStockOutputData data);
    void prepareGraphicalView(SingleStockOutputData data);
    void prepareFailedView(String error);
}
