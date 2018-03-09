package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class file {
	public static void main(String[]args) throws IOException {
		String linea;
		do {
		linea =LeerFichero();
		int numero = Resultado(linea);
		EscribirFichero(String.valueOf(numero));
		}while(linea == null);
	}
	public static void EscribirFichero(String linea) throws IOException {
		String ruta = "C:\\Users\\BOG-A404-E-011\\eclipse-workspace\\Conversion\\src\\file\\Arabigo.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
		try {
			bw.write(linea +"\n");
			System.out.println("se escribio correctamente en el archivo");
		} catch (Exception e) {
			System.err.println("ocurrio un error mientras se escribia en el archivo");
		}
		bw.close();
	}
	public static String ruta() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("por favor ingresa la ruta del archivo a convertir");
		return null;
	}
	public static String LeerFichero() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\BOG-A404-E-011\\eclipse-workspace\\Conversion\\src\\file\\Romano.txt"));
		String line = null;
		try {
			line = br.readLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return line;
	}

	public static int Resultado(String line) {
		int sum = 0;
		for (int i = 0; i < line.length(); i++) {
			sum += Conversion(line.charAt(i));
		}
		return sum;
	}

	public static int Conversion(char Romano) {
		if (Romano == 'I') {
			return 1;
		} else if (Romano == 'V') {
			return 5;
		} else if (Romano == 'X') {
			return 10;
		} else if (Romano == 'L') {
			return 50;
		} else if (Romano == 'C') {
			return 100;
		} else if (Romano == 'D') {
			return 500;
		} else if (Romano == 'M') {
			return 1000;
		} else {
			return 0;
		}
	}

}
