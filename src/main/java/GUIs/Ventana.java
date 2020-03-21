package GUIs;

import archivo.GestorArchivo;

import javax.swing.*;

public class Ventana {

    public void main() {
        GestorArchivo gestor = new GestorArchivo();
        gestor.crearArchivoVacio();
        gestor.vaciarArchivo("boletas.txt");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainVentana();
                }
            }
        );

    }

}
