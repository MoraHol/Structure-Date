/**
 * 
 */
package tercerpunto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Alexis Holguin
 * @version 01/11/2017 1:53 a.m.
 */
public class TercerPunto {
	static String line,buffer;
	static String[] arreglo; 

	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		System.out.println("escriba los numeros separados por coma");
		line = br.readLine();
		arreglo = line.split(",");
		
		
		for (int i = 0; i < arreglo.length;i++) //recorre el todo el arreglo y compara valor por valor
		{
			int counter = 0;
			for (int j = 0; j < arreglo.length; j++)
			{
				if (Integer.parseInt(arreglo[i]) == Integer.parseInt(arreglo[j])) 
				{
					counter += 1;
				}
			}
			if (counter == 1) //si el contador es igual a 1 lo guarda en le buffer por si otro valor tambien llega a ser 1
			{
				buffer = arreglo[i];
			}
		}
		System.out.println("el numero que no se repite es: " + buffer);
		
	}
}
	
	
		
		
