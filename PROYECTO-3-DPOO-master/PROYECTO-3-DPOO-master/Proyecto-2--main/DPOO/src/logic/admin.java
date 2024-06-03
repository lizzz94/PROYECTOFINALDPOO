package logic;
import entities.Galeria;
import entities.Pieza;
import java.util.Hashtable;
import java.util.List;



public class admin extends Usuario{
	
	private String nombre;
	private String apellido;
	
	
	public admin(String user, String pass, String rol, String actu, String nombre, String apellido) {
		
		super(user, pass, rol, actu);
		this.nombre = nombre;
		this.apellido = apellido;
		
	}
	
	public String getnombre() {
		return nombre;
	}

	public String getapellido() {
		return apellido;
	}

	public List<Pieza> verPiezas()
	{
		return Galeria.getPiezas();
	}

	public List<String> verArtistas()
	{
		return Galeria.getArtistas();
	}
	
	public Hashtable<String,Comprador> verCompradores()
	{
		return Galeria.getCompradores();
	}
	
	public Pieza buscarPieza(String nombre)
	{
		return Galeria.buscarPieza(nombre);
	}

	public String buscarArtista(String nombre)
	{
		return Galeria.buscarArtista(nombre);
	}

	public Comprador buscarComprador(String nombre)
	{
		return Galeria.buscarComprador(nombre);
	}
	
	public void registrarPieza(Galeria galeria, Pieza pieza) {
		Galeria.addPieza(pieza);
	}

	public void confirmarVenta(Galeria galeria, Pieza pieza, Comprador comprador)
	{
		if(comprador.verificar())
		{
			pieza.setVendida(true);
			galeria.removePieza(pieza);
		}
	}

	public void crearSubastas(Pieza pieza, double precio_inicial)
	{
		Galeria.crearSubastas(pieza, precio_inicial);
	}

	public void accederSubasta(int idSubasta)
	{
		Galeria.accederSubasta(idSubasta);
	}

	public boolean verificarOferta(int idSubasta, double oferta)
	{
		return Galeria.verificarOferta(idSubasta, oferta);
	}
	
}
