import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class EspiralForm1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
		Random rd = new Random();
		System.out.println("Ingrese el valor de m: ");
		int m = Integer.parseInt(br.readLine());
		
		//Creación de matriz
		int[][] matriz = new int[m][m];
		// llenado de matriz de forma aleatoria
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				matriz[i][j] = rd.nextInt(9)+1;
			}
		}
		//Impresión de matriz en pantalla
		for(int i = 0; i < matriz.length ;i++) {
			for(int j = 0; j < matriz.length;j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		//empezando secuencia de espiral
		int counter = 0;
		int k = 0,f = 0;	
		int salto = 0;
		while(counter < m * m) 
		{
		
		switch(salto) {
		
		case 0: //izquierda a derecha
			for(int j = f;j < m - k;j++) {
				System.out.print(matriz[k][j] + " ");
				counter++;
			}
			salto++;
			break;
		case 1: //arriba a abajo
			for(int i = k + 1; i < m - f;i++) {
				System.out.print(matriz[i][m - 1  - k ] + " ");
				counter++;
			}
			salto++;
			break;
		case 2: //derecha a izquierda
			for(int j = m - 2 - f; j > k;j--) {
				System.out.print(matriz[m - 1 - k][j] + " ");
				counter++;
			}
			salto++;
			break;
		case 3: //abajo a arriba
			for(int i = m - 1 - k; i > f; i--) {
				System.out.print(matriz[i][f] + " ");
				counter++;
			}
			salto = 0;
			k++;
			f++;
			break;
		}
			
		}
		
	}

}
