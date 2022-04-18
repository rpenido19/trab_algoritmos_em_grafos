package trab_algoritmos_em_grafos;

import java.security.Timestamp;
import java.util.ArrayList;

public class Vertice<TIPO> {

    private TIPO codVertice;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;
    private String cor;
    private Vertice<TIPO> pai;
    private Timestamp descoberta;
    private int componente;
    
    public Vertice(TIPO codVertice) {
        this.codVertice = codVertice;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }

    // Getters e Setters
    public int getComponente() {
        return componente;
    }

    public void setComponente(int componente) {
        this.componente = componente;
    }

    public Timestamp getDescoberta() {
        return descoberta;
    }

    public void setDescoberta(Timestamp descoberta) {
        this.descoberta = descoberta;
    }

    public Vertice<TIPO> getPai() {
        return pai;
    }

    public void setPai(Vertice<TIPO> pai) {
        this.pai = pai;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public TIPO getCodVertice() {
        return codVertice;
    }

    public void setCodVertice(TIPO codVertice) {
        this.codVertice = codVertice;
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    // Adicionar arestas de entrada e saída
    public void adicionarArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void adicionarArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.add(aresta);
    }

}
