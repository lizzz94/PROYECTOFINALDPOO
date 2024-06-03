package interfaces;

import java.util.Scanner;
import logic.Usuario;
import logic.admin;
import entities.Galeria;
import entities.Pieza;
import logic.Comprador;
import entities.Pieza; 
import entities.Pieza; 

public class administrator_main {
	
	private static admin adminInstance;
	
	public static void consola(String usuario, String contrasena) {
		
		Scanner escaner = new Scanner(System.in);
	    adminInstance = new admin(usuario, contrasena, "ADMIN", "actualizacion", "NombreAdmin", "ApellidoAdmin"); 
		
		while (true) {
			
			System.out.println("Bienvenido, Administrador");
			System.out.println("Opciones posibles: ");
			
			System.out.println("1. Ver piezas.");
			System.out.println("2. Ver artistas.");
			System.out.println("3. Ver compradores.");
			System.out.println("4. Buscar pieza.");
			System.out.println("5. Buscar artista.");
			System.out.println("6. Buscar comprador.");
			System.out.println("7. Ver solicitudes de usuario.");
			System.out.println("8. Registrar piezas.");
			System.out.println("9. Confirmar ventas.");
			System.out.println("10. Crear subasta.");
			System.out.println("11 Acceder a subasta.");
			System.out.println("12. Verificar oferta.");
			System.out.println("13. Salir.");
			int opcion = escaner.nextInt();
			
			switch (opcion) {
			
			case 1:
				
				
				
				break;
				
			case 2:
				
				
				
				break;
			case 3:
				
				
			break;
			
			
			
			case 4:
				
				
				break;
				
			case 5:
				
				
				break;
			case 6:
				
				
				
				break;
			case 7:
				
				
				
				break;
				
				
				
			case 8:
				
				break;
				
				
				
				
			case 9:
				
				break;
				
				
				
				
			case 10:
				
				
				break;
				
			case 11:
				
				
				break;
				
			case 12:
				
				
				break;
				
				
			case 13:
				
				System.out.println("¡Muchas gracias por su visita!");
				escaner.close();
				System.exit(0);
				break;

			
			}
	}

}

private static void registrarPieza()
{
	Scanner scanner = new Scanner(System.in);
	try {
		System.out.println("Ingrese los detalles de la pieza");
		System.out.println("Título:");
		String titulo = scanner.nextLine();
		Pieza pieza = new Pieza(titulo);
		Galeria galeria = new Galeria();
		adminInstance.registrarPieza(galeria, pieza);
	} finally {
		scanner.close();
	}
}
private static void confirmarVenta()
{
	Scanner scanner = new Scanner(System.in);
	try {
		System.out.println("Ingrese los detalles de la venta: ");
		Pieza pieza = new Pieza("tituloPieza");
		Comprador comprador = new Comprador(null, null, 0, null, null, 0, 0, null, null, false);
		Galeria galeria = new Galeria();
		adminInstance.confirmarVenta(galeria, pieza, comprador);
	} finally {
		scanner.close();
	}
}
}

