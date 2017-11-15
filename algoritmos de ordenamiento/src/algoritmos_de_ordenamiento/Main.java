/**
 * 
 */
package algoritmos_de_ordenamiento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Alexis Holguin
 *
 */
public class Main {
	public static void main (String[]args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		System.out.println("escriba los numeros a ordenar separados por coma");
		String line = br.readLine();
		String[] array = line.split(",");
		int [] array1 = new int [array.length ];
		for (int i = 0; i < array.length ;i++) 
		{
			array1[i] = Integer.parseInt(array[i]);
		}
		sortingAlgorithms dr = new sortingAlgorithms();
		array1 = dr.mergeSort(array1);
		for (int i = 0; i< array1.length;i++) {
			if (i < array.length - 1)
			{
				bw.write(array1[i] + ",");
			}
			else
			{
				bw.write(array1[i] + " ");
			}	
		}
		bw.flush();
		
	}
}
