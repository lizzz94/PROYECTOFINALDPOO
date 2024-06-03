package interfaces;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import Persistencia.subastas_persistence;
import Persistencia.piezas_persistence;
import entities.Galeria;
import logic.Comprador;
import entities.Pieza;
import logic.Operador;

public class propietario_main {

    public static void consola(String usuario, String contrasena) {

        Scanner escaner = new Scanner(System.in);

        Comprador propietario = Galeria.buscarcomprador(usuario);
        if (propietario == null || !propietario.getcontrasena().equals(contrasena)) {
            System.out.println("Usuario o contraseña incorrectos.");
            escaner.close();
            return;
        }

        String nombre = propietario.getnombre();
        nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);

        while (true) {

            System.out.println("Bienvenido, Propietario " + nombre);
            System.out.println("Opciones posibles: ");
            System.out.println("1. Ver piezas.");
            System.out.println("2. Ver compradores.");
            System.out.println("3. Buscar pieza y autor.");
            System.out.println("4. Buscar comprador.");
            System.out.println("5. Consignar pieza.");
            System.out.println("7. Ver subastas.");
            System.out.println("8. Ver historial de piezas.");
            System.out.println("9. Salir.");
            int opcion = escaner.nextInt();
            escaner.nextLine(); // Consumir la nueva línea

            switch (opcion) {

                case 1:
                // Ver piezas
                ArrayList<Pieza> piezas = Galeria.getInventario().getPiezasExhibidas();
                for (Pieza pieza : piezas) {
                    System.out.println(pieza.getTitulo() + " - " + pieza.getAnio());
                }
                break;

                case 2:
                // Ver compradores
                Hashtable<String, Comprador> compradores = Galeria.getCompradores();
                for (Comprador comprador : compradores.values()) {
                    System.out.println(comprador.getnombre() + " " + comprador.getapellido());
                }
                break;

                
                case 3:
                        // Buscar pieza y autor
                        System.out.println("Ingrese el título de la pieza que desea buscar:");
                        String titulo = escaner.next();
                        Pieza piezaBuscada = Galeria.buscarPieza(titulo);
                        if (piezaBuscada != null) {
                            System.out.println("Pieza encontrada: " + piezaBuscada.getTitulo());
                            ///ArrayList<String> autores = piezaBuscada.getAutores();
                            //for (String autor : autores) {
                                //System.out.println("Artista: " + autor);
                                System.out.println("Artista: ");
                            }
                         else {
                            System.out.println("No se encontró ninguna pieza con ese título.");
                        }
                        break;

                case 4:
                    // Buscar comprador por nombre
                    System.out.println("Ingrese el nombre del comprador:");
                    String nombreComprador = escaner.nextLine();
                    Comprador compradorBuscado = Galeria.buscarcomprador(nombreComprador);
                    if (compradorBuscado != null) {
                        System.out.println(compradorBuscado);
                    } else {
                        System.out.println("Comprador no encontrado.");
                    }
                    break;

                    case 5:
                    // Consignar pieza
                    System.out.println("Seleccione uno de los tipos de pieza a continuación:");
                    System.out.println("1. Escultura");
                    System.out.println("2. Pintura");
                    System.out.println("3. Fotografía");
                    System.out.println("4. Vídeo");
                    int tipo_pieza = escaner.nextInt();
                    escaner.nextLine(); // Consumir la nueva línea
                    String tipoPiezaStr = "";
                    switch (tipo_pieza) {
                        case 1:
                            tipoPiezaStr = "Escultura";
                            break;
                        case 2:
                            tipoPiezaStr = "Pintura";
                            break;
                        case 3:
                            tipoPiezaStr = "Fotografía";
                            break;
                        case 4:
                            tipoPiezaStr = "Vídeo";
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            continue;
                    }
                    propietario.infoconsignarpieza(tipoPiezaStr, propietario);
                    break;

                    case 6:
                    // Ver subastas
                    ArrayList<String> subastas = subastas_persistence.read_info();
                    for (String subasta : subastas) {
                        System.out.println(subasta);
                    }
                    break;
                

                    case 7:
                    // Ver historial de piezas
                    ArrayList<String> historialPiezas = piezas_persistence.read_info();
                    for (String pieza : historialPiezas) {
                        System.out.println(pieza);
                    }
                    break;
                

                case 8:
                    // Salir
                    System.out.println("¡Muchas gracias por su visita!");
                    escaner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
