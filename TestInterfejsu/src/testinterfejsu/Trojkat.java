package testinterfejsu;

public class Trojkat implements Figura {
	public double a, b, c;
	public double h;
	
	public Trojkat(double x, double y) {
		a = x;
		h = y;
	}
	
	public String getNazwa() {
		return "trojkat";
	}
	public double getPole() {
		return ( a * h ) / 2;
	}
	public double getObwod() {
		return a + b + c;
	}
	public int getKrawedzie() {
		return 3;
	}
}
