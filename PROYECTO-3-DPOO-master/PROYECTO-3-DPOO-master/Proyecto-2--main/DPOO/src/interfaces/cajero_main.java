package interfaces;

import java.util.Scanner;

import entities.Galeria;
import logic.Cashier;
import logic.Comprador;

public class cajero_main {
	
	public static void consola(String usuario, String contrasena) {
		
		   Scanner escaner = new Scanner(System.in);
		   
		   Cashier cajero = Galeria.buscarcajero(usuario);
		    String nombre = cajero.getnombre();
		    nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
			
			while (true) {
				
				System.out.println("Bienvenido, Cajero");
				System.out.println("Opciones posibles: ");
				System.out.println("1. Ver piezas.");
				System.out.println("2. Ver artistas.");
				System.out.println("3. Ver compradores.");
				System.out.println("4. Buscar pieza.");
				System.out.println("5. Buscar artista.");
				System.out.println("6. Buscar comprador.");
				System.out.println("7. Ver solicitudes.");
				System.out.println("8. Registrar nueva compra.");
				System.out.println("9. Salir.");
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
					
					System.out.println("¡Muchas gracias por su visita!");
					escaner.close();
					System.exit(0);
					break;
					
					
					
				}
			}
			
		
		
	}

}
