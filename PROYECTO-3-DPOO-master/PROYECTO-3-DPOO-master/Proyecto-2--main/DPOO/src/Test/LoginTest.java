package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.BeforeClass;
import login.login; 

public class LoginTest { 
	
    @BeforeClass
    public static void setUp() { 
    }

    @Test
    public void testCreateUser() { // verifica si el usuario se crea correctamente.
        login.createuser("Juan", "Perez", "12345678", "juanperez", "contraseña", "3001234567", 5000, "Usuario", "01-01-2024");
        assertNotNull(login.verifyUser("juanperez", "12345678")); 
    }

    @Test
    public void testVerifyUser() { 

        // verifica si la verificación del usuario funciona correctamente.
        String result = login.verifyUser("juanperez", "contraseña");
        assertEquals("Usuario", result); 
    }
}

