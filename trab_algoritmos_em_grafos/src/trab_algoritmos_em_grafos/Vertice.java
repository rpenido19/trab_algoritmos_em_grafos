package trab_algoritmos_em_grafos;

import java.util.ArrayList;

public class Vertice<TIPO> {

    private TIPO dado;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;

    public Vertice(TIPO dado) {
        this.dado = dado;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }

    // Getters e Setters
    public TIPO getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = dado;
    }

    // Adicionar arestas de entrada e saída
    public void adicionarArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void adicionarArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.add(aresta);
    }

    public Object getArestasSaida() {
        return null;
    }

    public Object getFim() {
        return null;
    }

}
