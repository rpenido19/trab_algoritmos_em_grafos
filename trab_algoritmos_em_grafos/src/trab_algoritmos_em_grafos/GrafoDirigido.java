package trab_algoritmos_em_grafos;

public class GrafoDirigido extends Grafo {
    public GrafoDirigido() {
        super();
    }

    public int getGrauEntrada(Vertice v) {
        int grau = 0;
        for (Vertice vertice : this.vertices) {
            for (Vertice vizinho : vertice.getVizinhos()) {
                if (vizinho.equals(v)) {
                    grau++;
                }
            }
        }
        return grau;
    }

    public int getGrauSaida(Vertice v) {
        int grau = 0;
        for (Vertice vertice : this.vertices) {
            for (Vertice vizinho : vertice.getVizinhos()) {
                if (vertice.equals(v)) {
                    grau++;
                }
            }
        }
        return grau;
    }

    public boolean hasCiclo(Vertice v) {
        boolean hasCiclo = false;
        for (Vertice vertice : this.vertices) {
            for (Vertice vizinho : vertice.getVizinhos()) {
                if (vertice.equals(v) && vizinho.equals(v)) {
                    hasCiclo = true;
                }
            }
        }
        return hasCiclo;
    }

}
