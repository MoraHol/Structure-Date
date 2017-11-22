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
		//inicializacion de matrices
		int[][] matriz = new int[m][m];
		int [][] matriz2 = new int[m][m];
		//llenado de matriz aleatoria
		FillRandomMatrix(matriz);
		//impresion de la matriz original
		PrintMatrix(matriz);
		int k;
		
		if(m % 2 == 0)
		{
			matriz2 = RomboPar(matriz, m);
			k = matriz.length /2;
		}
		else
		{
			matriz2 = RomboImpar(matriz, m); 
			k = matriz.length /2 + 1;
		}
		int i,j;
		
		
		System.out.println();
		
		MostrarMAtriz(matriz2);

	}
	public static int [][] RomboPar(int [][] matriz, int m){
		int k = matriz.length /2 ;
		int u = k,i,j;
		
		int[][] matriz2 = new int [m][m];
		
		for(i = 0;i < k;i++) {
			for(j = 0;j < u;j++) {
				matriz2[i][j] = matriz[i][j]; 
			}
			u--;
		}	
		
		u=0;
		for(i = k; i < matriz.length;i++) {
			for(j = 0; j < u + 1;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u++;
		}
		u = k;
		for(i = 0; i < k;i++) {
			for(j = u; j < matriz.length;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u++;
		}
		u = matriz.length - 1;
		for(i = k; i < matriz.length;i++) {
			for(j = u ; j < matriz.length;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u--;
		}
		return matriz2;
	}
	public static int [][] RomboImpar(int [][] matriz, int m){
		int k = matriz.length /2 ;
		int u = k-1,i,j;
		
		int[][] matriz2 = new int [m][m];
		
		for(i = 0;i < k;i++) {
			for(j = 0;j < u + 2;j++) {
				matriz2[i][j] = matriz[i][j]; 
			}
			u--;
		}	
		
		u=0;
		for(i = k; i < matriz.length;i++) {
			for(j = 0; j < u + 1;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u++;
		}
		u = k;
		for(i = 0; i < k;i++) {
			for(j = u; j < matriz.length;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u++;
		}
		u = matriz.length - 1;
		for(i = k; i < matriz.length;i++) {
			for(j = u ; j < matriz.length;j++) {
				matriz2[i][j] = matriz[i][j];  
			}
			u--;
		
		}
		return matriz2;
	}
	public static void FillRandomMatrix(int [][] matriz) {
		Random rd = new Random();
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				matriz[i][j] = rd.nextInt(9)+1;
			}
		}
	}
	public static void PrintMatrix(int [][] matriz) {
		
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
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
