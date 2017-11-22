import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TypeNumbers {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in));
		Random rd = new Random();
		
		System.out.println("ingrese el valor de m");
		int m = Integer.parseInt(br.readLine());
		//creacion de matriz
		int[][] matriz = new int[m][m];
		// llenado de matriz de forma aleatoria
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				matriz[i][j] = rd.nextInt();
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
		//impresion de la cantidad de numeros pares
		int[] pares = pares(matriz);
		System.out.println("la cantidad de numeros pares en la matriz es " + pares.length);	
		//impresion de numeros pares
		System.out.print("[");
		for (int i = 0; i < pares.length;i++) {
			if(i < pares.length - 1) {
				System.out.print(pares[i] + ",");	
			}else {
				System.out.print(pares[i] + "");
			}
		
		}
		System.out.print("] \n \n");
		
		
		//impresion de la cantidad de numeros impares
		int[] impares = impares(matriz);
		System.out.println("la cantidad de numeros impares en la matriz es " + impares.length);	
		//impresion de numeros pares
		System.out.print("[");
		for (int i = 0; i < impares.length;i++) {
			if(i < impares.length - 1) {
				System.out.print(impares[i] + ",");	
			}else {
				System.out.print(impares[i] + "");
			}
		
		}
		System.out.print("] \n \n");
		
		
		//impresion de la cantidad de numeros negativos
			int[] negativos = negativos(matriz);
			System.out.println("la cantidad de numeros pares en la matriz es " + negativos.length);	
			//impresion de numeros pares
			System.out.print("[");
			for (int i = 0; i < negativos.length;i++) {
					if(i < negativos.length - 1) {
					System.out.print(negativos[i] + ",");	
					}
					else 
					{
						System.out.print(negativos[i] + "");
					}
				
			}
			System.out.print("] \n \n");
				
			//impresion de la cantidad de numeros positivos
			int[] positivos = positivos(matriz);
			System.out.println("la cantidad de numeros pares en la matriz es " + positivos.length);	
			//impresion de numeros pares
			System.out.print("[");
			for (int i = 0; i < positivos.length;i++) {
				if(i < positivos.length - 1) {
					System.out.print(positivos[i] + ",");	
				}else {
					System.out.print(positivos[i] + "");
				}
			
			}
			System.out.print("] \n \n");
	}
	public static int[] pares(int [][] matriz) {
		
		int k = 0;
		for (int i = 0; i < matriz.length;i++) {
			for (int j = 0; j < matriz.length;j++) {
				if (matriz[i][j] % 2 == 0) {
					k++;
				}
			}	
		}
		int[] pares = new int [k];
		k = 0;
		for (int i = 0; i < matriz.length;i++) {
			for (int j = 0; j < matriz.length;j++) {
				if (matriz[i][j] % 2 == 0) {
					pares[k] = matriz[i][j];
					k++;
				}
			}	
		}
		return pares;
	}
	public static int[] impares(int [][] matriz) {
		int k = 0;
		for (int i = 0; i < matriz.length;i++) {
			for (int j = 0; j < matriz.length;j++) {
				if (matriz[i][j] % 2 != 0) {
					k++;
				}
			}	
		}
		int[] impares = new int [k];
		k = 0;
		
		for (int i = 0; i < matriz.length;i++) {
			for (int j = 0; j < matriz.length;j++) {
				if (matriz[i][j] % 2 != 0) {
					impares[k] = matriz[i][j];
					k++;
				}
			}	
		}
		return impares;
	}
	public static int[] negativos(int [][] matriz) {
		int k = 0;
		for (int i = 0; i < matriz.length;i++) {
			for (int j = 0; j < matriz.length;j++) {
				if (matriz[i][j] < 0) {
					k++;
				}
			}	
		}
		int[] negativos = new int [k];
		k = 0;		for (int i = 0; i < matriz.length;i++) {
			for (int j = 0; j < matriz.length;j++) {
				if (matriz[i][j] < 0) {
					negativos[k] = matriz[i][j];
					k++;
				}
			}	
		}
		return negativos;
	}
	public static int[] positivos(int [][] matriz) {
		int k = 0;
		for (int i = 0; i < matriz.length;i++) {
			for (int j = 0; j < matriz.length;j++) {
				if (matriz[i][j] > 0) {
					k++;
				}
			}	
		}
		int[] positivos = new int [k];
		k = 0;
		for (int i = 0; i < matriz.length;i++) {
			for (int j = 0; j < matriz.length;j++) {
				if (matriz[i][j] > 0) {
					positivos[k] = matriz[i][j];
					k++;
				}
			}	
		}
		return positivos;
	}
	
}
