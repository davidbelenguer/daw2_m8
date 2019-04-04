package David;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:file:C:\\Users\\super\\eclipse-workspace\\M08\\WebContent\\WEB-INF\\lib\\srv_db.tmp";
	public static Connection getConnection() {
		Connection conec = null;
		try {
			Class.forName(DRIVER);
			conec=DriverManager.getConnection(URL, "sa","");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error"+e);
		}
		return conec;
	}
	private ConnectionDB() {
		super();
	}
	
}
