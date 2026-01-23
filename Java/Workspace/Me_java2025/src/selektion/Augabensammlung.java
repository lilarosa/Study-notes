package selektion;

import java.util.Scanner;

public class Augabensammlung {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		double price1 = 5.50;
		double price2 = 3.00;
		double price3 = 0;
		
		System.out.println("Berechnung des Rechnungsbetrages:");
		System.out.print("Auftragssumme in Euro:");
		double bestell = scan.nextDouble();
		
		
		if(bestell<100) {
			double  Rechenugsbetrag = bestell + price1;
			System.out.println("Rechnungsbetrag:"+ Rechenugsbetrag+" Euro" );
		}
		else if(bestell<200) {
			double  Rechenugsbetrag = bestell + price2;
			System.out.println("Rechnungsbetrag:"+ Rechenugsbetrag + " Euro");
		}// System.out.println("Rechnungsbetrag:"+ (bestell + 3.00) + " Euro");
		else {
			double  Rechenugsbetrag = bestell + price3;
			System.out.println("Rechnungsbetrag:"+ Rechenugsbetrag + " Euro" );
		}
		
		
		System.out.println("Programmende Bestell2.");
		scan.close();
	}

}
