package controlador;

import java.sql.Connection;

import conexion.Conexion;

public class Prueba {

	public static void main(String[] args) throws Exception {
		Connection conexion;
		Conexion con = new Conexion(); 
		conexion = con.getConnection();
        conexion.close();
    }
}
