package GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton acercaDeNosotrosButton;
    private JButton instrucciones;

    //private PanelTexto panelTexto;
    private StringListener textListener;

    public Toolbar() {

        setBorder(BorderFactory.createEtchedBorder());


        acercaDeNosotrosButton = new JButton("Acerca de Nosotros");
        instrucciones = new JButton("Instrucciones");

        acercaDeNosotrosButton.addActionListener(this);
        instrucciones.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(acercaDeNosotrosButton);
        add(instrucciones);
    }

/*
    public void setTextPanel(PanelTexto panelTexto) {

        this.panelTexto = panelTexto;

    }
*/

    public void setStringListener(StringListener listener){
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        PanelTexto panelTexto = new PanelTexto();
        JButton clicked = (JButton) event.getSource();

        if(clicked == acercaDeNosotrosButton){
            if(textListener != null){
                textListener.textoEmitido("Somos una Pagina de Venta para ordenes online de Pizza,\n" +
                        "que trabaja con la emisión de boletas para el retiro de tu pedido en tienda.\n");
            }
        }

        if(clicked == instrucciones){

            if(textListener != null){

                textListener.textoEmitido("1- Ingrese su nombre en la casilla que lo indique.\n" +
                        "2- Ingrese su mail en la casilla que lo indique.\n" +
                        "3- Escoja el tipo de pizza.\n" +
                        "4- Escoja el tamaño de pizza.\n" +
                        "5- Una vez que este decidido presione el boton OK para generar su boleta.");
            }
        }
}
}
