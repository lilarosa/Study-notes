package uebung_kalssendiagramm_Artikel;

public class Artikel implements Druckbar {
	private String artikelName;
	private double Grosse;
	private double preis;
	
	public Artikel(String artikelName, double Grosse, double preis) {
		this.artikelName = artikelName;
		this.Grosse = Grosse;
		this.preis = preis;
	}
	public String getArtikelName() {
		return artikelName;
	}
	public double getGrosse() {
		return Grosse;
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
		System.out.println("Artikel: " + artikelName + " | " + "Grosse: " + Grosse + " | " + "Preis: " +preis + " EURO");}
 @Override
	
 	public void drucken() {
	 System.out.println("Artikel: " + artikelName);
 }
}

