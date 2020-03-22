package GUIs;

import javax.swing.*;
import java.awt.*;

public class PanelTexto extends JPanel {

    private JTextArea textArea;


    /**
     * Metodo que establece el Componente de JTextArea para su uso en MainVentana.
     */
    public PanelTexto() {

        textArea = new JTextArea();

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    /**
     * Metodo que posee la funcion de mostrar el texto indicado dentro del JTextArea.
     * @param texto String que guarda la información que se mostrara.
     */
    public void textoAdjunto(String texto) {
        textArea.setText(null);
        textArea.append(texto);
    }

}
