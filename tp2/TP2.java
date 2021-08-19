package tp2;

import programacaoDinamica.ProgramacaoDinamica;
import util.LinhadeMontagem;
import guloso.*;

public class TP2 {

    public static void main(String[] args) throws Exception {
        Guloso guloso;
        ProgramacaoDinamica programacaoDinamica;
        LinhadeMontagem Linha1;
        LinhadeMontagem Linha2;

        System.out.println("Instancia 1");
        /*
         * tempo de processamento de cada estação na Linha 1 com o primeiro e último
         * elementos sendo o tempo de entrada e saida dessa linha, respectivamente
         */
        int[] tempoEstacao1 = new int[] { 3, 5, 7, 10, 5, 9, 11, 9, 5, 2, 6 };
        /*
         * tempo de processamento de cada estação na Linha 2 com o primeiro e último
         * elementos sendo o tempo de entrada e saida dessa linha, respectivamentes
         */
        int[] tempoEstacao2 = new int[] { 2, 6, 3, 9, 11, 4, 9, 3, 12, 4, 5 };

        // tempo de transporte de uma Estacao na Linha 1 até a Estacao seguinte na Linha
        // 2
        int[] tempoTransporte1 = new int[] { 3, 5, 4, 2, 7, 5, 8, 1 };
        // tempo de transporte de uma Estacao na Linha 2 até a Estacao seguinte na Linha
        // 1
        int[] tempoTransporte2 = new int[] { 5, 3, 7, 5, 6, 2, 5, 2 };

        Linha1 = new LinhadeMontagem(tempoEstacao1, tempoTransporte1); // cria a linha 1 com seus respectivos custos de
                                                                       // estações e transportes
        Linha2 = new LinhadeMontagem(tempoEstacao2, tempoTransporte2); // cria a linha 2 com seus respectivos custos de
                                                                       // estações e transportes

        System.out.println("\nGuloso: ");
        // Roda o algoritmo guloso para a instancia 1
        guloso = new Guloso(Linha1, Linha2);
        guloso.gulosoMontagem();
        guloso.caminhoMinimoGuloso();

        System.out.println("\nProgramacao Dinamica: \n");
        // roda o algoritmo exponencial para a nstancia 1
        programacaoDinamica = new ProgramacaoDinamica(Linha1, Linha2);
        programacaoDinamica.caminhoMinimo();
        programacaoDinamica.imprimeCaminhoMinimo();

        System.out.println("Instancia 2");

        tempoEstacao1 = new int[] { 5, 10, 6, 3, 8, 5, 3, 7, 12, 8 };
        tempoEstacao2 = new int[] { 7, 3, 5, 3, 7, 6, 4, 9, 10, 9 };

        tempoTransporte1 = new int[] { 4, 2, 7, 2, 5, 8, 2 };
        tempoTransporte2 = new int[] { 6, 1, 7, 3, 6, 4, 5 };

        Linha1 = new LinhadeMontagem(tempoEstacao1, tempoTransporte1); // cria a linha A1 com seus respectivos custos de
                                                                       // estações e transportes
        Linha2 = new LinhadeMontagem(tempoEstacao2, tempoTransporte2); // cria a linha A2 com seus respectivos custos de
                                                                       // estações e transportes

        System.out.println("\nGuloso: ");
        // Roda o algoritmo guloso para a instancia 2
        guloso = new Guloso(Linha1, Linha2);
        guloso.gulosoMontagem();
        guloso.caminhoMinimoGuloso();

        System.out.println("\nProgramacao Dinamica: \n");
        // roda o algoritmo exponencial para a instancia 2
        programacaoDinamica = new ProgramacaoDinamica(Linha1, Linha2);
        programacaoDinamica.caminhoMinimo();
        programacaoDinamica.imprimeCaminhoMinimo();
    }
}
