import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class ExteriorRombo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		// ingreso de m
		System.out.println("ingrese el valor de m");
		int m= Integer.parseInt(br.readLine());
		//Inicialización de matrices
		int[][] matriz = new int[m][m];
		int [][] matriz2 = new int[m][m];
		//llenado de matriz aleatoria
		FillRandomMatrix(matriz);
		//Impresión de la matriz original
		PrintMatrix(matriz);
		if(m % 2 == 0)
		{
			matriz2 = RomboPar(matriz, m);
		}
		else
		{
			matriz2 = RomboImpar(matriz, m);
		}
		System.out.println();
		
		MostrarMAtriz(matriz2);

	}
	/**
	 * 
	 * @param matriz: matriz con los elementos a seleccionar
	 * @param m: el tamaño de la matriz
	 * @return una matriz con los elementos que están en el exterior de un rombo par
	 */
	public static int [][] RomboPar(int [][] matriz, int m){
		int k = matriz.length /2 ;
		int u = k,i,j;
		
		int[][] matriz2 = new int [m][m];
		
		for(i = 0;i < k;i++) { // diagonal superior izquierda
			for(j = 0;j < u;j++) {
				matriz2[i][j] = matriz[i][j]; 
			}
			u--;
		}	
		
		u=0;
		for(i = k; i < matriz.length;i++) {// diagonal inferior izquierda
			for(j = 0; j < u + 1;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u++;
		}
		u = k;
		for(i = 0; i < k;i++) { // diagonal superior derecha
			for(j = u; j < matriz.length;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u++;
		}
		u = matriz.length - 1;
		for(i = k; i < matriz.length;i++) {// diagonal inferior derecha
			for(j = u ; j < matriz.length;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u--;
		}
		return matriz2;
	}
	/**
	 * 
	 * @param matriz: matriz con los elementos a seleccionar
	 * @param m: el tamaño de la matriz
	 * @return una matriz con los elementos que están en el exterior de un rombo impar
	 */
	public static int [][] RomboImpar(int [][] matriz, int m){
		int k = matriz.length /2 ;
		int u = k-1,i,j;
		
		int[][] matriz2 = new int [m][m];
		
		for(i = 0;i < k;i++) {//diagonal superior izquierda
			for(j = 0;j < u + 2;j++) {
				matriz2[i][j] = matriz[i][j]; 
			}
			u--;
		}	
		
		u=0;
		for(i = k; i < matriz.length;i++) { //diagonal inferior izquierda
			for(j = 0; j < u + 1;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u++;
		}
		u = k;
		for(i = 0; i < k;i++) { // diagonal superior derecha
			for(j = u; j < matriz.length;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u++;
		}
		u = matriz.length - 1;
		for(i = k; i < matriz.length;i++) {//diagonal inferior derecha
			for(j = u ; j < matriz.length;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u--;
		
		}
		return matriz2;
	}
	/**
	 * llena la matriz aleatoriamente con numeros de 1 a 9
	 * @param matriz: contiene una matriz vacia
	 */
	public static void FillRandomMatrix(int [][] matriz) {
		Random rd = new Random();
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				matriz[i][j] = rd.nextInt(9)+1;
			}
		}
	}
	/**
	 * imprime la matriz en pantalla
	 * @param matriz: contiene la matriz que se va a mostrar
	 */
	public static void PrintMatrix(int [][] matriz) {
		
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * Imprime los elementos que están en el exterior de un rombo
	 * @param matriz: contiene la matriz que con los elementos a mostrar
	 */
	public static void MostrarMAtriz(int [][] matriz){
		for(int i = 0; i < matriz.length ;i++) {
			for( int j = 0; j < matriz.length;j++) {
				if(matriz[i][j] == 0) 
				{
					System.out.print("  ");
				}else 
				{
					System.out.print(matriz[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
