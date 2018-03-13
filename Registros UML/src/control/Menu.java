package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import trabajador.Trabajador;
import file.archivos;
public class Menu {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Main mn = new Main();
	boolean exit = true;
	public void menu(int decision) throws IOException {
		switch (decision) {
		case 1:
			pedirDatos();
			mn.posicion++;
			break;
		case 2:
			System.out.println("por ingrese el numero de registro de quien desea borrar");
			borrar(Integer.parseInt(br.readLine()));
			break;
		case 3:
			System.out.println("ingrese el numero de registro del trabajador que desea editar:");
			int registro = Integer.parseInt(br.readLine());
			System.out.println(
					"que sea editar: \n" + "1. Nombre \n" + "2. Apellido \n" + "3. Direccion \n" + "4. Salario \n"
							+ "5. Telefono \n" + "6. Numero de Identificacion (NUI) \n" + "7. Fecha de nacimiento \n"
							+ "8. Fecha de ingreso al trabajo \n" + "9. Genero \n" + "10. E-mail \n");
			edicion(registro, Integer.parseInt(br.readLine()));
		case 4:
			mn.mostar();
			break;
		case 5:
			exit = false;
			break;
		default:
			break;
		}
	}

	public void pedirDatos() throws IOException {
		mn.tb[mn.posicion] = new Trabajador();
		System.out.println("Ingrese el nombre:");
		mn.tb[mn.posicion].setNombre(br.readLine());
		System.out.println("Ingrese su apellido:");
		mn.tb[mn.posicion].setApellidos(br.readLine());
		System.out.println("Ingrese su fecha de nacimiento:");
		mn.tb[mn.posicion].setFnacimineto(br.readLine());
		System.out.println("Ingrese su direccion de residencia:");
		mn.tb[mn.posicion].setDireccion(br.readLine());
		System.out.println("Ingrese su correo electronico:");
		mn.tb[mn.posicion].setEmail(br.readLine());
		System.out.println("Ingrese su fecha de ingreso al trabajo:");
		mn.tb[mn.posicion].setFingreso(br.readLine());
		System.out.println("Ingrese su salario:");
		mn.tb[mn.posicion].setSalario(Double.parseDouble(br.readLine()));
		System.out.println("Ingrese su genero:");	
		mn.tb[mn.posicion].setGenero(br.readLine());
		System.out.println("Ingrese su numero de identificacion(NUI):");
		mn.tb[mn.posicion].setNUI(br.readLine());
		System.out.println("Ingrese su numero de telefono:");
		mn.tb[mn.posicion].setTelefono(br.readLine());
		mn.tb[mn.posicion].setRegistro(mn.posicion);
		System.out.println("se escribio correctamente en el archivo");
		
	}

	public void borrar(int numero) {
		mn.tb[numero] = new Trabajador(null, null, null, 0, null, null, null, null, null, null);
	}

	public void edicion(int regis, int desicion) throws IOException {
		switch (desicion) {
		case 1:
			System.out.println("ingrese el nombre:");
			mn.tb[regis].setNombre(br.readLine());
			break;
		case 2:
			System.out.println("ingrese el apellido:");
			mn.tb[regis].setApellidos(br.readLine());
			break;
		case 3:
			System.out.println("ingrese el direccion:");
			mn.tb[regis].setDireccion(br.readLine());
			break;
		case 4:
			System.out.println("ingrese el salario:");
			mn.tb[regis].setSalario(Double.parseDouble(br.readLine()));
			break;
		case 5:
			System.out.println("ingrese el telefono:");
			mn.tb[regis].setTelefono(br.readLine());
			break;
		case 6:
			System.out.println("ingrese el numero de identificacion:");
			mn.tb[regis].setNUI(br.readLine());
			break;
		case 7:
			System.out.println("ingrese la fecha de nacimiento:");
			mn.tb[regis].setFnacimineto(br.readLine());
			break;
		case 8:
			System.out.println("ingrese el fecha de ingreso:");
			mn.tb[regis].setFingreso(br.readLine());
			break;
		case 9:
			System.out.println("ingrese el genero:");
			mn.tb[regis].setGenero(br.readLine());
			break;
		case 10:
			System.out.println("ingrese el correo electronico:");
			mn.tb[regis].setEmail(br.readLine());
			break;
		default:
			break;
		}
	}
	public int opciones() throws NumberFormatException, IOException {
		System.out.println("que desea Hacer: \n"
				+ "1. Agregar al registro \n"
				+ "2. Borrar Del registro \n"
				+ "3. Editar del registro \n"
				+ "4. Mostar registros \n"
				+ "5. Salir");
		return Integer.parseInt(br.readLine());
	}
}
