package pascal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author Alexis Holguin ID: 604549
 * 
 */
public class TrianglePAscal {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("ingresa el numero de la fila:");
		int n = Integer.parseInt(br.readLine()) - 1;

		System.out.println("ingresa el numero de elemento:");
		int r = Integer.parseInt(br.readLine()) - 1;
		
		int[][] matrix = new int[n+1][n+1];
		
		System.out.println("el numero es:");
		System.out.println(pascal(n, r));
		System.out.println("Este es el triangulo de pascal:");
		matrix = fillTriangle(n, matrix);
		MostrarMAtriz(matrix);
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static int[][] fillTriangle(int nfila, int[][] matriz) {
		for (int i = 0; i <= nfila ; i++) {
			for (int j = 0; j <= i; j++) {
				matriz[i][j] = pascal(i, j);
			}
		}
		return matriz;
	}

	public static int pascal(int nfila, int nelem) {
		return (factorial(nfila)) / ((factorial(nelem)) * factorial(nfila - nelem));
	}

	public static void MostrarMAtriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] == 0) {
					System.out.print("  ");
				} else {
					System.out.print(matriz[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
