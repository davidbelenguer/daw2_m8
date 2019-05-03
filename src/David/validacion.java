package David;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class validacion
 */
/**
 * 
 * @author David Belenguer
 *
 */
@WebServlet("/validacion")
public class validacion extends HttpServlet {
	Properties prop = new Properties();
	FileReader is = null;
	
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validacion() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final Logger LOGGER = Logger.getLogger("David");
		
		try {
			is = new FileReader("datos.properties");
			prop.load(is);
		} catch(IOException e) {
			LOGGER.log(Level.SEVERE,e.toString());
		}
		Pattern pat1 = Pattern.compile((prop.getProperty("servidor_nik")));
		
		String email = request.getParameter("email");
		String nik = request.getParameter("nombre");
		String pass = request.getParameter("contra");
		
		
		Matcher mat1 = pat1.matcher(nik);
		
		Pattern pat = Pattern.compile((prop.getProperty("servidor_email")));
		Matcher mat = pat.matcher(email);
		
		Pattern pat2 = Pattern.compile((prop.getProperty("servidor_pa")));
		Matcher mat2 = pat2.matcher(pass);
		

		if (mat.find()) {
			if (mat1.find()) {
				if (mat2.find()) {
					ConnectionDB.getConnection();
					try {
						LoginCase.insertUser(nik, pass, email);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						if (LoginCase.insertUser(nik, pass, email) == true) {
							getServletContext().getRequestDispatcher("/html/ok.html").forward(request, response);
						}else {
							getServletContext().getRequestDispatcher("/html/UserRegistrado.html").forward(request, response);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else {
					getServletContext().getRequestDispatcher("/html/ErrorPass.html").forward(request, response);
				}
			}else {
				getServletContext().getRequestDispatcher("/html/ErrorNick.html").forward(request, response);
			}
		}else {
			getServletContext().getRequestDispatcher("/html/ErrorMail.html").forward(request, response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
