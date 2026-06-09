package uebung_kalssendiagramm_Artikel;

public class Artikel {
private String artikelName;
	private double Grosse;
	
	public Artikel(String artikelName, double Grosse) {
		this.artikelName = artikelName;
		this.Grosse = Grosse;
	}
	public void setArtikelName( String artikelName) {
		this.artikelName = artikelName;
		
	}
	public void anzeigen() {
		System.out.println("Artikel: " + artikelName + "Grosse: " + Grosse);}
}
