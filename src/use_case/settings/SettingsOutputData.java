package use_case.settings;

public class SettingsOutputData {
    final private String interval;
    final private int dataSize;
//    final private String[] favorites;
    public SettingsOutputData(String interval, int dataSize) {
        this.interval = interval;
        this.dataSize = dataSize;
//        this.favorites = favorites;
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
