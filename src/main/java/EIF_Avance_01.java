import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EIF_Avance_01 {

    public static void main(String[] args) {


    }

    public static String restaurant() {


        return null;
    }

    public static String cliente() {

        return null;
    }

    public static String pedido() {

        return null;
    }

    public static String Comida() {
        ArrayList pizza = new ArrayList();
        pizza.add("");

        return null;
    }


    public static int validarEnteros() {
        Scanner teclado = new Scanner(System.in);
        int entrada = 0;
        do {
            try {
                entrada = teclado.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Dato incorrecto vuelva a ingresar");
                teclado.next();
                entrada = -1;
            }
        } while (entrada < 0);
        return entrada;
    }

    public static String leerArchivo(String ruta) {
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println(texto);
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        return texto;
    }

    public static String nuevaLineaTexto(String ruta) {
        Path archivo = Paths.get(ruta);
        String texto = "";
        String linea = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            texto = texto + "\n" + linea;
            Files.write(archivo, texto.getBytes());
            System.out.println(texto);
        } catch (IOException e) {
            System.out.println("No se pudo agregar una nueva linea");
        }
        return texto;
    }

    public static boolean validarRut(String rut) {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            rut = rut.replace("k", "");
            rut = rut.replace("K", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

}
