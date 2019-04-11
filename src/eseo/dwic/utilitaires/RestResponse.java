package eseo.dwic.utilitaires;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import eseo.dwic.beans.Meteo;
import eseo.dwic.beans.VilleFrance;

public class RestResponse {
	
	public static ArrayList<VilleFrance> getAPIRestVillesFranceDeserialized(String url) throws IOException {
		String response = getAPIRestResponse(url);
		
		ArrayList<VilleFrance> villesFrance = new ArrayList<VilleFrance>();
		
		Gson gson = new Gson();
		Type villeFranceListType = new TypeToken<ArrayList<VilleFrance>>(){}.getType();
		villesFrance = gson.fromJson(response, villeFranceListType);
		
		return villesFrance;
	}
	
	public static Meteo getAPIRestMeteoDeserialized(String url) throws IOException {
		String meteoResponse = getAPIRestResponse(url);
		
		Gson gson = new Gson();
		Meteo meteo = gson.fromJson(meteoResponse, Meteo.class);
		
		return meteo;
	}
	
	private static String getAPIRestResponse(String url) throws IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = client.execute(httpGet);
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		return result.toString();
	}
	
}
