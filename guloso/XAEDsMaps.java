package guloso;

import util.Grafo;

public class XAEDsMaps {

    public XAEDsMaps() {
    }

    public void caminhoMinimoDijkstra(Grafo grafo, int v1, int v2) throws Exception {
        Dijkstra d = new Dijkstra(grafo);
        d.obterArvoreCMC(v1);                       //caminhos minimos do grafo
        d.imprimeCaminho(v1, v2);                   //imprime o caminho minimo
        d.getTempoTotal();                          //retorna o tempo total
    }
}
