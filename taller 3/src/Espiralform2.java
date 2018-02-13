import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Espiralform2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
		
		System.out.println("Ingrese el valor de m: ");
		int m = Integer.parseInt(br.readLine());
		
		//Creación de matriz
		int[][] matriz = new int[m][m];
		// llenado de matriz de forma aleatoria
		FillRandomMatriz(matriz);
		//Impresión de matriz en pantalla
		PrintMatriz(matriz);
		System.out.println();
		//Recorrido en espiral
		SpiralTravel(m, matriz);
		
		
		
	}
	/**
	 * Función que hace el recorrido en espiral
	 * @param m tamaño de la matriz
	 * @param matriz la matriz a recorrer
	 */
	public static void SpiralTravel(int m,int [][] matriz) {
		int i = 0, j = 0, sum = 0, contador = 0;
		int AreaMatriz = m * m;
		while (sum < AreaMatriz) {
			while(j < matriz.length - contador) {
				System.out.print(matriz[i][j] + " ");
				j++;
				sum++;
			}
			i++;
			j--;
			while(i < m - contador) {
				System.out.print(matriz[i][j] + " ");
				i++;
				sum++;
			}
			i--;
			j--;
			while(j > 0 + contador) {
				System.out.print(matriz[i][j] + " ");
				j--;
				sum++;
			}
			while(i > 0 + contador ) {
				System.out.print(matriz[i][j] + " ");
				i--;
				sum++;
			}
			contador++;
			i = 0 + contador;
			j = 0 + contador;
		}
	}
	/**
	 * Función que llena la matriz aleatoriamente
	 * @param matriz matriz vacía lista para ser llenada con numeros aleatorios de 1 a 9
	 */
	public static void FillRandomMatriz (int [][] matriz) {
		Random rd = new Random();
		
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				matriz[i][j] = rd.nextInt(9)+1;
			}			
		}
	}
	/**
	 * Método que muestra la matriz de forma ordenada y presentable
	 * @param matriz: contiene los datos a mostrar 
	 */
	public static void PrintMatriz(int [][] matriz) {
		
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
}
