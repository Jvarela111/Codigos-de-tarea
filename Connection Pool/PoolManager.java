package sql;

import java.sql.Connection;

public class PoolManager {
	
	private static final Singleton singleton = Singleton.InstanciaSingleton;
	public static int tamanoPoolInicial = singleton.getTamanoPoolInicial();
	public static int tamanoPoolMax = singleton.getTamanoPoolMax();
	public static int crecimiento = singleton.getCrecimiento();

    public synchronized void agregarConex() {
    	int conexionesTotales = getTotalConex();
    	
        if(conexionesTotales < tamanoPoolMax) {
            for (int i = 0; i < crecimiento; i ++) {
            	singleton.getConexionesDisp().add(createConex());
                System.out.println("El tamano actual de conexiones disponibles pool es de " + (conexionesTotales-9+i) + " conexiones");       
            }
        }
        else {
            System.out.println("Las conexiones han llegado al maximo (100) y no se pueden crear mas");
        }
    }

    public synchronized Connection getConex() {
        Connection connection = null;
        boolean conexionNoDisponible = singleton.getConexionesDisp().isEmpty();
        do {
            if (conexionNoDisponible) {
            	agregarConex();
            	
            	try {
            		System.out.println(Thread.currentThread() + " Esperando por conexiones disponibles");
                    Thread.sleep(1000);
                    
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                    }
            } else {
        	   
        	   connection = singleton.getConexionesDisp().get(0);
        	   singleton.getConexionesUsadas().add(connection); // Se agrega a la lista de conexiones utilizadas
        	   singleton.getConexionesDisp().remove(connection); // Se elimina de la lista de conexiones disponibles
        	   System.out.println("Cantidad de conexiones que hay actualmente para asignar: " + singleton.getConexionesDisp().size());
        	   
            }
            conexionNoDisponible = singleton.getConexionesDisp().isEmpty();
        } while(connection == null);
        return connection;
    }
    
    public void returnConex(Connection connection) {// Remueve y agrega la conexión de la lista de conexiones utilizadas
        singleton.getConexionesUsadas().remove(connection);
        singleton.getConexionesDisp().add(connection);
    }
    
    public Connection createConex() { return singleton.connectDB(); }
    
    public int getTotalConex() {
        return singleton.getConexionesDisp().size() + singleton.getConexionesUsadas().size();
    }

}
