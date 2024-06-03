package entities;

import java.util.ArrayList;

import logic.Comprador;

public class Escultura extends Pieza{
	
	private Double altura;
	private Double ancho;
	private Double profundidad;
	private ArrayList<String> materiales;
	private Double peso;
	private boolean electricidad;
	private String detalles;
	

	
	public Escultura(String titulo,
			int anio,
			String creacion,
			ArrayList<String> autores,
			int valor_fijo, boolean bloqueado,
			Comprador propietario,
			String tipo_pieza,
			boolean subastado,
			boolean aceptado, 
			Double altura,
			Double ancho,
			Double profundidad,
			ArrayList<String> materiales,
			Double peso,
			boolean electricidad,
			String detalles) {
		
		super(titulo, anio, creacion, autores, valor_fijo, bloqueado, propietario, tipo_pieza, subastado, aceptado);
		this.altura = altura;
		this.ancho = ancho;
		this.profundidad = profundidad;
		this.materiales = materiales;
		this.peso = peso;
		this.electricidad = electricidad;
		this.detalles = detalles;
	}
	
    public Escultura(int i, int j, int k, String string) {
       
    }

    public Double getAltura() {
        return altura;
    }

    public Double getAncho() {
        return ancho;
    }

    public Double getProfundidad() {
        return profundidad;
    }

    public ArrayList<String> getMateriales() {
        return materiales;
    }

    public Double getPeso() {
        return peso;
    }

    public boolean isElectricidad() {
        return electricidad;
    }

    public String getDetalles() {
        return detalles;
    }
	
	
	public static String leerpieza(Escultura pieza) {
		

		   String lectura_pieza = new String();
		   
		   lectura_pieza = Pieza.leerpieza(pieza);
		   
			String lista_materiales = (pieza.getMateriales()).get(0);;
			
			
			for (int i = 1; i < (pieza.getMateriales()).size(); i++) {
				lista_materiales = lista_materiales + "/" + (pieza.getMateriales()).get(i);
			}
			
		   
		   lectura_pieza = lectura_pieza + String.valueOf(pieza.getAltura())+","+String.valueOf(pieza.getAncho())+","+
				   String.valueOf(pieza.getProfundidad())+","+lista_materiales+","+String.valueOf(pieza.getPeso())+","+
				   String.valueOf(pieza.isElectricidad())+","+pieza.getDetalles()+";";
		   
		   
		return lectura_pieza;		
		
	}

}
