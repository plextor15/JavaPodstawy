package Space_Impact;

public class TxT extends Engine {
	public String DoWyswietlenia;
	public boolean czyWygral;

	public TxT() {
		DoWyswietlenia = "";
		czyWygral = true;
	}

	public void View() {
		DoWyswietlenia = "";
		
		for (int i = 0; i < WysokoscWidok; i++){
			for (int j = 0; j < SzerokoscWidok; j++){
				DoWyswietlenia += MapaWidoczna[i][j];
				System.out.print(MapaWidoczna[i][j]);
			}
			DoWyswietlenia += "\n";
			System.out.print("\n");
			//if (i+1 != WysokoscWidok) {
			//	DoWyswietlenia += "\n";
			//}
		}
		/*//Sleep
		try {
			Thread.sleep(ileKlatka);
		} catch (InterruptedException e) {
			System.out.println("Klatka nie pykla");
			e.printStackTrace();
		}*/
	}
	public void KoniecLevelu(boolean CzyWygrana) {
		czyWygral = CzyWygrana;
	}
}
