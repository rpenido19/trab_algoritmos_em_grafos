package trab_algoritmos_em_grafos;

public class Main {

	public static void main(String[] args) {
		//Menu menu = new Menu();
		//menu.initializeMenu();

		//Exemplo de criação do grafo
		Grafo<Integer> grafo = new Grafo<Integer>("NAO DIRECIONADO");
		grafo.adicionarVertice(0);
		grafo.adicionarVertice(1);
		grafo.adicionarAresta(1, 0, 1);
	}

}
