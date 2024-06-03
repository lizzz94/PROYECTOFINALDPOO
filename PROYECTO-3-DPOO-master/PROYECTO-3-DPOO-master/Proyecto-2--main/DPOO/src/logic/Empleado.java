package logic;

public abstract class Empleado extends Usuario{

	protected String nombre;
	protected String apellido;
	protected int cedula;
	
	
	
	public Empleado(String usuario, String contrasena, String rol, String ultimaActualizacion, String nombre, String apellido, int cedula) {
		
		super(usuario, contrasena, rol, ultimaActualizacion);
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;

		
	}
	
	public String getnombre() {
		return nombre;
	}
		
	

}
