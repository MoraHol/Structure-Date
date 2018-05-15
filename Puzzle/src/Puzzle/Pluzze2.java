package Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import Arbol.Nodo;

public class Pluzze2 {
	public static void main(String[] args) {
		int n = 4;
		// int[][] inicio = RandomFillTokens(n);
		// int[][] inicio = { { 3, 2, 4 }, {8, 5, 6 }, { 1, 0, 7 } };
		int[][] inicio = { { 5, 8, 12, 4 }, { 3, 7, 2, 14 }, { 1, 13, 6, 15 }, { 9, 0, 11, 10 } };
		int[][] solucion = MakeSolution(n);
		System.out.println("sin solucionar");
		printMatriz(inicio);
		System.out.println("solucion");
		printMatriz(solucion);

		Nodo sol = findSolution(inicio, solucion, n);
		Stack<Nodo> pasos = new Stack<>();
		System.out.println("pasos:");
		printMatriz(inicio);
		System.out.println();
		while (sol.getPadre() != null) {
			pasos.add(sol);
			sol = sol.getPadre();
		}
		int count = 0;
		while (!pasos.isEmpty()) {
			printMatriz(pasos.pop().getInfo());
			System.out.println();
			count++;
		}
		System.out.println(count);

	}

	static void printMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print("[" + matriz[i][j] + "]");
			}
			System.out.println("");
		}
	}

	static Nodo findSolution(int[][] problem, int[][] solution, int n) {
		Random rd = new Random();
		Nodo revisar = new Nodo(problem);
		ArrayList<Nodo> Recorridos = new ArrayList<>();
		int menorCoste;
		while (true) {
			if (Arrays.deepEquals(revisar.getInfo(), solution)) {
				return revisar;
			}
			int posicion = -1;
			ArrayList<Nodo> hijos = generateChildren(revisar, n);
			for (Nodo hijo : hijos) {
				Recorridos.add(hijo);
				if (hijo.getPadre().getPadre() != null) {
					if (Arrays.deepEquals(hijo.getInfo(), hijo.getPadre().getPadre().getInfo())) {
						Recorridos.remove(hijo);
						posicion = hijos.lastIndexOf(hijo);

					}
				}
			}
			if (posicion != -1) {
				hijos.remove(posicion);
				revisar.setHijos(hijos);
			}

			menorCoste = Integer.MAX_VALUE;
			for (Nodo nodo : Recorridos) {
				int auxCost = minCost(nodo, n);
				if (auxCost < menorCoste) {
					revisar = nodo;
					menorCoste = auxCost;
				}
			}
			Recorridos.remove(revisar);
		}
	}

	static ArrayList<Nodo> generateChildren(Nodo revisar, int n) {
		int[] pCero = ubicarPosicionCero(revisar.getInfo());
		ArrayList<Nodo> hijos = new ArrayList<>();
		if (pCero[0] != 0) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int arriba = hijo.getInfo()[pCero[0] - 1][pCero[1]];
			hijo.getInfo()[pCero[0]][pCero[1]] = arriba;
			hijo.getInfo()[pCero[0] - 1][pCero[1]] = 0;
			hijos.add(hijo);
		}
		if (pCero[0] != n - 1) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int abajo = hijo.getInfo()[pCero[0] + 1][pCero[1]];
			hijo.getInfo()[pCero[0]][pCero[1]] = abajo;
			hijo.getInfo()[pCero[0] + 1][pCero[1]] = 0;
			hijos.add(hijo);
		}
		if (pCero[1] != 0) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int izquierda = hijo.getInfo()[pCero[0]][pCero[1] - 1];
			hijo.getInfo()[pCero[0]][pCero[1]] = izquierda;
			hijo.getInfo()[pCero[0]][pCero[1] - 1] = 0;
			hijos.add(hijo);
		}
		if (pCero[1] != n - 1) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int derecha = hijo.getInfo()[pCero[0]][pCero[1] + 1];
			hijo.getInfo()[pCero[0]][pCero[1]] = derecha;
			hijo.getInfo()[pCero[0]][pCero[1] + 1] = 0;
			hijos.add(hijo);
		}
		revisar.setHijos(hijos);
		return hijos;
	}

	static int minCost(Nodo x, int n) {
		return fatherDistance(x) + uncorredPosition(x, n);
	}

	static int fatherDistance(Nodo x) {
		int counter = 0;
		Nodo aux = x;
		while (aux.getPadre() != null) {
			counter++;
			aux = aux.getPadre();
		}
		return counter;
	}

	static int uncorredPosition(Nodo x, int n) {
		int[][] ordenada = MakeSolution(n);
		int counter = 0;
		for (int i = 0; i < ordenada.length; i++) {
			for (int j = 0; j < ordenada.length; j++) {
				if (x.getInfo()[i][j] != ordenada[i][j]) {
					counter++;
				}
			}
		}
		return counter;
	}

	static int[] ubicarPosicionCero(int[][] matriz) {
		int[] vectorCero = new int[2]; // guardar la posición de cero
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] == 0) {
					vectorCero[0] = i;
					vectorCero[1] = j;
				}
			}
		}
		// System.out.println("la posicion de cero es: " + vectorCero[0] + " " +
		// vectorCero[1]);
		return vectorCero;
	}

	static int[][] MakeSolution(int n) {
		int aux = 1;
		int[][] solucion = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == n - 1 && j == n - 1) {
					solucion[i][j] = 0;
				} else {
					solucion[i][j] = aux;
					aux++;
				}
			}
		}

		return solucion;

	}

	static int[][] RandomFillTokens(int n) {
		int[][] Ordenada = MakeSolution(n);
		Random rd = new Random();
		int[] pCero = ubicarPosicionCero(Ordenada);

		for (int i = 0; i < rd.nextInt(100) + 30; i++) {
			pCero = ubicarPosicionCero(Ordenada);
			switch (rd.nextInt(4)) {
			case 0:
				if (pCero[0] != 0) {
					int arriba = Ordenada[pCero[0] - 1][pCero[1]];
					Ordenada[pCero[0]][pCero[1]] = arriba;
					Ordenada[pCero[0] - 1][pCero[1]] = 0;
				}
				break;
			case 1:
				if (pCero[0] != n - 1) {

					int abajo = Ordenada[pCero[0] + 1][pCero[1]];
					Ordenada[pCero[0]][pCero[1]] = abajo;
					Ordenada[pCero[0] + 1][pCero[1]] = 0;
				}
				break;
			case 2:
				if (pCero[1] != 0) {

					int izquierda = Ordenada[pCero[0]][pCero[1] - 1];
					Ordenada[pCero[0]][pCero[1]] = izquierda;
					Ordenada[pCero[0]][pCero[1] - 1] = 0;
				}
				break;
			case 3:
				if (pCero[1] != n - 1) {

					int derecha = Ordenada[pCero[0]][pCero[1] + 1];
					Ordenada[pCero[0]][pCero[1]] = derecha;
					Ordenada[pCero[0]][pCero[1] + 1] = 0;
				}
				break;
			}
		}
		return Ordenada;
	}

	static int[][] clone(int[][] matriz) {
		int[][] clon = new int[matriz.length][matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			clon[i] = matriz[i].clone();
		}
		return clon;
	}

	private static boolean isVisited(ArrayList<Nodo> visitados, Nodo hijo) {
		for (Nodo nodo : visitados) {
			if (Arrays.deepEquals(nodo.getInfo(), hijo.getInfo())) {
				return true;
			}
		}
		return false;
	}
}
