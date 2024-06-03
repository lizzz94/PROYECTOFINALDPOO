package entities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import logic.Comprador;

public abstract class Pieza {
	
	protected String titulo;
	protected int anio;
	protected String lugar_creacion;
	protected String autores;
	protected int valor_fijo;
	protected boolean bloqueado;
	protected Comprador propietario;
	protected String tipo_pieza;
	protected int codigo;
	protected String tiempo_ingreso;
	protected boolean subastado;
	protected boolean aceptado;
	
	public Pieza (String titulo, int anio, String creacion, ArrayList<String> autores2, int valor_fijo, boolean bloqueado, Comprador propietario, String tipo_pieza, boolean subastado, boolean aceptado){
		
		
		this.titulo = titulo;
		this.anio = anio;
		this.lugar_creacion = creacion;
		this.autores = autores2;
		this.valor_fijo = valor_fijo;
		this.bloqueado = bloqueado;
		this.propietario = propietario;
		this.tipo_pieza = tipo_pieza;
		this.codigo = generar_codigo();
		this.tiempo_ingreso = tiempo_ingreso();
		this.subastado = subastado;
		this.aceptado = aceptado;
		
	}
	
    public Pieza(String titulo2, int anio2, String creacion, ArrayList<String> autores2, int valor_fijo2,
            boolean bloqueado2, Comprador propietario2, String tipo_pieza2, boolean subastado2, boolean aceptado2) {
        //TODO Auto-generated constructor stub
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public String getLugar_creacion() {
        return lugar_creacion;
    }

    public String getAutores() {
        return autores;
    }

    public double getValor_fijo() {
        return valor_fijo;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public Comprador getPropietario() {
        return propietario;
    }

    public String getTipo_pieza() {
        return tipo_pieza;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTiempo_ingreso() {
        return tiempo_ingreso;
    }

    public boolean isSubastado() {
        return subastado;
    }

    public boolean isAceptado() {
        return aceptado;
    }
	
	public String tiempo_ingreso() {
		
		String UltimaActualizacion = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                .format(LocalDateTime.now());
		
		return UltimaActualizacion;
			
	}
	
	public int generar_codigo() {
		
		int codigoGenerado = Math.abs(titulo.hashCode() + anio + lugar_creacion.hashCode() +
                autores.hashCode() + valor_fijo + (bloqueado ? 1 : 0) + propietario.hashCode() +
                tipo_pieza.hashCode());
        return codigoGenerado;
	}
	
	public static String leerpieza(Pieza pieza) {
		
		String stringfinal = "";
		
		System.out.println((pieza.getAutores()).get(0));
		
		String lista_autores = (pieza.getAutores()).get(0);
		
		int tamanio_lista = pieza.getAutores().size();
		
		if (tamanio_lista > 2) {
		for (int i = 1; i < pieza.getAutores().size(); i++) {
			lista_autores = lista_autores + "/" + pieza.getAutores().get(i);
		}}
		
		
		 stringfinal = pieza.getTitulo() + "," + String.valueOf(pieza.getAnio()) + "," + pieza.getLugar_creacion() + "," + lista_autores + "," +
		        String.valueOf(pieza.getValor_fijo()) + "," + String.valueOf(pieza.isBloqueado()) + "," +
		        pieza.getPropietario().getusuario() + "," + pieza.getTipo_pieza() + "," + String.valueOf(pieza.getCodigo()) + "," +
		        pieza.getTiempo_ingreso() + "," + String.valueOf(pieza.isSubastado()) + "," +
		        String.valueOf(pieza.isAceptado()) + ",";
		
		return stringfinal;
		
		
	}


    public String infoconsignarpieza() {

        throw new UnsupportedOperationException("Unimplemented method 'infoconsignarpieza'");
    }

    public void setVendida(boolean b) {
      
        throw new UnsupportedOperationException("Unimplemented method 'setVendida'");
    }

	public static int getPrecio() {
		
		throw new UnsupportedOperationException("Unimplemented method 'getPrecio'");
	}

	
}