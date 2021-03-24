
public class Dziedziczenie {

	public static void main(String[] args) {
		Osoba X = new Osoba("Avok", "Wolfik");
		X.Wypisz();
		System.out.println("");
		
		Pracownik Y = new Pracownik("Adak", "Wolfikous", 15);
		Y.Wypisz();
		System.out.println("");
		
		Pracownik Z = new Pracownik();
		Z = Y;
		Z.DodajGodziny(100);
		Z.Wypisz();
		
		return;
	}

}
