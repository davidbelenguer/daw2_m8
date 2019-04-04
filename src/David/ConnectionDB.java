package David;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {

	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:file:C:\\Users\\super\\eclipse-workspace\\M08\\WebContent\\WEB-INF\\lib\\srv_db.tmp";
	public static Connection getConnection() {
	    final Logger LOGGER = Logger.getLogger("David");

		Connection conec = null;
		try {
			Class.forName(DRIVER);
			conec=DriverManager.getConnection(URL, "sa","");
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.log(Level.SEVERE,e.toString());
		}
		return conec;
	}
	private ConnectionDB() {
		super();
	}
	
}
