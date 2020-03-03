package GUIs;

import java.util.EventObject;

public class FormaEvento extends EventObject {


    private String nombre;
    private String ocupacion;
    private int categoriaEdad;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FormaEvento(Object source) {
        super(source);
    }

    public FormaEvento(Object source, String nombre, String ocupacion, int edadGato) {
        super(source);

        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.categoriaEdad = edadGato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getCategoriaEdad() {
        return categoriaEdad;
    }

    public void setCategoriaEdad(int categoriaEdad) {
        this.categoriaEdad = categoriaEdad;
    }
}
