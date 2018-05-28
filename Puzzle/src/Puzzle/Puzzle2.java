package Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

import Arbol.Nodo;

// TODO: Auto-generated Javadoc
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Universidad Minuto de Dios (Bogotá - Colombia) Departamento de
 * Ingeniería de Sistemas
 * 
 * Ejercicio: Puzzle.
 *
 * @author Alexis Holguin
 * @since Mayo 20, 2018
 *        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Puzzle2 {
	// ------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------

	/** matriz que alberga el problema o puzzle desordenado. */
	private int[][] problema;

	/** pila para almacenar los pasos para llegar a la solución del puzzle. */
	private Stack<Nodo> pasos;

	/** Matriz que alberga el puzzle al que se quiere llegar o la misma solución. */
	private int[][] solucion;

	/** el numero de movimientos necesarios para llegar a una solución. */
	private int movimientos;

	/** Tamaño de la matriz. */
	private int n;

	// ------------------------------------------------------------------------------------
	// Constructores
	// ------------------------------------------------------------------------------------

	/**
	 * constructor que generar un puzzle desordenado a partir de un tamaño
	 * especificado.
	 *
	 * @param n
	 *            tamaño del puzzle
	 */
	public Puzzle2(int n) {
		movimientos = 0;
		solucion = MakeSolution(n);
		problema = RandomFillTokens(n);
		this.n = n;

	}

	/**
	 * Constructor que generar un puzzle desordenado ingresado por el usuario.
	 *
	 * @param problem
	 *            matriz ingresada por el usuario como puzzle
	 * @param n
	 *            tamaño del puzzle
	 */
	public Puzzle2(int[][] problem, int n) {
		movimientos = 0;
		solucion = MakeSolution(n);
		problema = problem;
		this.n = n;
	}

	// ------------------------------------------------------------------------------------
	// Getters
	// ------------------------------------------------------------------------------------

	/**
	 * Gets the movimientos.
	 *
	 * @return numero de movimientos necesarios para solucionar el puzzle
	 */
	public int getMovimientos() {
		return movimientos;
	}

	/**
	 * Gets the pasos.
	 *
	 * @return pasos necesarios para alcanzar la solución
	 */
	public Stack<Nodo> getPasos() {
		return pasos;
	}

	/**
	 * Gets the problema.
	 *
	 * @return el puzzle desordenado
	 */
	public int[][] getProblema() {
		return problema;
	}

	/**
	 * Gets the solution.
	 *
	 * @return Puzzle ordenado
	 */
	public int[][] getSolution() {
		return solucion;
	}

	// ------------------------------------------------------------------------------------
	// Métodos
	// ------------------------------------------------------------------------------------
	/**
	 * genera solución al puzzle.
	 */
	public void generarSolucion() {
		generarSolucion(n);
	}

	/**
	 * genera solución y carga los pasos necesarios para solucionar el puzzle.
	 *
	 * @param n
	 *            tamaño del puzzle
	 */
	private void generarSolucion(int n) {
		Nodo sol = findSolution(problema, solucion, n);
		// si no se ha encontrado una solución devolverá el error
		if (sol != null) {
			pasos = new Stack<>();
			while (sol.getPadre() != null) {
				pasos.add(sol);
				sol = sol.getPadre();
				movimientos += 1;
			}
		} else {
			JOptionPane.showMessageDialog(null, "solcuion inalcanzable");
		}
	}

	/**
	 * Encuentra el nodo solución del puzzle rrecorriendo el arbol de soluciones.
	 *
	 * @param problem
	 *            puzzle desordenado
	 * @param solution
	 *            puzzle ordenado
	 * @param n
	 *            tamaño del puzzle
	 * @return nodo en donde se encuentra la solución
	 */
	private Nodo findSolution(int[][] problem, int[][] solution, int n) {
		int count = 0;
		Nodo revisar = new Nodo(problem);
		ArrayList<Nodo> Recorridos = new ArrayList<>();
		int menorCoste;
		ArrayList<Nodo> visitados = new ArrayList<>();
		while (true) {
			visitados.add(revisar);
			// si se han revisado mas de 10000 nodos y no se ha encontrado la solución
			// retornar error o null
			if (visitados.size() >= 10000) {
				return null;
			}
			// si nodo es la solución retornarlo
			if (Arrays.deepEquals(revisar.getInfo(), solution)) {
				System.out.println(count);
				return revisar;
			}

			ArrayList<Nodo> hijos = generateChildren(revisar, n, visitados);
			// añadirá los hijos del nodo a los próximos a revisar
			for (Nodo hijo : hijos) {
				Recorridos.add(hijo);
			}

			menorCoste = Integer.MAX_VALUE;
			// escoger el nodo con menor coste o mas cerca de la solución
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

	/**
	 * genera los hijos de un nodo especifico teniendo en cuenta las reglas del
	 * puzzle.
	 *
	 * @param revisar
	 *            nodo al que se le quieren generar los hijos
	 * @param n
	 *            tamaño del puzzle
	 * @param visitados
	 *            nodos a los cuales ya ha accedido
	 * @return los hijos de dicho nodo
	 */
	private ArrayList<Nodo> generateChildren(Nodo revisar, int n, ArrayList<Nodo> visitados) {
		int[] pCero = ubicarPosicionCero(revisar.getInfo());
		ArrayList<Nodo> hijos = new ArrayList<>();
		// si no esta en la primera fila puede genera el hijo de arriba
		if (pCero[0] != 0) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int arriba = hijo.getInfo()[pCero[0] - 1][pCero[1]];
			hijo.getInfo()[pCero[0]][pCero[1]] = arriba;
			hijo.getInfo()[pCero[0] - 1][pCero[1]] = 0;
			if (!isVisited(visitados, hijo)) {
				hijos.add(hijo);
			}
		}
		// si no esta en la ultima fila puede generar el hijo de abajo
		if (pCero[0] != n - 1) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int abajo = hijo.getInfo()[pCero[0] + 1][pCero[1]];
			hijo.getInfo()[pCero[0]][pCero[1]] = abajo;
			hijo.getInfo()[pCero[0] + 1][pCero[1]] = 0;
			if (!isVisited(visitados, hijo)) {
				hijos.add(hijo);
			}
		}
		// si no esta en la primera columna puede generar el hijo de la izquierda
		if (pCero[1] != 0) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int izquierda = hijo.getInfo()[pCero[0]][pCero[1] - 1];
			hijo.getInfo()[pCero[0]][pCero[1]] = izquierda;
			hijo.getInfo()[pCero[0]][pCero[1] - 1] = 0;
			if (!isVisited(visitados, hijo)) {
				hijos.add(hijo);
			}
		}
		// si no esta el la ultima columna puede generar el hijo de la derecha
		if (pCero[1] != n - 1) {
			Nodo hijo = new Nodo(clone(revisar.getInfo()));
			int derecha = hijo.getInfo()[pCero[0]][pCero[1] + 1];
			hijo.getInfo()[pCero[0]][pCero[1]] = derecha;
			hijo.getInfo()[pCero[0]][pCero[1] + 1] = 0;
			if (!isVisited(visitados, hijo)) {
				hijos.add(hijo);
			}
		}
		// asigna los hijos al nodo
		revisar.setHijos(hijos);
		return hijos;
	}

	/**
	 * obtiene el mínimo costo de un nodo en especifico.
	 *
	 * @param x
	 *            nodo al que se le quiere obtener el mínimo costo
	 * @param n
	 *            tamaño del puzzle
	 * @return el mínimo de costo del nodo x
	 */
	private int minCost(Nodo x, int n) {
		// return fatherDistance(x) + uncorredPosition(x, n);
		return rootDistance(x) + sumManhattanDistance(x, n) + uncorredPosition(x, n);
		// return fatherDistance(x) + sumaDistanciaManhattan(x, n);
	}

	/**
	 * Obtiene la distancia que hay de un nodo a la raíz del árbol.
	 *
	 * @param x
	 *            nodo al que se quiere buscar la distancia
	 * @return la distancia del nodo x a la raíz del padre
	 */
	private int rootDistance(Nodo x) {
		int counter = 0;
		Nodo aux = x;
		while (aux.getPadre() != null) {
			counter++;
			aux = aux.getPadre();
		}
		return counter;
	}

	/**
	 * Obtiene el numero de posiciones que no están en su posiciones correcta en un
	 * nodo.
	 *
	 * @param x
	 *            nodo a verificar
	 * @param n
	 *            tamaño del puzzle
	 * @return numero de posiciones que no están en la posición correcta en el nodo
	 *         x
	 */
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

	/**
	 * Obtiene la suma de las distancias desde la posición actual de cada ficha
	 * hasta su posición original o correcta en un nodo.
	 *
	 * @param x
	 *            nodo a verificar
	 * @param n
	 *            tamaño del puzzle
	 * @return la suma de las distancias desde la posición actual de cada ficha
	 *         hasta su posición original o correcta del nodo x
	 */
	private int sumManhattanDistance(Nodo x, int n) {
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

	/**
	 * busca la posición de un numero en el puzzle ordenado o solución.
	 *
	 * @param n
	 *            numero a verificar
	 * @return posición del numero n el el puzzle ordenado
	 */
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

	/**
	 * Ubicar la posición del 0 en una matriz.
	 *
	 * @param matriz
	 *            matriz a verificar
	 * @return posición del número 0 en matriz
	 */
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

	/**
	 * Genera un puzzle completamente solucionado a partir del tamaño del mismo.
	 *
	 * @param n
	 *            Tamaño del puzzle
	 * @return puzzle completamente ordenado o puzzle solución
	 */
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

	/**
	 * genera un puzzle desordenado a partir del tamaño del mismo.
	 *
	 * @param n
	 *            tamaño del puzzle
	 * @return puzzle desordeando
	 */
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

	/**
	 * Clona una matriz.
	 *
	 * @param matriz
	 *            the matriz
	 * @return the int[][]
	 */
	private int[][] clone(int[][] matriz) {
		int[][] clon = new int[matriz.length][matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			clon[i] = matriz[i].clone();
		}
		return clon;
	}

	/**
	 * revisa si en una ArrayList ya existe un nodo especifico.
	 *
	 * @param visitados
	 *            ArrayList en donde se va a buscar
	 * @param hijo
	 *            nodo a verificar
	 * @return true si y solo si nodo hijo se encuentra en visitados de lo contrario
	 *         retornara false
	 */
	private static boolean isVisited(ArrayList<Nodo> visitados, Nodo hijo) {
		for (Nodo nodo : visitados) {
			if (Arrays.deepEquals(nodo.getInfo(), hijo.getInfo())) {
				return true;
			}
		}
		return false;
	}
}
