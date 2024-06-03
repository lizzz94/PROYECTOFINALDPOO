package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import entities.Galeria;
import logic.Cashier;
import logic.Comprador;
import logic.Operador;
import logic.admin;

public class subastas_persistence {
	
	
	public static ArrayList<String> read_info () {
		
		ArrayList<String> datos = new ArrayList<>();
		
		File archivo = null; 
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
 
        try {

            archivo = new File("subastas.csv");

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
	
	
	
    public static void add_info(String data) {
    	
    	
    	BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            File file = new File("subastas.csv");
            
            if (!file.exists()) {
                file.createNewFile();
            }
           
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("Subasta agregada correctamente!");
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
