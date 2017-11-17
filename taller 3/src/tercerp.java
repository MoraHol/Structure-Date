import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class tercerp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
		Random rd = new Random();
		System.out.println("Ingrese el valor de m: ");
		int m = Integer.parseInt(br.readLine());
		 
		//creacion de matriz
		int[][] matriz = new int[m][m];
		// llenado de matriz de forma aleatoria
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				matriz[i][j] = rd.nextInt(9)+1;
			}
		}
		//impresion de matriz en pantalla
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		int j=0,i=0;
		while(i < matriz.length && j < matriz.length){
			while(j < matriz.length){
				System.out.print(matriz[i][j]);
				j++;
			}
			while(true);
		}
		
	}

}
