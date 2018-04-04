package pilas;

import java.util.Scanner;
import java.util.Stack;

public class ejercicio1 {
	private static Scanner en;

	static Stack<Integer> insertarFondo(Stack<Integer> P1, int numero) {
		Stack<Integer> pila = new Stack<Integer>();
		while (!P1.isEmpty()) {
			pila.push(P1.pop());
		}
		P1.push(numero);
		while (!pila.isEmpty()) {
			P1.push(pila.pop());
		}
		return P1;
	}

	public static void main(String arg[]) {
		en = new Scanner(System.in);
		Stack<Integer> pila = new Stack<Integer>();
		System.out.println("cuantos datos de sea ingresar:");
		int N = en.nextInt();
		int[] aux = new int [N];
		for (int i = 0; i < N; i++) {
			System.out.println("ingrese el siguiente dato");
			int dato = en.nextInt();
			pila.push(dato);
			aux[i] = dato;
		}
		System.out.println("pila original:");
		mostrarPila(pila);
		for (int i = 0; i < aux.length; i++) {
			pila.push(aux[i]);
		}
		System.out.println("ingrese el numero que desea ingresar:");
		pila = insertarFondo(pila, en.nextInt());
		System.out.println("pila despues de la insercion:");
		mostrarPila(pila);
		
	}
	public static void mostrarPila(Stack<Integer> P1) {
		while (!P1.isEmpty()) {
			System.out.println(P1.pop() + " ");
		}
	}
}
