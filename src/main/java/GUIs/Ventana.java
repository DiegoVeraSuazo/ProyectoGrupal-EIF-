package GUIs;

import javax.swing.*;

public class Ventana {

    public void main() {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainVentana();
                }
            }
        );

    }

}
