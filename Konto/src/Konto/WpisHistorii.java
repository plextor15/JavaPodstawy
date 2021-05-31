package Konto;

public class WpisHistorii {
	public String Opis;
	public boolean CzyWplata;
	public float Ile;
	
	WpisHistorii(String opis, boolean czywplata, float ile) {
		Opis = opis;
		if (czywplata) {
			CzyWplata = true;
			Ile = ile;
		} else {
			CzyWplata = false;
			Ile = ile;
		}
	}
}
