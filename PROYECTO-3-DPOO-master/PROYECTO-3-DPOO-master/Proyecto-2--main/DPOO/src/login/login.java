
package login;

import logic.Usuario;

import java.util.ArrayList;

import Persistencia.users_persistence;



public class login {
	
public static void loaddata() {
	
	users_persistence.read_info();
	
}
	

public static void createuser(String nombre, String apellido, String cedula, String usuario, String contrasena, String contacto, int ingresos, String rol, String UltimaActualizacion) {
	
	String format = users_persistence.formatter(nombre, apellido, cedula, usuario, contrasena, contacto, ingresos, rol, UltimaActualizacion);
	users_persistence.add_info(format);
}


public static String verifyUser (String usuario, String contrasena){

    // This function verifies the existence of the user in the persistence

    // If the user exists, it returns true
    // If the user does not exist, it returns false
	
	
	  ArrayList<String> read = new ArrayList<>(); read = users_persistence.read_info();
	
	  String bool = "nulo";
	for (int i = 0; i< read.size();i++) {
		
		
		String list = read.get(i);
        String[] strings = list.split(",");

        
        if (strings[3].equals(usuario) && strings[4].equals(contrasena)){
        	
        	bool = strings[7];
        }
        }
	return bool;
	
        } 

}
    

