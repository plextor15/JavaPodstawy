import java.io.*;

public class Strumyczek {
	public static void main(String[] args) throws IOException{
		String dane = "dane.txt";
		String tmp;
		BufferedReader czytanie = new BufferedReader(new FileReader(dane));
		PrintWriter pisanie = new PrintWriter(new BufferedWriter(new FileWriter("NEW_" + dane)));
		
		pisanie.println();
		for (int i = 0; i < 10; i++) {
			tmp = czytanie.readLine();
			tmp = tmp + " [RETURN]";
			pisanie.println(tmp);
		}
		
		pisanie.close();
		czytanie.close();
		
		DataInputStream liczby = new DataInputStream(new FileInputStream("inty.txt"));
		//TO DO
		
		liczby.close();
	}

}
