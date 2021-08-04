package modelo;

public class Jugador {

	private int id;
    private String nombre;
    private String apellido;
    private int posicion;
    private String club;
    
	public Jugador(int id, String nombre, String apellido, int posicion, String club) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.posicion = posicion;
		this.club = club;
	}

	public Jugador(String nombre, String apellido, int posicion, String club) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.posicion = posicion;
		this.club = club;
	}

	public Jugador() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", posicion=" + posicion
				+ ", club=" + club + "]";
	}
    
    
}
