package colas;

public class DobleCola {
	private Object[] ArregloCola;
	private int frente = 0, fondo = 0;
	private int Cant_elem = 5;

	public DobleCola() {
		ArregloCola = new Object[Cant_elem];
		frente = 0;
		fondo = Cant_elem;
	}

	/**
	 * inicializa una cola doble con un tamaño especifico
	 * 
	 * @param numero
	 *            - tamaño de la cola doble
	 */
	public DobleCola(int numero) {
		ArregloCola = new Object[numero + 1];
		frente = 0;
		fondo = numero;
		Cant_elem = numero;
	}

	public void EncolarIzq(Object x) {
		ArregloCola[frente] = x;
		frente++;
	}

	public void EncolarDer(Object x) {
		if (ColaLlena()) {
			System.out.println("cola llena");
		} else {
			ArregloCola[fondo] = x;
			fondo--;
		}

	}

	public Object DesencolarIzq() {
		if (ColaVacia()) {
			System.out.println("la cola esta vacia");
			return null;
		} else {
			Object aux = ArregloCola[frente];
			frente--;
			return aux;
		}

	}

	public Object DesencolarDer() {
		if (ColaVacia()) {
			System.out.println(" la cola esta vacia");
			return null;
		} else {
			Object aux = ArregloCola[fondo];
			fondo++;
			return aux;
		}

	}

	public boolean ColaLlena() {
		if (fondo == frente) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ColaVacia() {
		if (fondo == 0 && frente == Cant_elem) {
			return true;
		} else {
			return false;
		}
	}
}
