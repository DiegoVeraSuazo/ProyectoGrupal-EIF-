package validar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidarTest {

    String mail;
    String mailFallido;
    String mailLleno;
    String nombre;
    String nombreFallido;
    String nombreLleno;

    @Before
    public void setUp() throws Exception {
        mail = "prueba@correo.cl";
        mailFallido = "";
        mailLleno = "pruebadecorreollenisimodecaracteresbasura@correo.cl";
        nombre = "Nombre Prueba";
        nombreFallido = "";
        nombreLleno = "Nombre Lleno de palabras que deberian dar sentido";
    }

    @Test
    public void validarMail() {
        assertTrue(Validar.validarMail(mail));
        assertFalse(Validar.validarMail(mailFallido));
        assertFalse(Validar.validarMail(mailLleno));
    }

    @Test
    public void validarUsuario() {
        assertTrue(Validar.validarUsuario(nombre));
        assertFalse(Validar.validarUsuario(nombreFallido));
        assertFalse(Validar.validarUsuario(nombreLleno));
    }
}