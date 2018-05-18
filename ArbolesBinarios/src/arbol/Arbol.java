package arbol;

public class Arbol {
	private Nodo raiz;

	public Arbol(int valor) {
		this.raiz = new Nodo(valor);
	}

	public Arbol(Nodo raiz) {
		this.raiz = raiz;
	}

	public Arbol() {
		// default
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

	public void addNodo(int valor) {
		Nodo nodo = new Nodo(valor);
		this.addNodo(nodo, this.raiz);
	}

	private int CountNodes(Nodo raiz) {
		if (raiz == null) {
			return 0;
		} else {
			return (1 + CountNodes(raiz.getLeftLeaf()) + CountNodes(raiz.getRightLeaf()));
		}
	}

	public int CountNodes() {
		return CountNodes(this.raiz);
	}

	private void inorden(Nodo x) {
		if (x != null) {
			inorden(x.getLeftLeaf());
			System.out.print(x.getInfo() + ",");
			inorden(x.getRightLeaf());
		}
	}

	public void inorden() {
		inorden(this.raiz);
	}

	private void preorden(Nodo x) {
		if (x != null) {
			System.out.print(x.getInfo() + ",");
			preorden(x.getLeftLeaf());
			inorden(x.getRightLeaf());
		}
	}

	public void preorden() {
		preorden(this.raiz);
	}

	private void postorden(Nodo x) {
		if (x != null) {
			preorden(x.getLeftLeaf());
			inorden(x.getRightLeaf());
			System.out.print(x.getInfo() + ",");
		}
	}

	public void postorden() {
		postorden(this.raiz);
	}

	private int countInternalNodes(Nodo raiz) {
		if (raiz == null) {
			return 0;
		} else {
			if (raiz.getLeftLeaf() != null && raiz.getRightLeaf() != null) {
				return 1 + countInternalNodes(raiz.getLeftLeaf()) + countInternalNodes(raiz.getRightLeaf());
			} else {
				return 0;
			}

		}
	}

	public int countInternalNodes() {
		return countInternalNodes(this.raiz);
	}

	private int sumaNodos(Nodo raiz) {
		if (raiz == null) {
			return 0;
		} else {
			return raiz.getInfo() + sumaNodos(raiz.getLeftLeaf()) + sumaNodos(raiz.getRightLeaf());
		}
	}

	public int sumaNodos() {
		return sumaNodos(this.raiz);
	}

	public int promedio() {
		return sumaNodos() / CountNodes();
	}

	private Nodo maxValue(Nodo raiz, Nodo padre) {
		if (raiz == null) {
			return padre.getRightLeaf();

		} else {
			return maxValue(raiz.getRightLeaf(), raiz.getFather());
		}

	}

	public int maxValue() {
		return maxValue(this.raiz, null).getInfo();
	}
}
