package eseo.dwic.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eseo.dwic.beans.Meteo;
import eseo.dwic.beans.VilleFrance;
import eseo.dwic.utilitaires.RestResponse;

/**
 * Servlet implementation class ListeVillesServlet
 */
@WebServlet(name = "ListeVilles", urlPatterns = { "/ListeVilles" })
public class ListeVillesServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_FORM = "/listeVilles.jsp";
	private static final String URL_API_REST = "http://localhost:8181/";
	private static final String METHODE_GET_WITH_PAGINATION = "getWithPagination";
	private static final String URL_API_METEO = "http://api.openweathermap.org/data/2.5/weather";
	private static final String URL_API_METEO_ICON = "http://openweathermap.org/img/w/";
	private static final String METEO_API_KEY = "05426f15f776f166460c18994709fde8";
	private static final double CONVERSION_KELVIN_TO_DEGREE = 273.15;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeVillesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = URL_API_REST + METHODE_GET_WITH_PAGINATION;

		List<VilleFrance> villesFrance = RestResponse.getAPIRestVillesFranceDeserialized(url + "?offset=0");

		for (VilleFrance villeFrance : villesFrance) {			
			String urlMeteo = URL_API_METEO + "?lat=" + villeFrance.getLatitude() + "&lon=" + villeFrance.getLongitude() + "&APPID=" + METEO_API_KEY;

			Meteo meteo = RestResponse.getAPIRestMeteoDeserialized(urlMeteo);
			double temperature = Math.round((meteo.getMain().getTemp() - CONVERSION_KELVIN_TO_DEGREE) * 100) / 100;
			villeFrance.setTemperature(temperature);
			villeFrance.setWeather(URL_API_METEO_ICON + meteo.getWeather().get(0).getIcon() + ".png");
			villeFrance.setWeatherDescription(meteo.getWeather().get(0).getDescription());
		}

		request.setAttribute("villesFrance", villesFrance);

		request.setAttribute("offset", 0);

		RequestDispatcher dispatch = request.getRequestDispatcher(VUE_FORM);
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int offset = (int) Integer.parseInt(request.getParameter("offset"));

			String url = URL_API_REST + METHODE_GET_WITH_PAGINATION;

			List<VilleFrance> villesFrance = RestResponse.getAPIRestVillesFranceDeserialized(url + "?offset=" + offset);

			for (VilleFrance villeFrance : villesFrance) {			
				String urlMeteo = URL_API_METEO + "?lat=" + villeFrance.getLatitude() + "&lon=" + villeFrance.getLongitude() + "&APPID=" + METEO_API_KEY;

				Meteo meteo = RestResponse.getAPIRestMeteoDeserialized(urlMeteo);
				double temperature = Math.round((meteo.getMain().getTemp() - CONVERSION_KELVIN_TO_DEGREE) * 100) / 100;
				villeFrance.setTemperature(temperature);
				villeFrance.setWeather(URL_API_METEO_ICON + meteo.getWeather().get(0).getIcon() + ".png");
				villeFrance.setWeatherDescription(meteo.getWeather().get(0).getDescription());
			}

			request.setAttribute("villesFrance", villesFrance);
			request.setAttribute("offset", offset);

			RequestDispatcher dispatch = request.getRequestDispatcher(VUE_FORM);
			dispatch.forward(request, response);
		} catch (Exception e) {
			doGet(request, response);
			throw new RuntimeException(e);
		}

	}

}
