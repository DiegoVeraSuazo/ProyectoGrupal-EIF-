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
     * @param nombre String que posee el nombre ingresado por el cliente.
     * @param mail String que posee el correo que ingreso el cliente.
     * @param tipoPizza String que guarda la eleccion de la pizza que escogio el cliente.
     * @param tamanoPizza String que almacena el tamaño que selecciono el cliente.
     * @return retorna una nueva linea para el archivo boletas.txt que corresponde a un nuevo pedido.
     * */
    public String agregarPedido(Pedido pedido, GestorArchivo gestorArchivo, String nombre, String mail, String tipoPizza, String tamanoPizza){
        String pizza = pedido.pizzaPedida(tipoPizza,tamanoPizza);
        String cliente = pedido.registrarCliente(nombre,mail);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        tiempoPedido = dateFormat.format(date);
        return gestorArchivo.nuevaLineaTexto(tiempoPedido,pizza,cliente,"Boletas/boletas.txt");
    }
}