package selektion;

import java.util.Scanner;

public class BeriefTest1 {

	public static void main(String[] args) {
System.out.println("Portoberechnung");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Gewicht des Briefes in g: ");
		
		double gewicht = scan.nextDouble();
		double porto = 0.0;
		
		if(gewicht <= 20)
			porto = 1;
		else if (gewicht <= 50)
			porto = 1.70;
		else if (gewicht <= 100)
			porto = 2.40;
		else if (gewicht <= 250)
			porto = 3.20;
		else if (gewicht <= 500)
			porto = 4.00;
		else if (gewicht <= 1000)
			porto = 4.80;
		
		
		if(gewicht <= 1000)
			System.out.println("Kosten: " + porto + "Euro");
		else
			System.out.println("Paket oder Päckchen");
			
		System.out.println("Programmende Brief");
		scan.close();

	}

}
