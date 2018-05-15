package Arbol;

import java.util.ArrayList;

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

