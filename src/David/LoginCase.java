package David;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author David Belenguer
 *
 */

public class LoginCase {
	
	private LoginCase(){
		//Constructor LoginCase
	}

	/* CREATE TABLE */
	/**
	 * @param uName
	 * @param uPass
	 * @param uEmail
	 * @return
	 * @throws SQLException
	 */
	public static boolean insertUser(String uName, String uPass, String uEmail) throws SQLException {
		/**
		 * Esta funcion la utilizaremos para insertar usuario en nuestra base de datos.
		 */
		Connection con;
		con = ConnectionDB.getConnection();
		Connection conectionNick;
		PreparedStatement pss = null;
		PreparedStatement nick = null;
		conectionNick = ConnectionDB.getConnection();

		try {
			String consultaNick = "select * from users where nick=?;";
			nick = conectionNick.prepareStatement(consultaNick);
			nick.setString(1, uName);

			try (ResultSet Respuesta = nick.executeQuery()) {
				if (Respuesta.next()) {
					return false;
				} else {
					String consulta = "insert into users (NICK,PASS,EMAIL) VALUES (?,?,?);";
					pss = con.prepareStatement(consulta);
					pss.setString(1, uName);
					pss.setString(2, uPass);
					pss.setString(3, uEmail);
					con.commit();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pss != null) {
				try {
					pss.close();
				} catch (Exception e2) {
					//Exepcion 2
				}
			}
			if (nick != null) {
				try {
					nick.close();
				} catch (Exception e3) {
					//Exepcion 3
				}
			}
		}
		return false;
	}
}