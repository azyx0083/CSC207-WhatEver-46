package use_case.settings;

public class SettingsInputData {
    final private String interval;
    final private int dataSize;
    final private String username;
    public SettingsInputData(String interval, int dataSize, String username) {
        this.interval = interval;
        this.dataSize = dataSize;
        this.username = username;
    }

    public String getInterval() {
        return interval;
    }

    public int getDataSize() {
        return dataSize;
    }

    public String getUsername() {
        return username;
    }
}
