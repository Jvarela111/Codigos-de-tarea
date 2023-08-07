package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class conexionBD {
	String url = "jdbc:postgresql://localhost:5432/UruBD";
	String password = "0420";
	String pg = "postgres";
	
	Connection ConexionDB = null;
	
	public conexionBD() {
		try {
			ConexionDB = DriverManager.getConnection(url, pg, password);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectarse con la Base de Datos");
		}
		
		
	}
	
	public Connection getConnection() {
		return ConexionDB;
	}
	
	public void desconex() {
		ConexionDB = null;
	}
}