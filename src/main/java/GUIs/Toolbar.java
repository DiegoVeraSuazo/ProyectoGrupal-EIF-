package GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton pizzasButton;

    //private PanelTexto panelTexto;
    private StringListener textListener;

    public Toolbar() {

        setBorder(BorderFactory.createEtchedBorder());


        pizzasButton = new JButton("Pizzas");


        pizzasButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(pizzasButton);

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

        JButton clicked = (JButton) event.getSource();

        if(clicked == pizzasButton){
            //panelTexto.textoAdjunto("Hello\n");
            if(textListener != null){
                textListener.textoEmitido("deVeras\n");
            }
            System.out.println("deVeras");

        }
    }
}
