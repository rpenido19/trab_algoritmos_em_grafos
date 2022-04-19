package trab_algoritmos_em_grafos;

import java.util.ArrayList;

public class Grafo<TIPO> {

    private int qntVertices;
    private String tipoGrafo;
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;
    private int timestamp;
    private int componentes;
    private boolean hasCiclo;
    private TIPO verticeAnalisadoCiclo;

    //Construtor
    public Grafo(String tipoGrafo) {
        this.tipoGrafo = tipoGrafo;
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    //Getters e Setters
    public void setTipoGrafo(String tipoGrafo){
        this.tipoGrafo = tipoGrafo;
    }

    //Adicionar vértice
    public void adicionarVertice(TIPO codVertice) {
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(codVertice);
        this.vertices.add(novoVertice);
        this.qntVertices++;
    }

    //Adicionar aresta
    public void adicionarAresta(int peso, TIPO codVerticeInicio, TIPO codVerticeFim) {
        // Busca os vértices pelos dados de início e fim informados
        Vertice<TIPO> inicio = this.getVertice(codVerticeInicio);
        Vertice<TIPO> fim = this.getVertice(codVerticeFim);
        // Cria uma aresta utilizando os vértices encontrados
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        if(this.tipoGrafo == "NAO DIRECIONADO"){
            inicio.adicionarVizinho(fim);
            inicio.adicionarArestaEntrada(aresta);
            inicio.adicionarArestaSaida(aresta);
            fim.adicionarVizinho(inicio);
            fim.adicionarArestaEntrada(aresta);
            fim.adicionarArestaSaida(aresta);
        }else if(this.tipoGrafo == "DIRECIONADO"){
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

    //Retorna se o grafo é regular ou não
    public boolean isRegular(ArrayList<Integer> verticesGrafo){
        TIPO codVertice;
        boolean isRegular = true;
        int repeticoes = 0;
        int grauTemp = 0;
        for(Integer vertice : verticesGrafo){
            codVertice = (TIPO) vertice;
            if(repeticoes == 0){
                grauTemp = getGrau(codVertice);
            }else{
                if(grauTemp!=getGrau(codVertice)){
                    isRegular = false;
                    break;
                }
            }
            repeticoes++;
        }
        return isRegular;
    }

    //Retorna se o grafo é nulo ou não
    public boolean isNulo(ArrayList<Integer> verticesGrafo){
        TIPO codVertice;
        boolean isNulo = true;
        int grauTemp = 0;
        for(Integer vertice : verticesGrafo){
            codVertice = (TIPO) vertice;
            if(grauTemp!=getGrau(codVertice)){
                isNulo = false;
            }
        }
        return isNulo;
    }

    //Retorna se o grafo é completo
    public boolean isCompleto(ArrayList<Integer> verticesGrafo){
        System.out.println("Quantidade de vértices: " + this.qntVertices);
        TIPO codVertice;
        boolean isCompleto = true;
        int grauTemp = this.qntVertices - 1;
        for(Integer vertice : verticesGrafo){
            codVertice = (TIPO) vertice;
            if(grauTemp!=getGrau(codVertice)){
                isCompleto = false;
            }
        }
        return isCompleto;
    }

    //Retorna o grau de entrada de um vértice
    public int getGrauEntrada(TIPO codVertice){
        Vertice<TIPO> vertice = getVertice(codVertice);
        int countGrau = vertice.getArestasEntrada().size();
        System.out.println("Grau de entrada do vértice: " + countGrau);
        return countGrau;
    }

    //Retorna o grau de saída de um vértice
    public int getGrauSaida(TIPO codVertice){
        Vertice<TIPO> vertice = getVertice(codVertice);
        int countGrau = vertice.getArestasSaida().size();
        System.out.println("Grau de saída do vértice: " + countGrau);
        return countGrau;
    }

    //Retorna se um grafo é conexo ou não
    public boolean isConexo(ArrayList<Integer> verticesGrafo){
        TIPO codVertice;
        this.componentes = 1;
        this.timestamp = 0;
        boolean isConexo = true;
        for(Integer codVerticeTemp : verticesGrafo){
            codVertice = (TIPO) codVerticeTemp;
            Vertice<TIPO> vertice = getVertice(codVertice);
            vertice.setCor("branco");
            vertice.setPai(null);
        }
        for(Integer codVerticeTemp : verticesGrafo){
            codVertice = (TIPO) codVerticeTemp;
            Vertice<TIPO> vertice = getVertice(codVertice);
            if(vertice.getCor()=="branco"){
                isConexoVisita(vertice);
                this.componentes++;
            }
        }
        //Verifica com final de todos os vértices
        for(Integer codVerticeTemp : verticesGrafo){
            codVertice = (TIPO) codVerticeTemp;
            Vertice<TIPO> vertice = getVertice(codVertice);
            System.out.println("Componentes do vértice " + vertice.getCodVertice() + ": " + vertice.getComponente());
            if(vertice.getComponente()!=1){
                isConexo = false;
            }
        }
        return isConexo;
    }

    //Realiza a visita de um vértice (para analisar se é conexo)
    public void isConexoVisita(Vertice<TIPO> vertice){
        Vertice<TIPO> verticeVizinho;
        this.timestamp++; 
        vertice.setDescoberta(this.timestamp);
        vertice.setCor("cinza");
        vertice.setComponente(this.componentes);
        System.out.println("Vértice analisado: " + vertice.getCodVertice());
        for(Vertice<TIPO> verticeVizinhoTemp : vertice.getVizinhos()){
            System.out.println("Vértice vizinho a ser analisado: " + verticeVizinhoTemp.getCodVertice());
            verticeVizinho = getVertice(verticeVizinhoTemp.getCodVertice());
            if(verticeVizinho.getCor()=="branco"){
                verticeVizinho.setPai(vertice);
                isConexoVisita(verticeVizinho);
            }
        }
        vertice.setCor("preto");
        this.timestamp++;
        vertice.setDescoberta(this.timestamp);
    }

    //Retorna se o grafo é euleriano
    public boolean isEuleriano(ArrayList<Integer> verticesGrafo){
        if(isConexo(verticesGrafo)){
            //System.out.println("Quantidade de vértices: " + this.qntVertices);
            TIPO codVertice;
            boolean isEuleriano = true;
            int grauTemp = 0;
            for(Integer vertice : verticesGrafo){
                codVertice = (TIPO) vertice;
                if(grauTemp!=(getGrau(codVertice)%2)){
                    System.out.println("Vértice ímpar");
                    isEuleriano = false;
                }else{
                    System.out.println("Vértice par");
                }
            }
            return isEuleriano;
        }else{
            return false;
        }
    }

    //Retorna se o grafo é euleriano
    public boolean isUnicursal(ArrayList<Integer> verticesGrafo){
        if(isConexo(verticesGrafo)){
            //System.out.println("Quantidade de vértices: " + this.qntVertices);
            TIPO codVertice;
            int grauTemp = 0;
            int contGrauImpares = 0;
            for(Integer vertice : verticesGrafo){
                codVertice = (TIPO) vertice;
                if(grauTemp!=(getGrau(codVertice)%2)){
                    System.out.println("Vértice ímpar");
                    contGrauImpares++;
                }else{
                    System.out.println("Vértice par");
                }
            }
            if(contGrauImpares==2){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    //Retorna sua árvore geradora mínima usando o algoritmo de Prim
    public void getAGMPrim(TIPO codVertice){
        boolean continuarExecutandoWhile = true;
        ArrayList<Integer> pais = new ArrayList<>();
        int i, primeiro, dest=0, menorPeso=0;
        TIPO tempCodVertice;
        Vertice<TIPO> tempVertice;
        ArrayList<Aresta<TIPO>> tempArestas;
        int tempFimVertice;
        for(i=0; i<=this.qntVertices; i++){
            pais.add(-1); //-1 sem pai, 1 com pai
        }
        pais.set((Integer) codVertice, (Integer) codVertice);
        while(continuarExecutandoWhile){
            primeiro = 1;
            for(i = 1; i<=this.qntVertices; i++){
                if(pais.get(i)!=-1){
                    tempCodVertice = (TIPO) Integer.valueOf(i); //convertendo int para TIPO (código do vértice)
                    tempVertice = getVertice(tempCodVertice); //buscando vértice pelo código
                    tempArestas = tempVertice.getArestasSaida(); //buscando arestas de saída
                    for(Aresta<TIPO> aresta : tempArestas){ //para cada aresta faça
                        tempFimVertice = (int) aresta.getFim().getCodVertice(); //pega o vértice vizinho e converte em int
                        if(pais.get(tempFimVertice)==-1){ //analisa se o vértice vizinho não tem pai
                            if(primeiro==1){
                                menorPeso = aresta.getPeso();
                                codVertice = tempCodVertice;
                                dest = (int) aresta.getFim().getCodVertice();
                                primeiro = 0;
                            }else{
                                if(menorPeso > aresta.getPeso()){
                                    menorPeso = aresta.getPeso();
                                    codVertice = tempCodVertice;
                                    dest = (int) aresta.getFim().getCodVertice();
                                }
                            }
                        }
                    }
                }
            }
            if(primeiro == 1){
                continuarExecutandoWhile = false;
                break;
            }else{
                pais.set(dest, (Integer) codVertice);
            }
        }
        int verticeNumber = 0;
        for(int pai : pais){
            if(verticeNumber!=0){
                System.out.println("Vértice: " + verticeNumber + "/ Pai: " + pai);
            }
            verticeNumber++;
        }
    }

    //Verifica se existem ciclos ou não no grafo
    public boolean hasCiclo(ArrayList<Integer> verticesGrafo){
        TIPO codVertice;
        this.hasCiclo = false;
        this.timestamp = 0;
        for(Integer codVerticeTemp : verticesGrafo){
            //Settando todos os vértices como branco para fazer a análise vértice a vértice
            for(Integer limparCodVerticeTemp : verticesGrafo){
                codVertice = (TIPO) limparCodVerticeTemp;
                Vertice<TIPO> vertice = getVertice(codVertice);
                vertice.setCor("branco");
                vertice.setPai(null);
            }
            codVertice = (TIPO) codVerticeTemp;
            Vertice<TIPO> vertice = getVertice(codVertice);
            this.verticeAnalisadoCiclo = vertice.getCodVertice();
            System.out.println("--- Vértice analisado: " + vertice.getCodVertice() + " ---");
            if(vertice.getCor() == "branco"){
                hasCicloVisita(vertice);
            }
        }
        return this.hasCiclo;
    }

    //Realiza a visita de um vértice da função hasCiclo()
    public void hasCicloVisita(Vertice<TIPO> vertice){
        Vertice<TIPO> verticeVizinho;
        ArrayList<Aresta<TIPO>> arestasSaida;
        this.timestamp++;
        vertice.setDescoberta(this.timestamp);
        vertice.setCor("cinza");
        System.out.println("Percorrendo vértice: " + vertice.getCodVertice());
        arestasSaida = vertice.getArestasSaida();
        for(Aresta<TIPO> arestaSaidaTemp : arestasSaida){
            verticeVizinho = arestaSaidaTemp.getFim();
            System.out.println("Vértice vizinho: " + verticeVizinho.getCodVertice());
            if(verticeVizinho.getCodVertice() == this.verticeAnalisadoCiclo){
                System.out.println("Ciclo encontrado!");
                this.hasCiclo = true;
            }
            verticeVizinho = getVertice(verticeVizinho.getCodVertice());
            if(verticeVizinho.getCor()=="branco"){
                verticeVizinho.setPai(vertice);
                hasCicloVisita(verticeVizinho);
            }
        }
        vertice.setCor("preto");
        this.timestamp++;
        vertice.setTermino(timestamp);
    }

    //Retorna o grafo complementar
    public Grafo<TIPO> getComplementar(ArrayList<Integer> verticesGrafo){
        Vertice<TIPO> vertice;
        Vertice<TIPO> verticeTemp;
        Grafo<TIPO> grafoComplementar = new Grafo<>("NAO DIRECIONADO");
        if(isCompleto(verticesGrafo)){
            return this;
        }else{
            for(Integer codVertice : verticesGrafo){
                vertice = getVertice((TIPO) codVertice);
                for(Integer codVerticesTemp : verticesGrafo){
                    verticeTemp = getVertice((TIPO) codVerticesTemp);
                    if(!isAdjacente(vertice.getCodVertice(), verticeTemp.getCodVertice())){
                        grafoComplementar.adicionarVertice(vertice.getCodVertice());
                        grafoComplementar.adicionarVertice(verticeTemp.getCodVertice());
                        grafoComplementar.adicionarAresta(1, vertice.getCodVertice(), verticeTemp.getCodVertice());
                        System.out.println("Criando vértice " + vertice.getCodVertice() + "-" + verticeTemp.getCodVertice());
                    }
                }
            }
        }
        return grafoComplementar;
    }

}
