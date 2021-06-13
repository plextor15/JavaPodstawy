package Space_Impact;

import Space_Impact.GameObject.Typ;

public class Level {
	enum Kierunek{
		GORA,
		DOL,
		PRAWO,
		LEWO
	}
	
	public int Wysokosc;
	public int Szerokosc;
	public int WysokoscWidok;
	public int SzerokoscWidok;
	
	public int GraczWys;
	public int GraczSzer;
	
	public GameObject[][] Mapa;
	public char[][] MapaWidoczna;
	
	public GameObject TPustka;
	public GameObject TStatyczny;
	public GameObject TWrog;
	public GameObject TGracz;
	
	public int PunktyLevel;
	
	public Level() {
		Szerokosc = 0;
		Wysokosc = 0;
		SzerokoscWidok = 0;
		WysokoscWidok = 0;
		GraczSzer = 0;
		GraczWys = 0;
		PunktyLevel = 0;
		
		TPustka = new GameObject(' ', Typ.pusty, 0);
		TStatyczny = new GameObject('#', Typ.statyczny, 1000);
		TWrog = new GameObject('<', Typ.wrog, 10);
		TGracz = new GameObject('>', Typ.gracz, 4);
	}
	
	//private boolean Noclip(int wys) {
	//	if (wys > Wysokosc || wys < 0) {
	//		return true;
	//	}
	//	else{
	//		return false;
	//	}
	//}
	private void PrzesunGracza(int wysCel, int szerCel) {
		if (wysCel < 0 || wysCel > Wysokosc-1){
			return;
		}
		if (szerCel < 0 || szerCel > Szerokosc - 1) {
			return;
		}

		Mapa[wysCel][szerCel] = Mapa[GraczWys][GraczSzer];
		Mapa[GraczWys][GraczSzer] = TPustka;

		GraczWys = wysCel;
		GraczSzer = szerCel;
	}
	
	public void SetWidocznyRozmiar(int wys, int szer) {
		if (wys < Wysokosc && szer < Szerokosc) {
			WysokoscWidok = wys;
			SzerokoscWidok = szer;
		}
	}
	public int GetPunktyLevel() { 
		return PunktyLevel;
	}
	public void PrzesunObjekt(int wysOb, int szerOb, int wysCel, int szerCel) {
		Mapa[wysCel][szerCel] = Mapa[wysOb][szerOb];
		Mapa[wysOb][szerOb] = TPustka;
	}
	public void PrzesunGracza(int oIle, Kierunek wKtoraStrone) {
		switch (wKtoraStrone){
		case GORA:
			PrzesunGracza(GraczWys + oIle,GraczSzer);
			break;
		case DOL:
			PrzesunGracza(GraczWys - oIle, GraczSzer);
			break;
		case PRAWO:
			PrzesunGracza(GraczWys, GraczSzer + oIle);
			break;
		case LEWO:
			PrzesunGracza(GraczWys, GraczSzer - oIle);
			break;
		default: break;
		}
	}
	public Typ Kolizja(int wys, int szer) {
		Typ co = Mapa[wys][szer].Tag;

		switch (co) {
		case pusty: return co;
		case statyczny: return co;
		case wrog: return co;
		case gracz: return co;

		default:
			co = Typ.pusty;
			return co;
		}
	}
	int GraczUderzylW(Kierunek A) {
		int x = 0, y = 0;
		Typ UderzylW;
		
		switch (A){
		/*case GORA: y = 1;
			break;
		case DOL: y = -1;
			break;
		case PRAWO: x = 1;
			break;
		case LEWO: x = -1;
			break;*/
		default: break;
		}
		
		UderzylW = Kolizja(GraczWys + y, GraczSzer + x);

		if (UderzylW == Typ.statyczny){
			return 1;
		} else if (UderzylW == Typ.wrog) {
			return 2;
		} else {
			return 0;
		}
	}
	void ZniszczenieObiektu(int wysCel, int szerCel) {
		if (Kolizja(wysCel, szerCel) == Typ.wrog){
			PunktyLevel += 10;
		}
	}
	int GetPunktyZaWroga() {
		return TWrog.Zdrowie;
	}
}
