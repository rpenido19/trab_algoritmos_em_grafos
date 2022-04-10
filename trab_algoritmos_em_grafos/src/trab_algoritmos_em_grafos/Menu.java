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
		String cabecalho = "   _____              ____        \r\n"
				+ "  / ___/__________ __/ __/_  _____\r\n"
				+ " / / _ / ___/ __  /\\  / _  \\/ ___/\r\n"
				+ "/ /_/ / /  / /_/ / / / /_/ /__  ) \r\n"
				+ "\\____/_/   \\_____\\/_/\\____/____/  \r\n"
				+ "\r\n";

		// Vers�o do produto
		cabecalho += "Trab. Algoritmos em Grafos versão 1.0.1 26/03/2022"
				+ "\r\n";

		// Membros do grupo
		cabecalho += "Grupo: Gustavo Henrique, Matheus Ryuji, Maxwuell Junio, Rafael Penido"
				+ "\r\n\r\n";

		System.out.print(cabecalho);

		menu();
	}

	public static void menu() {
		Scanner input = new Scanner(System.in);
		String opt = new String();

		System.out.println("q, quit					finaliza o programa");

		System.out.print("\nDigite uma opção: ");
		opt = input.nextLine();

		switch (opt) {
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
