package contextoProblema;

public class Producto {

	private int id;
	private String tipoPizza;
	private double precio;
	private String tamano;

    public Producto() {
    }

	/**
	 * @param id
	 * */
	public void setId(int id) { this.id = id; }

	public int getId() { return id; }

	/**
	 * @param tipoPizza
	 */
	public void setTipoPizza(String tipoPizza) {
		this.tipoPizza = tipoPizza;
	}

	public String getTipoPizza() { return this.tipoPizza; }

	/**
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() { return this.precio; }

	/**
	 * @param tamano
	 */
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getTamano() { return this.tamano; }

	@Override
	public String toString() {
		return "Producto: {" +
				"Id = " + id +
				", \nTipo de Pizza = '" + tipoPizza + '\'' +
				", \nPrecio = " + precio +
				", \nTamaño ='" + tamano + '\'' +
				'}';
	}
}