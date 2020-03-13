package contextoProblema;

import archivo.GestorArchivo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Boleta {

    private String tiempoPedido;

    /**
     * Metodo que registra un pedido en el archivo .txt agregandole la hora al pedido.
     * @param pedido instancia para llamar a la clase Pedido.
     * @param gestorArchivo instancia para llamar a la clase GestorAerchivo.
     * @return retorna una nueva linea para el archivo boletas.txt que corresponde a un nuevo pedido.
     * */
    public String agregarPedido(Pedido pedido, GestorArchivo gestorArchivo){
        String pizza =  pedido.eleccionPizza();
        String cliente = pedido.registrarCliente();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        tiempoPedido = dateFormat.format(date);
        return gestorArchivo.nuevaLineaTexto(tiempoPedido,pizza,cliente,"boletas.txt");
    }
}