package iteration;

import java.util.Scanner;

public class SummeundDurchschnitt {

	public static void main(String[] args) {
		// Solang Eingabe Zahl Wenn zahl!=null Addiere zum Ergebnis dazu bis Zahl=0
		
		
		System.out.println("SummeundDurchschnitt: ");
		
		
		double summe = 0; // zur Speicherung der Summe
		int zaehler= 0; //zählt die Anzahl der Eingaben
		double eingabe;
		Scanner input= new Scanner(System.in);
		
		do {
			//Zahl vom Benutzer erfragen
			System.out.println("Zahl (Ende mit 0): " );
			 eingabe = input.nextDouble();
			if (eingabe !=0)
			{
				
				summe=summe+eingabe;
				zaehler++;
		}}
		while (eingabe != 0);
		
		
		System.out.println("Summe: "+summe+"; " +"Durchschnitt "+(summe/zaehler));
		System.out.println("programmende SummeundDurchschnitt.");
		input.close();
		
	}
}
				



