package iteration;

import java.util.Scanner;

public class EinsOrderZwei {

	public static void main(String[] args) {
		
		Scanner input= new Scanner (System.in);
		System.out.println("Waehlen Sie (1/2):");
		int zahl = input.nextInt();
		
      while (zahl != 1 && zahl != 2) {
    	  
        System.out.println("Fehlereingabe");
        System.out.println("Waehlen Sie (1/2):");
        zahl = input.nextInt();
        
        
      }
      System.out.println("Sie haben " + zahl + " gewählt");
		input.close();
	}


}
