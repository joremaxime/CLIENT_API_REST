package eseo.dwic.beans;

public class Wind {

	private double speed;
	private double deg;

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getDeg() {
		return deg;
	}

	public void setDeg(double deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		return "Wind [speed=" + this.speed + ", deg=" + this.deg + "]";
	}

}
