package cuartoPunto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Alexis Holguin
 * @version 01/11/2017 02:42 a.m
 */
public class cuartoPunto {

	static String[] arreglo;
	static String line;
	static int PosicionMin;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		System.out.println("escriba los siete precios separados por comas");
		line = br.readLine();
		arreglo = line.split(",");
		int min = valorMin();
		int max = valorMax();
		System.out.println("el maximo beneficio es: " + (max - min));
	}
	public static int valorMin() 
	{
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arreglo.length;i++) 
		{
			if (Integer.parseInt(arreglo[i]) < min) 
			{
				min = Integer.parseInt(arreglo[i]);
				PosicionMin = i;
			}
		}
		
		return min;
	}
	public static int valorMax() {
		int max = Integer.MIN_VALUE;
		for (int i = PosicionMin; i < arreglo.length;i++) 
		{
			if (Integer.parseInt(arreglo[i]) > max) 
			{
				max = Integer.parseInt(arreglo[i]);
			}
		}
		return max;
	}
}
