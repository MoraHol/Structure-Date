package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @version 2.0
 * @author Alexis Holguin ID:604549
 * @date 14/03/2018
 */
public class file {

	private static BufferedReader br;

	public static void main(String[] args) throws IOException {
		LeerFichero();
	}

	/**
	 * escribe numeros en un fichero en enteros
	 * 
	 * @param bw
	 *            buffered de escritura
	 * @param linea
	 *            numero a escribir
	 * @throws IOException
	 */
	public static void EscribirFichero(BufferedWriter bw, String linea) throws IOException {

		try {
			bw.write(linea + "\n");
			System.out.println("se escribio correctamente en el archivo");
		} catch (Exception e) {
			System.err.println("ocurrio un error mientras se escribia en el archivo");
		}

	}

	/**
	 * lee el fichero donde se encuentran los numeros romanos y los convierte a
	 * enteros
	 * 
	 * @throws IOException
	 */
	public static void LeerFichero() throws IOException {
		br = new BufferedReader(new FileReader("src\\file\\Romano.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src\\file\\Arabigo.txt"));
		String line = null;
		try {
			line = br.readLine();
			while (line != null) {
				EscribirFichero(bw, String.valueOf(Resultado(line)));
				line = br.readLine();
			}
			bw.close();
			br.close();
		} catch (Exception e) {
		}
	}

	/**
	 * convierte un numero completo escrito en romano a entero
	 * 
	 * @param line
	 *            numero en romano
	 * @return numero romano convertido a entero
	 */
	public static int Resultado(String line) {
		int sum = 0;
		for (int i = 0; i < line.length(); i++) {
			if (i <= line.length() - 1) {
				if (i < line.length() - 1) {
					if (Conversion(line.charAt(i + 1)) > Conversion(line.charAt(i))) {
						sum += Conversion(line.charAt(i + 1)) - Conversion(line.charAt(i));
					} else {
						sum += Conversion(line.charAt(i));
					}
				} else {
					if (Conversion(line.charAt(i - 1)) == Conversion(line.charAt(i))) {
						sum += Conversion(line.charAt(i));
					}
					if (Conversion(line.charAt(i - 1)) > Conversion(line.charAt(i))) {
						sum += Conversion(line.charAt(i));
					}
				}

			}
		}
		return sum;
	}

	/**
	 * convierte los caracteres escritos en romano a numeros enteros
	 * 
	 * @param Romano
	 *            Caracter que se desea convertir
	 * @return numero romano convertido a entero
	 */
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
