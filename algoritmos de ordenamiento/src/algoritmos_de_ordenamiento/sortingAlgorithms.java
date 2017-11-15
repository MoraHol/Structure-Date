/**
 * 
 */
package algoritmos_de_ordenamiento;

/**
 * @author Alexis Holguin 
 *
 */
public class sortingAlgorithms {
	
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
			for(int l=0;l<arrayLeft.length;l++) {
				System.out.println(arrayLeft[l]+",");
			}
			System.out.println("\n");
			for(int l=0;l<arrayLeft.length;l++) {
				System.out.println(arrayRight[l]+",");
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
	
	public static int[] QuickSort(int[] array) 
	{
		return quicksort(array, 0, array.length-1);
	}
	public static int [] quicksort (int[] array,int i, int j) 
	{
		int pivot = i;
		int Bufferi = i;
		int Bufferj = j;
		int temp;
		
		if(i >= j) 
		{
			return array;
		}
		while(i != j) {
			if(array[i] <= array[pivot] && i < j) {
				i++;
				System.out.println(i);
			}
			if(array[j] > array[pivot] && i < j) 
			{
				j--;
				System.out.println(j);
			}
			temp = array[j];
			array[j] = array[i];
			array[i] = temp;
			
		}
		
		if (i == j) 
		{
			temp = array [i];
			array[i] = array[Bufferi];
			array[Bufferi] = temp;
			
			//recursion
			quicksort(array, Bufferi, i - 1);
			quicksort(array, i + 1, Bufferj);
			
		}
		
		return array;
	}
	public static int[] InsertionSort(int[] array)
	{
        for (int i = 0; i < array.length; i++) //recorre el arreglo
        {
            for(int j = i ; j >= 0 ; j--) //compara si los de atras son menores que i
            {
                if(array[j] < array[j-1]) // si i es menor al numero de atras intercambian pociciones
                {
                    int aux = array[j];
                    array[j] = array[j-1];
                    array[j-1] = aux;
                }
            }
        }
        return array;
    }
	public int[] InsertionSort1(int[] array)
	{
		int swap, i, j;
		for ( i = 0; i < array.length; i++)
		{
			swap = array[i];
			
			for(j = i -1; j >= 0; j--)
				if (array[i] < array[j])
					break;
				
			
			for(int k = i; k < j + 1; k--)
				array[k] = array[k - 1];
			
				
			
			array[j + 1] = swap;
		}
		return array;
	}
	
}

	

