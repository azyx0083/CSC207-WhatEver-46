package interface_adapter.settings;

public class SettingsState {
    private String interval;
    private int dataSize;
    private String[] favorites;
    private String username;

    public SettingsState() {

    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public String[] getFavorites() {
        return favorites;
    }

    public void setFavorites(String[] favorites) {
        this.favorites = favorites;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
