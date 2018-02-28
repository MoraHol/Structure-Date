package registros;

import java.text.DecimalFormat;

public class Alumno {
	int codigo;
	String nombre;
	double Nota1, Nota2, Nota3, definitiva;
	DecimalFormat df = new DecimalFormat("0.00");
	public Alumno(int Cod, String Nom, double nota1, double nota2, double nota3) {
		this.codigo = Cod;
		this.nombre = Nom;
		this.Nota1 = nota1;
		this.Nota2 = nota2;
		this.Nota3 = nota3;
		this.definitiva = definitiva();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota1() {
		return Nota1;
	}

	public void setNota1(double nota1) {
		Nota1 = nota1;
	}

	public double getNota2() {
		return Nota2;
	}

	public void setNota2(double nota2) {
		Nota2 = nota2;
	}

	public double getNota3() {
		return Nota3;
	}

	public void setNota3(double nota3) {
		Nota3 = nota3;
	}

	public double getDefinitiva() {
		return definitiva;
	}


	public double definitiva() {
		return  (this.Nota1 + this.Nota2 + this.Nota3) / 3;
	}

	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", Nota 1=" + Nota1 + ", Nota 2=" + Nota2 + ", Nota 3="
				+ Nota3 + ", definitiva=" + df.format(definitiva) + "]";
	}
	

}
