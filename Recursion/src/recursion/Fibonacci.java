package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("por favor ingrese el numero desde el cual quiere generar la suma Fibonacci:");
		int num = Integer.parseInt(br.readLine());
		System.out.println(fibonacci(num));

	}

	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		int anterior = 0;
		int actual = 1;
		for (int i = 2; i <= n; i++) {
			int x = anterior;
			anterior = actual;
			actual = x + anterior;
		}
		return actual;
	}
}
