package use_case.settings;

public class SettingsInputData {
    final private String interval;
    final private int dataSize;
    final private String[] favorites;
    final private String username;
    public SettingsInputData(String interval, int dataSize, String[] favorites, String username) {
        this.interval = interval;
        this.dataSize = dataSize;
        this.favorites = favorites;
        this.username = username;
    }

    public String getInterval() {
        return interval;
    }

    public int getDataSize() {
        return dataSize;
    }

    public String[] getFavorites() {
        return favorites.clone(); // Return a separate object to prevent modification
    }

    public String getUsername() {
        return username;
    }
}