package GUIs;

import archivo.GestorArchivo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton acercaDeNosotrosButton;
    private JButton instrucciones;
    private JButton registroBoletas;

    private StringListener textListener;


    /**
     * Metodo que establece el Componente de JButtons para su uso en la parte superior de MainVentana.
     */
    public Toolbar() {

        setBorder(BorderFactory.createEtchedBorder());

        acercaDeNosotrosButton = new JButton("Acerca de Nosotros");
        instrucciones = new JButton("Instrucciones");
        registroBoletas = new JButton("Registros de Boletas emitidas");

        acercaDeNosotrosButton.addActionListener(this);
        instrucciones.addActionListener(this);
        registroBoletas.addActionListener(this);


        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(acercaDeNosotrosButton);
        add(instrucciones);
        add(registroBoletas);
    }


    /**
     * Metodo que llama la interface StringListener para que recibo el texto deseado.
     * @param listener StringListener que se usa para guardar String cuando se usa el metodo textoEmitido que posee.
     */
    public void setStringListener(StringListener listener){
        this.textListener = listener;
    }


    /**
     * Metodo que detecta el click de diversos JButtons y que realiza una accion en conforme al elegido.
     * @param event ActionEvent que es usa para detectar el click de un JButton.
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        JButton clicked = (JButton) event.getSource();
        GestorArchivo gestor = new GestorArchivo();

        if(clicked == acercaDeNosotrosButton){
            if(textListener != null){
                textListener.textoEmitido("Somos una Pagina de Venta para ordenes online de Pizza,\nque trabaja con la emisión de boletas para el retiro de tu pedido en tienda.\n");
            }
        }

        if(clicked == instrucciones){
            if(textListener != null){
                textListener.textoEmitido("1- Ingrese su nombre en la casilla que lo indique.\n2- Ingrese su mail en la casilla que lo indique con el formato(ejemplo@ejemplo.com).\n3- Escoja el tipo de pizza.\n4- Escoja el tamaño de pizza.\n5- Una vez que este decidido presione el boton OK para generar su boleta.");
            }
        }

        if(clicked == registroBoletas){
            if(textListener != null){
                textListener.textoEmitido(gestor.verArchivo("Boletas/boletas.txt"));
            }
        }
}
}
