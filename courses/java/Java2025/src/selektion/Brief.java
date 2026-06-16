package selektion;

import java.util.Scanner;

public class Brief {

	public static void main(String[] args) {
		double maxi []= {20,50,100,250,500,1000};
		double price[]= {1.00,1.70,2.40,3.20,4.00,4.80};
		double kosten=0.0;
		int i;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Portoberechnung");
		
		System.out.print("Gewicht des Briefes in g:");
		double gewicht= scan.nextDouble();
	
		
		for ( i = 0; i<maxi.length; i++ ){
			
			if (gewicht<= maxi[i]) {
			
			kosten= price[i];
			break;	
		}	
	}   if(gewicht<=1000) {
		System.out.println("Kosten:" + kosten + " Euro" );

	}
	   else {System.out.println("Paket oder Päckchen");
	   
	   System.out.println("Programmende Berief");
	   
}
	scan.close();
	} 
}


