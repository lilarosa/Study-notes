package uebung_kalssendiagramm_Artikel;//Warenkorb ist eine spezielle Artikelliste

public class Warenkorb extends ArtikelListe{

	private Kunde kunde;
	
	public Warenkorb (Kunde kunde) {
		super("warenkorb");
		this.kunde = kunde;
		
	}
	public double berechneGesamtpreis() {
		double summe = 0;
		for (Artikel artikel : getArtikelListe()) {
			summe += artikel.getPreis();
		}
		return summe;
	}
		
	}

