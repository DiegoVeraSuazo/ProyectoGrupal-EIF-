package archivo;

import com.google.zxing.WriterException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZxingTest {

    String rutaTest;
    String textoTest;

    @Before
    public void setUp() throws Exception {

        rutaTest = "imagenQRTest.png";
        textoTest = "Texto de Prueba para las pruebas unitarias con JUnit";

    }

    @Test
    public void generateQR() throws WriterException {

        assertEquals(true, Zxing.generateQR(textoTest, rutaTest));
    }
}