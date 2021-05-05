import java.io.Serializable;

public class Student implements Serializable {
	String imie;
	String nazwisko;
	
	
	String Przedmioty[] = new String[10];
	int licznik;
	
	Student(String imie, String nazwisko){
		this.imie = imie;
		this.nazwisko = nazwisko;
	}
	
	public String toString() {
		return imie + " " + nazwisko + " ";
	}
}
