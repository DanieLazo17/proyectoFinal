package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public String driver = "com.mysql.cj.jdbc.Driver";
	
    public Connection getConnection(){  
        Connection conexion = null;
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MpgHOHRoVu",
                    "MpgHOHRoVu","k8rJHUYKXJ");
            System.out.println("Conexión establecida");
        }catch(ClassNotFoundException | SQLException e){
        	System.out.println("Error de conexión");
            System.out.println(e.toString());
        }       
        return conexion;
    }
	
	/*
	protected Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/";
    private final String BASE_DATO = "codoacodo";
    private final String USER = "root";
    private final String PASS = "";

    public void conectar() throws Exception {
        try {
        	System.out.println("1");
            Class.forName(JDBC_DRIVER);
            System.out.println("2");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/codoacodo", "root", "");
            System.out.println("3");
            System.out.println("Conexión establecida");
        } catch(Exception e) {
            System.out.println("Error de conexión");
            throw e;
        }
    }

    public void cerrar() throws SQLException {

        if (conexion != null) {
            if (!conexion.isClosed()) {
            	conexion.close();
                System.out.println("Conexión cerrada");
            }
        }
    }
    */
}
