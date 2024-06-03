package Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import logic.admin;

public class adminTest {

    private admin administrador;

    @Before
    public void setUp() {
        // Inicializar el objeto admin antes de cada prueba
        administrador = new admin("usuarioAdmin", "contraseña123", "Administrador", "2024-05-27", "Ana", "Gomez");
    }

    @Test
    public void testGetNombre() {
        // Verificar que el método getnombre() retorna el valor correcto
        assertEquals("Ana", administrador.getnombre());
    }

    @Test
    public void testGetApellido() {
        // Verificar que el método getapellido() retorna el valor correcto
        assertEquals("Gomez", administrador.getapellido());
    }
}
