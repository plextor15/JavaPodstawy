package Space_Impact;

public class TxT extends Engine {
	public String DoWyswietlenia;
	public boolean czyWygral;

	public TxT() {
		DoWyswietlenia = "";
		czyWygral = false;
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
	public void KoniecLevelu(boolean CzyWygrana) {
		czyWygral = CzyWygrana;
	}
}
