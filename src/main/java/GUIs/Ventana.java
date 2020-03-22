package GUIs;

import archivo.GestorArchivo;
import archivo.Zxing;
import com.google.zxing.WriterException;

import javax.swing.*;
import java.io.File;


public class Ventana {


    /**
     * Metodo de ventana que invoca la Clase MainVentana para aumentar al estabilidad de los JFrame.
     */
    public void main() {

        inicializar();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainVentana();
                }
            }
        );

    }


    /**
     * Metodo que se encarga inicializar el programa desde cero,
     */
    public void inicializar() {

        GestorArchivo gestor = new GestorArchivo();
        gestor.deleteDir(new File("Boletas"));
        gestor.crearDirectorio("Boletas");
        gestor.crearArchivoVacio("Boletas/boletas.txt");
        gestor.vaciarArchivo("Boletas/boletas.txt");

        try {
            Zxing.generateQR("Aqui se encuentra el codigo QR que podra escanear para su pedido", "QRBoleta.png");
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

}
