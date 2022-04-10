package trab_algoritmos_em_grafos;

import java.util.ArrayList;

public class Grafo {

    ArrayList<Vertice> vertices;

    public Grafo() {
        this.vertices = new ArrayList<Vertice>();
    }

    public void addVertice(Vertice v) {
        this.vertices.add(v);

    }

}
