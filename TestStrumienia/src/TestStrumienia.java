import java.io.*;
//import java.text.*;
public class TestStrumienia {

public static void main(String[] args) 
throws IOException
{
	String plik = "test.txt";
	
	PrintWriter pisanie = new PrintWriter(new BufferedWriter(new FileWriter(plik)));
	pisanie.println("Testowanie");
	
	BufferedReader czytanie = new BufferedReader(new FileReader(plik));
	String s = czytanie.readLine();
	System.out.println(s);
	
	pisanie.close();
	czytanie.close();
}

}
