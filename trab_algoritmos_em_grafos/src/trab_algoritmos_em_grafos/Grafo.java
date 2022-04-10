package trab_algoritmos_em_grafos;

import java.util.ArrayList;

public class Grafo<TIPO> {

    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    public void adicionarVertice(TIPO dado) {
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim) {
        // Busca os vértices pelos dados de início e fim informados
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        // Cria uma aresta utilizando os vértices encontrados
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    public Vertice<TIPO> getVertice(TIPO dado) {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getDado().equals(dado)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public boolean isAdjacente(Vertice<TIPO> v1, Vertice<TIPO> v2) {
        boolean adjacente = false;
        for (int i = 0; i < ((ArrayList<Vertice<TIPO>>) v1.getArestasSaida()).size(); i++) {
            if (((ArrayList<Vertice<TIPO>>) v1.getArestasSaida()).get(i).getFim().equals(v2)) {
                adjacente = true;
                break;
            }
        }
        return adjacente;
    }

}
