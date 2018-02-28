package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ordenamiento {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		System.out.println("por favor ingrese los numeros a ordenar separados por coma:");
		String input = br.readLine();
		int[] vector = stringtoInt(input);
		vector = PoscisionMenor(vector, 0);
		System.out.println("El arreglo ordenado es el siguiente:");
		printVectors(vector);

	}

	/**
	 * 
	 * @param v
	 *            } vector que se imprimira en consola
	 */
	public static void printVectors(int[] v) {
		for (int i = 0; i < v.length; i++) {
			if (i == v.length - 1) {
				System.out.print(v[i] + " ");
			} else {
				System.out.print(v[i] + ",");
			}
		}
	}

	/**
	 * 
	 * @param a
	 *            } linea de caracteres la cual sera separada por comas
	 * @return } arreglo de enteros
	 */
	public static int[] stringtoInt(String a) {
		String[] conv = a.split(",");
		int[] n = new int[conv.length];
		for (int i = 0; i < conv.length; i++) {
			n[i] = Integer.parseInt(conv[i]);
		}
		return n;
	}

	/**
	 * 
	 * @param v
	 *            } vector el cual se analizara su numero menor
	 * @return } arreglo con el numero menor en la primera posicion
	 */
	public static int[] PoscisionMenor(int[] v,int posicion) {
		
		int temp = 0, comp = Integer.MAX_VALUE, aux;
		if(posicion == v.length) {
			return v;
		}else {
			for (int i = posicion; i < v.length; i++) {
				if (v[i] < comp) {
					temp = i;
					comp = v[i];
				}
			}
			aux = v[posicion];
			v[posicion] = comp;
			v[temp] = aux;
			return PoscisionMenor(v, posicion + 1);
		}
		
		
	}
}
