package trab_algoritmos_em_grafos;

public class GrafoNaoDirigido extends Grafo {

    public GrafoNaoDirigido() {
        super();
    }

    public boolean isAdjacent(Vertice v1, Vertice v2) {
        return v1.isVizinho(v2);
    }

    public int getGrau(Vertice v) {
        return v.getVizinhos().size();
    }

    public boolean isIsolado(Vertice v) {
        return v.getVizinhos().size() == 0;
    }

    public boolean isPendente(Vertice v) {
        return v.getVizinhos().size() == 1;
    }

    public boolean isRegular(Vertice v) {
        return v.getVizinhos().size() == v.getGrau();
    }

    public boolean isNulo(Vertice v) {
        return false;
    }

    public boolean isCompleto(Vertice v) {
        return v.getVizinhos().size() == v.getGrau();
    }

    public boolean isConexo(Vertice v) {
        return false;
    }

    public boolean isEuleriano(Vertice v) {
        return false;
    }

    public boolean isUnicursal(Vertice v) {
        return false;
    }

    public Grafo getComplementar() {
        return null;
    }

    public Grafo getAGMPrim(Vertice v1) {
        return null;
    }

    public Grafo getAGMKruskal() {
        return null;
    }

    public int getCutVertices() {
        return 0;
    }
}
