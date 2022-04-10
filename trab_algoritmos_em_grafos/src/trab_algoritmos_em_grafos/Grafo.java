package trab_algoritmos_em_grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {

    ArrayList<Vertice> vertices;
    Queue<Vertice> fila = new LinkedList<Vertice>();

    public Grafo() {
        this.vertices = new ArrayList<Vertice>();
    }

    public void addVertice(Vertice v) {
        this.vertices.add(v);

    }

    public void dfs(Vertice v) {
        v.setVisitado(true);
        System.out.println(v.getNome());
        for (Vertice vertice : v.getVizinhos()) {
            if (!vertice.isVisitado()) {
                dfs(vertice);
            }
        }
    }

    public void bfs(Vertice v) {
        fila.add(v);
        v.setVisitado(true);
        while (!fila.isEmpty()) {
            Vertice vertice = fila.remove();
            System.out.println(vertice.getNome());
            for (Vertice vertice2 : vertice.getVizinhos()) {
                if (!vertice2.isVisitado()) {
                    fila.add(vertice2);
                    vertice2.setVisitado(true);
                }
            }
        }
    }

}
