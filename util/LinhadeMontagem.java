package util;

public class LinhadeMontagem {

    private int[] tempoEstacao;
    private int[] tempoTransporte;

    public LinhadeMontagem(int[] tempoEstacao, int[] tempoTransporte) {
        this.tempoEstacao = tempoEstacao;
        this.tempoTransporte = tempoTransporte;
    }

    public int[] getTempoEst() {
        return tempoEstacao;
    }

    public int[] getTempoTrans() {
        return tempoTransporte;
    }
}
