package eseo.dwic.beans;

import java.util.ArrayList;

public class Meteo {

	private Coord coord;
	private ArrayList<Weather> weather;
	private String base;
	private Main main;
	private String visibility;
	private Wind wind;
	private Clouds clouds;
	private int dt;	
	private Sys sys;
	private int id;
	private String name;
	private int cod;
	
	public Coord getCoord() {
		return coord;
	}
	
	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public ArrayList<Weather> getWeather() {
		return weather;
	}

	public void setWeather(ArrayList<Weather> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public int getDt() {
		return dt;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return "Meteo [coord=" + this.coord.toString() + ", weather=" + this.weather + ", base=" + this.base + ", main=" + this.main.toString() + ","
				+ " visibility=" + this.visibility + ", wind=" + this.wind.toString() + ", clouds=" + this.clouds.toString() + ","
						+ " dt=" + this.dt + ", sys=" + this.sys.toString() + ", id=" + this.id + ", name=" + this.name + ", cod=" + this.cod + "]";
	}
	
}
