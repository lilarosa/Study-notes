package uebung_kalssendiagramm_Artikel;

import java.util.List;

public class Wunschliste extends ArtikelListe {
	private Kunde kunde;
	public Wunschliste(Kunde kunde) {
		super("Wunsch");
		this.kunde=kunde;
	}
	
	public List<Artikel> getWunschListe() {
		return super.getArtikelListe();
	}
	public void addWunsche(Artikel artikel ) {
		super.addArtikel(artikel );
	}
	public void anzeigen() {
		System.out.println("Wunsche von: " + kunde.getName());
		for(Artikel artikel: getWunschListe()) {
			System.out.println("Wunsch: " + artikel.getArtikelName());
		}
	}
}
