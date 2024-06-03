package entities;

import java.util.ArrayList;

import logic.Comprador;

public class Fotografia extends Pieza{

	private String formato;
	private String resolucion;
	
	
	public Fotografia(String titulo, int anio, String creacion, ArrayList<String> autores, int valor_fijo, boolean bloqueado, Comprador propietario, String tipo_pieza, boolean subastado, boolean aceptado, String formato, String resolucion) {
		super(titulo, anio, creacion, autores, valor_fijo, bloqueado, propietario, tipo_pieza, subastado, aceptado);
		this.formato = formato;
		this.resolucion = resolucion;
	}
	
	
	public String getformato() {
		return formato;
	}
	
	public String getresolucion() {
		
		return resolucion;
	}
	
	public static String leerpieza(Fotografia pieza) {
		
		String pieza_leida = Pieza.leerpieza(pieza);
		
		pieza_leida = pieza_leida+ pieza.getformato()+","+pieza.getresolucion()+";";
		
		return pieza_leida;
		
	}
	
}
