package variablen_datentypen_operatoren;

import java.util.Scanner;

public class Summe {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Erste Zahle einlesen
		System.out.println("Bitte die erste zahle geben:");
		int zahle1 = input.nextInt();
		
		// zweite Zahle einlesen
		System.out.println("Bitte die zweite zahle geben:");
		int zahle2 = input.nextInt();
		
		// Summe berechnen
		int Summe= zahle1 + zahle2;
		
		// Ergebnis Ausgeben
		System.out.println("Die Summe ist : " + Summe);
		//System.out.ptintln("Die Summe ist : " +(zahle1 + zahle2));
		
		input.close();// Scanner schließen
		
		

	}

}
