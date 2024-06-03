package logic;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Persistencia.piezas_persistence;
import entities.Escultura;
import entities.Fotografia;
import entities.Galeria;
import entities.Pieza;
import entities.Pintura;
import entities.Video;

public class Comprador extends Usuario {
	
	private String nombre;
	private String apellido;
	private  int cedula;
	private  int contacto;
	private  int ingresos;
	private boolean propietario;
	private ArrayList<Pieza> piezas;
	
	
	public Comprador (String nombre, String apellido, int cedula, String usuario, String contrasena, int contacto, int ingresos, String rol, String UltimaActualizacion, boolean propietario) {
		
		super(usuario, contrasena, rol, UltimaActualizacion);
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.contacto = contacto;
		this.ingresos = ingresos;
		this.propietario = propietario;

	}
	
	public String getnombre() {
		return nombre;
	}
	
	public String getapellido() {
		return apellido;
	}
	
	
	public boolean ispropietario (Comprador comprador) {
		
		return this.propietario;
	}
	
	public ArrayList<Pieza> getpiezas(Comprador comprador){

		        this.propietario = true;
				return this.piezas;
	}
	
	public void addpieza(Comprador comprador, Pieza pieza){
		
		ArrayList<Pieza> piezas = getpiezas(comprador);
		piezas.add(pieza);
		this.piezas = piezas;
		
		}
	
	public void consignarpieza(Pieza pieza) {
		
		String tipo_pieza = pieza.getTipo_pieza();
		String info_pieza = "";
		
		if (tipo_pieza.equals("Escultura")){
			
			info_pieza = Escultura.leerpieza(pieza);
			
		}if (tipo_pieza.equals("Fotografía")){
			
			info_pieza = Fotografia.leerpieza(pieza);
			
		}if (tipo_pieza.equals("Pintura")){
			
		    info_pieza = Pintura.leerpieza(pieza);
			
		}if (tipo_pieza.equals("Vídeo")){
			
			info_pieza = Video.leerpieza(pieza);
			
		}
		
		piezas_persistence.add_info(info_pieza);
		
	}
	
	public void infoconsignarpieza(String tipo_pieza, Comprador dueño) {
		
	    Comprador propietario = dueño;
		Scanner escaner = new Scanner(System.in);
		ArrayList<String> lista_autores = new ArrayList();
		int valor_fijo = 0;
		boolean bloqueado = false;
		boolean subastado = false;
		
		
		System.out.println("Por favor, ingrese el título: ");
		String titulo = escaner.next();	
		System.out.println("Por favor, ingrese el lugar de creación: ");
		String lugar_creacion = escaner.next();	
		System.out.println("Por favor, ingrese el año de creación: ");
		int anio_creacion = escaner.nextInt();	
		System.out.println("¿La pieza posee más de un autor?: ");
		System.out.println("1. Sí");
		System.out.println("2. No");
		int cantidad_autores = escaner.nextInt();	
		
		String autor = "";
		if (cantidad_autores == 2) {
			System.out.println("Ingrese el nombre del autor: ");
		    autor = escaner.next();	
			
		}if (cantidad_autores == 1) {
			System.out.println("Ingrese la cantidad de autores");
			int cantidad = escaner.nextInt();
			System.out.println("Ingrese el primer autor: ");
			lista_autores.add(autor);
			
			for (int i = 1; i < cantidad; i++) {
				System.out.println("Ingrese el siguiente autor: ");
				String autor_provisional = escaner.next();
				lista_autores.add(autor_provisional);
			}
		}
		System.out.println("¿Acepta la posiblidad de venta de la pieza?:");
		System.out.println("1. Sí");
		System.out.println("2. No");
		int vender = escaner.nextInt();
		
		if (vender == 1) {
			
			System.out.println("¿Desea vender la pieza por valor fijo o por subasta?: ");
			System.out.println("1. Valor fijo.");
			System.out.println("2. Subasta.");
	        int venta_pieza = escaner.nextInt();	
			
			if (venta_pieza == 1) {
				
				System.out.println("Ingrese el valor de la pieza(sin puntos ni comas): ");
				valor_fijo = 0;
				
			}if (venta_pieza == 2) {
				
				subastado = true;
				
			}
			
			
		}if (vender == 2) {
			
			bloqueado = true;
			
		}
		
		
		if (tipo_pieza.equals("Escultura")){
			
			System.out.println("Ingrese la altura:");
	        Double altura = escaner.nextDouble();

	        System.out.println("Ingrese el ancho:");
	        Double ancho = escaner.nextDouble();

	        System.out.println("Ingrese la profundidad:");
	        Double profundidad = escaner.nextDouble();

	        ArrayList<String> materiales = new ArrayList<>();
	        System.out.println("Ingrese los materiales (ingrese 'fin' para terminar):");
	        String material = escaner.next();
	        while (!material.equals("fin")) {
	            materiales.add(material);
	            material = escaner.next();
	        }

	        System.out.println("Ingrese el peso:");
	        Double peso = escaner.nextDouble();

	        System.out.println("¿Tiene electricidad? (true/false):");
	        boolean electricidad = escaner.nextBoolean();

	        System.out.println("Ingrese los detalles:");
	        String detalles = escaner.next();
	        
	       
	        Escultura pieza = new Escultura(titulo, anio_creacion, lugar_creacion, lista_autores, valor_fijo, bloqueado, propietario,
	        		tipo_pieza, subastado, false, altura, ancho,profundidad, materiales, peso, electricidad, detalles);
	        consignarpieza(pieza);

		}else if (tipo_pieza.equals("Pintura")) {
			
			System.out.println("Ingrese el alto:");
	        Double alto = escaner.nextDouble();

	        System.out.println("Ingrese el ancho:");
	        Double ancho = escaner.nextDouble();

	        ArrayList<String> materiales = new ArrayList<>();
	        System.out.println("Ingrese los materiales (ingrese 'fin' para terminar):");
	        String material = escaner.next();
	        while (!material.equals("fin")) {
	            materiales.add(material);
	            material = escaner.next();
	        }

	        System.out.println("Ingrese el peso:");
	        Double peso = escaner.nextDouble();

	        System.out.println("Ingrese los detalles de instalación:");
	        escaner.nextLine();
	        String detalleinstalacion = escaner.nextLine();
	        
	        Pintura pieza = new Pintura(titulo, anio_creacion, lugar_creacion, lista_autores, valor_fijo, bloqueado, propietario,
	        		tipo_pieza, subastado, false, alto, ancho, materiales, peso, detalleinstalacion);
		
	        consignarpieza(pieza);
	        
	        
	        
	        
			
		}else if (tipo_pieza.equals("Fotografía")) {
			
			System.out.println("Ingrese el formato: ");
	        String formato = escaner.next();
	        
	        System.out.println("Ingrese la resolución: ");
	        String resolucion = escaner.next();
			
	        Fotografia pieza = new Fotografia(titulo, anio_creacion, lugar_creacion, lista_autores, valor_fijo, bloqueado, propietario,
	        		tipo_pieza, subastado, false, formato, resolucion);
			
	        consignarpieza(pieza);
			

		}else if (tipo_pieza.equals("Vídeo")) {
			
			System.out.println("Ingrese la duración (en minutos): ");
	        int minutos = escaner.nextInt();
	        
	        System.out.println("Ingrese el formato: ");
	        String formato = escaner.next();
			
	        System.out.println("Ingrese el género: ");
	        String genero = escaner.next();
	        
	        Video pieza = new Video(titulo, anio_creacion, lugar_creacion, lista_autores, valor_fijo, bloqueado, propietario,
	        		tipo_pieza, subastado, false, minutos, formato, genero);
	        
	        consignarpieza(pieza);
			
		}

	}

public boolean verificar()
{
	return ingresos >= Pieza.getPrecio();
}

public void confirmarVenta(Galeria galeria, Pieza pieza, Comprador comprador)
{
	if(comprador.verificar())
	{
		pieza.setVendida(true);
		galeria.removePieza(pieza);
		comprador.removePieza(pieza);
		galeria.removePieza(pieza);
		System.out.println("La venta se ha realizado con éxito");
	}	
	else{
		System.out.println("No se ha podido realizar la venta");
	}
	}

private void removePieza(Pieza pieza) {
	if (piezas.contains(pieza)) {
		piezas.remove(pieza);
	}
}

}
