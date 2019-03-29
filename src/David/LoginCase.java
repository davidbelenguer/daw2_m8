package David;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginCase {

	public static boolean insertUser;

	/* CREATE TABLE */
	public static boolean insertUser(String uName, String uPass, String uEmail) {
		Connection con;
		con = ConnectionDB.getConnection();
		Connection conectionNick;
		conectionNick = ConnectionDB.getConnection();
		PreparedStatement pss = null;
		PreparedStatement nick = null;

		try {
			String consultaNick = "select * from users where nick=?;";
			nick = conectionNick.prepareStatement(consultaNick);
			nick.setString(1, uName);
			ResultSet Respuesta = nick.executeQuery();

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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pss != null) {
					pss.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeAll(nick, pss);
		}
		return false;
	}

	private static void closeAll(PreparedStatement nick, PreparedStatement pss) {
		if (nick != null) {
			try {
				nick.close();
			} catch (Exception e) {
			}
		}
		if (pss != null) {
			try {
				pss.close();
			} catch (Exception e) {
				
			}
		}

	}

//	private void closeAll(ResultSet rs, Statement st, Connection cnx) {
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (Exception ex) {
//			}
//		}
//		if (st != null) {
//			try {
//				st.close();
//			} catch (Exception ex) {
//			}
//		}
//		if (cnx != null) {
//			try {
//				cnx.close();
//			} catch (Exception ex) {
//			}
//		}
//	}
}
