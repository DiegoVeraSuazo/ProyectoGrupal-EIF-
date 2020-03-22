package archivo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class GestorArchivoTest {

    String nombreArchivo;
    String hora;
    String pizza;
    String cliente;

    @Before
    public void setUp() {
        nombreArchivo = "boletasTest.txt";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        hora = dateFormat.format(date);
        pizza = "pizza test";
        cliente = "cliente test";
    }

    @Test
    public void nuevaLineaTexto() {
        GestorArchivo.vaciarArchivo(nombreArchivo);
        assertEquals(pizza+"\n"+cliente+"\nHora del pedido: "+hora, GestorArchivo.nuevaLineaTexto(hora,pizza,cliente,nombreArchivo) );
    }

    @Test
    public void verArchivo() throws IOException {
        String texto = GestorArchivo.verArchivo(nombreArchivo);
        Path archivo = Paths.get(nombreArchivo);
        String salto = new String(Files.readAllBytes(archivo));
        assertEquals(salto,texto);
    }
}