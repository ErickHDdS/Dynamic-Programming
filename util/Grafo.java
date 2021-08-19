package util;

public class Grafo {

    public class Peso {

        private int distancia, tempo;

        public Peso(int distancia, int tempo) {
            this.distancia = distancia;
            this.tempo = tempo;
        }

        public Peso(int distancia) {
            this.distancia = distancia;
            this.tempo = 0;
        }

        public int getDistancia() {
            return this.distancia;
        }

        public int getTempo() {
            return this.tempo;
        }

        public void setDistancia(int distancia) {
            this.distancia = distancia;
        }

        public void setTempo(int tempo) {
            this.tempo = tempo;
        }

        public int getPesoTotal() {
            return this.distancia + this.tempo;
        }

        @Override
        public String toString() {
            return distancia + "";
        }

    }

    public static class Aresta {

        private int v1, v2;
        private Peso peso;

        public Aresta(int v1, int v2, Peso peso) {
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
        }

        public Peso peso() {
            return this.peso;
        }

        public int v1() {
            return this.v1;
        }

        public int v2() {
            return this.v2;
        }

        public void setV1(int v1) {
            this.v1 = v1;
        }

        public void setV2(int v2) {
            this.v2 = v2;
        }

        public void setPeso(Peso peso) {
            this.peso = peso;
        }

    }

    public Peso mat[][]; // pesos do tipo inteiro
    private int numVertices;
    private int pos[]; // posicao atual ao se percorrer os adjs de um vertice v

    public Grafo(int numVertices) {
        this.mat = new Peso[numVertices][numVertices];
        this.pos = new int[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++)
                this.mat[i][j] = null;
            this.pos[i] = -1;
        }
    }

    public void insereAresta(int v1, int v2, int distancia, int tempo) {
        Peso p = new Peso(distancia, tempo);
        this.mat[v1][v2] = p;
    }

    public void insereAresta(int v1, int v2, int distancia) {
        Peso p = new Peso(distancia);
        this.mat[v1][v2] = p;
    }

    public boolean existeAresta(int v1, int v2) {
        return (this.mat[v1][v2] != null);
    }

    public boolean listaAdjVazia(int v) {
        for (int i = 0; i < this.numVertices; i++) {
            if (this.mat[v][i] != null)
                return false;
        }
        return true;
    }

    /*
     * retorna a primeira aresta que o vertice v participa ou se a lista de
     * adjacencia de v for vazia
     */
    public Aresta primeiroListaAdj(int v) {
        this.pos[v] = -1;
        return this.proxAdj(v);
    }

    /*
     * retorna a proxima aresta que o vertice v participa ou se a lista de
     * adjacencia de v estiver no fim
     */
    public Aresta proxAdj(int v) {
        this.pos[v]++;
        while ((this.pos[v] < this.numVertices) && (this.mat[v][this.pos[v]] == null))
            this.pos[v]++;
        if (this.pos[v] == this.numVertices)
            return null;
        else
            return new Aresta(v, this.pos[v], this.mat[v][this.pos[v]]);

    }

    public Aresta retiraAresta(int v1, int v2) {
        if (this.mat[v1][v2] == null)
            return null; // @{\it Aresta n\~ao existe}@
        else {
            Aresta aresta = new Aresta(v1, v2, this.mat[v1][v2]);
            this.mat[v1][v2] = null;
            return aresta;
        }
    }

    public int numVertices() {
        return this.numVertices;
    }

    public Grafo grafoTransposto() {
        Grafo grafoT = new Grafo(this.numVertices);
        for (int v = 0; v < this.numVertices; v++) {
            if (!this.listaAdjVazia(v)) {
                Aresta adj = this.primeiroListaAdj(v);
                while (adj != null) {
                    grafoT.insereAresta(adj.v2(), adj.v1(), adj.peso().distancia, adj.peso().tempo);
                    adj = this.proxAdj(v);
                }
            }
        }
        return grafoT;
    }

    public void imprime() {
        System.out.println();
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print("[" + i + "]-> ");
            for (int j = 0; j < this.numVertices; j++) {
                if (this.mat[i][j] != null)
                    System.out.print(j + " > ");
            }
            System.out.println(".");
        }
        System.out.println();
    }
}
