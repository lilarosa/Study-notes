package uebung_kalssendiagramm_Artikel;

public class Haupt {

	public static void main(String[] args) {
		Kunde kunde = new Kunde("Kelly");
		Artikel a = new Artikel("pen", 5, 10);
		Warenkorb w = new Warenkorb(kunde);
		w.addArtikel(a);
		System.out.println(w.berechneGesamtpreis());
		w.removeArtikel(a);
		System.out.println(w.berechneGesamtpreis());

	}

}
