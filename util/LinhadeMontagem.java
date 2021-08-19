package util;

public class LinhadeMontagem {

    private int[] stationTime;
    private int[] transportTime;

    public LinhadeMontagem(int[] stationTime, int[] transportTime) {
        this.stationTime = stationTime;
        this.transportTime = transportTime;
    }

    public int[] getStationTime() {
        return stationTime;
    }

    public int[] getTransportTime() {
        return transportTime;
    }
}
