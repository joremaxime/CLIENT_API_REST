package eseo.dwic.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Servlet implementation class SupprimerVilleServlet
 */
@WebServlet(name = "SupprimerVille", urlPatterns = { "/SupprimerVille" })
public class SupprimerVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String URL_API_REST = "http://localhost:8181/";
	private static final String METHODE_DELETE = "delete";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerVilleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/CLIENT_API_REST/ListeVilles");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("codeCommuneINSEE") != null) {
			String codeCommuneINSEE = request.getParameter("codeCommuneINSEE");
			
			String url = URL_API_REST + METHODE_DELETE + "/" + codeCommuneINSEE;
						
			HttpClient client = HttpClientBuilder.create().build();
			HttpDelete httpDelete = new HttpDelete(url);
			client.execute(httpDelete);
		}
		
		doGet(request, response);
	}

}
