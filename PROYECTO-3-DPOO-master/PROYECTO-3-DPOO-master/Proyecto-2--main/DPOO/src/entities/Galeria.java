package entities;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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
