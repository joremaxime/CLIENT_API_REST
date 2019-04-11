package eseo.dwic.beans;

public class VilleFrance {

	private String codeCommuneINSEE;
	private String nomCommune;
	private String codePostal;
	private String libelleAcheminement;
	private String ligne5;
	private String latitude;
	private String longitude;
	private double temperature;
	private String weather;
	private String weatherDescription;
	
	public VilleFrance() {
		super();
	}

	public String getCodeCommuneINSEE() {
		return codeCommuneINSEE;
	}

	public void setCodeCommuneINSEE(String codeCommuneINSEE) {
		this.codeCommuneINSEE = codeCommuneINSEE;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public String getLigne5() {
		return ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	@Override
	public String toString() {
		return "VilleFrance [codeCommuneINSEE=" + this.codeCommuneINSEE + ", nomCommune=" + this.nomCommune + ", codePostal=" + this.codePostal + ", libelleAcheminement=" + this.libelleAcheminement + ", ligne5=" + this.ligne5 + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", temperature=" + this.temperature + ", weather=" + this.weather + ", weatherDescription=" + this.weatherDescription + "]";
	}
	
}
