package guloso;

import util.Grafo;

public class XAEDsMaps {

    public XAEDsMaps() {
    }

    public void caminhoMinimoDijkstra(Grafo grafo, int v1, int v2) throws Exception {
        // inicia o algoritmo de Dijkstra com o grafo
        Dijkstra d = new Dijkstra(grafo);
        // gera os caminhos minimos de todos os vertices
        d.obterArvoreCMC(v1);
        // imprime o caminho minimo dos dois vertices passados como parametro
        d.imprimeCaminho(v1, v2);
        // imprime o tempo total
        d.getTempoTotal();
    }
}
