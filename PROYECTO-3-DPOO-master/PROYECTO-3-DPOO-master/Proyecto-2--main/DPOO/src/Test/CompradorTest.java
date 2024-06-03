package Test;
import entities.Escultura;
import entities.Pieza;
import logic.Comprador;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class CompradorTest {

    private Comprador comprador;
    private Escultura escultura;

    @Before
    public void setUp() {
        comprador = new Comprador("Nombre", "Apellido", 12345678, "usuario", "contraseña", 3000000, 500000, "comprador", "01-01-2024", true);
        ArrayList<String> autores = new ArrayList<>();
        autores.add("Autor1");
        autores.add("Autor2");
        escultura= new Escultura("Obra1", 2024, "Colombia", autores, 1000000, false, comprador, "Escultura", false, true, 1.20, 7.8, 8.5, autores, (double) 102, false, "NA");
    }

    @Test
    public void testAddPieza() {
        ArrayList<Pieza> piezasEsperadas = new ArrayList<>();
        piezasEsperadas.add(escultura);
        comprador.addpieza(comprador, escultura);

        ArrayList<Pieza> piezasActuales = comprador.getpiezas(comprador);

        assertEquals(piezasEsperadas, piezasActuales);
    }
}
