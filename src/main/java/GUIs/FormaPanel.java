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
import java.io.IOException;

import static javax.swing.JOptionPane.*;

public class FormaPanel extends JPanel {

    private JLabel etiquetaNombre;
    private JLabel etiquetaCorreo;
    private JTextField campoNombre;
    private JTextField campoCorreo;
    private JButton okBtn;
    private FormListener formListener;
    private JComboBox comboTam;
    private JComboBox comboTipo;


    /**
     * Metodo que permite modelar el JPanel como uno desee,
     * ademas de ser usado para llamar otro metodos que lo complementan.
     */
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
        DefaultComboBoxModel modeloTamano = new DefaultComboBoxModel();
        modeloTamano.addElement("Pequeña $5000");
        modeloTamano.addElement("Mediana $10000");
        modeloTamano.addElement("Grande $15000");
        comboTam.setModel(modeloTamano);
        comboTam.setSelectedIndex(0);
        comboTam.setEditable(true);

        okBtn = new JButton("OK");

        accionOkBtn();
        Border bordeInterno = BorderFactory.createTitledBorder("Añadir Pedido");
        Border bordeExterno = BorderFactory.createEmptyBorder(5,5,5,5);

        setBorder(BorderFactory.createCompoundBorder(bordeExterno,bordeInterno));

        layoutComponents();
    }


    /**
     * Metodo que reacciona al ser pulsado el boton llamado OkBtn,
     * y que realiza diversas acciones en concorde a esta como lo son:
     * Recopilar la informacion, llamar un metodo para verificar la entrada correcta de dato,
     * llamar la generacion del codigo QR y abrir una ventana que muestre la boleta.
     */
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


    /**
     * Metodo que dicta el formato de como se presenta el JLabel.
     */
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

    /**
     * Metodo que se encarga de verificar la entrada correcta de datos en los JTextField indicados,
     * ademas de instanciar un objeto FormaEvento.
     * @param pedido Pedido objeto para ser usado en el metodo de boleta.
     * @param gestor GestorArchivo objeto para ser usado en el metodo de boleta.
     * @param nombre String que posee el nombre ingresado por el cliente.
     * @param correo String que posee el correo que ingreso el cliente.
     * @param tipoPizza String que posee el tipo de pizza escogido.
     * @param tamanoEmp String que posee el tamaño de la pizza escogido.
     * @param boleta Boleta que ademas de ordenar los datos, devuelve estos en un String debido a su metodo agregarPedido.
     * @return String que posee la boleta ya realizada y ordenada.
     */
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

    /**
     * Metodo que llama la interface FormListener para que recibo el evento deseado.
     * @param listener FormListener que se usa para obtener un evento.
     */
    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}
