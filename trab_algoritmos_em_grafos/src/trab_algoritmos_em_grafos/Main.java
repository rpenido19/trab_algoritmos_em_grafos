package trab_algoritmos_em_grafos;

public class Main {

	public static void main(String[] args) {
		//Menu menu = new Menu();
		//menu.initializeMenu();

		//Exemplo de criação do grafo
		Grafo<String> grafo = new Grafo<String>();
		grafo.adicionarVertice("A");
		grafo.adicionarVertice("B");
		grafo.adicionarAresta(1.0, "A", "B");
	}

}
