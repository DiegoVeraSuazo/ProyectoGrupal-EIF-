package validar;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {
    

    /**
     * Metodo que valida el mail ingresado por el usuario.
     * @param mail variable de tipo String ingresado por el usuario que corresponde al mail de este.
     * @return boleano que certifica con un true que el mail ingresado por consola es verdadero.
     * */
    public static boolean validarMail(String mail){
        boolean validar = false;
        try{
            Pattern pattern = Pattern
                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(mail);
            if(mather.find() == true){
                validar = true;
            }
        }catch (Exception e){}
        return validar;
    }

    /**
     * Metodo que valida el nombre ingresado por el usuario.
     * @param nombre variable de tipo String ingresado por el usuario que corresponde al nombre de usuario de este.
     * @return boleano que certifica con un true que el nombre de usuario ingresado por consola es verdadero.
     * */
    public static boolean validarUsuario(String nombre){
        boolean validar = false;
        try{
            Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
            Matcher mather = pattern.matcher(nombre);
            if(mather.find() == true){
                validar = true;
            }
        }catch (Exception e){}
        return validar;
    }
}