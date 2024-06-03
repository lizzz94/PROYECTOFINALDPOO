package entities;

import java.util.ArrayList;

import logic.Comprador;

public class Pintura extends Pieza{
	
	private Double alto;
	private Double ancho;
	private ArrayList<String> materiales;
	private Double peso;
	private String detalleinstalacion;
	
	
	
	public Pintura(String titulo, int anio, String creacion, ArrayList<String> autores, int valor_fijo, boolean bloqueado, Comprador propietario, String tipo_pieza, boolean subastado, boolean aceptado, Double alto, Double ancho, ArrayList<String> materiales, Double peso, String detalles) {
		
		super(titulo, anio, creacion, autores, valor_fijo, bloqueado, propietario, tipo_pieza, subastado, aceptado);
		this.alto = alto;
		this.ancho = ancho;
		this.materiales = materiales;
		this.peso = peso;
		this.detalleinstalacion = detalles;
	}
	
    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public ArrayList<String> getMateriales() {
        return materiales;
    }

    public void setMateriales(ArrayList<String> materiales) {
        this.materiales = materiales;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDetalleInstalacion() {
        return detalleinstalacion;
    }

    public void setDetalleInstalacion(String detalleinstalacion) {
        this.detalleinstalacion = detalleinstalacion;
    }
    
    
    public static String leerPieza(Pintura pieza) {
    	
    	
		String lista_materiales = (pieza.getMateriales()).get(0);;
		
		
		for (int i = 1; i < pieza.getMateriales().size(); i++) {
			lista_materiales = lista_materiales + "/" + pieza.getMateriales().get(i);
		}

    	
        String pieza_leida = Pieza.leerpieza(pieza);
        pieza_leida += pieza.getAlto() + "," + pieza.getAncho() + "," +
                lista_materiales + "," + pieza.getPeso() + "," +
                pieza.getDetalleInstalacion() + ";";
        return pieza_leida;
    }
	


}
