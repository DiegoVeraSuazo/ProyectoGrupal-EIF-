package GUIs;

import archivo.GestorArchivo;
import archivo.Zxing;
import com.google.zxing.WriterException;
import contextoProblema.Boleta;
import contextoProblema.Pedido;
import validar.Validar;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static javax.swing.JOptionPane.*;

public class FormaPanel extends JPanel {

    private PanelTexto panel;
    private JLabel etiquetaNombre;
    private JLabel etiquetaCorreo;
    private JTextField campoNombre;
    private JTextField campoCorreo;
    private JButton okBtn;
    private FormListener formListener;
    private JComboBox comboTam;
    private JComboBox comboTipo;

    public FormaPanel(){

        Dimension dim = getPreferredSize();
        dim.width = 300;
        dim.height = 15;
        setPreferredSize(dim);
        System.out.println(dim);

        etiquetaNombre = new JLabel("Nombre: ");
        etiquetaCorreo = new JLabel("Correo: ");
        campoNombre = new JTextField(15);
        campoCorreo = new JTextField(20);
        comboTam = new JComboBox();
        comboTipo = new JComboBox();

        // Set up combo box
        DefaultComboBoxModel modeloPizza = new DefaultComboBoxModel();
        modeloPizza.addElement("Pizza Vegetariana");
        modeloPizza.addElement("Pizza Texana");
        modeloPizza.addElement("Pizza Americana");
        modeloPizza.addElement("Pizza Mediterranea");
        comboTipo.setModel(modeloPizza);
        comboTipo.setSelectedIndex(0);
        comboTipo.setEditable(true);

        // Set up combo box
        DefaultComboBoxModel modeloTamaño = new DefaultComboBoxModel();
        modeloTamaño.addElement("Pequeña $5000");
        modeloTamaño.addElement("Mediana $10000");
        modeloTamaño.addElement("Grande $15000");
        comboTam.setModel(modeloTamaño);
        comboTam.setSelectedIndex(0);
        comboTam.setEditable(true);

        okBtn = new JButton("OK");

        accionOkBtn();
        Border bordeInterno = BorderFactory.createTitledBorder("Añadir Pedido");
        Border bordeExterno = BorderFactory.createEmptyBorder(5,5,5,5);

        setBorder(BorderFactory.createCompoundBorder(bordeExterno,bordeInterno));

        layoutComponents();
    }

    public void accionOkBtn(){
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String nombre = campoNombre.getText();
            String correo = campoCorreo.getText();
            String tipoPizza = (String)comboTipo.getSelectedItem();
            String tamanoEmp = (String)comboTam.getSelectedItem();
            Boleta boleta = new Boleta();
            GestorArchivo gestor = new GestorArchivo();
            Pedido pedido = new Pedido();
            String textoQR = ventanaErrores(pedido, gestor, nombre, correo, tipoPizza, tamanoEmp, boleta);
            if (!textoQR.isEmpty()) {

                try {
                    Zxing.generateQR(textoQR, "QRBoleta.png");
                } catch (WriterException ex) {
                    ex.printStackTrace();
                }
            }
                try {
                    ImageInFrame frameQR = new  ImageInFrame();
                    frameQR.mostrarQR("QRBoleta.png", textoQR);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void layoutComponents() {

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        ///First Row///

        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(etiquetaNombre, gc);

        gc.gridy = 0;
        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(campoNombre, gc);

        ///Next Row///

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(etiquetaCorreo, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(campoCorreo, gc);

        ///Next Row///

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.3;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Tipo Pizza: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(comboTipo, gc);

        ///Next Row///

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Tamaño: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(comboTam, gc);

        ///Next Row///

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(okBtn, gc);

    }

    public String ventanaErrores (Pedido pedido, GestorArchivo gestor, String nombre, String correo, String tipoPizza, String tamanoEmp, Boleta boleta) {

        String boletaPedido = "";

        if(!Validar.validarUsuario(nombre) && !Validar.validarMail(correo)){
            showMessageDialog(null, "No se ingreso un nombre o tiene Numeros\nNo se ingreso un mail con el formato correcto (ejemplo@ejemplo.com)", "Error", ERROR_MESSAGE);
        }else if(!Validar.validarUsuario(nombre)){
            showMessageDialog(null, "No se ingreso un nombre o tiene Numeros", "Error", ERROR_MESSAGE);
        }else if(!Validar.validarMail(correo)){
            showMessageDialog(null, "No se ingreso un mail con el formato correcto (ejemplo@ejemplo.com)", "Error", ERROR_MESSAGE);
        } else{
            boletaPedido = boleta.agregarPedido(pedido, gestor,nombre,correo,tipoPizza,tamanoEmp);
            FormaEvento ev = new FormaEvento(this, nombre, correo, comboTipo.getSelectedIndex(), comboTam.getSelectedIndex());
            if (formListener != null) {
                formListener.formaEventoOcurrido(ev);
            }
        }
        return boletaPedido;
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}
