package colas;

import java.util.Arrays;

public class ColaCircular {
	private String Q[];
	private int FRENTE;
	private int FINAL;
	private int MAX;

	public ColaCircular(int max) {
		FRENTE = 0;
		FINAL = 0;
		MAX = max;
		Q = new String[max];
	}

	public void insertar(String elem) {
		if ((FINAL == MAX - 1 && FRENTE == 1) || FRENTE == FINAL + 1) {
			System.out.println("cola llena");
			return;
		} else {
			if (FINAL == MAX - 1) {
				FINAL = 1;
			} else {
				if (FRENTE == 0) {
					FRENTE = 1;
					FINAL = 1;
				} else {
					FINAL++;
					
				}
				Q[FINAL] = elem;
			}

		}
	}

	public String eliminar() {
		String elem = null;
		if (FRENTE == 0) {
			System.out.println("cola vacia");
			return "";
		} else {
			elem = Q[FRENTE];
			Q[FRENTE] = null;
			if (FRENTE == MAX) {
				FRENTE = 1;
			} else {
				if (FRENTE == FINAL) {
					FRENTE = 0;
					FINAL = 0;
				} else {
					FRENTE++;
				}
			}
		}
		
		return elem;
	}

	@Override
	public String toString() {
		return Arrays.toString(Q);
	}

}
