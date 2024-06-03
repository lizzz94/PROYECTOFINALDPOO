package logic;

public abstract class Usuario {
	
	protected String Username;
	protected String Password;
	protected String Rol;
	protected String UltimaActualizacion;
	
	public Usuario(String user, String pass, String rol, String actu) {
		
		this.Username = user;
		this.Password = pass;
		this.Rol = rol;
		this.UltimaActualizacion = actu;
	}
	
	public String verificarRol() {
		return Rol;

	}

	public String getusuario() {
		return Username;
	}
	

}
