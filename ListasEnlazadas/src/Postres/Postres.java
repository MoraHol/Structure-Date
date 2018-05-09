package Postres;

import java.util.ArrayList;

/**
 * @since 12:55 a.m
 * @author Alexis Holguin ID: 604549
 * @version 1.0
 */
public class Postres {

	private String Nombre;
	private ArrayList<String> Ingredientes;

	public Postres(String nombre, ArrayList ingredientes) {
		this(nombre);
		this.Ingredientes = ingredientes;
	}

	public Postres(String nombre) {
		this.Nombre = nombre;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public ArrayList<String> getIngredientes() {
		return Ingredientes;
	}

}
