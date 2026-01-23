package selektion;

import java.util.Scanner;

public class Warnung1 {

	public static void main(String[] args) {
        int anzahlFehler = 0; 
		int grenzWert = 50;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Bitte Wert eingeben: ");
		int wert = scan.nextInt();
		
		if(wert > grenzWert) {
			
			System.out.println("Warnung");
			anzahlFehler++;
			
			//++anzahlFehler;
			//System.out.println(anzahlFehler);
		}
		
		scan.close();
		
		System.out.println("Programmende Warnung1.");
		System.out.println(anzahlFehler);
		
	}

}
