/**
 * 
 */
package algoritmos_de_ordenamiento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Alexis Holguin
 *
 */
public class Main {
	public static void main (String[]args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("escriba os numeros a ordenar separados por coma");
		String line = br.readLine();
		String[] array = line.split(",");
		int [] array1 = new int [array.length ];
		for (int i = 0; i < array.length ;i++) 
		{
			array1[i] = Integer.parseInt(array[i]);
		}
		sortingAlgorithms dr = new sortingAlgorithms();
		dr.QuickSort(array1);
		for (int i = 0; i< array1.length;i++) {
			System.out.println(array1[i]);
		}
	}
}
