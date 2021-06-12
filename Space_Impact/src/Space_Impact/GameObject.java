package Space_Impact;

public class GameObject {
	public enum Typ{
		pusty,
		statyczny,
		wrog,
		gracz
	}
	
	public char Wyglad;
	public Typ Tag;
	public int Zdrowie;
	
	public GameObject(char wyglad, Typ tag, int zdrowie) {
		Wyglad = wyglad;
		Tag = tag;
		Zdrowie = zdrowie;
	}
	
	public boolean CzyZyje() {
		if (Zdrowie > 0) {
			return true;
		} else {
			return false;
		}
	}
}
