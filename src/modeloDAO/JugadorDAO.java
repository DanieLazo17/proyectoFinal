package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import interfaces.IJugador;
import modelo.Jugador;

public class JugadorDAO implements IJugador {

	Connection conexion;

	public JugadorDAO(){
	     Conexion con = new Conexion(); 
	     conexion = con.getConnection();
	}

	@Override
	public List<Jugador> formar() {

		List<Jugador> listaJugadores = new ArrayList<>();
		try {
			
			PreparedStatement ps = conexion.prepareStatement("SELECT * FROM jugador");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Jugador jug = new Jugador(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("posicion"), rs.getString("club"));
				listaJugadores.add(jug);
			}
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error al formar jugadores");
		}

		return listaJugadores;
	}

	@Override
	public Jugador buscar(int id) {

		Jugador jug = new Jugador();

		try {
			
			PreparedStatement ps = conexion.prepareStatement("SELECT * FROM jugador WHERE id=" + id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				jug.setId(id);
				jug.setNombre(rs.getString("nombre"));
				jug.setApellido(rs.getString("apellido"));
				jug.setPosicion(rs.getInt("posicion"));
				jug.setClub(rs.getString("club"));
			}
			
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error al buscar jugador");
		}

		return jug;
	}

	@Override
	public boolean agregar(Jugador j) {

		Boolean estado = false;

		try {
				
			PreparedStatement st = conexion.prepareStatement("INSERT INTO jugador(nombre,apellido,posicion,club) VALUES (?,?,?,?)");
			
			st.setString(1, j.getNombre());
			st.setString(2, j.getApellido());
			st.setInt(3, j.getPosicion());
			st.setString(4, j.getClub());
			st.execute();
			
			estado = true;
			
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error al agregar jugador");
		}
		return estado;
	}

	@Override
	public boolean editar(Jugador j) {

		Boolean estado = false;

		try {
			
			PreparedStatement st = conexion.prepareStatement("UPDATE jugador SET nombre=?, apellido=?, posicion=?, club=? WHERE id=?");
			
			st.setString(1, j.getNombre());
			st.setString(2, j.getApellido());
			st.setInt(3, j.getPosicion());
			st.setString(4, j.getClub());
			st.setInt(5, j.getId());
			
			st.executeUpdate();
			estado = true;
			
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error al editar jugador");
		}
		return estado;
	}

	@Override
	public boolean eliminar(int id) {

		Boolean estado = false;

		try {
			
			String statementSql = "UPDATE jugador SET nombre=?, apellido=?, posicion=?, club=? WHERE id=?";
			PreparedStatement st = conexion.prepareStatement(statementSql);
			
			
			st.setString(1, "");
			st.setString(2, "");
			st.setInt(3, 0);
			st.setString(4, "");
			st.setInt(5, id);
			
			
			st.executeUpdate();
			
			estado = true;
			
			//conexion.close();
		} catch (Exception e) {
			System.out.println("Error al eliminar jugador");
		}
		return estado;
	}

}
