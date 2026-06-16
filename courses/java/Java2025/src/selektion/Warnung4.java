package selektion;

import java.util.Scanner;

public class Warnung4 {

	public static void main(String[] args) {
		
		int anzahlFehler = 0;
		int grenzWert = 50;
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Bitte den Wert geben: ");
		
		int Wert = sc.nextInt();
		if (Wert<=grenzWert) {
			
			System.out.println("Ok");
		}
		else {
			System.out.println("Warnung");
			anzahlFehler++;
		}
		System.out.println(anzahlFehler);
		sc.close();
	}

}
