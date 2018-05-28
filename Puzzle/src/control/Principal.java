package control;

import gui.InterfazPuzzle;
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad Minuto de Dios (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas
 * 
 * clase que contiene el main y que maneja todo el proyecto
 * 
 * Ejercicio: Puzzle
 * 
 * @author Alexis Holguin
 * @since Mayo 20, 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Principal {
	public static void main(String[] args) {
		InterfazPuzzle puzzle = new InterfazPuzzle();
		puzzle.setVisible(true);
	}
}
