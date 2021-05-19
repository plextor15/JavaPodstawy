package testinterfejsu;

import java.util.ArrayList;
import java.util.Scanner;

public class TestInterfejsu {

	public static void main(String[] args) {
		ArrayList<Figura> figury = new ArrayList<>(2);
		Scanner scanner = new Scanner(System.in);

		System.out.print("Bok kwadratu: ");
		figury.add(new Kwadrat(scanner.nextDouble()));
		
		System.out.print("Podloga i wysokosc trojkata: ");
		figury.add(new Trojkat(scanner.nextDouble(), scanner.nextDouble()));
		
		
		System.out.print("\n\nPola i obwody zsumowane:\n");
		double tmp = 0;

		for (Figura figura : figury) {
			System.out.print(figura.getNazwa() + " ");
			tmp += figura.getPole();
			System.out.print(tmp + "\n");
		}
		
		for (Figura figura : figury) {
			System.out.print(figura.getNazwa() + " ");
			tmp += figura.getObwod();
			System.out.print(tmp + "\n");
		}
		
		
		scanner.close();
	}

}
