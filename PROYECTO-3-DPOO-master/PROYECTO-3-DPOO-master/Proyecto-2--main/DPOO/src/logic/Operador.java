package logic;

import entities.Subasta;

public class Operador extends Empleado {
	

	public Operador(String user, String pass, String rol, String actu, String nombre, String apellido, int cedula) {
		super(user, pass, rol, actu, nombre, apellido, cedula);

	}
	
	public String getnombre() {
		return nombre;
	}
	
	public String getapellido() {
		return apellido;
	}

}
