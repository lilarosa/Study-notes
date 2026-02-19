package iteration;

import java.util.Scanner;

public class WaehlenZahl {

	public static void main(String[] args) {
		
	   Scanner input = new Scanner (System.in);
	   
	   int zahl;
        
       do {
    	   System.out.println("Bitte die Zahl geben: ");
    	   zahl= input.nextInt();
		   
		   if (zahl != 1 && zahl != 2) {
	    	   
	    	   System.out.println("Fehleingabe!");}
       }
		   
	    while ( zahl != 1 && zahl != 2);
     
       System.out.println("Sie haben " + zahl + " gewahlt");
       input.close();
}
}

       
	


