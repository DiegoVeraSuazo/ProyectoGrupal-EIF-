package contextoProblema;

public class Cliente {

	private String nombre;
	private String run;

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
	 * @param run
	 */
	public void setRun(String run) {
		this.run = run;
	}

	public String getRun() { return this.run; }

	@Override
    public String toString() {
        return "Cliente: {" +
                "Nombre='" + nombre + '\'' +
                ", R.U.N='" + run + '\'' +
                '}';
    }
}