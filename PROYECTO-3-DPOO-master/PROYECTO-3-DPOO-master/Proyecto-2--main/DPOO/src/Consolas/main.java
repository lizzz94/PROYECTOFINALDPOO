package Consolas;
import java.util.Scanner;
import Persistencia.users_persistence;
import interfaces.administrator_main;
import interfaces.buyer_main;
import interfaces.cajero_main;
import interfaces.operador_main;
import interfaces.propietario_main;
import login.login;

import logic.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class main {

	public static void main(String[] args) {
		
		Scanner escaner = new Scanner(System.in);
		
		while (true) {
			
			login.loaddata();
	
			System.out.println("Opciones: ");
			System.out.println("1. Ingresar al programa");
			System.out.println("2. Crear Solicitud de Usuario");
			System.out.println("3. Salir");
			
			int opcion = escaner.nextInt();
			
			switch (opcion) {
			case 1: 
				
				System.out.println("Ingrese nombre de usuario: ");
				String usuario = escaner.next();
				System.out.println("Ingrese la constraseña: ");
				String contrasena = escaner.next();		
				String roll = login.verifyUser(usuario, contrasena);
				
				if (roll.equals("nulo")){
					
					System.out.print("El usuario ingresado no existe");
					System.out.println(" ");
					
				}else {
					
					next_consola(roll, usuario, contrasena);
				}

				break;
			    
			case 2: 
				System.out.println("Ingrese nombre de usuario: ");
				String nuevo_usuario = escaner.next();
				System.out.println("Ingrese la constraseña: ");
				String nueva_contrasena = escaner.next();
				System.out.println("Ingrese el tipo de usuario: ");
				System.out.println("1. Administrador.");
				System.out.println("2. Comprador.");
				System.out.println("3. Propietario.");
				System.out.println("4. Cajero.");
				System.out.println("5. Operador.");
				int tipo_usuario = escaner.nextInt();
				
				String UltimaActualizacion = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
		                    .format(LocalDateTime.now());
				
				String rol;
				String name;
				String last_name;
				String cedula;
				
				if (tipo_usuario == 1){
					 rol = "ADMIN";
					 
					    System.out.println("Ingrese su nombre: ");
					    name = escaner.next();
					    System.out.println("Ingrese su apellido: ");
					    last_name = escaner.next();
					    System.out.println("Ingrese su cédula: ");
					    cedula = escaner.next();
					    login.createuser(name, last_name, cedula, nuevo_usuario, nueva_contrasena, "0", 0, rol, UltimaActualizacion);
					 
					
				}else if (tipo_usuario == 2) {
					 rol = "BUYER";
			
 
			    System.out.println("Ingrese su nombre: ");
			    name = escaner.next();
			    System.out.println("Ingrese su apellido: ");
			    last_name = escaner.next();
			    System.out.println("Ingrese su cédula: ");
			    cedula = escaner.next();
			    System.out.println("Ingrese su número de contacto: ");
			    int numero = Integer.parseInt(escaner.next());
			    System.out.println("¿Cuáles son sus ingresos promedio?:  ");
			    String ingresos = escaner.next();
			    login.createuser(name, last_name, cedula, nuevo_usuario, nueva_contrasena, ingresos, numero, rol, UltimaActualizacion);
					
				}else if (tipo_usuario == 3) {
					 rol = "OWNER";

					    System.out.println("Ingrese su nombre: ");
					    name = escaner.next();
					    System.out.println("Ingrese su apellido: ");
					    last_name = escaner.next();
					    System.out.println("Ingrese su cédula: ");
					    cedula = escaner.next();
					    System.out.println("Ingrese su número de contacto: ");
					    int numero = Integer.parseInt(escaner.next());
					    System.out.println("¿Cuáles son sus ingresos promedio?:  ");
					    String ingresos = escaner.next();
					    
					    login.createuser(name, last_name, cedula, nuevo_usuario, nueva_contrasena, ingresos, numero, rol, UltimaActualizacion);
					    
				}else if (tipo_usuario == 4) {
					 rol = "CASHIER";
	
					    System.out.println("Ingrese su nombre: ");
					    name = escaner.next();
					    System.out.println("Ingrese su apellido: ");
					    last_name = escaner.next();
					    System.out.println("Ingrese su cédula: ");
					    cedula = escaner.next();
					    
					    login.createuser(name, last_name, cedula, nuevo_usuario, nueva_contrasena, "0", 0, rol, UltimaActualizacion);
						
				}else if (tipo_usuario == 5) {
					 rol = "OPERATOR";	
					    

					    System.out.println("Ingrese su nombre: ");
					    name = escaner.next();
					    System.out.println("Ingrese su apellido: ");
					    last_name = escaner.next();
					    System.out.println("Ingrese su cédula: ");
					    cedula = escaner.next();
					    
					    login.createuser(name, last_name, cedula, nuevo_usuario, nueva_contrasena, "0", 0, rol, UltimaActualizacion);
				}else {
					
					System.out.println("Ingreso inválido.");
				}
				
				break;
				
			case 3:
				System.out.println("¡Muchas gracias por su visita!");
				escaner.close();
				System.exit(0);
				break;
				
			default:
					System.out.println("Opción inválida.");
					break;

		}
	}
}
	
	
	public static void next_consola(String rol, String usuario, String contrasena) {
		

		if (rol.equals("ADMIN")) {
			
			administrator_main.consola(usuario, contrasena);
			
		}else if (rol.equals("BUYER")) {
			
			buyer_main.consola(usuario, contrasena);
			
		}else if (rol.equals("OWNER")) {
			
			propietario_main.consola(usuario, contrasena);
			
		}else if (rol.equals("CASHIER")) {
			
			cajero_main.consola(usuario, contrasena);
			
		}else if (rol.equals("OPERATOR")){
			
			operador_main.consola(usuario, contrasena);
			
		}

	}
}
