package iteration;

import java.util.Scanner;

public class Ratespiel {

	public static void main(String[] args) {
		
    Scanner input = new Scanner(System.in);
    int zahl= (int)(Math.random()*100);// zufallzahl erzeugen
    int counter=0; // Zaehler Anzahler der Versuch
    int eingabe = 0; // Startwert, darf nicht gleich zahl sein
    
    System.out.println("Ratespiel Zufallenzahl zwischen 0 und 100 erzeugt");
    
   
	while (eingabe!=zahl) 
    {   
		System.out.print("Eingabe: ");
    	 eingabe= input.nextInt();
    	counter++;
    	
    	if(eingabe<zahl)
    		
    	{   
    		
    		System.out.println("Die gesuchte Zahl ist großer ...");
    	}
    	else if (eingabe>zahl)
    	{
    		
    		System.out.println("Die gesuchte Zahl ist kleiner ...");
    	}
    	else 
    		
    	{   
    		
    		System.out.println("Gesuchte Zahl nach "+ counter +" Versuchen gefunden" );
    
    		
    	}
    }
	input.close();

	}
          
}
