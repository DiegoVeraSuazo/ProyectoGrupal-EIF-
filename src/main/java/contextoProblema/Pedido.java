package contextoProblema;

import validar.Validar;
import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {

	private static ArrayList<Producto> pizzas = new ArrayList<>();

	/**
	 * Metodo que se encarga de recoger valores de los metodos platos y tamano, estos valores sirven para tener el pedido listo en un texto que contiene todo los datos necesarios.
	 * @return retorna una variable String que contiene un texto con lo que escojio el usuario.
	 * */
	public static String eleccionPizza(){
		Producto pizza = new Producto();
		Validar validar = new Validar();

		int opcion = 0;
		platos(opcion, pizza,validar);

		opcion=0;
		tamano(opcion, pizza, validar);

		pizzas.add(pizza);
		int contador = 0;
		while(contador<pizzas.size()){
			contador++;
		}
		pizza.setId(contador);
		return pizza.toString();
	}

	/**
	 * Metodo que permite escoger el tipo de pizza interactuando con el usuario.
	 * @param opcion pertenece al valor que escoje el usuario ingrasado por teclado.
	 * @param pizza se llama como objeto pizza a la clase Producto para crear una variable que recoje los datos que escojio el usuario.
	 * @param validar se llama a un metodo de la clase validar para comprobar si el dato igresado es valido en este caso un numero entero.
	 * @return retorna una variable pizza de la clase Producto con los datos obtenidos de este metodo.
	 * */
	public static Producto platos(int opcion, Producto pizza,Validar validar){
		do {
			System.out.println("¿Que pizza desea llevar? (Ingrese el numero correspondiente) \n1- Pizza Mediterranea\n2- Pizza Vegetariana\n3- Pizza Texana\n4- Pizza Americana");
			opcion = validar.validarEntero();
			System.out.println(opcion);
			switch (opcion) {
				case 1:
					pizza.setTipoPizza("Pizza Mediterranea");
					break;
				case 2:
					pizza.setTipoPizza("Pizza Vegetariana");
					break;
				case 3:
					pizza.setTipoPizza("Pizza Texana");
					break;
				case 4:
					pizza.setTipoPizza("Pizza Americana");
					break;
				default:
					break;
			}
		}while(opcion == 0 || opcion > 4);
		return pizza;
	}

	/**
	 * Metodo que permite escoger el tamaño de pizza que se ofrece y luego obtener estos datos para mandarlos al metodo eleccionPizza.
	 * @param opcion pertenece al valor que escoje el usuario ingrasado por teclado.
	 * @param pizza se llama como objeto pizza a la clase Producto para crear una variable que recoje los datos que escojio el usuario.
	 * @param validar  se llama a un metodo de la clase validar para comprobar si el dato igresado es valido en este caso un numero entero.
	 * @return retorna una variable pizza de la clase Producto con los datos obtenidos de este metodo.
	 * */
	public static Producto tamano(int opcion, Producto pizza, Validar validar) {
		do {
			System.out.println("¿Que tamaño desea? (Ingrese el numero correspondiente) \n1- Chica Valor $5000\n2- Mediana Valor $10000\n3- Grande Valor $15000");
			opcion= validar.validarEntero();
			switch (opcion) {
				case 1:
					pizza.setTamano("Chica");
					pizza.setPrecio(5000);
					break;
				case 2:
					pizza.setTamano("Mediana");
					pizza.setPrecio(10000);
					break;
				case 3:
					pizza.setTamano("Grande");
					pizza.setPrecio(15000);
					break;
				default:
					break;
			}
		}while(opcion == 0 || opcion > 3);
		return pizza;
	}

	/**
	 * Metodo que se encarga de interactuar con el usuario para que pueda ingresar sus datos.
	 * @return retorna una variable de tipo String con un texto con los datos ingresados por el usuario.
	 * */
	public static String registrarCliente(){
		Cliente cliente = new Cliente();
		Scanner teclado = new Scanner(System.in);
		Validar validar = new Validar();
		System.out.println("Ingrese su nombre de usuario");
		cliente.setNombre(teclado.nextLine());
		while (validar.validarUsuario(cliente.getNombre()) == false){
			System.out.println("no se ingreso un nombre ingrese nuevamente...");
			System.out.println("Ingrese su nombre completo");
			cliente.setNombre(teclado.nextLine());
		}
		System.out.println("Ingrese su mail (ejemplo: nombre@correo.com)");
		cliente.setMail(teclado.next());
		while (validar.validarMail(cliente.getMail()) == false){
			System.out.println("mail invalido ingrese nuevamente...");
			System.out.println("Ingrese su mail (ejemplo: nombre@correo.com)");
			cliente.setMail(teclado.next());
		}
		return cliente.toString();
	}

	public static String registrarClienteNombre(String nombre){
		Cliente cliente = new Cliente();
		Validar validar = new Validar();
		cliente.setNombre(nombre);
		while (validar.validarUsuario(cliente.getNombre()) == false){
			System.out.println("no se ingreso un nombre ingrese nuevamente...");
			System.out.println("Ingrese su nombre completo");
			cliente.setNombre(nombre);
		}
		return nombre;
	}
}