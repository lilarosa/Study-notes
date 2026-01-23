package selektion;

import java.util.Scanner;

public class Bestell {

	public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
		
		double price1 = 5.50;
		double price2 = 3.00;
		double price3 = 0;
		double rechnungsbetrag ; //这里是全局变量，
		
		System.out.println("Berechnung des Rechnungsbetrages:");
		System.out.print("Auftragssumme in Euro:");
		double bestell = scan.nextDouble();
		
		
		if(bestell<100) {
			 rechnungsbetrag= bestell+ price1; //这里只赋值，不声明变量
		}
		else if(bestell<200) {
			 rechnungsbetrag= bestell+ price2;
			
		}// System.out.println("Rechnungsbetrag:"+ (bestell + 3.00) + " Euro");
		else {
			
			 rechnungsbetrag= bestell+ price3;
			
		}
		
		System.out.println("Rechnungsbetrag:"+ rechnungsbetrag + " Euro");
		System.out.println("Programmende Bestell2.");
		scan.close();	}


	}


