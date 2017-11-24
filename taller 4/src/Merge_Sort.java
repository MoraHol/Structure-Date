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
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] hola = {9,8,7,6,5,4,3,2,1};
		int nleft = hola.length / 2;
		System.out.println(nleft);
		int nright = hola.length - nleft;
		System.out.println(nright);
		hola = MergeSort(hola);
		for (int i= 0;i < hola.length; i++) {
			System.out.print(nright);
			
		}
		
		
		
		
		
		
		
		
	}
	public static int[] MergeSort1(int [] array) {
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
				System.out.print(left_sub_array[i] + " ");
			}
			System.out.println();
			for (int i = nleft + 1 ; i < array.length ; i++) {
				left_sub_array[i - (nleft + 1)] = array[i];
				System.out.println(i - nleft + " " + i);
				//System.out.println(right_sub_array[i] + " ");
			}
		}
		return array;
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
				System.out.print(left_sub_array[i] + " ");
			}
			System.out.println();
			for (int i = nleft + 1 ; i < array.length ; i++) {
				left_sub_array[i - (nleft + 1)] = array[i];
				System.out.println(i - nleft + " " + i);
			}
				//System.out.println(right_sub_array[i] + " ");
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
