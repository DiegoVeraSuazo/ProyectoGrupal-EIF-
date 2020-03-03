package validar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validar {

    /**
     * Metodo que valida una variable de tipo entero.
     * @return retorna una variable de tipo entero.
     * */
    public static int validarEntero() {
        Scanner teclado = new Scanner(System.in);
        int entrada = 0;
        boolean valido;
        do {
            try {
                entrada = teclado.nextInt();
                if (entrada >= 0) {
                    valido = false;
                } else {
                    System.out.println("Ingreso de negativo, Invalido");
                    valido = true;
                }
            } catch (InputMismatchException ime) {
                System.out.println("No ingrese letras u oraciones");
                teclado.next();
                valido = true;
            }
        } while (valido);
        return entrada;
    }

    /**
     * Metodo que valida el rut ingresado por el usuario.
     * @param rut variable de tipo String ingresado por el usuario que corresponde al rut de este.
     * @return retorna una variable de tipo boleano que certifica con un true que el rut ingresado por consola es verdadero.
     * */
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
            int m = 0;

            int s;
            for(s = 1; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }

            if (dv == (char)(s != 0 ? s + 47 : 75)) {
                validacion = true;
            }
        } catch (NumberFormatException var6) {
        } catch (Exception var7) {
        }
        return validacion;
    }
}