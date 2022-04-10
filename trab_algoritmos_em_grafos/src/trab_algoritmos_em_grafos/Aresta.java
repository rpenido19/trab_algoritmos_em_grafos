package trab_algoritmos_em_grafos;

public class Aresta<TIPO> {
    private int peso;
    private Vertice<TIPO> inicio;
    private Vertice<TIPO> fim;

    //Getters e Setters
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public Vertice<TIPO> getFim() {
        return fim;
    }
    public void setFim(Vertice<TIPO> fim) {
        this.fim = fim;
    }
    public Vertice<TIPO> getInicio() {
        return inicio;
    }
    public void setInicio(Vertice<TIPO> inicio) {
        this.inicio = inicio;
    }
    
    //Construtor
    public Aresta(int peso, Vertice<TIPO> inicio, Vertice<TIPO> fim){
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }
    
}