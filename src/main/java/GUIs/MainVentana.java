package GUIs;

import archivo.GestorArchivo;
import javax.swing.*;
import java.awt.BorderLayout;

public class MainVentana extends JFrame{

    private PanelTexto panelTexto;
    private Toolbar toolbar;
    private FormaPanel formaPanel;


    /**
     * Metodo principal en lo que se tiene que ver con el JFrame en este proyecto,
     * este metodo se encarga de dar forma a las ventanas, ademas de llamar a los difererentes componentes que posee,
     * entre los que se encuentran JPanel, JTextArea, JButtons, etc.
     */
    public MainVentana() {

        super("Eat it Fast");

        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        panelTexto = new PanelTexto();
        formaPanel = new FormaPanel();

        toolbar.setStringListener(new StringListener() {
            public void textoEmitido(String texto) {
               panelTexto.textoAdjunto(texto);
            }
        });

        formaPanel.setFormListener(new FormListener() {
           public void formaEventoOcurrido(FormaEvento e) {
               GestorArchivo gestorArchivo = new GestorArchivo();
               panelTexto.textoAdjunto(gestorArchivo.verArchivo("Boletas/boletas.txt"));
           }
        });

        add(formaPanel,BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(panelTexto, BorderLayout.CENTER);
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
