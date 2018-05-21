package arbol;

/**
 * @version 2.0
 * @author Alexis Holguin
 * @since 18/05/2018 5:57 p.m
 */
public class Arbol {
	// -----------------------------------------------------------------------------------
	// Atribbutos
	// -----------------------------------------------------------------------------------

	private Nodo raiz;
	// -----------------------------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------------------------

	/**
	 * incializa el arbol con su raiz
	 * 
	 * @param valor
	 *            valor que va acontener el nod raiz
	 */
	public Arbol(int valor) {
		this.raiz = new Nodo(valor);
	}

	/**
	 * inicializa un arbol con su nodo raiz
	 * 
	 * @param raiz
	 *            Nodo Raiz del Arbol
	 */
	public Arbol(Nodo raiz) {
		this.raiz = raiz;
	}

	/**
	 * Constructor por defecto
	 */
	public Arbol() {
	}

	// -----------------------------------------------------------------------------------
	// Getters And Setters
	// -----------------------------------------------------------------------------------

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	// -----------------------------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------------------------
	/**
	 * agrega un nodo al arbol
	 * 
	 * @param nodo
	 *            nodo a agregar
	 * @param raiz
	 *            nodo raiz
	 */
	private void addNodo(Nodo nodo, Nodo raiz) {
		/* 2.- Partiendo de la raíz preguntamos: Nodo == null ( o no existe ) ? */
		if (raiz == null) {
			/*
			 * 3.- En caso afirmativo X pasa a ocupar el lugar del nodo y ya hemos ingresado
			 * nuestro primer dato. ==== EDITO ===== Muchas gracias a @Espectro por la
			 * corrección de esta línea
			 */
			this.setRaiz(nodo);
		} else {
			/* 4.- En caso negativo preguntamos: X < Nodo */
			if (nodo.getInfo() < raiz.getInfo()) {
				/*
				 * 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del que acabamos de
				 * preguntar y repetimos desde el paso 2 partiendo del Nodo al que acabamos de
				 * visitar
				 */
				if (raiz.getLeftLeaf() == null) {
					raiz.setLeftLeaf(nodo);
				} else {
					addNodo(nodo, raiz.getLeftLeaf());
				}
			} else {
				/*
				 * 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal cual hicimos con
				 * el caso anterior repetimos desde el paso 2 partiendo de este nuevo Nodo.
				 */
				if (nodo.getInfo() > raiz.getInfo()) {
					if (raiz.getRightLeaf() == null) {
						raiz.setRightLeaf(nodo);
					} else {
						addNodo(nodo, raiz.getRightLeaf());
					}
				}
			}
		}
	}

	/**
	 * agregar nodo al arbol
	 * 
	 * @param valor
	 *            valor el cual se contiene el nodo
	 */
	public void addNodo(int valor) {
		Nodo nodo = new Nodo(valor);
		this.addNodo(nodo, this.raiz);
	}

	/**
	 * cuenta el numero de nodos de un arbol
	 * 
	 * @param raiz
	 *            raiz del arbol
	 * @return numero de nodos del arbol
	 */
	private int CountNodes(Nodo raiz) {
		if (raiz == null) {
			return 0;
		} else {
			return (1 + CountNodes(raiz.getLeftLeaf()) + CountNodes(raiz.getRightLeaf()));
		}
	}

	/**
	 * cuenta el numero de nodos de un arbol
	 * 
	 * @return
	 */
	public int CountNodes() {
		return CountNodes(this.raiz);
	}

	/**
	 * imprime el arbol en inorden de forma recursiva
	 * 
	 * @param x
	 *            nodo al que se esta accediendo
	 */
	private void inorden(Nodo x) {
		if (x != null) {
			inorden(x.getLeftLeaf());
			System.out.print(x.getInfo() + ",");
			inorden(x.getRightLeaf());
		}
	}

	/**
	 * imprime el arbol inorden
	 */
	public void inorden() {
		inorden(this.raiz);
	}

	/**
	 * imprime el arbol en preorden de manera recursiva
	 * 
	 * @param x
	 *            nodo al que se esta accediendo
	 */
	private void preorden(Nodo x) {
		if (x != null) {
			System.out.print(x.getInfo() + ",");
			preorden(x.getLeftLeaf());
			inorden(x.getRightLeaf());
		}
	}

	/**
	 * imprime el arbol en preorden
	 */
	public void preorden() {
		preorden(this.raiz);
	}

	/**
	 * imprime el arbol en postorden de manera recursiva
	 * 
	 * @param x
	 */
	private void postorden(Nodo x) {
		if (x != null) {
			preorden(x.getLeftLeaf());
			inorden(x.getRightLeaf());
			System.out.print(x.getInfo() + ",");
		}
	}

	/**
	 * imprime el arbol postorden
	 */
	public void postorden() {
		postorden(this.raiz);
	}

	/**
	 * Cuneta el numero de nodos internos del arbol accediendo a cada nodo de manera
	 * recursiva Nodo Interno: que al menos tiene un hijo
	 * 
	 * @param raiz
	 *            nodo al que se esta accediendo que en primer momento es la raiz
	 *            del arbol
	 * @return numero de nodos internos
	 */
	private int countInternalNodes(Nodo raiz) {
		if (raiz == null) {
			return 0;
		} else {
			if (raiz.getLeftLeaf() != null || raiz.getRightLeaf() != null) {
				return 1 + countInternalNodes(raiz.getLeftLeaf()) + countInternalNodes(raiz.getRightLeaf());
			} else {
				return 0;
			}

		}
	}

	/**
	 * cuneta numero de nodos Internos del arbol
	 * 
	 * @return numero de nodos internos del arbol
	 */
	public int countInternalNodes() {
		return countInternalNodes(this.raiz);
	}

	/**
	 * suma la informacion contenida en un arbol de enteros
	 * 
	 * @param raiz
	 *            nodo al que se esta acedinedo que en su primer momento es el la
	 *            raiz del arbol
	 * @return suma de todos los nodos
	 */
	private int sumaNodos(Nodo raiz) {
		if (raiz == null) {
			return 0;
		} else {
			return raiz.getInfo() + sumaNodos(raiz.getLeftLeaf()) + sumaNodos(raiz.getRightLeaf());
		}
	}

	/**
	 * suma todos los nodos de arbol
	 * 
	 * @return suma total de los nodos
	 */
	public int sumaNodos() {
		return sumaNodos(this.raiz);
	}

	/**
	 * promedio de los datos que contiene el arbol
	 * 
	 * @return promedio
	 */
	public double promedio() {
		return sumaNodos() / CountNodes();
	}

	/**
	 * busca el numero mayor de arbol
	 * 
	 * @param raiz
	 *            nodo acceder que en primer momento debe serla raiz del arbol
	 * @param padre
	 *            padre del nodo al que se esta accediendo
	 * @return numero mayor del arbol
	 */
	private Nodo maxValue(Nodo raiz, Nodo padre) {
		if (raiz == null) {
			return padre.getRightLeaf();

		} else {
			return maxValue(raiz.getRightLeaf(), raiz.getFather());
		}

	}

	/**
	 * @return el numero mayor del arbol
	 */
	public int maxValue() {
		return maxValue(this.raiz, null).getInfo();
	}
}