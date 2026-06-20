package bibliothek;

public class Benutzer {
	private String name;
	private int kundennummer;
	
	public Benutzer(String name, int kundennummer) {
		this.name = name;
		this.kundennummer = kundennummer;
	}
	
	public String getName() {
		return name;
	}
	public int getKundennumer() {
		return kundennummer;
	}
	
	// AENDERUNG: anzeigen() braucht keinen Benutzer-Parameter.
	// GRUND: Das aktuelle Benutzer-Objekt kennt seine eigenen Attribute.
	public void anzeigen() {
		System.out.println("User: " + name + " | Nummer: " + kundennummer);
	}
}
