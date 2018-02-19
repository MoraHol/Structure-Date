package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumaEnteros {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("por favor ingrese el numero desde el cual quieregeerar la suma:");
		int num = Integer.parseInt(br.readLine());
		System.out.println(Suma_nEnteros(num));
	}

	public static int Suma_nEnteros(int n) {
		if (n == 0) {
			return 0;
		} else {
			return Suma_nEnteros(n - 1) + n;
		}
	}
}
