package interfaces;

import java.util.Scanner;

import entities.Galeria;
import logic.Comprador;

public class buyer_main {
	
	public static void consola(String usuario, String contrasena) {
		
    Scanner escaner = new Scanner(System.in);
    
    Comprador comprador = Galeria.buscarcomprador(usuario);
    String nombre = comprador.getnombre();
    nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
		
		while (true) {
			
			System.out.println("Bienvenido, "+nombre);
			System.out.println("Opciones posibles: ");
			System.out.println("1. Ver piezas.");
			System.out.println("2. Ver artistas.");
			System.out.println("3. Ver compradores.");
			System.out.println("4. Buscar pieza.");
			System.out.println("5. Buscar artista.");
			System.out.println("6. Buscar comprador.");
			System.out.println("7. Consignar pieza.");
			System.out.println("8. Ver y solicitar monto.");
			System.out.println("9. Ver subastas [extendido].");
			System.out.println("10. Salir.");
			
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
				
				//en esta sección, se hace la consignación de piezas
				
				System.out.println("Seleccione uno te los tipos de pieza a continuación:");
				System.out.println("1. Escultura");
				System.out.println("2. Pintura");
				System.out.println("3. Fotografía");
				System.out.println("4. Vídeo");
				
				int tipo_pieza = escaner.nextInt();
				String pieza = "";
				if (tipo_pieza == 1) {
					pieza = "Escultura";
					
				}else if (tipo_pieza ==2) {
					pieza = "Pintura";
					
				}else if (tipo_pieza ==3) {
					pieza = "Fotografía";
					
				}else if (tipo_pieza ==4) {
					pieza = "Vídeo";	
				}
				comprador.infoconsignarpieza(pieza, comprador);
				
			
				
				
				
				break;
				
				
			
			case 8:
				
				break;
				
				
				
				
			case 9:
				
				break;
				
				
			
			case 10:
				
				System.out.println("¡Muchas gracias por su visita!");
				escaner.close();
				System.exit(0);
				break;
				
				
				
			}
		}
		
	
		
	}

}
