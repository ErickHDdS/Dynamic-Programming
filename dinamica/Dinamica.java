package dinamica;

import util.LinhaDeMontagem;

public class Dinamica {

    private LinhaDeMontagem L1, L2; 
    private int[] tempoMin1, tempoMin2; 
    private int[] caminho1, caminho2;   // vetores para guardar o caminho de quais linhas devem ser seguidas
    private int tempoFinal, linhaFinal; // valores que armazenarao a saida otima
    private int i;                     

    public Dinamica(LinhaDeMontagem L1, LinhaDeMontagem L2) {
        this.tempoMin1 = new int[L1.getStationTime().length - 2];
        this.tempoMin2 = new int[L2.getStationTime().length - 2];
        this.caminho1 = new int[L1.getStationTime().length - 2];
        this.caminho2 = new int[L2.getStationTime().length - 2];

        // inicializa a primeira posicao do primeiro vetor dos caminhos minimos
        tempoMin1[0] = L1.getStationTime()[0] + L1.getStationTime()[1];
        tempoMin2[0] = L2.getStationTime()[0] + L2.getStationTime()[1]; 

        caminho1[0] = 1; 
        caminho2[0] = 2; 

        this.L1 = L1;
        this.L2 = L2;
        this.i = 1;
    }

    // método que calcula o caminho minimo entre a entrada e saida
    public void caminhoMinimo() {
        // loop que comeca do 2 para que nao haja conflitos em arrays diferentes e de tamanhos diferentes
        for (i = 2; i <= L1.getStationTime().length - 2; i++) {

            // tempo para se manter na estacao 1 e 2
            int tempo1 = tempoMin1[i - 2] + L1.getStationTime()[i];
            int tempo2 = tempoMin2[i - 2] + L2.getTransportTime()[i - 2] + L1.getStationTime()[i];

            // compara qual dos dois custos e melhor para ser armazenado no vetor
            if (tempo1 <= tempo2) {
                // salva o tempo 1 que é a subsolucao otima e que o caminha contem a solução
                tempoMin1[i - 1] = tempo1;
                caminho1[i - 1] = 1;
            } else {
                // salva o tempo 2 que é a subsolucao otima e que o caminha contem a solução
                tempoMin1[i - 1] = tempo2;
                caminho1[i - 1] = 2;
            }

            // tempo para se manter na estacao 1 e 2
            tempo1 = tempoMin2[i - 2] + L2.getStationTime()[i];
            tempo2 = tempoMin1[i - 2] + L1.getTransportTime()[i - 2] + L2.getStationTime()[i];

            // compara qual dos dois custos e melhor para ser armazenado no vetor
            if (tempo1 <= tempo2) {
                // salva o tempo 1 que é a subsolucao otima e que o caminha contem a solução
                tempoMin2[i - 1] = tempo1;
                caminho2[i - 1] = 2;
            } else {
                // salva o tempo 2 que é a subsolucao otima e que o caminha contem a solução
                tempoMin2[i - 1] = tempo2;
                caminho2[i - 1] = 1;
            }
        }

        // calcula qual saida é otima
        if (tempoMin1[i - 2] + L1.getStationTime()[L1.getStationTime().length - 1] <= tempoMin2[i - 2]
                + L2.getStationTime()[L2.getStationTime().length - 1]) {
            // armazena a saida otima caso seja a primeira e registra que e na linha 1
            tempoFinal = tempoMin1[i - 2] + L1.getStationTime()[L1.getStationTime().length - 1];
            linhaFinal = 1;
        } else {
            // armazena a saida otima caso seja a primeira e registra que e na linha 2
            tempoFinal = tempoMin2[i - 2] + L2.getStationTime()[L2.getStationTime().length - 1];
            linhaFinal = 2;
        }

    }

    public void imprimeCaminhoMinimo() {
        int j = linhaFinal;
        // printa a primeira linha antes do loop
        System.out.println("Linha: " + j + "   Estação: " + (L1.getStationTime().length - 2));
        // loop decrescente, da ultima estacao ate a primeira
        for (i = L1.getStationTime().length - 2; i > 1; i--) {
            // condicao para qual linha deve ser printada, de acordo com os valores salvos
            // nos vetores l1 e l2, na funcao caminhoMinimo()
            if (j == 1) {
                j = caminho1[i - 1];
            } else {
                j = caminho2[i - 1];
            }
            // printa as estacoes e linhas de acordo com os valores previamente armazenados
            System.out.println("Linha: " + j + "   Estacao: " + (i - 1));
        }
        // ao final imprime o tempo total
        System.out.println("\nTempo gasto: " + tempoFinal + "\n\n");
    }
}
