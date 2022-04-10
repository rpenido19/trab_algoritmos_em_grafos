package trab_algoritmos_em_grafos;

import java.util.ArrayList;

public class Grafo<TIPO> {

    private String tipoGrafo;
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;

    public Grafo(String tipoGrafo) {
        this.tipoGrafo = tipoGrafo;
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    public void adicionarVertice(TIPO codVertice) {
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(codVertice);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(int peso, TIPO codVerticeInicio, TIPO codVerticeFim) {
        // Busca os vértices pelos dados de início e fim informados
        Vertice<TIPO> inicio = this.getVertice(codVerticeInicio);
        Vertice<TIPO> fim = this.getVertice(codVerticeFim);
        // Cria uma aresta utilizando os vértices encontrados
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        if(this.tipoGrafo.equals("NAO DIRECIONADO")){
            inicio.adicionarArestaEntrada(aresta);
            inicio.adicionarArestaSaida(aresta);
            fim.adicionarArestaEntrada(aresta);
            fim.adicionarArestaSaida(aresta);
        }else if(this.tipoGrafo.equals("DIRECIONADO")){
            inicio.adicionarArestaSaida(aresta);
            fim.adicionarArestaEntrada(aresta);
        }else{
            System.out.println("ERRO - TIPO DE GRAFO NÃO EXISTENTE");
        }
        this.arestas.add(aresta);
    }

    public Vertice<TIPO> getVertice(TIPO codVertice) {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getCodVertice().equals(codVertice)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public boolean isAdjacente(TIPO vertice1, TIPO vertice2) {
        if(this.tipoGrafo.equals("NAO DIRECIONADO")){
            Vertice<TIPO> v1 = this.getVertice(vertice1);
            Vertice<TIPO> v2 = this.getVertice(vertice2);
            boolean adjacente = false;
            for (int i = 0; i < v1.getArestasSaida().size(); i++) {
                if (v1.getArestasSaida().get(i).getCodVertice().equals(v2)) {
                    adjacente = true;
                    break;
                }
            }
            return adjacente;
        }else{
            System.out.println("ERRO - MÉTODO DISPONÍVEL APENAS PARA GRAFOS NÃO DIRECIONADOS");
            return false;
        }
        
    }

}
