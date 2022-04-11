package trab_algoritmos_em_grafos;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	// Exibe cabeçalho, chama menu
	public static void initializeMenu() {
		// _____ ____
		// / ___/__________ __/ __/_ _____
		// / / _ / ___/ __ /\ / _ \/ ___/
		// / /_/ / / / /_/ / / / /_/ /__ )
		// \____/_/ \_____\/_/\____/____/
		String cabecalho = "   _____              ____        \r\n" + "  / ___/__________ __/ __/_  _____\r\n"
				+ " / / _ / ___/ __  /\\  / _  \\/ ___/\r\n" + "/ /_/ / /  / /_/ / / / /_/ /__  ) \r\n"
				+ "\\____/_/   \\_____\\/_/\\____/____/  \r\n" + "\r\n";

		// Versão do produto
		cabecalho += "Trab. Algoritmos em Grafos versão 1.0.1 26/03/2022" + "\r\n";

		// Membros do grupo
		cabecalho += "Grupo: Gustavo Henrique, Matheus Ryuji, Maxwuell Junio, Rafael Penido" + "\r\n\r\n";

		System.out.print(cabecalho);

		// Pausa a execução
		Scanner input = new Scanner(System.in);
		String pause = new String();
		System.out.println("\nAperte enter para ler o arquivo txt e criar o grafo... ");
		pause = input.nextLine();

		Input filereader = new Input();

		//Cria o grafo
		Grafo<Integer> grafo = new Grafo<Integer>("NAO DIRECIONADO");
		ArrayList<Integer> verticesGrafo = new ArrayList<>();

		grafo = new Grafo<Integer>("NAO DIRECIONADO");
		ArrayList<Integer> verticesAdicionar = new ArrayList<>();	
		ArrayList<String> grafoFileData = filereader.readFile();
		//Cria os vértices
		int repeticoes = 0;
		for(String linha : grafoFileData){
			if(repeticoes!=0){
				linha = linha.replace(" ", "");
				String[] arestasArray =  linha.split(";");
				//Verifica os dois primeiros números da linha do input (vertice 1, vertice 2)
				for(int i = 0; i < 2; i++){
					boolean verticeEncontrado = false;
					//Analisa se o vertice já existe na lista de vertices a adicionar
					if(verticesAdicionar.size() == 0){
						verticesAdicionar.add(Integer.parseInt(arestasArray[i]));
					}else{
						for(Integer verticeTemp : verticesAdicionar){
							if(verticeTemp == Integer.parseInt(arestasArray[i])){
								verticeEncontrado = true;
								break;
							}
						}
						if(verticeEncontrado == false){
							verticesAdicionar.add(Integer.parseInt(arestasArray[i]));
						}
					}
				}
			}
			repeticoes++;
		}
		//Adicionando os vertices da arrayList 'verticesAdicionar'
		for(Integer verticeTemp : verticesAdicionar){
			grafo.adicionarVertice(verticeTemp);
			System.out.println("Vértice adicionado: Cod. " + verticeTemp);
		}
		//Vetor de vertices adicionados
		verticesGrafo = verticesAdicionar;
		//Cria as arrestas
		repeticoes = 0;
		for(String linha : grafoFileData){
			if(repeticoes!=0){
				linha = linha.replace(" ", "");
				String[] arestasArray =  linha.split(";");
				if(arestasArray.length == 3){
					//Grafo não-direcionado
					grafo.setTipoGrafo("NAO DIRECIONADO");
					grafo.adicionarAresta(Integer.parseInt(arestasArray[2]), Integer.parseInt(arestasArray[0]), Integer.parseInt(arestasArray[1]));
					System.out.println("Arresta adicionada: " + arestasArray[0] + "-" + arestasArray[1]);
				}else if(arestasArray.length == 4){
					//Grafo direcionado
					grafo.setTipoGrafo("DIRECIONADO");
					if(Integer.parseInt(arestasArray[3]) == 1){
						grafo.adicionarAresta(Integer.parseInt(arestasArray[2]), Integer.parseInt(arestasArray[0]), Integer.parseInt(arestasArray[1]));
						System.out.println("Arresta adicionada: " + arestasArray[0] + "-" + arestasArray[1]);
					}else if(Integer.parseInt(arestasArray[3]) == -1){
						grafo.adicionarAresta(Integer.parseInt(arestasArray[2]), Integer.parseInt(arestasArray[1]), Integer.parseInt(arestasArray[0]));
						System.out.println("Arresta adicionada: " + arestasArray[1] + "-" + arestasArray[0]);
					}else{
						System.out.println("Erro ao ler a direção da aresta");
					}
				}else{
					System.out.println("Falha na criação do grafo, verificar arquivo de input");
				}
				System.out.println("Leitura de linha do input: " + linha);
			}
			repeticoes++;
		}
		System.out.println("Grafo criado!");

		menu(grafo, verticesGrafo);
	}

	public static void menu(Grafo<Integer> grafo, ArrayList<Integer> verticesGrafo) {
		Scanner input = new Scanner(System.in);
		String opt = new String();
		String pause = new String();

		System.out.println("\nAperte enter para continuar... ");
		pause = input.nextLine();

		System.out.println("Menu de opções");
		System.out.println("_______________________________________________________________________");
		System.out.println("isRegular			verifica se o grafo é regular");
		System.out.println("quit				finaliza o programa");

		System.out.print("\nDigite uma opção: ");
		opt = input.nextLine();

		switch (opt) {
		case "isRegular":
			if(grafo.isRegular(verticesGrafo)==true){
				System.out.println("O grafo é regular");
			}else{
				System.out.println("O grafo não é regular");
			}
			menu(grafo, verticesGrafo);
			break;
		case "quit":
			System.out.println("Obrigado por utilizar o programa!");
			break;
		default:
			System.out.println("\nWARNING - Comando digitado inválido!\n");
			menu(grafo, verticesGrafo);
		}

		input.close();
	}
}
