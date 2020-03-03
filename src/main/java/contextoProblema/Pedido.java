package contextoProblema;

import validar.Validar;
import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {

	private static ArrayList<Producto> pizzas = new ArrayList<>();

	/**
	 * Metodo que se encarga de interactuar con el usuario para que pueda escoger la pizza que quiera y su tamaño.
	 * @return retorna una variable String que contiene un texto con lo que escojio el usuario.
	 * */
	public static String eleccionPizza(){
		Validar validar = new Validar();
		Producto pizza = new Producto();

		int opcion = 0;
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

		int opcion1 = 0;
		do {
			System.out.println("¿Que tamaño desea? (Ingrese el numero correspondiente) \n1- Chica Valor $5000\n2- Mediana Valor $10000\n3- Grande Valor $15000");
			opcion1 = validar.validarEntero();
			switch (opcion1) {
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
		}while(opcion1 == 0 || opcion1 > 3);

		pizzas.add(pizza);
		int contador = 0;
		while(contador<pizzas.size()){
			contador++;
		}
		pizza.setId(contador);
		String nuevaPizza = pizza.toString();
		return nuevaPizza;
	}

	/**
	 * Metodo que se encarga de interactuar con el usuario para que pueda ingresar sus datos.
	 * @return retorna una variable de tipo String con un texto con los datos ingresados por el usuario.
	 * */
	public static String registrarCliente(){
		Cliente cliente = new Cliente();
		Scanner teclado = new Scanner(System.in);
		Validar validar = new Validar();

		System.out.println("Ingrese su nombre completo");
		cliente.setNombre(teclado.nextLine());

		System.out.println("Ingrese su rut");
		cliente.setRun(teclado.next());
		while (validar.validarRut(cliente.getRun()) == false){
			System.out.println("rut invalido ingrese nuevamente");
			cliente.setRun(teclado.next());
		}

		String nuevoCliente = cliente.toString();
		return nuevoCliente;
	}
}