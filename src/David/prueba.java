package David;
/**
 * 
 * @author David Belenguer
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
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
 * Servlet implementation class prueba
 */


@WebServlet("/prueba")
public class prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Properties prop = new Properties();
	InputStream is = null;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public prueba() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final Logger LOGGER = Logger.getLogger("David");
		/**
		 * Aqui leemos el fichero properties que hemos externalizado 
		 * de nuestro codigo, para tener más seguridad.
		 */
		try {
			is = new FileInputStream("configuracion.properties");
			prop.load(is);
		} catch(IOException e) {
			LOGGER.log(Level.SEVERE,e.toString());
		}
		/**
		 * variables que utilizaremos en esta clase.
		 */
		String email = request.getParameter("email");
		Pattern pat = Pattern.compile((prop.getProperty("servidor.email")));
	
		Matcher mat = pat.matcher(email);
		
		if (mat.matches()) {
			getServletContext().getRequestDispatcher("/html/ok.html").forward(request, response);
		} else {
			
			getServletContext().getRequestDispatcher("/html/error.html").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doGet(request, response);
	}

}
