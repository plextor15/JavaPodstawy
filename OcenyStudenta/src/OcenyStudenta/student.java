package OcenyStudenta;

public class student {
	String imie;
	String nazwisko;
	
	ocena Oceny[] = new ocena[20];
	String Przedmioty[] = new String[20];
	int licznik;
	
	student(String imie, String nazwisko){
		this.imie = imie;
		this.nazwisko = nazwisko;
	}
	
	void Wypisz(boolean oceny) {
		System.out.println(this.imie + " " + this.nazwisko);
		
		if(oceny) {
			for(int i=0; licznik>=i; i++) {
				System.out.println(Oceny[i].wartosc + "   " + Oceny[i].waga + "  " + Przedmioty[i]);
			}
		}
		
		return;
	}
	
	void DodajOcene(int wart, int waga, String przedmiot) {
		ocena tmp = new ocena(wart, waga);
		
		Oceny[licznik] = tmp;
		Przedmioty[licznik] = przedmiot;
		
		licznik++;
		return;
	}
	
	void EdytujOcene(int ktora, int wart, int waga, String przedmiot) {
		if(ktora<0 || ktora>licznik) {
			//WypiszError();
			return;
		}
		if(wart>5 || wart<2) {
			System.out.println("Podano nieprawidlowa");
			return;
		}
		
		Oceny[ktora].wartosc = wart;
		Oceny[ktora].waga = waga;
		Przedmioty[ktora] = przedmiot;
		
		return;
	}
	
	void EdytujOcene(int ktora, int wart) {
		if(ktora<0 || ktora>licznik) {
			return;
		}
		
		Oceny[ktora].wartosc = wart;
		
		return;
	}
	
	void UsunOcene(int ktora) {
		if(ktora<0 || ktora>licznik) {
			return;
		}
		
		Oceny[ktora] = new ocena(0,0);
		Przedmioty[ktora] = "";
		
		//zeby byl tetris
		
		licznik--;
		return;
	}
}
