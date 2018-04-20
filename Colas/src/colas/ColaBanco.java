package colas;

import java.util.Scanner;

public class ColaBanco {
	static ColaCircular circular;
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Bienvenido al Su Banco");
		System.out.println("por favor ingrese el numero de persona que puede tener la cola: ");
		int numero = scan.nextInt();
		circular = new ColaCircular(numero + 1);
		do {
			desicion(menu());
		} while (true);

	}

	public static int menu() {
		System.out.println(
				"Que desea hacer: \n" + "1. agregar persona a la cola \n" + "2. quitar una persona de la cola\n"+"3. mostar cola" + "ingrese su desicion:");
		scan = new Scanner(System.in);
		int opcion = scan.nextInt();
		return opcion;
	}

	public static void desicion(int opcion) {
		switch (opcion) {
		case 1:
			Scanner scan = new Scanner(System.in);
			System.out.println("por favor ingrese a la persona:");
			String persona = scan.next();
			circular.insertar(persona);
			break;
		case 2:
			System.out.println("la persona que salio de la cola es: " + circular.eliminar());
		case 3:
			System.out.println(circular.toString());
		default:
			break;
		}
	}
}
