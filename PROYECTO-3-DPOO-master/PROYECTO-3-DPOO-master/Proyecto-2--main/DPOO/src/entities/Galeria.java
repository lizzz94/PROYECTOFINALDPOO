package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import Persistencia.piezas_persistence;
import logic.Cashier;
import logic.Comprador;
import logic.Empleado;
import logic.Operador;
import logic.admin;

public class Galeria {
	
	
	private static Inventario inventario;
	private static ArrayList<Subasta> Subastas = new ArrayList<Subasta>();
	private static admin administrador;
	private static Hashtable<String, Cashier> cajeros = new Hashtable<>();
	private static Hashtable<String, Operador> operadores = new Hashtable<>();
	private static Hashtable<String, Comprador> compradores = new Hashtable<>();
	private static Hashtable<String, Comprador> propietarios = new Hashtable<>();
	public static List<Pieza> piezas = new ArrayList<Pieza>();

	public static Pieza convertirStringAPieza(String dato) {
		String[] campos = dato.split(",");
		String titulo = campos[0];
		int anio = Integer.parseInt(campos[1]);
		String lugar_creacion = campos[2];
		ArrayList<String> autores = new ArrayList<>(Arrays.asList(campos[3].split("/")));
		int valor_fijo = Integer.parseInt(campos[4]);
		boolean bloqueado = Boolean.parseBoolean(campos[5]);
		Comprador propietario = Galeria.buscarpropietario(campos[6]);
		String tipo_pieza = campos[7];
		int codigo = Integer.parseInt(campos[8]);
		String tiempo_ingreso = campos[9];
		boolean subastado = Boolean.parseBoolean(campos[10]);
		boolean aceptado = Boolean.parseBoolean(campos[11]);
	
		switch (tipo_pieza) {
			case "Escultura":
				Double altura = Double.valueOf(campos[12]);
				Double ancho = Double.valueOf(campos[13]);
				Double profundidad = Double.valueOf(campos[14]);
				ArrayList<String> materiales = new ArrayList<>(Arrays.asList(campos[15].split("/")));
				Double peso = Double.valueOf(campos[16]);
				boolean electricidad = Boolean.parseBoolean(campos[17]);
				String detalles = campos[18];
				return new Escultura(titulo, anio, lugar_creacion, autores, valor_fijo, bloqueado, propietario, tipo_pieza, subastado, aceptado, altura, ancho, profundidad, materiales, peso, electricidad, detalles);
			case "Fotografia":
				String formato = campos[12];
				String resolucion = campos[13];
				return new Fotografia(titulo, anio, lugar_creacion, autores, valor_fijo, bloqueado, propietario, tipo_pieza, subastado, aceptado, formato, resolucion);
			case "Pintura":
				Double alto = Double.valueOf(campos[12]);
				Double anchoPintura = Double.valueOf(campos[13]);
				ArrayList<String> materialesPintura = new ArrayList<>(Arrays.asList(campos[14].split("/")));
				Double pesoPintura = Double.valueOf(campos[15]);
				String detallesPintura = campos[16];
				return new Pintura(titulo, anio, lugar_creacion, autores, valor_fijo, bloqueado, propietario, tipo_pieza, subastado, aceptado, alto, anchoPintura, materialesPintura, pesoPintura, detallesPintura);
			default:
				throw new IllegalArgumentException("Tipo de pieza desconocido: " + tipo_pieza);
		}
	}

	public static ArrayList<Subasta> getSubastas() {
        return Subastas;
	}

	public static void cargarPiezas() {
        ArrayList<String> datos = piezas_persistence.read_info();
        for (String dato : datos) {
            // se convierte la cadena de datos en una instancia de Pieza
            Pieza pieza = convertirStringAPieza(dato);
           // piezas.put(pieza.getTitulo(), pieza);
        }
	}

	public static Inventario getInventario() {
        return inventario;
    }
	
	public static ArrayList<Subasta> subastas(){
		return Subastas;
	}


	public static List<Pieza> getPiezas() {
		return piezas;
	}

	public static List<String> getArtistas() {
		List<String> artistas = new ArrayList<>();
		for (Pieza pieza : piezas) {
			String autor = pieza.getAutores();
			if (!artistas.contains(autor)) {
				artistas.add(autor);
			}
		}
		return artistas;
	    }

	public static void addPieza(Pieza pieza) {
		piezas.add(pieza);
	}

	public static Hashtable<String,Comprador> getCompradores() {
		return compradores;
	}

	public static Pieza buscarPieza(String nombre) {
		for (Pieza pieza : piezas) {
			if (pieza.getTitulo().equals(nombre)) {
				return pieza;
			}
		}
		return null;
	}

	public static String buscarArtista(String nombre) {
		for (Pieza pieza : piezas) {
			if (pieza.getAutores().equals(nombre)) {
				return pieza.getAutores();
			}
		}
		return null;
	}

	public static Comprador buscarComprador(String nombre) {
				for (Comprador comprador : compradores.values()) {
					if (comprador.getnombre().equals(nombre)) {
						return comprador;
					}
				}
				return null;
			}
	
	public static void crearSubastas(Pieza pieza, double precio_inicial)
	{
		Subasta subasta = new Subasta(pieza, precio_inicial);
		Subastas.add(subasta);
	
	}

	public static Subasta accederSubasta(int codigo)
	{
		for (Subasta subasta : Subastas) {
			if (subasta.getCodigo() == codigo) {
				return subasta;
			}
		}
		return null;
	}

	public static boolean verificarOferta(int idSubasta, double oferta)
	{
		Subasta subasta = accederSubasta(idSubasta);
		if (subasta != null) {
			return subasta.verificarOferta(oferta);
		}
		return false;
	}
	public static void setcajero(String usuario, Cashier cajero) {
				
			   cajeros.put(usuario, cajero);
					
				}
				
	public static void setoperador(String usuario,Operador operador) {
			
			operadores.put(usuario, operador);
		}

    public static void setcomprador(String usuario,Comprador comprador) {
	
    	
    	compradores.put(usuario, comprador);
       }

    public static void setpropietario(String usuario,Comprador propietario) {
	
    	propietarios.put(usuario, propietario);
	
       }

    public static void setadmin(admin admin) {
    	
    	administrador = admin;
      }	
    
    public static Comprador buscarcomprador(String usuario) {
    	
    	return compradores.get(usuario);
    	
    }
    
    public static Cashier buscarcajero(String usuario) {
    	
    	return cajeros.get(usuario);
    	
    }
    
    public static Operador buscaroperador(String usuario) {
    	
    	return operadores.get(usuario);
    	
    }
    
    public static Comprador buscarpropietario(String usuario) {
    	
    	return propietarios.get(usuario);
    	
    }

	public void removePieza(Pieza pieza) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removePieza'");
	}
	
	}
