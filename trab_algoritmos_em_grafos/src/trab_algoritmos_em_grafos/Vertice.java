package trab_algoritmos_em_grafos;

import java.util.ArrayList;

public class Vertice<TIPO> {

    private TIPO codVertice;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;

    public Vertice(TIPO codVertice) {
        this.codVertice = codVertice;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }

    // Getters e Setters
    public TIPO getCodVertice() {
        return codVertice;
    }

    public void setCodVertice(TIPO codVertice) {
        this.codVertice = codVertice;
    }
    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
      return arestasSaida;
  }
    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

    // Adicionar arestas de entrada e saída
    public void adicionarArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void adicionarArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.add(aresta);
    }

}