package colas;

import java.util.Arrays;

public class ColaCirculas {
	private int Q[];
	private int FRENTE;
	private int FINAL;
	private int MAX;

	public ColaCirculas(int max) {
		FRENTE = 0;
		FINAL = 0;
		MAX = max;
		Q = new int[max];
	}

	public void insertar(int elem) {
		if (FINAL == MAX && FRENTE == 1 || FRENTE == FINAL + 1) {
			System.out.println("cola llena");
			return;
		}else {
			if(FINAL == MAX) {
				FINAL = 1;
			}else {
				if (FRENTE == 0) {
					FRENTE = 1;
					FINAL = 1;
				}else {
					FINAL++;
					Q[FINAL] = elem;
				}
			}
				
		}
	}
	public int eliminar() {
		int elem = 0;
		if (FRENTE == 0) {
			System.out.println("cola vacia");
		}else {
			elem = Q[FRENTE];
			if (FRENTE == MAX) {
				FRENTE = 1;
			}else {
				if(FRENTE == FINAL) {
					FRENTE =0;
					FINAL = 0;
				}else{
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
