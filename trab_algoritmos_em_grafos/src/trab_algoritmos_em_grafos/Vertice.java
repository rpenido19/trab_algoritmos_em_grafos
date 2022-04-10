package trab_algoritmos_em_grafos;

import java.util.ArrayList;

public class Vertice {

    private String nome;
    private int grau;
    private ArrayList<Vertice> vizinhos;

    public Vertice(String nome) {
        this.nome = nome;
        this.grau = 0;
        this.vizinhos = new ArrayList<Vertice>();
    }

    public void addVertice(Vertice v) {
        if (!isVizinho(v)) {
            this.vizinhos.add(v);
            this.grau++;
        }
    }

    public boolean isVizinho(Vertice v) {
        return this.vizinhos.contains(v);
    }

    public ArrayList<Vertice> getVizinhos() {
        return this.vizinhos;
    }

    public int getGrau() {
        return this.grau;
    }
}
