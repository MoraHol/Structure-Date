package Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import Arbol.Nodo;

public class Puzzle {
	public static void main(String[] args) {
		int n = 3;
		int[][] inicio = { { 8, 1, 2 }, {7, 6, 4 }, { 0, 5, 3 } };
		//int[][] inicio = { { 9, 15, 1, 4 }, { 14, 3, 2, 12 }, { 13, 6, 7, 8 }, { 10, 0, 5, 11 } };
		//int[][] inicio = RandomFillTokens(n);

		int[][] solucion = MakeSolution(n);
		System.out.println("sin solucionar");
		imprimirMatriz(inicio);
		System.out.println("solucion");
		imprimirMatriz(solucion);

		Nodo inicial = new Nodo(inicio);
		Nodo sol = buscarSolucion(inicial, solucion, n);
		Stack<Nodo> pasos = new Stack<>();
		// imprimirMatriz(inicio);
		System.out.println("pasos:");
		while (sol.getPadre() != null) {
			pasos.add(sol);
			sol = sol.getPadre();
		}
		int count = 0;
		while (!pasos.isEmpty()) {
			imprimirMatriz(pasos.pop().getInfo());
			System.out.println();
			count++;
		}
		System.out.println(count);
	}

	public static Nodo buscarSolucion(Nodo inicio, int[][] solucion, int n) {
		ArrayList<Nodo> expandidos = new ArrayList<>();
		expandidos.add(inicio);
		int count = 0;

		ArrayList<Nodo> visitados = new ArrayList<>();
		while (expandidos.size() != 0) {
			Nodo revisar = expandidos.remove(0);
			// imprimirMatriz(revisar.getInfo());
			int[] pCero = ubicarPosicionCero(revisar.getInfo());
			count++;
			visitados.add(revisar);
			if (Arrays.deepEquals(revisar.getInfo(), solucion)) {
				System.out.println("*** solucion encontrda");
				System.out.println("realizo " + count + " pasos");
				return revisar;
			}

			ArrayList<Nodo> hijos = new ArrayList<>();
			if (pCero[0] != 0) {
				Nodo hijo = new Nodo(clone(revisar.getInfo()));
				int arriba = hijo.getInfo()[pCero[0] - 1][pCero[1]];
				hijo.getInfo()[pCero[0]][pCero[1]] = arriba;
				hijo.getInfo()[pCero[0] - 1][pCero[1]] = 0;

				if (!isVisited(visitados, hijo)) {
					expandidos.add(hijo);
				}
				hijos.add(hijo);
			}
			if (pCero[0] != n - 1) {
				Nodo hijo = new Nodo(clone(revisar.getInfo()));
				int abajo = hijo.getInfo()[pCero[0] + 1][pCero[1]];
				hijo.getInfo()[pCero[0]][pCero[1]] = abajo;
				hijo.getInfo()[pCero[0] + 1][pCero[1]] = 0;
				if (!isVisited(visitados, hijo)) {
					expandidos.add(hijo);
				}
				hijos.add(hijo);
			}
			if (pCero[1] != 0) {
				Nodo hijo = new Nodo(clone(revisar.getInfo()));
				int izquierda = hijo.getInfo()[pCero[0]][pCero[1] - 1];
				hijo.getInfo()[pCero[0]][pCero[1]] = izquierda;
				hijo.getInfo()[pCero[0]][pCero[1] - 1] = 0;
				if (!isVisited(visitados, hijo)) {
					expandidos.add(hijo);
				}
				hijos.add(hijo);
			}
			if (pCero[1] != n - 1) {
				Nodo hijo = new Nodo(clone(revisar.getInfo()));
				int derecha = hijo.getInfo()[pCero[0]][pCero[1] + 1];
				hijo.getInfo()[pCero[0]][pCero[1]] = derecha;
				hijo.getInfo()[pCero[0]][pCero[1] + 1] = 0;
				if (!isVisited(visitados, hijo)) {
					expandidos.add(hijo);
				}
				hijos.add(hijo);
			}
			revisar.setHijos(hijos);
		}

		return null;

	}

	private static boolean isVisited(ArrayList<Nodo> visitados, Nodo hijo) {
		for (Nodo nodo : visitados) {
			if (Arrays.deepEquals(nodo.getInfo(), hijo.getInfo())) {
				return true;
			}
		}
		return false;
	}

	static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print("[" + matriz[i][j] + "]");
			}
			System.out.println("");
		}
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

	static int[][] clone(int[][] matriz) {
		int[][] clon = new int[matriz.length][matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			clon[i] = matriz[i].clone();
		}
		return clon;
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
		int movimientos = rd.nextInt(40)+20;
		int[] pCero = ubicarPosicionCero(Ordenada);
		System.out.println(movimientos);
		do {
			for (int i = 0; i < movimientos; i++) {
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
		}while (pCero[1] % 2 != 0) ;
			
		
		return Ordenada;

	}

}