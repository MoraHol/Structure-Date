import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TransMatrix {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		
		System.out.println("ingrese el valor de m");
		int m = Integer.parseInt(br.readLine());
		int AreaMatriz = m * m;
		System.out.println("ingrese los " + AreaMatriz + " numeros de la matriz separados por coma");
		String input = br.readLine();
		String[] matInput = input.split(",");
		int k = 0;
		
		int [][] matriz = new int [m][m];
		// llenado de matriz 
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				matriz[i][j] = Integer.parseInt(matInput[k]);
				k++;
			}
		}
		//impresion de matriz en pantalla
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}	
		System.out.println("\n");
		
		int [][] matrizTrans = transpuesta(matriz);
		//impresion de matriz en pantalla
		for(int i = 0; i < matrizTrans.length ;i++) {
			for(int j = 0; j < matrizTrans.length;j++) {
				System.out.print(matrizTrans[i][j] + " ");
			}
			System.out.println();
		}

	}
	public static int[][] transpuesta(int [][] matriz){
		int[][] mTrans = new int [matriz.length][matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				mTrans[i][j] = matriz[j][i];
			}
		}
		return mTrans;
	}
}
