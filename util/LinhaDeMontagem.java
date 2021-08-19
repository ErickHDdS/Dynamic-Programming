package util;

public class LinhaDeMontagem {

    private int[] stationTime;
    private int[] transportTime;

    public LinhaDeMontagem(int[] stationTime, int[] transportTime) {
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
