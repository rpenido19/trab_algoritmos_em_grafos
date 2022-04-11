package trab_algoritmos_em_grafos;

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
		cabecalho += "Trab. Algoritmos em Grafos vers�o 1.0.1 26/03/2022" + "\r\n";

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
		System.out.println("rf, readfile			l� o arquivo de entrada");
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
			// grafo = filereader.readFile();
			break;
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
			System.out.println("\nWARNING - Comando digitado inv�lido!\n");
			menu();
		}

		input.close();
	}
}
