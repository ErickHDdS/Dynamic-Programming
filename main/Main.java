package main;

import util.LinhadeMontagem;
import dinamica.Dinamica;
import guloso.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Guloso guloso;
        Dinamica programacaoDinamica;
        LinhadeMontagem L1;
        LinhadeMontagem L2;

        System.out.println("Instancia - 1");
        
        int[] A1 = new int[] {3,5,7,10,5,9,11,9,5,2,6};
        int[] A2 = new int[] {2,6,3,9,11,4,9,3,12,4,5};

        int[] T1 = new int[] {3,5,4,2,7,5,8,1};
        int[] T2 = new int[] {5,3,7,5,6,2,5,2};

        L1 = new LinhadeMontagem(A1, T1); //criando a linha 1 
        L2 = new LinhadeMontagem(A2, T2); //criando a linha 2 

        System.out.println("\nGuloso: ");

        // Aplicando o algoritmo guloso para a primeira instancia
        guloso = new Guloso(L1, L2);
        guloso.gulosoMontagem();
        guloso.caminhoMinimoGuloso();

        System.out.println("\nProgramacao Dinamica: \n");

        // Aplicando o algoritmo dinamico para a primeira instancia
        programacaoDinamica = new Dinamica(L1, L2);
        programacaoDinamica.caminhoMinimo();
        programacaoDinamica.imprimeCaminhoMinimo();

        System.out.println("Instancia - 2");

        A1 = new int[] {5,10,6,3,8,5,3,7,12,8};
        A2 = new int[] {7,3,5,3,7,6,4,9,10,9};

        T1 = new int[] {4,2,7,2,5,8,2};
        T2 = new int[] {6,1,7,3,6,4,5};

        L1 = new LinhadeMontagem(A1, T1); //criando a linha 1
        L2 = new LinhadeMontagem(A2, T2); //criando a linha 2

        System.out.println("\nGuloso: ");

        // Aplicando o algoritmo guloso para a segunda instancia
        guloso = new Guloso(L1, L2);
        guloso.gulosoMontagem();
        guloso.caminhoMinimoGuloso();

        System.out.println("\nProgramacao Dinamica: \n");

        // Aplicando o algoritmo dinamico para a segunda instancia
        programacaoDinamica = new Dinamica(L1, L2);
        programacaoDinamica.caminhoMinimo();
        programacaoDinamica.imprimeCaminhoMinimo();
    }
}