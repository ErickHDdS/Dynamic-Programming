/*
 Disponibilizado em Projeto de Algoritmos com implementações em Java e C++
 Autor: Nivio Ziviani
*/
package guloso;

import util.FPHeapMinIndireto;
import util.Grafo;

public class Dijkstra {

    private int antecessor[];
    private double p[];
    private Grafo grafo;
    private int tempoTotal;

    public void getTempoTotal() {
        System.out.println("\nTempo total: " + tempoTotal);
    }

    public Dijkstra(Grafo grafo) {
        this.grafo = grafo;
        this.tempoTotal = 0;
    }

    public void obterArvoreCMC(int raiz) throws Exception {
        int n = this.grafo.numVertices();
        this.p = new double[n];                             //peso dos vertices
        int vs[] = new int[n + 1];                          //vertices
        this.antecessor = new int[n];
        for (int u = 0; u < n; u++) {
            this.antecessor[u] = -1;
            p[u] = Double.MAX_VALUE;                        //p tem o maximo valor possivel 
            vs[u + 1] = u;                                  //Heap indireto a ser construído
        }
        p[raiz] = 0;
        FPHeapMinIndireto heap = new FPHeapMinIndireto(p, vs);
        heap.constroi();
        while (!heap.vazio()) {
            int u = heap.retiraMin();
            if (!this.grafo.listaAdjVazia(u)) {
                Grafo.Aresta adj = grafo.primeiroListaAdj(u);
                while (adj != null) {
                    int v = adj.v2();
                    if (this.p[v] > (this.p[u] + adj.peso().getPesoTotal())) {
                        antecessor[v] = u;
                        heap.diminuiChave(v, this.p[u] + adj.peso().getPesoTotal());
                    }
                    adj = grafo.proxAdj(u);
                }
            }
        }
    }

    public int antecessor(int u) {
        return this.antecessor[u];
    }

    public double peso(int u) {
        return this.p[u];
    }

    public void imprimeCaminho(int origem, int v) {
        if (origem == v) 
            return;
        else if (this.antecessor[v] == -1) 
            System.out.println("Nao existe caminho de " + origem + " ate " + v);
        else {
            imprimeCaminho(origem, this.antecessor[v]);                     //imprimindo recursivamente o caminho
            System.out.println("Aresta " + antecessor[v] + " a " + v);      //arestas
            System.out.println("Distancia: " + grafo.mat[antecessor[v]][v].getDistancia() + "  Tempo: " + grafo.mat[antecessor[v]][v].getDistancia());      //distancia e tempo
            tempoTotal += grafo.mat[antecessor[v]][v].getDistancia();       //tempo total gasto
        }
    }
}
