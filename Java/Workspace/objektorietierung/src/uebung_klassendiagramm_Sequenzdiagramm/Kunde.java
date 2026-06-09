package uebung_klassendiagramm_Sequenzdiagramm;

public class Kunde {
	private String name;
	private Warekorb ware;
	

	public Kunde(String name) {
		
		this.name = name;
		this.ware = new Warekorb(); //
		
	}

	public void artikelHinzufuegen(String bezeichnung, double preis){
		ware.addArtikel(bezeichnung, preis);
	}

	public void bestellungsAbschließen() {
		double gesamtpreis = ware.berechnePreis();
		System.out.println(gesamtpreis);
		}

}
