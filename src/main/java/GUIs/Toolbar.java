package GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton helloButoon;
    private JButton goodbyeButton;

    //private PanelTexto panelTexto;
    private StringListener textListener;

    public Toolbar() {

        setBorder(BorderFactory.createEtchedBorder());

        helloButoon = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");

        helloButoon.addActionListener(this);
        goodbyeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButoon);
        add(goodbyeButton);

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

        if(clicked == helloButoon){
            //panelTexto.textoAdjunto("Hello\n");
            if(textListener != null){
                textListener.textoEmitido("Hello\n");
            }
            System.out.println("Hello");
        }else{
            //panelTexto.textoAdjunto("Goodbye\n");
            if(textListener != null){
                textListener.textoEmitido("Goodbye\n");
            }
            System.out.println("Goodbye");
        }

    }
}
