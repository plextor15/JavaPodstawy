package Space_Impact;

public class TxT extends Engine {
	public String DoWyswietlenia;

	public TxT() {
		DoWyswietlenia = "";
	}

	public void View() {
		DoWyswietlenia = "";
		
		for (int i = 0; i < WysokoscWidok; i++){
			for (int j = 0; j < SzerokoscWidok; j++){
				DoWyswietlenia += MapaWidoczna[i][j];
			}
			
			if (i+1 != WysokoscWidok) {
				DoWyswietlenia += "\n";
			}
		}
	}
	//public void WyswietlTekst(String tekst) {}
	public void KoniecLevelu(boolean CzyWygrana) {
		DoWyswietlenia = "\n\n     ";
		
		if (CzyWygrana) {
			DoWyswietlenia += "Poziom ukonczony :)\n";
		}
		else{
			DoWyswietlenia += "Przegrana :(\n";
		}
		
		DoWyswietlenia = DoWyswietlenia + "     Uzyskano punktow: " + String.valueOf(GetPunktyLevel());
	}
}
