package entities;

import java.util.ArrayList;

import logic.Comprador;

public class Video extends Pieza{
	
	public int duracion;
	public String formato;
	public String genero;
	
	
	public Video(String titulo, int anio, String creacion, ArrayList<String> autores, int valor_fijo, boolean bloqueado, Comprador propietario, String tipo_pieza, boolean subastado, boolean aceptado, int duracion, String formato, String genero) {
		
		super(titulo, anio, creacion, autores, valor_fijo, bloqueado, propietario, tipo_pieza, subastado, aceptado);
		this.duracion = duracion;
		this.formato = formato;
		this.genero = genero;
	}

    // Getters y Setters
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    // métodos aplicados xd
    
    public static String leerpieza(Video pieza) {
        String pieza_leida = Pieza.leerpieza(pieza);
        pieza_leida += pieza.getDuracion() + "," + pieza.getFormato() + "," +
                pieza.getGenero() + ";";
        return pieza_leida;
    }
	
	
	

}
