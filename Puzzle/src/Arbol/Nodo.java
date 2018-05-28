package Arbol;

import java.util.ArrayList;
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad Minuto de Dios (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas
 * 
 * clase donde se maneja los atributos y métodos del Nodo en un arbol
 * 
 * Ejercicio: Puzzle
 * 
 * @author Alexis Holguin
 * @since Mayo 20, 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Nodo {
	int [][] info;
	private ArrayList<Nodo> hijos;
	private Nodo padre;
	public Nodo(int[][] info) {
		this.info = info;
		hijos=null;
		padre=null;
	}
	public int[][] getInfo() {
		return info;
	}
	public void setInfo(int[][] info) {
		this.info = info;
	}
	public ArrayList<Nodo> getHijos() {
		return hijos;
	}
	public void setHijos(ArrayList<Nodo> hijos) {
		this.hijos = hijos;
		if (hijos != null) {
			for (Nodo nodo : hijos) {
				nodo.setPadre(this);
			}
		}
	}
	public Nodo getPadre() {
		return padre;
	}
	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
	
}

