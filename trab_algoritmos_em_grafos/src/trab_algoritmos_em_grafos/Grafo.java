package trab_algoritmos_em_grafos;

import java.util.ArrayList;

public class Grafo<TIPO> {

    private String tipoGrafo;
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;

    //Construtor
    public Grafo(String tipoGrafo) {
        this.tipoGrafo = tipoGrafo;
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    //Adicionar vértice
    public void adicionarVertice(TIPO codVertice) {
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(codVertice);
        this.vertices.add(novoVertice);
    }

    //Adicionar aresta
    public void adicionarAresta(int peso, TIPO codVerticeInicio, TIPO codVerticeFim) {
        // Busca os vértices pelos dados de início e fim informados
        Vertice<TIPO> inicio = this.getVertice(codVerticeInicio);
        Vertice<TIPO> fim = this.getVertice(codVerticeFim);
        // Cria uma aresta utilizando os vértices encontrados
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        if(this.tipoGrafo == "NAO DIRECIONADO"){
            inicio.adicionarArestaEntrada(aresta);
            inicio.adicionarArestaSaida(aresta);
            fim.adicionarArestaEntrada(aresta);
            fim.adicionarArestaSaida(aresta);
        }else if(this.tipoGrafo == "NAO DIRECIONADO"){
            inicio.adicionarArestaSaida(aresta);
            fim.adicionarArestaEntrada(aresta);
        }else{
            System.out.println("Erro - Tipo de grafo não existente");
        }
        this.arestas.add(aresta);
    }

    //Retorna todos os dados referente ao vértice
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

    //Verifica se dois vértices são adjacentes ou não
    public boolean isAdjacente(TIPO vertice1, TIPO vertice2) {
        if(this.tipoGrafo.equals("NAO DIRECIONADO")){
            Vertice<TIPO> v1 = this.getVertice(vertice1);
            Vertice<TIPO> v2 = this.getVertice(vertice2);
            boolean adjacente = false;
            for (int i = 0; i < v1.getArestasSaida().size(); i++) {
                if (v2.getCodVertice().equals(v1.getArestasSaida().get(i).getFim().getCodVertice())) {
                    adjacente = true;
                    break;
                }
            }
            for (int i = 0; i < v2.getArestasSaida().size(); i++) {
                if (v1.getCodVertice().equals(v2.getArestasSaida().get(i).getFim().getCodVertice())) {
                    adjacente = true;
                    break;
                }
            }
            if(adjacente == true){
                System.out.println("Sim, é adjacente");
            }else{
                System.out.println("Não é adjacente");
            }
            return adjacente;
        }else if(this.tipoGrafo.equals("DIRECIONADO")){
            Vertice<TIPO> v1 = this.getVertice(vertice1);
            Vertice<TIPO> v2 = this.getVertice(vertice2);
            boolean adjacente = false;
            for (int i = 0; i < v1.getArestasSaida().size(); i++) {
                if (v2.getCodVertice().equals(v1.getArestasSaida().get(i).getFim().getCodVertice())) {
                    adjacente = true;
                    break;
                }
            }
            if(adjacente == true){
                System.out.println("Sim, é adjacente");
            }else{
                System.out.println("Não é adjacente");
            }
            return adjacente;
        }else{
            System.out.println("ERRO - TIPO DE GRAFO NÃO EXISTENTE");
            return false;
        }
        
    }

    //Retorna o grau de um vértice
    public int getGrau(TIPO codVertice){
        Vertice<TIPO> vertice = getVertice(codVertice);
        int countGrau = 0;
        for (int i = 0; i < vertice.getArestasSaida().size(); i++) {
            if (vertice.getCodVertice().equals(vertice.getArestasSaida().get(i).getFim().getCodVertice()) || vertice.getCodVertice().equals(vertice.getArestasSaida().get(i).getInicio().getCodVertice())) {
                countGrau++;
            }
        }
        System.out.println("Grau do vértice: " + countGrau);
        return countGrau;
    }

    //Retorna se o vértice é isolado ou não
    public boolean isIsolado(TIPO codVertice){
        int grau = getGrau(codVertice);
        if(grau == 0){
            System.out.println("O vértice está isolado");
            return true;
        }else{
            System.out.println("O vértice não está isolado");
            return false;
        }
    }

    //Retorna se o vértice é pendente ou não
    public boolean isPendente(TIPO codVertice) {
        return getGrau(codVertice) == 1;     
    }

}