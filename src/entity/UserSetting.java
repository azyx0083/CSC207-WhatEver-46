package entity;

public class UserSetting {
    private String interval;
    private int outputSize;

    public UserSetting(String interval, int outputSize) {
        this.interval = interval;
        this.outputSize = outputSize;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public int getOutputSize() {
        return outputSize;
    }

    public void setOutputSize(int outputSize) {
        this.outputSize = outputSize;
    }

}
