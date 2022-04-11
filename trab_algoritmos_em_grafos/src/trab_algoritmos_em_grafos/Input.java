package trab_algoritmos_em_grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

	private static String route = "C:\\";
	private static String filename = "teste.txt";

	public static String getRoute() {
		return route;
	}

	public static void setRoute(String route) {
		try {
			File file = new File(getRoute() + getFilename());
			file.renameTo(new File(route + Input.filename));
			System.out.println("Rota alterada com sucesso.");
			Input.route = route;
		} catch (Exception e) {
			System.out.println("Operação falhou.");
		}
	}

	public static String getFilename() {
		return filename;
	}

	public static void setFilename(String filename) {
		File file = new File(getRoute() + getFilename());
		File rename = new File(getRoute() + filename);
		boolean flag = file.renameTo(rename);
		if (flag) {
			System.out.println("Arquivo renomeado com sucesso.");
			Input.filename = filename;
		} else {
			System.out.println("Operação falhou.");
		}
	}

	// Lê o arquivo de entrada e retorna um array com os dados do grafo
	public static ArrayList<String> readFile() {
		ArrayList<String> data = new ArrayList<String>();
		try {
			File file = new File(getRoute() + getFilename());
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				data.add(input.nextLine());
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
			System.out.println(getRoute() + getFilename());
			e.printStackTrace();
		}
		return data;
	}

}
