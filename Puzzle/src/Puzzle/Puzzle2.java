package Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

import Arbol.Nodo;

public class Puzzle2 {
	private int[][] problema;
	private Stack<Nodo> pasos;
	private int[][] solucion;
	private int movimientos;
	private int n;

	public Puzzle2(int n) {
		movimientos = 0;
		solucion = MakeSolution(n);
		problema = RandomFillTokens(n);
		this.n = n;

	}

	public Puzzle2(int[][] problem, int n) {
		movimientos = 0;
		solucion = MakeSolution(n);
		problema = problem;
		this.n = n;
	}

	public void generarSolucion() {
		generarSolucion(n);
	}

	private void generarSolucion(int n) {
		Nodo sol = findSolution(problema, solucion, n);
		//if (sol != null) {
			pasos = new Stack<>();
			while (sol.getPadre() != null) {
				pasos.add(sol);
				sol = sol.getPadre();
				movimientos += 1;
			}
		//} else {
			//JOptionPane.showMessageDialog(null, "solcuion inalcanzable");
		//}
	}

	public int getMovimientos() {
		return movimientos;
	}

	public Stack<Nodo> getPasos() {
		return pasos;
	}

	public int[][] getProblema() {
		return problema;
	}

	public int[][] getSolution() {
		return solucion;
	}

	private Nodo findSolution(int[][] problem, int[][] solution, int n) {
		int count = 0;
		Nodo revisar = new Nodo(problem);
		ArrayList<Nodo> Recorridos = new ArrayList<>();
		int menorCoste;
		ArrayList<Nodo> visitados = new ArrayList<>();
		while (true) {
			visitados.add(revisar);
			//if (Recorridos.size() >= 10000) {
				//return null;
			//}
			if (Arrays.deepEquals(revisar.getInfo(), solution)) {
				System.out.println(count);
				return revisar;
			}
			int posicion = -1;
			ArrayList<Nodo> hijos = generateChildren(revisar, n, visitados);
			for (Nodo hijo : hijos) {
				Recorridos.add(hijo);
				/*
				 * if (hijo.getPadre().getPadre() != null) { if
				 * (Arrays.deepEquals(hijo.getInfo(), hijo.getPadre().getPadre().getInfo())) {
				 * Recorridos.remove(hijo); posicion = hijos.lastIndexOf(hijo); } }
				 */
			}
			/*
			 * if (posicion != -1) { hijos.remove(posicion); revisar.setHijos(hijos); }
			 */

			menorCoste = Integer.MAX_VALUE;
			for (Nodo nodo : Recorridos) {
				int auxCost = minCost(nodo, n);
				if (auxCost < menorCoste) {
					revisar = nodo;
					menorCoste = auxCost;
				}
			}
			count++;
			Recorridos.remove(revisar);
		}
	}

	private ArrayList<Nodo> generateChildren(Nodo revisar, int n, ArrayList<Nodo> visitados) {
		int[] pCero = ubicarPosicionCero(revisar.getInfo());
		ArrayList<Nodo> hijos = new ArrayList<>();
		if (pCero[0] != 0) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int arriba = hijo.getInfo()[pCero[0] - 1][pCero[1]];
			hijo.getInfo()[pCero[0]][pCero[1]] = arriba;
			hijo.getInfo()[pCero[0] - 1][pCero[1]] = 0;
			if (!isVisited(visitados, hijo)) {
				hijos.add(hijo);
			}
		}
		if (pCero[0] != n - 1) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int abajo = hijo.getInfo()[pCero[0] + 1][pCero[1]];
			hijo.getInfo()[pCero[0]][pCero[1]] = abajo;
			hijo.getInfo()[pCero[0] + 1][pCero[1]] = 0;
			if (!isVisited(visitados, hijo)) {
				hijos.add(hijo);
			}
		}
		if (pCero[1] != 0) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int izquierda = hijo.getInfo()[pCero[0]][pCero[1] - 1];
			hijo.getInfo()[pCero[0]][pCero[1]] = izquierda;
			hijo.getInfo()[pCero[0]][pCero[1] - 1] = 0;
			if (!isVisited(visitados, hijo)) {
				hijos.add(hijo);
			}
		}
		if (pCero[1] != n - 1) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int derecha = hijo.getInfo()[pCero[0]][pCero[1] + 1];
			hijo.getInfo()[pCero[0]][pCero[1]] = derecha;
			hijo.getInfo()[pCero[0]][pCero[1] + 1] = 0;
			if (!isVisited(visitados, hijo)) {
				hijos.add(hijo);
			}
		}
		revisar.setHijos(hijos);
		return hijos;
	}

	private int minCost(Nodo x, int n) {
		// return fatherDistance(x) + uncorredPosition(x, n);
		return fatherDistance(x) + sumaDistanciaManhattan(x, n) + uncorredPosition(x, n);
		// return fatherDistance(x) + sumaDistanciaManhattan(x, n);
	}

	private int fatherDistance(Nodo x) {
		int counter = 0;
		Nodo aux = x;
		while (aux.getPadre() != null) {
			counter++;
			aux = aux.getPadre();
		}
		return counter;
	}

	private int uncorredPosition(Nodo x, int n) {
		int[][] ordenada = solucion;
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

	private int sumaDistanciaManhattan(Nodo x, int n) {
		int[] vectorPosicion;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				vectorPosicion = buscarPosicion(x.getInfo()[i][j]);
				sum += Math.abs(vectorPosicion[0] - i) + Math.abs(vectorPosicion[1] - j);
			}
		}
		return sum;
	}

	private int[] buscarPosicion(int n) {
		int[] vectorPosicion = new int[2];
		for (int i = 0; i < solucion.length; i++) {
			for (int j = 0; j < solucion.length; j++) {
				if (solucion[i][j] == n) {
					vectorPosicion[0] = i;
					vectorPosicion[1] = j;
				}
			}
		}
		return vectorPosicion;
	}

	private int[] ubicarPosicionCero(int[][] matriz) {
		int[] vectorCero = new int[2]; // guardar la posición de cero

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] == 0) {
					vectorCero[0] = i;
					vectorCero[1] = j;
				}
			}
		}
		return vectorCero;
	}

	public static int[][] MakeSolution(int n) {
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

	private int[][] RandomFillTokens(int n) {
		int aux = n == 3 ? 0 : n == 4 ? 2 : n == 5 ? 6 : 10;
		int[][] Ordenada = clone(solucion);
		Random rd = new Random();
		int[] pCero = ubicarPosicionCero(Ordenada);
		Nodo x = new Nodo(Ordenada);
		while (uncorredPosition(x, n) != (n * n) - aux) {
			x.setInfo(Ordenada);
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

	private int[][] clone(int[][] matriz) {
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
