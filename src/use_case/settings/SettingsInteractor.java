package use_case.settings;

import entity.User;
import entity.UserSetting;

import java.util.Set;

public class SettingsInteractor implements SettingsInputBoundary{
    final SettingsOutputBoundary settingsPresenter;
    final SettingsUserDataAccessInterface userAccess;

    /**
     * constructor
     * @param settingsPresenter the presenter
     * @param userAccess to find the user
     */
    public SettingsInteractor(SettingsOutputBoundary settingsPresenter, SettingsUserDataAccessInterface userAccess) {
        this.settingsPresenter = settingsPresenter;
        this.userAccess = userAccess;
    }
    @Override
    public void applyChanges(SettingsInputData settingsInputData) {
        User user = userAccess.get(settingsInputData.getUsername());
        user.getSetting().setInterval(settingsInputData.getInterval());
        user.getSetting().setOutputSize(settingsInputData.getDataSize());
        /**Map<String, Stock> favs = user.getFavouriteStocks();

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
        }**/ //uncomment if want favorites in future
    }

    /**
     * goes back to settings
     * @param username username so settings knows whose data to manipulate
     */
    @Override
    public void goToSettings(String username) {
        User user = userAccess.get(username);
        String interval = user.getSetting().getInterval();
        int dataSize = user.getSetting().getOutputSize();
//        Set<String> favsSet = user.getFavouriteStocks().keySet();
//        String[] favs = favsSet.toArray(new String[0]);
        SettingsOutputData settingsOutputData = new SettingsOutputData(interval, dataSize);
        settingsPresenter.prepareSettingsView(settingsOutputData);
    }
}
