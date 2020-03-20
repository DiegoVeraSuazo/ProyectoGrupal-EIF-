package GUIs;
import javax.swing.*;
import java.awt.BorderLayout;
/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/

public class MainVentana extends JFrame{

    private PanelTexto panelTexto;
    //private JButton btn;
    private Toolbar toolbar;
    private FormaPanel formaPanel;

    public MainVentana() {

        super("Eat it Fast");

        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        panelTexto = new PanelTexto();
        //btn = new JButton("Click Me");
        formaPanel = new FormaPanel();

        //toolbar.setTextPanel(panelTexto);
        toolbar.setStringListener(new StringListener() {

            public void textoEmitido(String texto) {
               panelTexto.textoAdjunto(texto);
            }
        });

        formaPanel.setFormListener(new FormListener() {
           public void formaEventoOcurrido(FormaEvento e) {
               String nombre = e.getNombre();
               String correo = e.getCorreo();
               int idPizza = e.getIdPizza();
               int idTamano = e.getIdTamano();

               panelTexto.textoAdjunto(nombre + ": " + correo + ": " + idPizza + ": " + idTamano
                       +"\n");

           }

        });


        add(formaPanel,BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(panelTexto, BorderLayout.CENTER);
        //add(btn,BorderLayout.SOUTH);

        /*
        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                panelTexto.textoAdjunto("Hello\n");
            }
        });
        */

        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
