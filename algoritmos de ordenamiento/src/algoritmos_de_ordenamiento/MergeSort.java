/**
 * 
 */
package algoritmos_de_ordenamiento;

/**
 * @author Alexis Holguin 
 *
 */
public class MergeSort {
	
	/**
	 * @param args
	 */
	
	public static int[] mergeSort(int [] array) 
	{
		if(array.length > 1)
		{
			
			int nLeft = array.length/2;
			int nRight = array.length - nLeft;
			int [] arrayLeft = new int [nLeft];
			int [] arrayRight = new int [nRight];
		
			//fill of arrayLeft
			for (int i = 0; i < nLeft; i++) 
			{
				arrayLeft[i] = array[i];
			}
			//fill of arrayRight
			for (int i = nLeft; i < nLeft + nRight; i++) 
			{
				arrayRight[i-nLeft] = array[i];
			}
		
			//Recursion
			arrayLeft = mergeSort(arrayLeft);
			arrayRight = mergeSort(arrayRight);
		
			int i = 0; 
			int j = 0; 
			int k = 0;
			//ordering of array
			while(arrayLeft.length != j && arrayRight.length != k) 
			{
				if(arrayLeft[j] < arrayRight[k]) 
				{
					array[i]= arrayLeft[j];
					i++;
					j++;
				}
				else
				{
					array[i]= arrayRight[k];
					i++;
					k++;
				}	
			}
			//array totally ordered
			while(arrayLeft.length != j) 
			{
				array[i] = arrayLeft[j];
				i++;
				j++;
			}
			while(arrayRight.length != k) 
			{
				array[i] = arrayRight[k];
				i++;
				k++;
			}
		}
		return array;
	}
	public void QuickSort(int [] array) 
	{
		array = QuickSort1(array);
	}
	public static int[] QuickSort1(int[] array) 
	{
		return QuickSort2(array, 0, array.length-1);
	}
	public static int[] QuickSort2(int[] array, int left, int right) 
	{
		if(left >= right) 
		{
			return array;
		}
		int l = left, r = right;
		
		if (left != right) 
		{
			int pivot;
			int aux;
			pivot = left;
			
			while(left != right) 
			{
				while(array[right] >= array [pivot] && left < right) 
				{ 
					right--;
					while (array[left] < array[pivot] && left < right) 
					{
						left++;
					}
				}
				
				if (right != left) 
				{
					aux = array[right];
					array[right] = array [left];
					array[left] = aux;
				}
			}
			if (left == right)
			{
				QuickSort2(array, l, left-1);
				QuickSort2(array, left+1, r);
			}
		}
		return array;
	}
	
}
	

