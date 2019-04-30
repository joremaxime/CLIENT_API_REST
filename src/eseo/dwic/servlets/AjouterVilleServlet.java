package eseo.dwic.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Servlet implementation class AjouterVilleServlet
 */
@WebServlet(name = "AjouterVille", urlPatterns = { "/AjouterVille" })
public class AjouterVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VUE_FORM = "/ajouterVille.jsp";
	private static final String URL_API_REST = "http://localhost:8181/";
	private static final String METHODE_POST = "post";
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterVilleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(VUE_FORM);
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("codeCommuneINSEE") != null && request.getParameter("nomCommune") != null &&
				request.getParameter("codePostal") != null && request.getParameter("libelleAcheminement") != null &&
				request.getParameter("ligne5") != null && request.getParameter("latitude") != null &&
				request.getParameter("longitude") != null) {

			String codeCommuneINSEE = deleteSpace(request.getParameter("codeCommuneINSEE"));
			String nomCommune = deleteSpace(request.getParameter("nomCommune"));
			String codePostal = deleteSpace(request.getParameter("codePostal"));
			String libelleAcheminement = deleteSpace(request.getParameter("libelleAcheminement"));
			String ligne5 = deleteSpace(request.getParameter("ligne5"));
			String latitude = deleteSpace(request.getParameter("latitude"));
			String longitude = deleteSpace(request.getParameter("longitude"));

			String url = URL_API_REST + METHODE_POST + "?codeCommuneINSEE=" + codeCommuneINSEE + "&nomCommune=" + nomCommune + 
					"&codePostal=" + codePostal + "&libelleAcheminement=" + libelleAcheminement +
					"&ligne5=" + ligne5 + "&latitude=" + latitude + "&longitude=" + longitude;
					
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost httpPost = new HttpPost(url);
			client.execute(httpPost);

			response.sendRedirect("/CLIENT_API_REST/ListeVilles");

		} else {
			doGet(request, response);
		}
	}

	private static String deleteSpace(String str) {
		return str.replaceAll(" ", "%20");
	}

}
