/**
 * 
 */
package algoritmos_de_ordenamiento;

/**
 * @author Alexis Holguin
 *
 */
public class QuickSort {
	public static void main (String[]args) {
		int array[] = {9,5,7,8,3,2,1};
		MergeSort dr = new MergeSort();
		dr.QuickSort(array);
		for (int i = 0; i< array.length;i++) {
			System.out.println(array[i]);
		}
	}
}
