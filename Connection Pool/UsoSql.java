package sql;

import java.sql.*;

public class UsoSql extends Thread {

    public UsoSql (PoolManager poolManager) {
        this.poolManager = poolManager;
    }

    private PoolManager poolManager;
    
    @Override
    public void run() {
    	Connection connection = null;
    	PreparedStatement stmt = null;
        try {
        	
            connection = poolManager.getConex();
            stmt = connection.prepareStatement("SELECT * FROM productos limit 1");
            ResultSet rs = stmt.executeQuery();
            Thread.sleep(10000);
            while (rs.next()) {
                String textoPrueba = rs.getString(2);
                System.out.println("nombre: " + textoPrueba + "\n");
            }
        } catch (Exception e){
            e.printStackTrace();
            
        } finally {
            // Se devuelve la conexión al PoolManager en cualquier caso (éxito o error)
            if (connection != null) {
                poolManager.returnConex(connection);
            }
        }
    }
}