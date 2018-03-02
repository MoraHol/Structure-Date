package profesores;

public class Main {
	static Estadisticas est = new Estadisticas();

	public static void main(String[] args) {
		est.inicializar();
		mostrar();
	}

	public static void mostrar() {
		System.out.println("La edad promedio del grupo de profesores es: " + est.EdadPromedio());
		System.out.println("La persona mas joven del grupo es: " + est.Menor());
		System.out.println("La persona de mas edad del grupo es: " + est.Mayor());
		System.out.println("El numero de profesoras con edad mayor al promedio es: " + est.NMujeres());
		System.out.println("El numero de profesores con edad menor al promedio es: "+ est.NHombres());
	}
}
