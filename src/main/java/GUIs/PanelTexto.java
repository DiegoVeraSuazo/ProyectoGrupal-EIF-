package GUIs;

import javax.swing.*;
import java.awt.*;

public class PanelTexto extends JPanel {

    private JTextArea textArea;

    public PanelTexto() {

        textArea = new JTextArea();

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    public void textoAdjunto(String texto) {

        textArea.setText(null);
        textArea.append(texto);
    }

}
