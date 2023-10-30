package use_case.single_stock;

public interface SingleStockInputBoundary {
    void execute(String symbol, String mode);
}
