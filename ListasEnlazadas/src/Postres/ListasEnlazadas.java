package Postres;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @since 12:55 a.m
 * @author Alexis Holguin ID: 604549
 * @version 1.0
 */
public class ListasEnlazadas {
	/**
	 * contiene los datos del postre y sus ingredientes
	 */
	private ArrayList<Postre> postres;
	/**
	 * lector de consola
	 */
	private BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
	/**
	 * bandera para terminar el programa
	 */
	private static boolean flag = false;
	/**
	 * muestra las diferentes opciones para el usuarios por consola
	 * @return el numero de opción que ha escogido el usuario
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int mostrarMenu() throws NumberFormatException, IOException {
		System.out.println("---------------------------------------------------------- \n" + "Que desea realizar: \n"
				+ "1. listar postre. \n" + "2. Insertar ingredientes a un postre \n"
				+ "3. Eliminar ingredientees a un protres \n" + "4. Ingresar un postre con todos sus ingredientes. \n"
				+ "5. Eliminar un postre. \n" + "6. listar Ingredientes de un postre. \n" + "7. Salir \n"
				+ "---------------------------------------------------------- \n");
		return Integer.parseInt(scan.readLine());

	}
	/**
	 * dependiendo de la opción del usuario realizara acciones
	 * @param option entero el cual contiene la decision que tomo el usuario
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void opciones(int option) throws NumberFormatException, IOException {
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
	/**
	 * muestra los nombres de los postre en consola
	 */
	public void MostrarPostres() {
		System.out.println("----------------------------------------------------------");
		for (int i = 0; i < postres.size(); i++) {
			System.out.println((i + 1) + ". " + postres.get(i).getNombre());
		}
		System.out.println("----------------------------------------------------------");
	}
	/**
	 * Muestra los ingredientes de un postre especifico
	 * @param postre postre al cual se le quiere istar sus ingredientes
	 */
	public void MostrarIngredientes(int postre) {
		System.out.println("----------------------------------------------------------");
		for (int i = 0; i < postres.get(postre).getIngredientes().size(); i++) {
			System.out.println((i + 1) + ". " + postres.get(postre).getIngredientes().get(i));
		}
		System.out.println("----------------------------------------------------------");
	}
	/**
	 * agrega un ingrediente a un postre en especifico 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void agregarIngrediente() throws NumberFormatException, IOException {
		System.out.println("A que postre desea agregar ingredientes:");
		MostrarPostres();
		int option = Integer.parseInt(scan.readLine());
		System.out.println("**********************************************************");
		System.out.println("por favor ingrese el nombre del ingrediente que desea agregar:");
		String name = scan.readLine();
		postres.get(option - 1).getIngredientes().add(name);
		System.out.println("se ha ingresado correctamente el dato");
	}
	/**
	 * remueve un ingrediente de un postre consultando su nombre para proceder 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void removerIngrediente() throws NumberFormatException, IOException {
		System.out.println("A que postre desea eliminar ingredientes:");
		MostrarPostres();
		int option = Integer.parseInt(scan.readLine());
		MostrarIngredientes(option - 1);
		System.out.println("**********************************************************");
		System.out.println("por favor ingrese el nombre del ingrediente que desea remover:");
		String name = scan.readLine();
		if (postres.get(option - 1).getIngredientes().contains(name)) {
			postres.get(option - 1).getIngredientes().remove(name);
			System.out.println("se ha removido correctamente");
		} else {
			System.out.println("el elemento no se encuentra registrado");
		}

	}
	/**
	 * agrega un postre al ArrayList con todos sus ingredientes 
	 * @throws IOException 
	 */
	public void IngresarPostre() throws IOException {
		System.out.println("Ingrese el nombre del postre que desea insertar:");
		String name = scan.readLine();
		Postre postre = new Postre(name, new ArrayList<>());
		String nombre = "";
		System.out.println("ingresa los ingredientes y cuando finalices presionar 0:");
		do {
			System.out.println("por favor ingrese el nombre del ingrediente que desea agregar:");
			nombre = scan.readLine();
			if (!nombre.equals("0"))
				postre.getIngredientes().add(nombre);
		} while (!nombre.equals("0"));
		postres.add(postre);
	}
	/**
	 * muestra en consola los ingredientes de un postre en especifico 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void ListarIngredientes() throws NumberFormatException, IOException {
		System.out.println("De que postre quieres listar ingredientes :");
		MostrarPostres();
		int option = Integer.parseInt(scan.readLine());
		System.out.println("Ingredientes :");
		MostrarIngredientes(option - 1);
	}
	/**
	 * elimina un postre del ArrayList con todos sus ingredientes
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void eliminarPostre() throws NumberFormatException, IOException {
		System.out.println("que postre desea eliminar:");
		MostrarPostres();
		int option = Integer.parseInt(scan.readLine());
		postres.remove(option - 1);
		System.out.println("Se ha removido correctamente");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		ListasEnlazadas n = new ListasEnlazadas();
		n.postres = new ArrayList<Postre>();
		// agregar postre 
		Postre postre = new Postre("Banana Split", new ArrayList<>());
		n.postres.add(postre);
		n.postres.get(0).getIngredientes().add("banana");
		n.postres.get(0).getIngredientes().add("leche");
		n.postres.get(0).getIngredientes().add("helado");
		postre = new Postre("flan", new ArrayList<>());
		n.postres.add(postre);
		n.postres.get(1).getIngredientes().add("gelatina");
		n.postres.get(1).getIngredientes().add("leche");
		n.postres.get(1).getIngredientes().add("crema de leche");
		do {
			n.opciones(n.mostrarMenu());
		} while (!flag);
	}

}
