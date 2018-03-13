package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import file.archivos;
import trabajador.*;

public class Main {
	public static Trabajador[] tb = new Trabajador[50];
	static int posicion = 0;
	static Menu mu = new Menu();
	static archivos ar = new archivos();

	public static void main(String[] args) throws NumberFormatException, IOException {
		do {
			mu.menu(mu.opciones());
		} while (mu.exit);
		Escritura();
	}

	public void mostar() {
		for (int i = 0; i < posicion; i++) {
			System.out.println(tb[i].toString());
		}
	}

	public static void Escritura() throws IOException {
		File fl = new File("registros.txt");
		BufferedWriter bw;

		bw = new BufferedWriter(new FileWriter(fl));
		try {
			for (int i = 0; i < posicion; i++) {
				bw.write(tb[i].toString() + "\n");
			}
			System.out.println("archivo correcto");
		} catch (Exception e) {
			System.err.println("ocurrio un error mientras se escribia en el archivo");
		}

		bw.close();
	}

}
