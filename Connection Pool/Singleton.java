package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public enum Singleton { 
	//Para instanciar el Singleton
	InstanciaSingleton;
	
	//Arraylist para llamar las conexiones disponibles y usadas
	public List<Connection> getConexionesDisp() { return conexionesDisp; }
	public List<Connection> getConexionesUsadas() { return conexionesUsadas; }
    
	//Arraylist para almacenar las conexiones disponibles y usadas
    private List<Connection> conexionesDisp = new ArrayList<>();
    private List<Connection> conexionesUsadas = new ArrayList<>();
    
    //Variables del archivo .properties
    private Properties properties = new Properties();
    private int tamanoMax;
    private int crecimiento;
    private int tamanoPoolInicial;
    
    Connection connection;
    
    //Datos para conectarse a la Base de datos
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USUARIO = "postgres";
    private final String CONTRA = "1234";

    private Singleton() {
    	try {
    	properties.load(new FileInputStream("src/sql/config.properties"));
        tamanoMax = Integer.parseInt(properties.getProperty("tamanoMax"));
        crecimiento = Integer.parseInt(properties.getProperty("crecimiento"));
        tamanoPoolInicial = Integer.parseInt(properties.getProperty("tamanoPoolInicial"));
        
    	} catch (IOException e) {
        e.printStackTrace();
    	}
    	
    	for (int i = 0; i < tamanoPoolInicial; i++) {
            	 conexionesDisp.add(connectDB());
            }
    }
  
    public Connection connectDB() {
        try {
            connection = DriverManager.getConnection(URL, USUARIO, CONTRA);
            System.out.println("Conexion creada " + (conexionesDisp.size() + 1));
            return connection;
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public int getTamanoPoolMax() { return tamanoMax; }
    public int getCrecimiento() { return crecimiento; }
    public int getTamanoPoolInicial() { return tamanoPoolInicial; }
}