package contextoProblema;

import java.util.ArrayList;


public class Pedido {

	private static ArrayList<Producto> pizzas = new ArrayList<>();

	/**
	 *Metodo que se encarga de enviar los datos al objeto de tipo Producto llamado pizzaPedida.
	 * @param tipoPizza String indica el tipo de pizza escogido.
	 * @param tamanoPizza String indica el tamaño que se escogio de pizza.
	 * @return un toString del objeto pizzaPedida
	 */
	public static String pizzaPedida(String tipoPizza, String tamanoPizza){
		Producto pizzaPedida = new Producto();
		if(tamanoPizza.equals("Pequeña $5000")){
			pizzaPedida.setTipoPizza(tipoPizza);
			pizzaPedida.setTamano("Pequeña");
			pizzaPedida.setPrecio(5000);
		}else if(tamanoPizza.equals("Mediana $10000")){
			pizzaPedida.setTipoPizza(tipoPizza);
			pizzaPedida.setTamano("Mediana");
			pizzaPedida.setPrecio(10000);
		}else if(tamanoPizza.equals("Grande $15000")){
			pizzaPedida.setTipoPizza(tipoPizza);
			pizzaPedida.setTamano("Grande");
			pizzaPedida.setPrecio(15000);
		}
		pizzas.add(pizzaPedida);
		int contador = 0;
		while(contador<pizzas.size()){
			contador++;
		}
		pizzaPedida.setId(contador);
		return pizzaPedida.toString();
	}

	/**
	 * Metodo que se encarga de registrar los datos recibos.
	 * @param nombre String que posee el nombre del Cliente.
	 * @param correo String que posee el el correo del Cliente.
	 * @return retorna String que guarda un texto con los datos registrados.
	 * */
	public static String registrarCliente(String nombre,String correo){
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setMail(correo);
		return cliente.toString();
		}
   	}