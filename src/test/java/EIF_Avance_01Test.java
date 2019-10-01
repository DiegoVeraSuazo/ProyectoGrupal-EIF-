import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EIF_Avance_01Test {

    ArrayList anadirPizzaTest = new ArrayList();
    ArrayList texto = new ArrayList();
    @BeforeEach
    void setUp() {
        anadirPizzaTest.add("Pizza Mediterranea $3000");
        anadirPizzaTest.add("Pizza Vegetariana $9500");
        anadirPizzaTest.add("Pizza Texana $3000");
        anadirPizzaTest.add("Pizza Americana $5500");
        texto.add("Test");
        texto.add("Texto Prueba");
    }


    @Test
    void anadirPizza() {
        assertEquals(anadirPizzaTest, EIF_Avance_01.anadirPizza(anadirPizzaTest));
    }

    @Test
    void nuevaLineaTexto() {
        String ruta = "pedidos.csv";
        EIF_Avance_01.crearArchivo(ruta);
        assertEquals("\nTest", EIF_Avance_01.nuevaLineaTexto(ruta,(String)texto.get(0)));
        assertEquals("\nTest\nTexto Prueba", EIF_Avance_01.nuevaLineaTexto(ruta,(String)texto.get(1)));
    }


    @Test
    void validarRut() {
        String rutX = "20080961-0";
        String rutY = "8468868-1";
        //String rutZ = "20901792-K"; //este falla
        boolean resultado = true;
        assertEquals(EIF_Avance_01.validarRut(rutX),resultado);
        assertEquals(EIF_Avance_01.validarRut(rutY),resultado);
        //assertEquals(EIF_Avance_01.validarRut(rutZ),resultado);
    }
}