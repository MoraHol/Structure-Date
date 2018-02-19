package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumaPares {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("por favor ingrese el numero desde el cual quiere generar la suma:");
		int num = Integer.parseInt(br.readLine());
		comprobar(num);
	}

	public static void comprobar(int n) {
		if (n % 2 != 0) {
			System.err.println("error ingresar numeros pares por favor");
		} else {
			System.out.println(SumPar(n));
		}
	}

	public static int SumPar(int n) {

		if (n == 2) {
			return 2;
		} else {
			return n + SumPar(n - 2);
		}
	}

}
