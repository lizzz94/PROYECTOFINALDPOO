package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import entities.Escultura;
import entities.Fotografia;
import entities.Galeria;
import entities.Pintura;
import entities.Video;
import logic.Cashier;
import logic.Comprador;
import logic.Operador;
import logic.admin;

public class piezas_persistence {
	
	
	public static ArrayList<String> read_info () {
		
		ArrayList<String> datos = new ArrayList<>();
		
		File archivo = null; 
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
 
        try {

            archivo = new File("piezas.csv");

            fr = new FileReader(archivo);
  
            br = new BufferedReader(fr);
 
            while ((linea = br.readLine()) != null) {
            	
                	
                	String[] strings = linea.split(";");
                	    
                	
                	for (int i = 0; i < strings.length; i++) {
                		datos.add(strings[i]);
                		
                		String [] lines = strings[i].split(",");  
              
                		for (int j = 0; j < lines.length; j++) {
                			
                	
                		ArrayList<String> lista_autores = new ArrayList();
                	    String titulo = lines[0];
                	    int anio = Integer.parseInt(lines[1]);
                	    String lugar_creacion = lines[2];
       
                	  
                	    String [] autores = lines[3].split("/"); 
                	    
                	    for (int k = 0; k < autores.length; k++) {
                	    	lista_autores.add(autores[k]);
                	    	
						}    
   
                	    int valor_fijo = Integer.parseInt(lines[4]);
                	    boolean bloqueado = Boolean.parseBoolean(lines[5]);
                	    
                	    Comprador propietario = Galeria.buscarpropietario(lines[6]);

                	    String tipo_pieza = lines[7];
            		    int codigo = Integer.parseInt(lines[8]);
            		    String tiempo_ingreso = lines[9];
            		    boolean subastado = Boolean.parseBoolean(lines[10]);
            		    boolean aceptado = Boolean.parseBoolean(lines[11]);
            		    
            			if (tipo_pieza.equals("Escultura")){
            				
            				Double altura = Double.valueOf(lines[12]);
            				Double ancho = Double.valueOf(lines[13]);
            				Double profundidad = Double.valueOf(lines[14]);
            
            				
            				ArrayList<String> lista_materiales = new ArrayList();
            				
            				String [] materiales = lines[3].split("/"); 
                    	    
                    	    for (int k = 0; k < materiales.length; k++) {
                    	    	lista_materiales.add(materiales[k]);
                    	    	
    						}  
            				
            				
            				
            				Double peso = Double.valueOf(lines[16]);
            				boolean electricidad = Boolean.parseBoolean(lines[17]);
            				String detalles = lines[18];
            				
            				
            				
            				
            			}if (tipo_pieza.equals("Fotografía")){
            				
            				String formato = lines[12];
            				String resolucion = lines[13];
            				
            				
            				
            			}if (tipo_pieza.equals("Pintura")){
            				
            				Double altura = Double.valueOf(lines[12]);
            				Double ancho = Double.valueOf(lines[13]);
                            ArrayList<String> lista_materiales = new ArrayList();
            				
            				String [] materiales = lines[3].split("/"); 
                    	    
                    	    for (int k = 0; k < materiales.length; k++) {
                    	    	lista_materiales.add(materiales[k]);
                    	    	
    						}
            				
            				
            				Double peso = Double.valueOf(lines[15]);
            		        String detalles_instalacion = lines[16];
            				
            				
            				
            			}if (tipo_pieza.equals("Vídeo")){
            				
            				int duracion = Integer.parseInt(lines[12]);
            				String formato = lines[13];
            		        String genero = lines[14];
           	    
            		        
            		        
            		        
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
	
	
	
    public static void add_info(String data) {
    	
    	
    	BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            File file = new File("piezas.csv");
            
            if (!file.exists()) {
                file.createNewFile();
            }
           
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("¡Pieza agregada correctamente!");
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
