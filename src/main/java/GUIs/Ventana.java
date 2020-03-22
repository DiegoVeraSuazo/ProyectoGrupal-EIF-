package GUIs;

import archivo.GestorArchivo;
import archivo.Zxing;
import com.google.zxing.WriterException;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Ventana {

    public void main() {

        inicializar();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainVentana();
                }
            }
        );

    }

    public void inicializar() {

        GestorArchivo gestor = new GestorArchivo();
        gestor.deleteDir(new File("Boletas"));
        gestor.crearDirectorio("Boletas");
        gestor.crearArchivoVacio("Boletas/boletas.txt");
        gestor.vaciarArchivo("Boletas/boletas.txt");

        try {
            Zxing.generateQR("Aqui se encuentra el codigo QR que podra escanear para su pedido");
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

}
