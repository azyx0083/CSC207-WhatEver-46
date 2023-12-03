package interface_adapter.settings;

public class SettingsState {
    private String interval;
    private int dataSize;
//    private String[] favorites;
//    private String fav1;
//    private String fav2;
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

//    public String[] getFavorites() {
//        return favorites;
//    }
//
//    public void setFavorites(String[] favorites) {
//        this.favorites = favorites;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public String getFav1() {
//        return fav1;
//    }
//
//    public void setFav1(String fav1) {
//        this.fav1 = fav1;
//    }
//
//    public String getFav2() {
//        return fav2;
//    }
//
//    public void setFav2(String fav2) {
//        this.fav2 = fav2;
//    }
}
