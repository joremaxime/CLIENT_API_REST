package eseo.dwic.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eseo.dwic.beans.VilleFrance;
import eseo.dwic.utilitaires.RestResponse;


/**
 * Servlet implementation class DistancesServlet
 */
@WebServlet(name = "Distances", urlPatterns = { "/Distances" })
public class DistancesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_FORM = "/distances.jsp";
	private static final String URL_API_REST = "http://localhost:8181/";
	private static final String METHODE_GET = "get";
	private static final int RAYON_TERRESTRE = 6367445;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistancesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = URL_API_REST + METHODE_GET;
		
		ArrayList<VilleFrance> villesFrance = RestResponse.getAPIRestVillesFranceDeserialized(url);
		request.setAttribute("villesFrance", villesFrance);
		
		RequestDispatcher dispatch = request.getRequestDispatcher(VUE_FORM);
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeCommuneINSEEVilleA = request.getParameter("villeA");
		String codeCommuneINSEEVilleB = request.getParameter("villeB");
		
		if (codeCommuneINSEEVilleA != null && codeCommuneINSEEVilleB != null) {
			String url = URL_API_REST + METHODE_GET;
			
			VilleFrance villeFranceA = RestResponse.getAPIRestVillesFranceDeserialized(url + "?codeCommuneINSEE=" + codeCommuneINSEEVilleA).get(0);
			VilleFrance villeFranceB = RestResponse.getAPIRestVillesFranceDeserialized(url + "?codeCommuneINSEE=" + codeCommuneINSEEVilleB).get(0);
			
			request.setAttribute("villeFranceA", villeFranceA);
			request.setAttribute("villeFranceB", villeFranceB);
			
			double distance = calculerDistance(villeFranceA, villeFranceB);
			
			request.setAttribute("distance", distance);
			request.setAttribute("displayDistance", true);
		
		}
		
		doGet(request, response);
	}
	
	private static double calculerDistance(VilleFrance villeFranceA, VilleFrance villeFranceB) {
		double latitudeA = (double) Double.parseDouble(villeFranceA.getLatitude());
		double latitudeB = (double) Double.parseDouble(villeFranceB.getLatitude());
		double longitudeA = (double) Double.parseDouble(villeFranceA.getLongitude());
		double longitudeB = (double) Double.parseDouble(villeFranceB.getLongitude());
		
		double distance = RAYON_TERRESTRE * Math.acos(Math.sin(latitudeA)*Math.sin(latitudeB) + Math.cos(latitudeA)*Math.cos(latitudeB)*Math.cos(longitudeA - longitudeB));
		
		return Math.round((distance / 1000) * 100) / 100;
	}
	
}
