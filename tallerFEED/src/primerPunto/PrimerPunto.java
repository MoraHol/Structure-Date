
package primerPunto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Alexis Holguin
 * @version 31/10/2017
 */
public class PrimerPunto {
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		String line;
		String[] arreglo;
		int k,counter = 0;
	
		System.out.println("por favor ingrese los numeros separados por coma ");
		
		// leer los numeros
		line = br.readLine();
		
		System.out.println("por favor ingrese el valor de k:");
		k = Integer.parseInt(br.readLine());
		
		//llenar el arreglo
		arreglo = line.split(",");
		
		//comparar cada uno de los numeros 
		for (int i = 0; i < arreglo.length; i++)
		{
			for (int j = 0; j < arreglo.length; j++) 
			{
				if (Integer.parseInt(arreglo [i]) - Integer.parseInt(arreglo[j]) == k) // comparar si la resta de los numeros es el valor de k
				{
					counter ++;
				}
			}
		}
		System.out.println("el numero de parejas que cumplen la restriccion son: " + counter);
	}

}
