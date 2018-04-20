package conversiones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * @version 06/04/2018
 * @author Alexis Holguin ID:604549
 *
 */
public class Conversion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		System.out.println("por favor ingrese su notacion infija:");
		String infija = br.readLine();
		System.out.println("la notacion infija en postfija  es: " + postfija(infija));
		System.out.println("la notacion infija en prefija es: " + prefija(infija));
	}
	/**
	 * convierte una cadena en notacion infija a postfija
	 * @param infija - cadena en notacion infija
	 * @return - cadena en notacion postfija
	 */
	public static String postfija(String infija) {
		Stack<String> pila = new Stack<String>();
		String epos = "";
		while (!infija.isEmpty()) {// mientras pila no este vacia
			// escojera el valor mas a la izquierda y luego recortara la expresion
			String simbol = Character.toString(infija.charAt(0));
			infija = infija.substring(1);

			if (simbol.equals("(")) {// si el valor es parentesis izquierdo
				// poner simbolo en la pila
				pila.push(simbol);
			} else if (simbol.equals(")")) { // si el valor es parentesis derecho
				while (!(pila.peek().equals("("))) {// hasta que se escriba en epre toda la operacion dentro de
													// parentesis
					epos += (pila.pop());
				}
				// sacamos el parentesis izquierdo de pila y no se agregue a epos
				pila.pop();
			} else {
				if (simbol.equals("+") || simbol.equals("-") || simbol.equals("*") || simbol.equals("/")
						|| simbol.equals("^")) {// si el simbolo es un operando
					while (!pila.isEmpty() && pref(simbol) <= pref(pila.peek())) { // mientras la pila no esta vacia y
																					// la prioridad del simbolo es menor
																					// o igual que la de la pila
						// agregar a epos todos los demas simbolos dentro de la pila
						epos += pila.pop();
					}
					// agregar simbolo a la pila
					pila.push(simbol);
				} else {
					// si simbolo es un operando agregar a epos
					epos += simbol;
				}
			}
		}
		// agregar todos los simbolos que se encuentren dentro de pila
		while (!pila.isEmpty()) {
			epos += pila.pop();
		}
		return epos;
	}
	/**
	 * convierte una cadena en notacion infija a notacion prefija
	 * @param infija - cadena en notacion infija
	 * @return -cadena en notacion prefija
	 */
	public static String prefija(String infija) {
		Stack<String> pila = new Stack<String>();
		String epre = "";
		while (!infija.isEmpty()) {// mientras pila no este vacia
			// escojera el valor mas a a derecha y luego recortara la expresion
			String simbol = Character.toString(infija.charAt(infija.length() - 1));
			if (infija.length() == 1) {
				infija = infija.substring(1);
			} else {
				infija = infija.substring(0, infija.length() - 1);
			}

			if (simbol.equals(")")) { // si el valor es parentesis derecho
				// poner simbolo en la pila
				pila.push(simbol);
			} else if (simbol.equals("(")) {// si el valor es parentesis izquierdo
				while (!(pila.peek().equals(")"))) {// hasta que se escriba en epre toda la operacion dentro de
					// parentesis
					epre += (pila.pop());
				}
				// sacamos el parentesis derecho de pila y no se agregue a epre
				pila.pop();
			} else {
				if (simbol.equals("+") || simbol.equals("-") || simbol.equals("*") || simbol.equals("/")
						|| simbol.equals("^")) { // si simbolo es un operador
					while (!pila.isEmpty() && pref(simbol) < pref(pila.peek())) { // si la pila no esta vacia y la
																					// prioridad del simbolo es
																					// menor que la de la pila
						// agregar a epre todos los demas simbolos dentro de la pila
						epre += pila.pop();
					}
					// agregar simbolo a la pila
					pila.push(simbol);
				} else {
					// si simbolo es un operando agregar a epre
					epre += simbol;
				}

			}
		}

		// agregar todos los simbolos que se encuentren dentro de pila
		while (!pila.isEmpty()) {
			epre += pila.pop();
		}
		// inversion de epre
		String aux = "";
		for (int i = epre.length() - 1; i >= 0; i--) {
			aux += epre.charAt(i);
		}
		epre = aux;

		return epre;
	}

	/**
	 *  Jerarquia de los operadores
	 * @param op -valor a evaluar prioridad
	 * @return -el grado de prioridad
	 */
	private static int pref(String op) {
		int prf = 0;
		if (op.equals("^"))
			prf = 3;
		if (op.equals("*") || op.equals("/"))
			prf = 2;
		if (op.equals("+") || op.equals("-"))
			prf = 1;
		return prf;
	}
}
