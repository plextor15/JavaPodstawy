package testinterfejsu;

public class Kwadrat implements Figura {
	public double A;
	
	public Kwadrat(double x) {
		A = x;
	}
	
	public String getNazwa() {
		return "kwadrat";
	}
	public double getPole() {
		return A * A;
	}
	public double getObwod() {
		return A * 4;
	}
	public int getKrawedzie() {
		return 4;
	}
}
