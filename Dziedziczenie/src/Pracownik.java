
public class Pracownik extends Osoba {
	private int PrzepracowaneGodziny;
	private float Stawka;
	
	public Pracownik() {
		PrzepracowaneGodziny = 0;
		Stawka = 0;
	}

	public Pracownik(String imie, String nazwisko, int stawka) {
		super(imie, nazwisko);
		Stawka = stawka;
		PrzepracowaneGodziny = 0;
	}
	
	public void DodajGodziny(int x) {
		PrzepracowaneGodziny = PrzepracowaneGodziny + x;
	}

	public void Wypisz() {
		super.Wypisz();
		
		System.out.println("Godziny: " + PrzepracowaneGodziny);
		System.out.println("Stawka/1h: " + Stawka);
	}
}
