package interfaces;

import java.util.List;
import modelo.Jugador;

public interface IJugador {
	
	public List<Jugador> formar();
    public Jugador buscar(int id);
    public boolean agregar(Jugador j);
    public boolean editar(Jugador j);
    public boolean eliminar(int id);
    
}
