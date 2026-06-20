package uebung_kalssendiagramm_Artikel;

public class Haupt {

	public static void main(String[] args) {
		Kunde kunde = new Kunde("Kelly");
		Artikel a = new Artikel("pen", 5, 10);
		Artikel b = new Artikel("Hermas", 20, 30000);
		Warenkorb w = new Warenkorb(kunde);
		Wunschliste wunschliste = new Wunschliste(kunde);
		w.addArtikel(a);
		System.out.println(w.berechneGesamtpreis());
		w.removeArtikel(a);
		System.out.println(w.berechneGesamtpreis());
		System.out.println(a.getArtikelName());
		a.setPreis(15);
		w.addArtikel(a);
		System.out.println(w.berechneGesamtpreis());
		a.anzeigen();
		w.warenkorbAnzeigen();
		wunschliste.addArtikel(b);
		wunschliste.anzeigen();
		Druckbar d1 = a;
		Druckbar d2 = kunde;
		Druckbar d3 = w;

		d1.drucken();
		d2.drucken();
		d3.drucken();

	}

}
