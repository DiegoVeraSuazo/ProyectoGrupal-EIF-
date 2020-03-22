package GUIs;

import java.util.EventListener;

public interface FormListener extends EventListener {

    /**
     * Interface que se encarga de detecta los eventos indicados en las clases que la implementan.
     * @param e FormaEvento que recibe.
     */
    public void formaEventoOcurrido(FormaEvento e);

}
