package validar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidarTest {

    String mail;
    String mailFallido;
    String nombre;
    String nombreFallido;

    @Before
    public void setUp() throws Exception {
        mail = "prueba@correo.cl";
        mailFallido = "";
        nombre = "Nombre prueba";
        nombreFallido = "";
    }

    @Test
    public void validarMail() {
        assertTrue(Validar.validarMail(mail));
        assertFalse(Validar.validarMail(mailFallido));
    }

    @Test
    public void validarUsuario() {
        assertTrue(Validar.validarUsuario(nombre));
        assertFalse(Validar.validarUsuario(nombreFallido));
    }
}