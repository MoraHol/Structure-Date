package POO;

import javax.swing.JOptionPane;

public class vectorsorting {
	public static void main(String[] args) {
		String input;
		String[] matInput;

		input = JOptionPane.showInputDialog("ingrese los numeros del vector separados por coma:");
		matInput = input.split(",");
		int n = matInput.length;
		int[] array = new int[n];
		int k=0;
		for(int i = 0; i < matInput.length;i++){
			array[i] =  Integer.parseInt(matInput[k]);
			k ++;
		}
		int[] array1 = InsertionSort(array, n);
		System.out.println("Arreglo ordenado: \n");
		for(int i = 0; i < matInput.length;i++){
			if (i < n - 1){
				System.out.println(array1[i] + ",");
			}
			else
			{
				System.out.println(array1[i]);
			}
		}
		

	}
	public static int[] InsertionSort(int array[],int n){
		int x; //valueToinsert
		int index; //holePosition
		for (int i = 0; i < n;i++){
			/*select value to moved*/
			x = array[i];
			index = i;
			while (index > 0 && array[index -1] > x){
				array[index] = array[index -1];
				index = index - 1;
			}
			/* insert the value at hole position*/
			array[index] = x;
		}
		return array;
	}
}
