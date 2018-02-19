package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxComunDiv {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Ingrese el valor del primer numero:");
		int M = Integer.parseInt(br.readLine());
		System.out.println("Ingrese el valor del segundo numero:");
		int N = Integer.parseInt(br.readLine());
		System.out.println("El maximo comun divisor entre " + M + " y " + N + " es:");
		System.out.println(MCD(M, N));
	}

	public static int MCD(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			if (a < b) {
				int aux = a;
				a = b;
				b = aux;
			}
			return MCD(b, a % b);
		}
	}
}
