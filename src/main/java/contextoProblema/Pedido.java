package contextoProblema;

import GUIs.FormaPanel;
import GUIs.MainVentana;
import validar.Validar;
import javax.swing.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

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
	 * Metodo que se encarga de interactuar con el usuario para que pueda ingresar sus datos.
	 * @param nombre String que posee el nombre del Cliente.
	 * @param correo String que posee el el correo del Cliente.
	 * @return retorna String que guarda un texto con los datos ingresados por el usuario.
	 * */
	public static String registrarCliente(String nombre,String correo){
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setMail(correo);
			return cliente.toString();
		}
   	}