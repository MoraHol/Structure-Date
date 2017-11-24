import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Alexis
 *
 */
public class Merge_Sort {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] hola = {9,8,7,6,5,4,3,2,1};
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		System.out.println("ingrese los numeros  aordenar separados por coma");
		String input = br.readLine();
		String[] matInput = input.split(",");
		int [] array = new int [matInput.length];
		// conversion de nunmeros y llenado de arreglo
		for ( int i = 0; i < matInput.length;i++){
			array [i] = Integer.parseInt(matInput[i]);
		}
		// llamar funcion mergeSort
		array = MergeSort(array);
		//impresion del arreglo ordenado
		System.out.println("Arreglo ordenado: ");
		PrintArray(array);
		
		
		
		
		
		
		
		
	}
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
	public static int[] MergeSort(int [] array) {
		if (array.length == 1) {
			/* array is already sorted */
			return array;
		}
		else {
			/* split in two parts */
			int nleft = array.length / 2;
			int nright = array.length - nleft;
			int [] left_sub_array = new int [nleft];
			int []right_sub_array = new int [nright];
			
			/* filling each of the arrangements */
			for (int i = 0; i < nleft; i++) {
				left_sub_array[i] = array[i];
			}
			int k = 0;
			for (int i = nleft; i < array.length ; i++) {
				right_sub_array[k] = array[i];
				k++;
			}
			
			/* sort each one of the parts */
			
			int [] sortedL = MergeSort(left_sub_array);
			int [] sortedR = MergeSort(right_sub_array);
			
			/* following the strategy Divide & Conquer */
			return Merge(sortedL,sortedR);
		}
	}
	public static int[] Merge(int[] A, int[] B) {
		int l = A.length + B.length;
		/* create C array */
		int [] C = new int [l];
		int indexA = 0, indexB = 0, indexC = 0;
		
		while(indexA < A.length && indexB < B.length) {
			if(A[indexA] < B[indexB]) {
				/* add element from A array */
				C[indexC] = A[indexA];
				indexA ++;
				indexC ++;				
			}
			else
			{
				/* add element form B Array*/
				C[indexC] = B[indexB];
				indexB ++;
				indexC ++;
			}
		}
		/* one of A or B has still some elements */
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
