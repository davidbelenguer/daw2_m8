package David;

/**
 * 
 * @author David Belenguer
 *
 */
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionDB {

	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:file:C:\\Users\\super\\eclipse-workspace\\M08\\WebContent\\WEB-INF\\lib\\srv_db.tmp";
	
	
	public static Connection getConnection() {
		/**
		 * @param LOGGER
		 * @param prop
		 * @param is
		 * @param us
		 * @param pass
		 * @param conec
		 * @return
		 */
		
		/**
		 * Este es el metodo para conectarnos a la base de datos,
		 * con su contrase�a y usuario que le corresponde. Estos datos
		 * estan en un fichero aparte, apra tener m�s seguridad
		 */
	    final Logger LOGGER = Logger.getLogger("David");
	    Properties prop = new Properties();
		FileReader is = null;
		/**
		 * Aqui leemos el fichero properties que hemos externalizado 
		 * de nuestro codigo, para tener m�s seguridad.
		 */
		try {
			is = new FileReader("/datos.properties");
			prop.load(is);
		} catch(IOException e) {
			LOGGER.log(Level.SEVERE,e.toString());
		}
	    //Variables para la conexion
	    String us = (prop.getProperty("usuario"));
	    String pass = (prop.getProperty("contrase�a"));
	    
		Connection conec = null;
		try {
			Class.forName(DRIVER);
			
			conec=DriverManager.getConnection(URL, us,pass);
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.log(Level.SEVERE,e.toString());
		}
		return conec;
	}
	private ConnectionDB() {
		/** 
		 * Esto es el constructor por defecto de la clase.
		 */
		super();
	}
	
}
