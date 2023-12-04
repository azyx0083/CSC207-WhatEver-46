package app.factory;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockPresenter;
import interface_adapter.single_stock.SingleStockViewModel;
import use_case.single_stock.SingleStockInputBoundary;
import use_case.single_stock.SingleStockInteractor;
import use_case.single_stock.SingleStockOutputBoundary;

import java.util.HashMap;
import java.util.Map;

public class SingleStockUseCaseFactory {
    public static Map<String, SingleStockController> createSingleStockUsecase(ViewManagerModel viewManagerModel,
                                                                       Map<String, SingleStockViewModel> viewModels,
                                                                       APIDataAccess apiDataAccess) {
        Map<String, SingleStockController> controllers = new HashMap<>();
        for (String type : viewModels.keySet())
            controllers.put(type, createController(viewManagerModel, viewModels.get(type), apiDataAccess));
        return controllers;
    }

    private static SingleStockController createController(ViewManagerModel viewManagerModel,
                                                          SingleStockViewModel singleStockViewModel,
                                                          APIDataAccess apiDataAccessObject) {
        SingleStockOutputBoundary singleStockOutputBoundary = new SingleStockPresenter(singleStockViewModel,
                viewManagerModel);
        SingleStockInputBoundary singleStockInputBoundary = new SingleStockInteractor(singleStockOutputBoundary, apiDataAccessObject);
        return new SingleStockController(singleStockInputBoundary);
    }
}
