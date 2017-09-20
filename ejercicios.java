package ejercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class ejercicios 
{
	static BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		Random rd = new Random();
		System.out.println( 5 + rd.nextInt(25));
	}
	
	public static void interes() throws IOException
	{
		bw.write("Bienvenido \n");
		bw.write("¿cuanto dinero va invertir? \n");
		bw.flush();
		int dinero = Integer.parseInt(br.readLine());
		int interes = (int) (dinero * 0.02) ;
		int ganancia_anual = (interes * 12) ;
		int total = dinero + interes ; 
		int total_anual = dinero + ganancia_anual;
		bw.write("Su ganancia mensual es $"+interes+"\n");
		bw.write("tendra un total en el mes de $" + total+ "\n");
		bw.write("Su ganacia anual es $"+ganancia_anual +"\n");
		bw.write("tendra un total en el año de $" + total_anual+ "\n");
		bw.flush();
	}
	public static void comision() throws IOException
	{
		bw.write("¿cual es su sueldo base?\n");
		bw.flush();
		int sueldo = Integer.parseInt(br.readLine());
	
		int[] ventas = new int [3];
		for (int n = 0; n < 3;n++)
		{
			bw.write("De cuanto due su "+(n+1)+" venta? \n");
			bw.flush();
			ventas[n] = Integer.parseInt(br.readLine());
		}
		int comision = (int) ((ventas[0] * 0.1) + (ventas[1] * 0.1) + (ventas[2] * 0.1));
		bw.write("su comision por las tres ventas es " + comision +"\n");
		bw.flush();
		int total = comision + sueldo;
		bw.write("su sueldo total  es " + total+"\n");
		bw.flush();
	}
	
}
