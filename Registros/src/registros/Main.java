package registros;

import javax.swing.JOptionPane;

public class Main {
	static Alumno[] al = new Alumno[10];

	public static void main(String[] args) {
		inicializar();
		desplegar();
	}

	public static void inicializar() {
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
	public static void desplegar() {
		for (int i = 0; i < al.length; i++) {
			System.out.println(al[i].toString());
			System.out.println();
		}
		
	}
}
