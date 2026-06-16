package iteration;

import java.util.Scanner;

public class WaehlenZahler {

	public static void main(String[] args) {
       Scanner scan = new Scanner (System.in);
       
       System.out.println("Waehlen Sie(1/2)");
       int zahl= scan.nextInt();
       
       while(zahl!=1&&zahl!=2) 
       {
    	   System.out.println("Fehlereingabe!");
    	   System.out.println("Waehlen Sie(1/2)");
    	   zahl= scan.nextInt();
       }
       System.out.println("Sie haben "+ zahl + " gewaehlt");
       scan.close();
	}

}
