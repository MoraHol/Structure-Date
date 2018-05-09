package Postres;

import java.util.ArrayList;

/**
 * clase postre
 * @since 12:55 a.m
 * @author Alexis Holguin ID: 604549
 * @version 1.0
 */
public class Postre {
	/**
	 * Nombre del postre
	 */
	private String Nombre;
	/**
	 * ArrayList para almacenar los ingredientes del postre
	 */
	private ArrayList<String> Ingredientes;

	public Postre(String nombre, ArrayList<String> ingredientes) {
		this(nombre);
		this.Ingredientes = ingredientes;
	}

	public Postre(String nombre) {
		this.Nombre = nombre;
	}
	/**
	 * @return el nombre del postre
	 */
	public String getNombre() {
		return Nombre;
	}
	/**
	 * @param nombre da nombre al postre
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	/**
	 * @return el ArrayList de los ingredientes de postre
	 */
	public ArrayList<String> getIngredientes() {
		return Ingredientes;
	}

}
