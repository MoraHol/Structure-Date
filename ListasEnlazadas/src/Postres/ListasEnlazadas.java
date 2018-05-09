package Postres;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @since 12:55 a.m
 * @author Alexis Holguin ID: 604549
 * @version 1.0
 */
public class ListasEnlazadas {
	private ArrayList<Postres> postres;
	private Scanner scan = new Scanner(System.in);
	private static boolean flag = false;
	public int mostrarMenu() {
		System.out.println("---------------------------------------------------------- \n" + "Que desea realizar: \n"
				+ "1. listar postres. \n" + "2. Insertar ingredientes a un postre \n"
				+ "3. Eliminar ingredientees a un protres \n" + "4. Ingresar un postres con todos sus ingredientes. \n"
				+ "5. Eliminar un postre. \n" + "6. listar Ingredientes de un postre. \n"
				+ "7. Salir \n"
				+ "---------------------------------------------------------- \n");
		return scan.nextInt();
	}

	public void opciones(int option) {
		switch (option) {
		case 1:
			MostrarPostres();
			break;
		case 2:
			agregarIngrediente();
			break;
		case 3:
			removerIngrediente();
			break;
		case 4:
			IngresarPostre();
			break;
		case 5:
			eliminarPostre();
			break;
		case 6:
			ListarIngredientes();
			break;
		default:
			flag = true;
			break;
		}
	}

	public void MostrarPostres() {
		System.out.println("----------------------------------------------------------");
		for (int i = 0; i < postres.size(); i++) {
			System.out.println((i + 1) + ". " + postres.get(i).getNombre());
		}
		System.out.println("----------------------------------------------------------");
	}

	public void MostrarIngredientes(int postre) {
		System.out.println("----------------------------------------------------------");
		for (int i = 0; i < postres.get(postre).getIngredientes().size(); i++) {
			System.out.println((i + 1) + ". " + postres.get(postre).getIngredientes().get(i));
		}
		System.out.println("----------------------------------------------------------");
	}

	public void agregarIngrediente() {
		System.out.println("A que postre desea agregar ingredientes:");
		MostrarPostres();
		int option = scan.nextInt();
		System.out.println("**********************************************************");
		System.out.println("por favor ingrese el nombre del ingrediente que desea agregar:");
		String name = scan.next();
		postres.get(option - 1).getIngredientes().add(name);
	}

	public void removerIngrediente() {
		System.out.println("A que postre desea eliminar ingredientes:");
		MostrarPostres();
		int option = scan.nextInt();
		MostrarIngredientes(option - 1);
		System.out.println("**********************************************************");
		System.out.println("por favor ingrese el nombre del ingrediente que desea remover:");
		String name = scan.next();
		if (postres.get(option - 1).getIngredientes().contains(name)) {
			postres.get(option - 1).getIngredientes().remove(name);
			System.out.println("se ha removido correctamente");
		} else {
			System.out.println("el elemento no se encuentra registrado");
		}

	}

	public void IngresarPostre() {
		System.out.println("Ingrese el nombre del postre que desea insertar:");
		String name = scan.next();
		Postres postre = new Postres(name, new ArrayList<>());
		String nombre = "";
		System.out.println("ingresa los ingredientes y cuando finalices presionar 0:");
		do {
			System.out.println("por favor ingrese el nombre del ingrediente que desea agregar:");
			nombre = scan.next();
			if (!nombre.equals("0"))
				postre.getIngredientes().add(nombre);
		} while (!nombre.equals("0"));
		postres.add(postre);
	}

	public void ListarIngredientes() {
		System.out.println("De que postre quieres listar ingredientes :");
		MostrarPostres();
		int option = scan.nextInt();
		System.out.println("Ingredientes :");
		MostrarIngredientes(option - 1);
	}

	public void eliminarPostre() {
		System.out.println("que postre desea eliminar:");
		MostrarPostres();
		int option = scan.nextInt();
		postres.remove(option - 1);
		System.out.println("Se ha removido correctamente");
	}

	public static void main(String[] args) {
		ListasEnlazadas n = new ListasEnlazadas();
		n.postres = new ArrayList<Postres>();
		// agregar elementos
		Postres postre = new Postres("Banana Split", new ArrayList<>());
		n.postres.add(postre);
		n.postres.get(0).getIngredientes().add("banana");
		n.postres.get(0).getIngredientes().add("leche");
		n.postres.get(0).getIngredientes().add("helado");
		postre = new Postres("flan", new ArrayList<>());
		n.postres.add(postre);
		n.postres.get(1).getIngredientes().add("gelatina");
		n.postres.get(1).getIngredientes().add("leche");
		n.postres.get(1).getIngredientes().add("crema de leche");
		do {
			n.opciones(n.mostrarMenu());
		} while (!flag);
	}

}
