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

		// Vers�o do produto
		cabecalho += "Trab. Algoritmos em Grafos versão 1.0.1 26/03/2022" + "\r\n";

		// Membros do grupo
		cabecalho += "Grupo: Gustavo Henrique, Matheus Ryuji, Maxwuell Junio, Rafael Penido" + "\r\n\r\n";

		System.out.print(cabecalho);

		menu();
	}

	public static void menu() {
		Scanner input = new Scanner(System.in);
		String opt = new String();
		Input filereader = new Input();

		System.out.println("afn, alterfilename		alterar nome do arquivo de entrada");
		System.out.println("afp, alterfilepath		alterar rota do arquivo de entrada");
		System.out.println("rf, readfile			lê o arquivo de entrada");
		System.out.println("sfp, showfilepath		exibe o nome e rota do arquivo de entrada");
		System.out.println("\nq, quit					finaliza o programa");

		System.out.print("\nDigite uma opção: ");
		opt = input.nextLine();

		switch (opt) {
		case "afn":
		case "alterfilename":
			filereader.setFilename(input.nextLine());
			menu();
			break;
		case "afp":
		case "alterfilepath":
			filereader.setRoute(input.nextLine());
			menu();
			break;
		case "rf":
		case "readfile":
			Grafo<Integer> grafo = new Grafo<Integer>("NAO DIRECIONADO");	
			ArrayList<String> grafoFileData = filereader.readFile();
			//Criar vértices
			int repeticoes = 0;
			ArrayList<Integer> verticesAdicionar = new ArrayList<>();
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
			//Criar arrestas
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
		case "sfp":
		case "showfilepath":
			System.out.println(filereader.getRoute() + filereader.getFilename());
			menu();
			break;
		case "q":
		case "quit":
			System.out.println("Obrigado por utilizar o programa!");
			break;
		default:
			System.out.println("\nWARNING - Comando digitado inválido!\n");
			menu();
		}

		input.close();
	}
}
