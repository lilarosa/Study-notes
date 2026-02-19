package übungAufgabe;

	import java.util.Scanner;

	public class ReceptFarbe {
	 
	    public static void main(String[] args) {
	    boolean verschreibungspflichtig;
	    boolean versichert;
	    boolean Betäubungsmittel;
	    String receptFarbe;
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Ist das Medikament verschreibungspflichtig? (true/false)");
	  verschreibungspflichtig = sc.nextBoolean();
	    System.out.println("Ist das Medikament versichert? (true/false)");
	    versichert = sc.nextBoolean();
	    System.out.println("Ist das Medikament ein Betäubungsmittel? (true/false)");
	    Betäubungsmittel = sc.nextBoolean();

	    if (Betäubungsmittel) {
	            receptFarbe = "gelb";
	        } 
	        else if (!versichert) {
	            receptFarbe = "blau";
	        } 
	        else if (verschreibungspflichtig) {
	            receptFarbe = "rot";
	        } 
	        else {
	            receptFarbe = "grün";
	        }

	        System.out.println("Die Rezeptfarbe ist: " + receptFarbe);
	        sc.close();
	}
	}

