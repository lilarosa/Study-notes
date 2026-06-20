package uebung_kalssendiagramm_Artikel;

public class Artikel implements Druckbar {
	private String artikelName;
	private double grosse;
	private double preis;
	
	public Artikel(String artikelName, double grosse, double preis) {
		this.artikelName = artikelName;
		this.grosse = grosse;
		this.preis = preis;
	}
	public String getArtikelName() {
		return artikelName;
	}
	public double getGrosse() {
		return grosse;
	}
	
	public void setArtikelName( String artikelName) {
		this.artikelName = artikelName;
		
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public void anzeigen() {
		System.out.println("Artikel: " + artikelName + " | Grosse: " + grosse + " | Preis: " + preis + " EURO");
	}

	@Override
	
 	public void drucken() {
		anzeigen();
	}
}
