package eseo.dwic.beans;

public class Sys {
	
	private int type;
	private int id;
	private float message;
	private String country;
	private int sunrise;
	private int sunset;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMessage() {
		return message;
	}

	public void setMessage(float message) {
		this.message = message;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getSunrise() {
		return sunrise;
	}

	public void setSunrise(int sunrise) {
		this.sunrise = sunrise;
	}

	public int getSunset() {
		return sunset;
	}

	public void setSunset(int sunset) {
		this.sunset = sunset;
	}

	@Override
	public String toString() {
		return "Sys" + this.type + ", id=" + this.id + ", message=" + this.message + ", country=" + this.country + ", sunrise=" + this.sunrise + ", sunset=" + this.sunset + "]";
	}

}
