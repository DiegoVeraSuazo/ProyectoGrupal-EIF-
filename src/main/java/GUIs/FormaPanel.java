package GUIs;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormaPanel extends JPanel {

    private JLabel etiquetaNombre;
    private JLabel etiquetaOcupacion;
    private JTextField campoNombre;
    private JTextField campoOcupacion;
    private JButton okBtn;
    private FormListener formListener;
    private JList listaEdad;
    private JComboBox comboEmp;


    public FormaPanel(){

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        System.out.println(dim);

        etiquetaNombre = new JLabel("Name: ");
        etiquetaOcupacion = new JLabel("Ocupacion: ");
        campoNombre = new JTextField(10);
        campoOcupacion = new JTextField(10);
        listaEdad = new JList();
        comboEmp = new JComboBox();

        // Set up list box
        DefaultListModel modeloEdad = new DefaultListModel();
        modeloEdad.addElement(new CategoriaEdad(0,"Bajo 18"));
        modeloEdad.addElement(new CategoriaEdad(1,"18 a 65"));
        modeloEdad.addElement(new CategoriaEdad(2,"Sobre 65"));
        listaEdad.setModel(modeloEdad);

        listaEdad.setPreferredSize(new Dimension(105, 70));
        listaEdad.setBorder(BorderFactory.createEtchedBorder());
        listaEdad.setSelectedIndex(1);

        // Set up combo box
        DefaultComboBoxModel modeloEmp = new DefaultComboBoxModel();
        modeloEmp.addElement("Empleado");
        modeloEmp.addElement("Su Propio Empleado");
        modeloEmp.addElement("Desempleado");
        comboEmp.setModel(modeloEmp);
        comboEmp.setSelectedIndex(0);
        comboEmp.setEditable(true);

        okBtn = new JButton("OK");

        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String ocupacion = campoOcupacion.getText();
                CategoriaEdad edadGato = (CategoriaEdad)listaEdad.getSelectedValue();
                String gatoEmp = (String)comboEmp.getSelectedItem();

                System.out.println(edadGato.getId() + "|" + gatoEmp);

                FormaEvento ev = new FormaEvento(this, nombre, ocupacion, edadGato.getId());

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
        add(etiquetaOcupacion, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(campoOcupacion, gc);

        ///Next Row///

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Edad: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(listaEdad, gc);

        ///Next Row///

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Employment: "), gc);

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

class CategoriaEdad {
    private int id;
    private String texto;

    public CategoriaEdad(int id, String texto) {
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
