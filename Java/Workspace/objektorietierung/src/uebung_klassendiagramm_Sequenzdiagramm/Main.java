package uebung_klassendiagramm_Sequenzdiagramm;

public class Main {

	public static void main(String[] args) {
		Kunde k = new Kunde ("Tao");
		
		k.artikelHinzufuegen("Kette", 50.60);
		k.artikelHinzufuegen("Armband", 6.23);
		k.bestellungsAbschließen();

	}

}
