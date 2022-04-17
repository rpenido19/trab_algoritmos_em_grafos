package trab_algoritmos_em_grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

<<<<<<< Updated upstream
    /**
     * Atributos
     */
    private String filename;
    private String path;
    private ArrayList<String> filedata;
=======
	private static String route = "C:\\Users\\Gustavo\\Documents\\Grafos\\";
	private static String filename = "grafoRegular.txt";

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
>>>>>>> Stashed changes

    /**
     * Construtor
     */
    public Input() {
        this.filename = "fileinput.txt";
        this.path = "E:\\Users\\rafae\\Documents\\";
        this.filedata = new ArrayList<String>();
        createFile();
    }

    /**
     * Métodos getters e setters
     */
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<String> getFiledata() {
        return filedata;
    }

    public void setFiledata(ArrayList<String> filedata) {
        this.filedata = filedata;
    }

    /**
     * Criar um arquivo
     */
    public void createFile() {
        try {
            File file = new File(getPath() + getFilename());
            if (file.createNewFile()) {
                System.out.println("Arquivo criado: " + file.getName());
            } else {
                System.out.println("O arquivo já existe.");
                System.out.println(file.getAbsolutePath());
                readFile();
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar um arquivo.");
            e.printStackTrace();
        }
    }

    /**
     * Ler um arquivo
     */
    public void readFile() {
        ArrayList<String> data = new ArrayList<String>();
        try {
            File file = new File(getPath() + getFilename());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                data.add(line);
            }
            setFiledata(data);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um erro ao ler um arquivo.");
            e.printStackTrace();
        }
    }

    /**
     * Gravar em um arquivo
     */
    public void updateFile() {
        try {
            Scanner scanner = new Scanner(System.in);
            FileWriter writer = new FileWriter(new File(getPath() + getFilename()));
            System.out.println("Após escrever o texto desejado pressione Enter depois Ctrl + C");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.write(line);
                if (scanner.hasNextLine()) {
                    writer.write("\n");
                }
            }
            scanner.close();
            writer.close();
            System.out.println("Sucesso ao gravar o arquivo.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro gravar um arquivo.");
            e.printStackTrace();
        }
    }

    /**
     * Excluir um arquivo
     */
    public void deleteFile() {
        File file = new File(getPath() + getFilename());
        if (file.delete()) {
            System.out.println("Apagou o arquivo: " + file.getName());
        } else {
            System.out.println("Falha ao excluir o arquivo.");
        }
    }

    /**
     * Renomear um arquivo
     * 
     * @param newname Novo nome do arquivo
     */
    public void renameFile(String newname) {
        try {
            File file = new File(getPath() + getFilename());
            if (!file.exists()) {
                createFile();
            }
            file.renameTo(new File(getPath() + newname));
            setFilename(newname);
            System.out.println("Renomeou o arquivo: " + file.getName());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao renomear o arquivo.");
            e.printStackTrace();
        }
    }

    /**
     * Move arquivo para outra pasta
     * 
     * @param newpath Nova rota do arquivo
     */
    public void alterFilePath(String newpath) {
        try {
            File file = new File(getPath() + getFilename());
            if (!file.exists()) {
                createFile();
            }
            file.renameTo(new File(newpath + getFilename()));
            setPath(newpath);
            System.out.println("Rota alterada: " + file.getName());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao alterar a rota do arquivo.");
            e.printStackTrace();
        }
    }
}
