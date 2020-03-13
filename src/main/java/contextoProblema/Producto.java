package contextoProblema;

public class Producto {

	private int id;
	private String tipoPizza;
	private double precio;
	private String tamano;

    public Producto() {
    }

	public int getId() {
		return id;
	}

	/**
	 * @param id
	 * */
	public void setId(int id) {
		this.id = id;
	}

	public String getTipoPizza() {
		return this.tipoPizza;
	}

	/**
	 * @param tipoPizza
	 */
	public void setTipoPizza(String tipoPizza) {
		this.tipoPizza = tipoPizza;
	}

	public double getPrecio() {
		return this.precio;
	}

	/**
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTamano() {
		return this.tamano;
	}

	/**
	 * @param tamano
	 */
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	@Override
	public String toString() {
		return "Producto: {" +
				"id=" + id +
				", tipo de Pizza='" + tipoPizza + '\'' +
				", precio=" + precio +
				", tamaño='" + tamano + '\'' +
				'}';
	}
}