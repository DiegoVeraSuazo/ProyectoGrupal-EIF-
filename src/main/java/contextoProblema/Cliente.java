package contextoProblema;

public class Cliente {

	private String nombre;
	private String mail;

	public Cliente() {
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() { return this.nombre; }

	/**
	 * @param mail
	 */
	public void setRun(String mail) {
		this.mail = mail;
	}

	public String getRun() { return this.mail; }

	@Override
    public String toString() {
        return "Cliente: {" +
                "Nombre='" + nombre + '\'' +
                ", Mail='" + mail + '\'' +
                '}';
    }
}