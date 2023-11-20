package interface_adapter.single_stock.tabular;

import interface_adapter.single_stock.SingleStockState;
import interface_adapter.single_stock.SingleStockStateUpdater;
import use_case.single_stock.SingleStockOutputData;

/**
 * An updater that update the SingleStockState
 */
public class SingleStockTabularStateUpdater implements SingleStockStateUpdater {
    public SingleStockTabularStateUpdater() {
    }

    /**
     * Update the state using data provided
     * @param data the data structure contains all the new information
     * @param state the SingleStockState that need to be updated
     */
    @Override
    public void updateState(SingleStockOutputData data, SingleStockState state) {
        if (state.getSymbol().equals(data.getSymbol())) {
            state.setCurrentPrice(data.getCurrentPrice());
            state.getData().updateData(data.getData());
        } else {
            state.setSymbol(data.getSymbol());
            state.setTitle(data.getTitle());
            state.setCurrentPrice(data.getCurrentPrice());
            state.setDetail(data.getDetails());
            state.setData(new StockPriceTableModel(data.getData()));
        }
    }
}
