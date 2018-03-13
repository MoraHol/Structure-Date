package trabajador;

public class Trabajador {
	private String nombre;
	private String apellidos;
	private String direccion;
	private double salario;
	private String Telefono;
	private String NUI;
	private String Fnacimineto;
	private String Fingreso;
	private String genero;
	private String email;
	private int Registro;

	public Trabajador(String nombre, String apellidos, String direccion, double salario, String telefono, String nUI,
			String fnacimineto, String fingreso, String genero, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.salario = salario;
		this.Telefono = telefono;
		this.NUI = nUI;
		this.Fnacimineto = fnacimineto;
		this.Fingreso = fingreso;
		this.genero = genero;
		this.email = email;
	}

	public Trabajador() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getNUI() {
		return NUI;
	}

	public void setNUI(String nUI) {
		NUI = nUI;
	}

	public String getFnacimineto() {
		return Fnacimineto;
	}

	public void setFnacimineto(String fnacimineto) {
		Fnacimineto = fnacimineto;
	}

	public String getFingreso() {
		return Fingreso;
	}

	public void setFingreso(String fingreso) {
		Fingreso = fingreso;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		if (genero != "Maculino" || genero != "maculino" || genero != "Femenino" || genero != "femenino") {
			System.err.println("El genero no no es valido");
		} else {
			this.genero = genero;
		}

	}

	public String getEmail() {
		return email;
	}

	public int getRegistro() {
		return Registro;
	}

	public void setRegistro(int registro) {
		Registro = registro;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", salario="
				+ salario + ", Telefono=" + Telefono + ", NUI=" + NUI + ", Fnacimineto=" + Fnacimineto + ", Fingreso="
				+ Fingreso + ", genero=" + genero + ", email=" + email + ", Registro=" + Registro + "]";
	}

}
