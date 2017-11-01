/**
 * 
 */
package segundoPunto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Alexis Holguin
 * @version 01/11/2017 12:22 a.m
 */
public class SegundoPunto {

	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 	
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter(System.out));
		String line;
		String[] arreglo,buffer;
		
		int counter = 1;
		
		System.out.println("escriba los numeros separados por coma");
		//leer numeros
		line = br.readLine();
		
		//llenar el arreglo
		arreglo = line.split(",");
		
		//llenar el Buffer
		buffer = arreglo;
		
		
		int[]nuevoArreglos = new int [arreglo.length] ;
		
		for (int i = 0; i < arreglo.length; i++) 
		{
			for(int j = 0; j < arreglo.length; j++)
			{
				if (i == j) 
				{
					 buffer[j] = "1";
				}
				counter *= Integer.parseInt(buffer[j]);
			}
			nuevoArreglos[i] = counter; 
			counter = 1;
			buffer = line.split(",");
		}
		
		//imprimir el nuevo arreglo
		
		bw.write("el nuevo arreglo es: \n");
		for (int i =0; i < nuevoArreglos.length;i++) 
		{
			
			if(i < nuevoArreglos.length - 1) 
			{
				bw.write(nuevoArreglos[i]+",");
			}
			else
			{
				bw.write(nuevoArreglos[i]+" ");
			}
		}
		bw.flush();
	}
	
	
}
