package archivo;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GestorArchivo {

    /**
     * Metodo que comprueba si existe el archivo boletas.txt.
     * @return retorna un boleano que comprueba si el archivo boletas.txt fue creado.
     */
    public static boolean crearArchivoVacio() {
        boolean validar = false;
        if(new File("boletas.txt").exists()){
            validar = true;
        }
        else{
            try{
                Files.write(Paths.get("boletas.txt"), new String().getBytes());
            }
            catch(IOException e) {}
        }
        return validar;
    }

    /**
     * Metodo que agrega una nueva linea de texto de tipo String al archivo boletas.txt.
     * @param hora tiempo que se registro en el momento del pedido.
     * @param cliente los datos registrados por el usuario.
     * @param pizza el producto que escogio y su tamaño.
     * @param ruta variable para acceder a la ruta del archivo boletas.txt
     * @return retorna un texto que corresponde a lo que contiene el archivo boletas.txt con su nueva linea.
     */
    public static String nuevaLineaTexto(String hora, String pizza, String cliente, String ruta) {
        Path archivo = Paths.get(ruta);
        String texto = "";
        String linea = pizza+"\n"+cliente+"\nHora del pedido: "+hora;
        try {
            texto = Files.readString(archivo);
            String textoAnterior = new String(Files.readAllBytes(archivo));
            texto = textoAnterior+"\n"+linea;
            Files.write(archivo, texto.getBytes());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar Linea de Texto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return texto;
    }

    /**
     * Elimina completamente el contenido del .txt.
     * @param ruta Ruta del archivo .txt.
     */
    public static void vaciarArchivo(String ruta){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            bw.write("");
            bw.close();
        }catch(IOException e){}
    }

    /**
     * Metodo que entrega por consola lo que contiene el archivo boletas.txt.
     * @param ruta variable para acceder a la ruta del archivo boletas.txt.
     * @return retorna un texto que corresponde a lo que contiene el archivo boletas.txt.
     * */
    public static String verArchivo(String ruta) {
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println(texto);
        } catch (IOException var4) {
            System.out.println("El archivo no pudo ser leido");
        }
        return texto;
    }

}