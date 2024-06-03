package logic;

public class Cashier extends Empleado{
	

	public Cashier(String user, String pass, String rol, String actu, String nombre, String apellido, int cedula) {
		super(user, pass, rol, actu, nombre, apellido, cedula);
	}
	
	public String getnombre() {
		return nombre;
	}
	
}
