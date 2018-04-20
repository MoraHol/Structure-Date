package colas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class colas {
	private static BufferedReader scan;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<String> cola = new LinkedList<>() ;
		System.out.println("por favor ingrese el tamaño que quiere para la cola");
		scan = new BufferedReader(new InputStreamReader(System.in));
		int numero = Integer.parseInt(scan.readLine());
		String Aux = scan.readLine();
		boolean ola = cola.add(Aux);
		for (int i = 0; i < numero; i++) {
			System.out.println("ingrese numero a insertar");
			Aux = scan.readLine();
			cola.add(Aux);
		}
		System.out.println("cola original: " + cola.toString());
		System.out.println("cola invertida: " + invertirCola(cola).toString());
	}
	public  static Queue<String> invertirCola(Queue<String> cola) {
		Stack<String> colaAux = new Stack<>();
		while(!cola.isEmpty()) {
			colaAux.add(cola.remove());
		}
		while(!colaAux.isEmpty()) {
			cola.add(colaAux.pop());
		}
		return cola;
	}
}
