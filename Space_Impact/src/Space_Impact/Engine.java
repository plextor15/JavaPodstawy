package Space_Impact;

//import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.StringReader;
import java.util.Scanner;

import Space_Impact.GameObject.Typ;

public abstract class Engine extends Level {
	public boolean exit = false;
	public char key = '`';
	public boolean WcisnietoKlawisz;
	public int ileKlatka = 300;
	public int Postep;
	
	public Engine() {
		key = '`';
		Postep = 0;
		WcisnietoKlawisz = false;
	}
	
	public void Sterow() {
		//if (!WcisnietoKlawisz) {
		//	key = 'd';
		//}

		int WcoUderzylGracz = 0;
		switch (key) {
		case 's':
			WcoUderzylGracz = GraczUderzylW(Kierunek.GORA);
			break;
		case 'w':
			WcoUderzylGracz = GraczUderzylW(Kierunek.DOL);
			break;
		case 'd':
			WcoUderzylGracz = GraczUderzylW(Kierunek.PRAWO);
			break;
		case 'a':
			WcoUderzylGracz = GraczUderzylW(Kierunek.LEWO);
			break;
		default:break;
		}

		GraczWCosUderzyl(WcoUderzylGracz);

		switch (key) {
		case 's':
			PrzesunGracza(1, Kierunek.GORA);
			break;
		case 'w':
			PrzesunGracza(1, Kierunek.DOL);
			break;
		case 'd':
			PrzesunGracza(1, Kierunek.PRAWO);
			break;
		case 'a':
			if (Postep != GraczSzer) {
				PrzesunGracza(1, Kierunek.LEWO);
			}
			break;
		case 'q':
			exit = true;
			break;

		case '.':
			ileKlatka += 50;
			break;
		case ',':
			ileKlatka -= 50;
			break;
		default: break;

		}
		key = '`';
	}
	public void Initialize() /*throws IOException*/ {
		char[] DataChar;
		String DataStr;
		
		try {
			File plik = new File("mapa.dat");
			Scanner inic = new Scanner(plik);
			
			
			DataStr = inic.nextLine();
			Szerokosc = Integer.parseInt(DataStr);
			DataStr = inic.nextLine();
			Wysokosc = Integer.parseInt(DataStr);
			DataStr = inic.nextLine();
			SzerokoscWidok = Integer.parseInt(DataStr);
			DataStr = inic.nextLine();
			WysokoscWidok = Integer.parseInt(DataStr);
			WysokoscWidok = Wysokosc;
			
			Mapa = new GameObject[Wysokosc][Szerokosc];
			MapaWidoczna = new char[WysokoscWidok][SzerokoscWidok];
			
			for (int i = 0; i < Wysokosc; i++){
				DataStr = inic.nextLine();
				DataChar = DataStr.toCharArray();
				for (int j = 0; j < Szerokosc; j++){
					ParserGameObject(DataChar[j], i, j);
				}
			}
			
			Postep = 0;
			AktualizacjaWidocznejMapy(Postep);
			inic.close();
		}
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred. File problem");
		      e.printStackTrace();
		}
	}
	/*public void GameLoop() {
		//Initialize();
		
		while (!exit){
			Sterow();
			if (GraczSzer != Szerokosc - 1) {
				if (key != 'd'){
					GraczWCosUderzyl(GraczUderzylW(Kierunek.PRAWO));
					PrzesunGracza(1, Kierunek.PRAWO);
				}
			} else {
				KoniecLevelu(true);
			}
			WcisnietoKlawisz = false;
			Postep++;
			AktualizacjaWidocznejMapy(Postep);
			View();
		}
	}*/
	public void ParserGameObject(char wyg, int i, int j) {
		switch (wyg) {
		case '.':
			Mapa[i][j] = TPustka;
			break;
		case '>':
			Mapa[i][j] = TGracz;
			GraczWys = i;
			GraczSzer = j;
			break;
		case '<':
			Mapa[i][j] = TWrog;
			break;
		case '#':
			Mapa[i][j] = TStatyczny;
			break;
		default:
			Mapa[i][j] = new GameObject(wyg, Typ.statyczny, 1);
			break;
		}
	}
	public void AktualizacjaWidocznejMapy(int odkad) {
		if (Szerokosc - odkad <= SzerokoscWidok){
			odkad = Szerokosc - SzerokoscWidok;
		}

		for (int i = 0; i < WysokoscWidok; i++) {
			for (int j = 0; j < SzerokoscWidok; j++) {
				MapaWidoczna[i][j] = Mapa[i][j + odkad].Wyglad;
			}
		}
	}
	public void GraczWCosUderzyl(int cos) {
		if (cos == 1){
			KoniecLevelu(false);
		}
		if (cos == 2){
			PunktyLevel += TWrog.Zdrowie;
		}
	}
	
	abstract public void View();
	abstract public void KoniecLevelu(boolean CzyWygrana);
}
