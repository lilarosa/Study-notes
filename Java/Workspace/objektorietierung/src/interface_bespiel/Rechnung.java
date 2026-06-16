package interface_bespiel;

public class Rechnung implements Document{
   private int rechnungsNr;
   private double betrag;
   
   public Rechnung (int rechnungsNr, double betrag) {
	   this.betrag = betrag;
	   this.rechnungsNr = rechnungsNr;
   }
   @Override 
   
	public void ausgeben() {
		
		System.out.println("Rechnung mit der Nummer: " + rechnungsNr);
		System.out.println(("hat den Betrag: " + betrag));
	}

}
