package registros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Main {
	static Alumno[] al = new Alumno[1];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// inicializar();
		// desplegarConsola();
		inicializarBox();
		desplegarBox();
	}

	public static void inicializar() throws NumberFormatException, IOException {

		al[0] = new Alumno(1011, "Carlos Sanchez", 3.0, 3.5, 3.0);
		al[1] = new Alumno(1012, "Rodrigo Torres", 3.7, 4.2, 5.0);
		al[2] = new Alumno(1013, "Juliana Arango", 3.0, 3.0, 3.0);
		al[3] = new Alumno(1014, "Bertha Diaz", 4.0, 2.0, 2.5);
		al[4] = new Alumno(1015, "Arthuro Calle", 3.5, 3.5, 3.5);
		al[5] = new Alumno(1016, "Maribel Castiblanco", 2.8, 3.6, 4.0);
		al[6] = new Alumno(1017, "Felipe Guerrero", 3.2, 3.0, 2.8);
		al[7] = new Alumno(1018, "Alicia Duarte", 4.1, 4.5, 4.3);
		al[8] = new Alumno(1019, "Alberto Camargo", 4.0, 1.3, 3.2);
		al[9] = new Alumno(1020, "Patricia Herrera", 4.1, 2.5, 2.0);

	}

	public static void incializarEntrada() throws NumberFormatException, IOException {
		for (int i = 0; i < al.length; i++) {
			System.out.println("Por favor introduzca el codigo del estudiante " + (i + 1) + ":");
			int codigo = Integer.parseInt(br.readLine());
			System.out.println("Por favor introduzca el nombre del estudiante " + (i + 1) + ":");
			String nombre = br.readLine();
			System.out.println("Por favor introduzca la primera nota  del estudiante " + (i + 1) + ":");
			double nota1 = Double.parseDouble(br.readLine());
			System.out.println("Por favor introduzca la segunda nota del estudiante " + (i + 1) + ":");
			double nota2 = Double.parseDouble(br.readLine());
			System.out.println("Por favor introduzca la tercera nota del estudiante " + (i + 1) + ":");
			double nota3 = Double.parseDouble(br.readLine());
			al[i] = new Alumno(codigo, nombre, nota1, nota2, nota3);
			System.out.println("Se ha guardado correctamente la informacion \n");
		}
	}

	public static void inicializarBox() {
		String nl = System.getProperty("line.separator");
		for (int i = 0; i < al.length; i++) {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Por favor introduzca el codigo del estudiante " + (i + 1) + ":"));
			String nombre = JOptionPane.showInputDialog(null,
					"Por favor introduzca el nombre del estudiante " + (i + 1) + ":");
			double nota1 = Double.parseDouble(JOptionPane.showInputDialog(null,
					"Por favor introduzca la primera nota  del estudiante " + (i + 1) + ":"));
			double nota2 = Double.parseDouble(JOptionPane.showInputDialog(null,
					"Por favor introduzca la segunda nota  del estudiante " + (i + 1) + ":"));
			double nota3 = Double.parseDouble(JOptionPane.showInputDialog(null,
					"Por favor introduzca la tercera nota  del estudiante " + (i + 1) + ":"));
			al[i] = new Alumno(codigo, nombre, nota1, nota2, nota3);
			
		}
	}

	public static void desplegarConsola() {
		for (int i = 0; i < al.length; i++) {
			System.out.println(al[i].toString());
			System.out.println();
		}

	}

	public static void desplegarBox() {
		String nl = System.getProperty("line.separator");
		JOptionPane.showMessageDialog(null, al[0].toString(), "Registros", JOptionPane.INFORMATION_MESSAGE);
	}

}
