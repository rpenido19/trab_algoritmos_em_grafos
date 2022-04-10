package trab_algoritmos_em_grafos;

public class Main {

	public static void main(String[] args) {
		//Menu menu = new Menu();
		//menu.initializeMenu();

		//Exemplo de criação do grafo
		Grafo<Integer> grafo = new Grafo<Integer>("NAO DIRECIONADO");
		grafo.adicionarVertice(0);
		grafo.adicionarVertice(1);
		grafo.adicionarVertice(2);
		grafo.adicionarVertice(3);
		grafo.adicionarVertice(4);
		grafo.adicionarVertice(5);
		grafo.adicionarAresta(1, 1, 0);
		grafo.adicionarAresta(1, 1, 2);
		grafo.adicionarAresta(1, 1, 3);
		grafo.adicionarAresta(1, 2, 4);
		if(grafo.isPendente(5)){
			System.out.println("SIM");
		}else{
			System.out.println("NÃO");
		}
	}

}