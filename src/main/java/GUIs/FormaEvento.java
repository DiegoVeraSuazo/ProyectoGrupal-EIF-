package GUIs;

import java.util.EventObject;

public class FormaEvento extends EventObject {


    private String nombre;
    private String correo;
    private int idPizza;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FormaEvento(Object source) {
        super(source);
    }

    public FormaEvento(Object source, String nombre, String correo, int idPizza) {
        super(source);

        this.nombre = nombre;
        this.correo = correo;
        this.idPizza = idPizza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }
}
