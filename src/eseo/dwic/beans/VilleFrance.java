package eseo.dwic.beans;

public class VilleFrance {

	private String codeCommuneINSEE;
	private String nomCommune;
	private String codePostal;
	private String libelleAcheminement;
	private String ligne5;
	private String latitude;
	private String longitude;
	private boolean isActive;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
		return "VilleFrance [codeCommuneINSEE=" + codeCommuneINSEE + ", nomCommune=" + nomCommune + ", codePostal="
				+ codePostal + ", libelleAcheminement=" + libelleAcheminement + ", ligne5=" + ligne5 + ", latitude="
				+ latitude + ", longitude=" + longitude + ", isActive=" + isActive + ", temperature=" + temperature
				+ ", weather=" + weather + ", weatherDescription=" + weatherDescription + "]";
	}

}
