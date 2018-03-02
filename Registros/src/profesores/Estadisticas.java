package profesores;

public class Estadisticas {
	static Profesor[] pf = new Profesor[10];

	public int EdadPromedio() {
		int prom = 0;
		for (int i = 0; i < pf.length; i++) {
			prom += pf[i].getEdad();
		}
		return prom / pf.length;

	}

	public void inicializar() {
		pf[0] = new Profesor("Pepito Perez", "masculino", 29);
		pf[1] = new Profesor("laura montes", "Femenino", 31);
		pf[2] = new Profesor("Allison", "Femenino", 23);
		pf[3] = new Profesor("Cesar", "masculino", 35);
		pf[4] = new Profesor("Ivan", "masculino", 74);
		pf[5] = new Profesor("Fabian", "masculino", 49);
		pf[6] = new Profesor("Hilda", "Femenino", 63);
		pf[7] = new Profesor("Isable", "Femenino", 38);
		pf[8] = new Profesor("Elena", "Femenino", 21);
		pf[9] = new Profesor("david", "masculino", 39);
	}

	public String Menor() {
		int min = Integer.MAX_VALUE;
		int aux = 0;
		for (int i = 0; i < pf.length; i++) {
			if (pf[i].getEdad() < min) {
				min = pf[i].getEdad();
				aux = i;
			}
		}
		return pf[aux].getNombre();
	}

	public String Mayor() {
		int max = Integer.MIN_VALUE;
		int aux = 0;
		for (int i = 0; i < pf.length; i++) {
			if (pf[i].getEdad() > max) {
				max = pf[i].getEdad();
				aux = i;
			}
		}
		return pf[aux].getNombre();
	}

	public int NMujeres() {
		int counter = 0;
		for (int i = 0; i < pf.length; i++) {
			if (pf[i].getSexo() == "Femenino" || pf[i].getSexo() == "femenino") {
				if (pf[i].getEdad() > EdadPromedio()) {
					counter++;
				}
			}
		}
		return counter;
	}

	public int NHombres() {
		int counter = 0;
		for (int i = 0; i < pf.length; i++) {
			if (pf[i].getSexo() == "Masculino" || pf[i].getSexo() == "masculino") {
				if (pf[i].getEdad() < EdadPromedio()) {
					counter++;
				}
			}
		}
		return counter;
	}
}
