package eingabe_benutzer;

import java.util.Scanner;

public class EinlesenKonsole {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); //Erzeuge eienen neuen Scanner, der scan heißt
		System.out.print("Bitte Name eingeben:"); // Benutzer Hinweis für die Eingabe geben
		String name = scan.nextLine(); // Definiere eine Variable name vom Type String und Speicher darin die Eingabe vom Speicher
		System.out.println("Ihre Name ist:" + name);
		 
		
		//Zahl einlesen
		System.out.println("Bitte Alter eingeben:");
		int alter = scan.nextInt();
		System.out.println("Benutzername:" + name + " ist " + alter + " Jahre alt");
		
		
		 scan.close();// Schließ den Datenstrom wieder
	}

}
