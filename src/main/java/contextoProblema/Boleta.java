package contextoProblema;

import archivo.GestorArchivo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Boleta {

    private String tiempoPedido;

    public String getTiempoPedido() {
        return tiempoPedido;
    }

    public void setTiempoPedido(String tiempoPedido) {
        this.tiempoPedido = tiempoPedido;
    }

    /**
     * Metodo que registra un pedido en el archivo .txt agregandole la hora al pedido.
     * */
    public void agregarPedido(){
        Pedido pedido = new Pedido();
        GestorArchivo gestor = new GestorArchivo();
        String pizza =  pedido.eleccionPizza();
        String cliente = pedido.registrarCliente();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        tiempoPedido = dateFormat.format(date);
        gestor.nuevaLineaTexto(tiempoPedido,pizza,cliente,"boletas.txt");
    }

}