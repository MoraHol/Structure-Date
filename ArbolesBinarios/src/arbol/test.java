package arbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @version 2.0
 * @author Alexis Holguin
 * @since 18/05/2018 5:57 p.m
 */
public class test {
	static boolean flag = false;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Arbol arbol = new Arbol();

	public static void main(String[] args) throws IOException {
		do {
			decision(menu());
		} while (!flag);

	}

	static int menu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("--------------------------------------------");
		System.out.println("1. inicilizar arbol \n" + "2. agregar nodos \n" + "3. mostar informacion del arbol \n"
				+ "4. ingrese cualquier tecla para salir \n" + "Por favor Ingrese su opcion");
		System.out.println("--------------------------------------------");
		return scan.nextInt();
	}

	static void decision(int option) throws IOException {
		switch (option) {
		case 1:
			System.out.println("ingrese los numeros que desea agregar al arbol separados por coma :");
			String line = br.readLine();
			String[] numeros = line.split(",");
			for (int i = 0; i < numeros.length; i++) {
				arbol.addNodo(Integer.parseInt(numeros[i]));
			}
			break;

		case 2:
			System.out.println("--------------------------------------------");
			System.out.println("Por favor ingrese el numero a agregar: ");
			System.out.println("--------------------------------------------");
			try {
				arbol.addNodo(Integer.parseInt(br.readLine()));
				System.out.println("se agrego correctamente ");
			} catch (Exception e) {
				System.out.println("ingrese solo numeros");
			}
			break;
		case 3:
			System.out.println("En este arbol hay: " + arbol.CountNodes() + " nodos");
			System.out.println("arbol en inorden: ");
			arbol.inorden();
			System.out.println("\nArbol en preorden:");
			arbol.preorden();
			System.out.println("\nArbol en postorden: ");
			arbol.postorden();
			System.out.println();
			System.out.println("En este arbo hay " + arbol.countInternalNodes() + " internos.");

			System.out.println("la suma de todos los nodos del arbol es : " + arbol.sumaNodos());

			System.out.println("el promedio de los numeros de este arbol es: " + arbol.promedio());

			System.out.println("el numero mas grande de este arbol es: " + arbol.maxValue());
			break;
		default:
			flag = true;
			break;
		}
	}
}