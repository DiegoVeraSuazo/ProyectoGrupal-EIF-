package GUIs;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormaPanel extends JPanel {

    private JLabel etiquetaNombre;
    private JLabel etiquetaCorreo;
    private JTextField campoNombre;
    private JTextField campoCorreo;
    private JButton okBtn;
    private FormListener formListener;
    private JList listaPedido;
    private JComboBox comboEmp;


    public FormaPanel(){

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        System.out.println(dim);

        etiquetaNombre = new JLabel("Nombre: ");
        etiquetaCorreo = new JLabel("Correo: ");
        campoNombre = new JTextField(10);
        campoCorreo = new JTextField(10);
        listaPedido = new JList();
        comboEmp = new JComboBox();

        // Set up list box
        DefaultListModel modeloPedido = new DefaultListModel();
        modeloPedido.addElement(new Pedido(0,"Pizza Vegetariana"));
        modeloPedido.addElement(new Pedido(1,"Pizza Texana"));
        modeloPedido.addElement(new Pedido(2,"Pizza Americana"));
        modeloPedido.addElement(new Pedido(3,"Pizza Mediterranea"));
        listaPedido.setModel(modeloPedido);

        listaPedido.setPreferredSize(new Dimension(115, 75));
        listaPedido.setBorder(BorderFactory.createEtchedBorder());
        listaPedido.setSelectedIndex(1);

        // Set up combo box
        DefaultComboBoxModel modeloTamaño = new DefaultComboBoxModel();
        modeloTamaño.addElement("Pequeña");
        modeloTamaño.addElement("Mediana");
        modeloTamaño.addElement("Grande");
        comboEmp.setModel(modeloTamaño);
        comboEmp.setSelectedIndex(0);
        comboEmp.setEditable(true);

        okBtn = new JButton("OK");

        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String correo = campoCorreo.getText();
                Pedido pedido = (Pedido) listaPedido.getSelectedValue();
                String gatoEmp = (String)comboEmp.getSelectedItem();

                System.out.println(pedido.getId() + "|" + gatoEmp);

                FormaEvento ev = new FormaEvento(this, nombre, correo, pedido.getId());

                if (formListener != null) {
                    formListener.formaEventoOcurrido(ev);
                }

            }
        });

        Border bordeInterno = BorderFactory.createTitledBorder("Add Person");
        Border bordeExterno = BorderFactory.createEmptyBorder(5,5,5,5);

        setBorder(BorderFactory.createCompoundBorder(bordeExterno,bordeInterno));

        layoutComponents();

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
        gc.weighty = 0.1;

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
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Pizza: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(listaPedido, gc);

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
        add(comboEmp, gc);

        ///Next Row///

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(okBtn, gc);

    }

    public void setFormListener(FormListener listener) {

        this.formListener = listener;
    }
}

class Pedido {
    private int id;
    private String texto;

    public Pedido(int id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public String toString() {
        return texto;
    }

    public int getId() {
        return id;
    }

}
