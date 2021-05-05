
public class Ocena {
	public int Wartosc;
	public int Waga;
	
	Ocena(int wartosc, int waga){
		this.Wartosc = wartosc;
		this.Waga = waga;
	}
	
	public String toString() {
		//@SuppressWarnings("deprecation")
		//Integer x = new Integer(Wartosc);
		//return x.toString();
		return String.valueOf(Wartosc);
	}
}
