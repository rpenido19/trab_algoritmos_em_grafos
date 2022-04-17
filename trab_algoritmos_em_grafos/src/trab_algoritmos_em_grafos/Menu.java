package trab_algoritmos_em_grafos;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void menu(Grafo<Integer> grafo, ArrayList<Integer> verticesGrafo) {
		Scanner input = new Scanner(System.in);
		String opt = new String();
		String pause = new String();
		int vertice1;
		int vertice2;

		System.out.println("\nAperte enter para continuar... ");
		pause = input.nextLine();

		System.out.println("Menu de opções");
		System.out.println("_______________________________________________________________________");
		System.out.println("getGrau				retorna o grau de um vértice");
		System.out.println("isAdjacente			verifica dois angulos são adjacentes");
		System.out.println("isIsolado			verifica se o vértice está isolado");
		System.out.println("isPendente			verifica se o vértice é pendente");
		System.out.println("isRegular			verifica se o grafo é regular");
		System.out.println("isNulo				verifica se o grafo é nulo");
		System.out.println("isCompleto			verifica se o grafo é completo");
		System.out.println("quit				finaliza o programa");

		System.out.print("\nDigite uma opção: ");
		opt = input.nextLine();

		switch (opt) {
		case "isAdjacente":
			System.out.print("Digite o primeiro vértice: ");
			vertice1 = input.nextInt();
			System.out.print("Digite o segundo vértice: ");
			vertice2 = input.nextInt();
			grafo.isAdjacente(vertice1, vertice2);
			menu(grafo, verticesGrafo);
			break;
		case "getGrau":
			System.out.print("Digite do vértice: ");
			vertice1 = input.nextInt();
			grafo.getGrau(vertice1);
			menu(grafo, verticesGrafo);
			break;
		case "isIsolado":
			System.out.print("Digite do vértice: ");
			vertice1 = input.nextInt();
			grafo.isIsolado(vertice1);
			menu(grafo, verticesGrafo);
			break;
		case "isPendente":
			System.out.print("Digite do vértice: ");
			vertice1 = input.nextInt();
			if(grafo.isPendente(vertice1)==true){
				System.out.println("O vértice é pendente");
			}else{
				System.out.println("O vértice não é pendente");
			}
			menu(grafo, verticesGrafo);
			break;
		case "isRegular":
			if(grafo.isRegular(verticesGrafo)==true){
				System.out.println("O grafo é regular");
			}else{
				System.out.println("O grafo não é regular");
			}
			menu(grafo, verticesGrafo);
			break;
		case "isNulo":
			if(grafo.isNulo(verticesGrafo)==true){
				System.out.println("O grafo é nulo");
			}else{
				System.out.println("O grafo não é nulo");
			}
			menu(grafo, verticesGrafo);
			break;
		case "isCompleto":
			if(grafo.isCompleto(verticesGrafo)==true){
				System.out.println("O grafo é completo");
			}else{
				System.out.println("O grafo não é completo");
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
