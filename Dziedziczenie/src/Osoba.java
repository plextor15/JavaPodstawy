
public class Osoba {
	private String imie;
	private String nazwisko;
	
	//settery i gettery
	
	Osoba(){
		imie = new String("");
		nazwisko = new String("");
	}
	
	Osoba(String imie, String nazwisko){
		this.imie = imie;
		this.nazwisko = nazwisko;
	}
	
	void Wypisz() {
		System.out.println(imie + " " + nazwisko);
	}
}
