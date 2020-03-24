package archivo;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
public class GestorArchivo {

    /**
     * Metodo que comprueba si existe el archivo Indicado.
     * @param ruta String que indica la ruta y el nombre del archivo a crear en este caso: Boletas/boletas.txt.
     * @return retorna un boleano que comprueba si el archivo boletas.txt fue creado.
     */
    public boolean crearArchivoVacio(String ruta) {
        boolean validar = false;
        if(new File(ruta).exists()){
            validar = true;
        }
        else{
            try{
                Files.write(Paths.get(ruta), new String().getBytes());
            }
            catch(IOException e) {}
        }
        return validar;
    }


    /**
     * Metodo de tipo void que se encarga de crer un directorio.
     * @param ruta String que indica el Ruta que va a tener el directorio siendo esta: Boletas.
     */
    public void crearDirectorio(String ruta) {
        Path directorio = Paths.get(ruta);
        if (Files.exists(directorio)) {
            System.out.println("El directorio ya existe");
        } else {
            try {
                Files.createDirectories(directorio);
                System.out.println("El directorio fue creado");
            } catch (IOException e) {
                System.out.println("El directorio no fue creado");
            }
        }
    }


    /**
     * Metodo de tipo void que elimina el Directorio indicado junto con su archivos.
     * @param file File indica la direccion del Directorio, siendo esta: Boletas.
     */
    public void deleteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                if (! Files.isSymbolicLink(f.toPath())) {
                    deleteDir(f);
                }
            }
        }
        file.delete();
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
            String textoAnterior = new String(Files.readAllBytes(archivo));
            texto = textoAnterior+"\n"+linea;
            Files.write(archivo, texto.getBytes());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar Linea de Texto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return linea;
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
        }catch(IOException e){
            System.out.println("El directorio no pudo ser vaciado");
        }
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