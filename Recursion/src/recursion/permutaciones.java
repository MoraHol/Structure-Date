package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class permutaciones {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("ingresa el valor n cosas de un conjunto:");
		int n = Integer.parseInt(br.readLine());
		System.out.println("ingresa el valor de r cosas");
		int r = Integer.parseInt(br.readLine());
		System.out.println("las maneras diferentes que tengo para elegir r cosas\r\n" + 
				"distintas de un conjunto de n cosas es:");
		System.out.println(elegir(n, r));
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	public static int elegir (int n, int r) {
		return (factorial(n))/((factorial(r))*factorial(n-r));
	}
}
