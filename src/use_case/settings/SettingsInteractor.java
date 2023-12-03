package use_case.settings;

import data_access.APIDataAccess;
import entity.Stock;
import entity.User;
import use_case.search.SearchAPIDataAccessInterface;
import use_case.settings.SettingsOutputBoundary;

import java.util.Map;

public class SettingsInteractor implements SettingsInputBoundary{
    final SettingsOutputBoundary settingsPresenter;
    final SettingsDataAccessInterface userAccess;
    final APIDataAccess apiAccess;

    public SettingsInteractor(SettingsOutputBoundary settingsPresenter, SettingsDataAccessInterface userAccess, APIDataAccess apiAccess) {
        this.settingsPresenter = settingsPresenter;
        this.userAccess = userAccess;
        this.apiAccess = apiAccess;
    }
    @Override
    public void applyChanges(SettingsInputData settingsInputData) {
        User user = userAccess.get(settingsInputData.getUsername());
        user.setInterval(settingsInputData.getInterval());
        user.setOutputSize(settingsInputData.getDataSize());
        Map<String, Stock> favs = user.getFavouriteStocks();

        String[] favs2 = settingsInputData.getFavorites();
        for (String stock : favs.keySet()) {
            boolean contains = false;
            for (String value : favs2) {
                if (value.equals(stock)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                favs.remove(stock);
            }
        }
        for (String stock : favs2) {
            boolean contains = false;
            for (String value : favs.keySet()) {
                if (value.equals(stock)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                if (apiAccess.search(stock) == null) {
                    Stock newStock = apiAccess.getStock(stock);
                    favs.put(stock, newStock);
                }
            }
        }
    }

    @Override
    public void goToSettings(String username) {

    }
}
