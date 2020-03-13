package archivo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class GestorArchivoTest {

    String nombreArchivo;

    @Before
    public void setUp() throws Exception {
        nombreArchivo = "boletas.txt";
    }

    @Test
    public void crearArchivoVacio() {
    }

    @Test
    public void nuevaLineaTexto() {

    }

    @Test
    public void verArchivo() throws IOException {
        String texto = GestorArchivo.verArchivo(nombreArchivo);
        Path archivo = Paths.get(nombreArchivo);
        String salto = "";
        salto = new String(Files.readAllBytes(archivo));
        assertEquals(salto,texto);
    }
}