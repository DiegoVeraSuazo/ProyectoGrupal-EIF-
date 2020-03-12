package interfazUsuario;

import GUIs.Ventana;
import archivo.GestorArchivo;
import contextoProblema.Boleta;
import contextoProblema.Pedido;
import validar.Validar;

public class Menu {

    public static void menu() {
        Validar v = new Validar();
        GestorArchivo gestor = new GestorArchivo();
        boolean ejec = true;
        gestor.crearArchivoVacio();
        gestor.vaciarArchivo("boletas.txt");
        do {
            System.out.println("\nSelecciona la operacion a realizar (Ingrese el numero correspondiente)\n1- Hacer un pedido\n2- Ver Boletas emitidas\n3- Vaciar Archivo Boletas\n4- Abrir Ventana\n9- Salir");
            int opcion = v.validarEntero();
            if (opcion >= 1 && opcion <= 4) {
                seleccion(opcion, true);
            } else if (opcion == 9) {
                System.out.println("Hasta luego");
                ejec = false;
            } else {
                System.out.println("Opcion no valida");
            }
        } while (ejec);
    }

    public static void seleccion(int opcion, boolean ejec) {
        GestorArchivo gestorArchivo = new GestorArchivo();
        Boleta boleta = new Boleta();
        Pedido nuevoPedido = new Pedido();
        switch(opcion){
            case 1:
                boleta.agregarPedido(nuevoPedido,gestorArchivo);
                break;
            case 2:
                gestorArchivo.verArchivo("boletas.txt");
                break;
            case 3:
                gestorArchivo.vaciarArchivo("boletas.txt");
                gestorArchivo.nuevaLineaTexto("{id, pizza, tamano, precio, nombreCliente, runCliente, horaPedido}","","","boletas.txt");
                break;
            case 4:
                Ventana ventana = new Ventana();
                ventana.main();
            default:
                break;
        }

    }
}