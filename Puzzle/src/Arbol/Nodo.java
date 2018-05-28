package Arbol;

import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Universidad Minuto de Dios (Bogotá - Colombia) Departamento de
 * Ingeniería de Sistemas
 * 
 * clase donde se maneja los atributos y métodos del Nodo en un arbol
 * 
 * Ejercicio: Puzzle.
 *
 * @author Alexis Holguin
 * @since Mayo 20, 2018
 *        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Nodo {

	/** The info. */
	int[][] info;

	/** The hijos. */
	private ArrayList<Nodo> hijos;

	/** The padre. */
	private Nodo padre;

	/**
	 * Instantiates a new nodo.
	 *
	 * @param info
	 *            the info
	 */
	public Nodo(int[][] info) {
		this.info = info;
		hijos = null;
		padre = null;
	}

	/**
	 * Gets the info.
	 *
	 * @return the info
	 */
	public int[][] getInfo() {
		return info;
	}

	/**
	 * Sets the info.
	 *
	 * @param info
	 *            the new info
	 */
	public void setInfo(int[][] info) {
		this.info = info;
	}

	/**
	 * Gets the hijos.
	 *
	 * @return the hijos
	 */
	public ArrayList<Nodo> getHijos() {
		return hijos;
	}

	/**
	 * Sets the hijos.
	 *
	 * @param hijos
	 *            the new hijos
	 */
	public void setHijos(ArrayList<Nodo> hijos) {
		this.hijos = hijos;
		if (hijos != null) {
			for (Nodo nodo : hijos) {
				nodo.setPadre(this);
			}
		}
	}

	/**
	 * Gets the padre.
	 *
	 * @return the padre
	 */
	public Nodo getPadre() {
		return padre;
	}

	/**
	 * Sets the padre.
	 *
	 * @param padre
	 *            the new padre
	 */
	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

}
