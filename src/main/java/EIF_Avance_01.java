import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EIF_Avance_01 {

    public static void main(String[] args) {
        restaurant();
    }

    public static void restaurant() {
        Scanner teclado = new Scanner(System.in);
        crearArchivo("pedidos.csv");
        boolean ejec = true;
        do {
            System.out.println("Selecciona la operacion a realizar"
                    +"\n1 - Creacion Pedidos"
                    +"\n2 - Muestra Pedidos"
                    //+"\n3 - Eliminar Pedidos"
                    +"\n9 - Terminar");
            int opcion = escribirNum();
            if (opcion >= 1 && opcion <= 3 ) {
                seleccion(opcion, ejec);

            } else if (opcion == 9) {
                ejec = false;
            } else {
                System.out.println("Opcion no valida");
            }

        } while (ejec);
    }

    private static void seleccion(int opcion, boolean ejec) {

        switch(opcion){
            case 1:
                pedido();
                break;
            case 2:
                leerArchivo("pedidos.csv");
                break;
            //case 3:
              //  break;
            default:
                break;
        }

    }

    public static String cliente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese nombre Cliente");
        String nombre = teclado.nextLine();
        String rutIngresado;
        do {
            System.out.println("Ingrese RutCliente");
            rutIngresado = teclado.nextLine();

        } while (validarRut(rutIngresado) == false);

        return nombre +","+ rutIngresado;
    }

    public static String pedido() {
        nuevaLineaTexto("pedidos.csv", cliente()+","+comida());
        return null;
    }

    public static String comida() {
        ArrayList pizza = new ArrayList();
        anadirPizza(pizza);
        String eleccion;
        eleccion = eleccionDePizza(pizza);
        return eleccion;
    }

    public static String eleccionDePizza(ArrayList tipo) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escriba el tipo, o escoja el numero de la opcion:");
        Boolean bandera1;
        String tipoElegido;
        do {
            for (int i = 0; i < tipo.size(); i++) {
                System.out.println((i+1)+"°"+tipo.get(i));
            }
            tipoElegido = teclado.nextLine();
            if (tipoElegido.equals("1")) {tipoElegido = (String) tipo.get(0);}
            if (tipoElegido.equals("2")) {tipoElegido = (String) tipo.get(1);}
            if (tipoElegido.equals("3")) {tipoElegido = (String) tipo.get(2);}
            if (tipoElegido.equals("4")) {tipoElegido = (String) tipo.get(3);
            }
            if (tipo.contains(tipoElegido)) {
                bandera1 = false;
            } else {
                bandera1 = true;
            }
        } while (bandera1);
        return tipoElegido;
    }

    public static ArrayList anadirPizza(ArrayList pizza) {
        pizza.add("Pizza Mediterranea $3000");
        pizza.add("Pizza Vegetariana $9500");
        pizza.add("Pizza Texana $3000");
        pizza.add("Pizza Americana $5500");

        return pizza;
    }


    public static int escribirNum() {
        Scanner teclado = new Scanner(System.in);
        int entrada = 0;
        Boolean valido;
        do {
            try {
                entrada = teclado.nextInt();
                if (entrada >= 0){
                    valido = false;
                } else {
                    System.out.println("Ingreso de negativo, Invalido");
                    valido = true;
                }
            } catch (InputMismatchException ime) {
                System.out.println("No ingrese letras u oraciones");
                teclado.next();
                valido = true;
            }
        } while (valido);
        return entrada;
    }

    public static String leerArchivo(String ruta) {
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println(texto);
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        return texto;
    }

    public static String nuevaLineaTexto(String ruta, String newLine) {
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            texto = texto + "\n" + newLine;
            Files.write(archivo, texto.getBytes());
            System.out.println(texto);
        } catch (IOException e) {
            System.out.println("No se pudo agregar una nueva linea");
        }
        return texto;
    }


    public static void crearArchivo(String nameArchivo){
        Scanner teclado = new Scanner(System.in);
        String ruta = nameArchivo;
        Path archivo = Paths.get(ruta);
        try {
            Files.write(archivo, "".getBytes());
            System.out.println("Se ha guardado el archivo");
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser guardado");
        }
    }

    public static boolean validarRut(String rut) {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            rut = rut.replace("k", "");
            rut = rut.replace("K", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    public static String teclado() {
        Scanner teclado = new Scanner(System.in);
        String texto = teclado.nextLine();
        return texto;
    }

}
