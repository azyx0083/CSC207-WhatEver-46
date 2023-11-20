package interface_adapter.single_stock;

import use_case.single_stock.SingleStockOutputData;

/**
 * An updater that update the SingleStockState
 */
public interface SingleStockStateUpdater {
    // This interface is not part of the Clean Architecture engine
    // This class separate the duty of updating state from SingleStockPresenter (Single Responsibility Principle)
    // Therefore this interface can also depend on the SingleStockOutputData
    // There are different ways to update the SingleStockState (depend on the method of visualization)
    // By having this interface, the choice of different updater only need to determine by the client
    // If we want to add more ways to visualize a stock, we only need to add more updater without modify the SingleStockPresenter
    // Apply the Open/Closed Principle and the Strategy design pattern
    /**
     * Update the state using data provided
     * @param data the data structure contains all the new information
     * @param state the SingleStockState that need to be updated
     */
    void updateState(SingleStockOutputData data, SingleStockState state);
}
