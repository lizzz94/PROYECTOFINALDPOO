package Persistencia;
import java.io.*;
import java.util.ArrayList;

import entities.Galeria;
import logic.Cashier;
import logic.Comprador;
import logic.Operador;
import logic.admin;

public class users_persistence {
	
	
	public static ArrayList<String> read_info () {
		
		ArrayList<String> datos = new ArrayList<>();
		
		File archivo = null; 
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
 
        try {

            archivo = new File("users.csv");

            fr = new FileReader(archivo);
  
            br = new BufferedReader(fr);
 
            while ((linea = br.readLine()) != null) {
            	
            	   
                	
                	String[] strings = linea.split(";");
                	    
                	
                	for (int i = 0; i < strings.length; i++) {
                		datos.add(strings[i]);
                		
                		String [] lines = strings[i].split(",");  
              
                		for (int j = 0; j < lines.length; j++) {
                			
                	
                	
            			String nombre = lines[0];
            		    String apellido = lines[1];
            		    int cedula = Integer.parseInt(lines[2]);
            		    String usuario = lines[3];
            		    String contrasena = lines[4];
            		    int contacto = Integer.parseInt(lines[5]);
            		    int ingresos = Integer.parseInt(lines[6]);
            		    String rol = lines[7];
            		    String actualizacion = lines[8]+lines[9];
            		    
            		    if (rol.equals("ADMIN")){
            		    	
            		    	admin user1 = new admin(usuario, contrasena, rol, actualizacion, nombre, apellido);
            		    	Galeria.setadmin(user1);
            		    }
            		    	
            		    else if (rol.equals("BUYER")){
            		    	
            		    	
            		    Comprador user2 = new Comprador(nombre, apellido, cedula, usuario, contrasena, contacto, ingresos, rol, actualizacion, false);
            		    	Galeria.setcomprador(usuario, user2);
            		    
            		    }
            		    
            		    else if (rol.equals("OWNER")){
            		    	
            		    
            		    Comprador user3 = new Comprador(nombre, apellido, cedula, usuario, contrasena, contacto, ingresos, rol, actualizacion, true);
            		    	Galeria.setpropietario(usuario, user3);
            		    	
            		    }
            		    
            		    else if (rol.equals("CASHIER")){
            		    	
            		    	
            		    Cashier user4 = new Cashier(usuario, contrasena, rol, actualizacion, nombre, apellido, cedula);
            		    	Galeria.setcajero(usuario, user4);
            		    }
            		    
            		    else if (rol.equals("OPERATOR")){
            		    	
            		    	
            		    Operador user5 = new Operador(usuario, contrasena, rol, actualizacion, nombre, apellido, cedula);
            		    	Galeria.setoperador(usuario, user5);
            		    }
            		    
            		    
            		    }
            		    
					}
           
				}
 
            return datos;

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		return null; 
	}
	
	
	public static String formatter(String nombre, String apellido, String cedula, String usuario, String contrasena, String contacto, int ingresos, String rol, String UltimaActualizacion) {

	    String ingresosStr = Integer.toString(ingresos);

	    String line = nombre + "," + apellido + "," + cedula + "," + usuario + "," + contrasena + "," + contacto + "," + ingresosStr + "," + rol + "," + UltimaActualizacion + ";";

	    return line;
	}
	
    public static void add_info(String data) {
    	
    	
    	BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            File file = new File("users.csv");
            
            if (!file.exists()) {
                file.createNewFile();
            }
           
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("¡Usuario agregado correctamente!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                   
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    	

	}
}


