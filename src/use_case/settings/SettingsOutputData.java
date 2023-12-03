package use_case.settings;

public class SettingsOutputData {
    final private String username;
    final private String interval;
    final private int dataSize;
//    final private String[] favorites;
    public SettingsOutputData(String username, String interval, int dataSize) {
        this.username = username;
        this.interval = interval;
        this.dataSize = dataSize;
//        this.favorites = favorites;
    }

    public String getUsername() {
        return username;
    }

    public String getInterval() {
        return interval;
    }

    public int getDataSize() {
        return dataSize;
    }

//    public String[] getFavorites() {
//        return favorites;
//    }
}
