import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Alexis Holguin
 * @version 24/11/2017
 */
public class Merge_Sort {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		System.out.println("ingrese los numeros  a ordenar separados por coma");
		String input = br.readLine();
		String[] matInput = input.split(",");
		int [] array = new int [matInput.length];
		// conversion de numeros y llenado de arreglo
		for ( int i = 0; i < matInput.length;i++){
			array [i] = Integer.parseInt(matInput[i]);
		}
		// llamar función mergeSort
		array = MergeSort(array);
		//Impresión del arreglo ordenado
		System.out.println("Arreglo ordenado: ");
		PrintArray(array);
	}
	/**
	 * Imprime el arreglo en la consola
	 * @param array guarda los datos del arreglo a mostrar
	 */
	public static void PrintArray (int[] array){
		for (int i= 0;i < array.length; i++) {
			if (i < array.length - 1){
				System.out.print(array[i] + ",");
			}
			else
			{
				System.out.print(array[i] + "\n");
			}
		}
	}
	/**
	 * 
	 * @param array contiene el arreglo a ordenar
	 * @return el arreglo completamente ordenado valiéndose de la función Merge
	 */
	public static int[] MergeSort(int [] array) {
		if (array.length == 1) {
			/* el arreglo esta ordenado */
			return array;
		}
		else {
			/* split in two parts */
			int nleft = array.length / 2;
			int nright = array.length - nleft;
			int [] left_sub_array = new int [nleft];
			int []right_sub_array = new int [nright];
			
			/* llenando cada uno de los arrglos */
			for (int i = 0; i < nleft; i++) {
				left_sub_array[i] = array[i];
			}
			int k = 0;
			for (int i = nleft; i < array.length ; i++) {
				right_sub_array[k] = array[i];
				k++;
			}
			
			/* ordenando cada uno de los arreglos */
			
			int [] sortedL = MergeSort(left_sub_array);
			int [] sortedR = MergeSort(right_sub_array);
			
			/* Siguiendo la estrategia divide y conquistaras */
			return Merge(sortedL,sortedR);
		}
	}
	/**
	 * 
	 * @param A corresponde a la parte izquierda del arreglo
	 * @param B corresponde a la parte derecha del arreglo
	 * @return el arreglo completamente ordenado
	 */
	public static int[] Merge(int[] A, int[] B) {
		int l = A.length + B.length;
		/* crear un arreglo C  */
		int [] C = new int [l];
		int indexA = 0, indexB = 0, indexC = 0;
		
		while(indexA < A.length && indexB < B.length) {
			if(A[indexA] < B[indexB]) {
				/* agregando los elementos del arreglo A */
				C[indexC] = A[indexA];
				indexA ++;
				indexC ++;				
			}
			else
			{
				/* Agregando los elementos del arreglo B*/
				C[indexC] = B[indexB];
				indexB ++;
				indexC ++;
			}
		}
		/* el arreglo A o B todavía tiene algunos elementos */
		while(indexA < A.length) {
			C[indexC] = A[indexA];
			indexA ++;
			indexC ++;
		}
		while(indexB < B.length) {
			C[indexC] = B[indexB];
			indexB ++;
			indexC ++;
		}
		return C;
	}
}
