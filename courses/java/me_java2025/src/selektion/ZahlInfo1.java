package selektion;

import java.util.Scanner;

public class ZahlInfo1 {

	public static void main(String[] args) {
		// Zahl einlesen
		Scanner scan = new Scanner(System.in);
        System.out.print("Bitte geben Sie eine ganze Zahl ein: ");
        int zahl = scan.nextInt();
 
        System.out.println("Zahlinfo");
        System.out.println("Zahl: " + zahl);
 
        // Prüfen ob größer, kleiner oder gleich 0
        if (zahl > 0) {
            System.out.print("Eingegebene Zahl ist groesser 0");
        } else if (zahl < 0) {
            System.out.print("Eingegebene Zahl ist kleiner 0");
        } else {
            System.out.print("Eingegebene Zahl ist gleich 0");
            
        }
 
        // Prüfen ob gerade oder ungerade
        if (zahl % 2 == 0) {
            System.out.println(" und gerade.");
        } else {
            System.out.println(" und ungerade.");
        }
 
        System.out.println("Programmende ZahlInfo.");
        scan.close();
    }
}
 
 
