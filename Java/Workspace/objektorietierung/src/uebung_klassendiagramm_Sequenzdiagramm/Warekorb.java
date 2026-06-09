package uebung_klassendiagramm_Sequenzdiagramm;

import java.util.ArrayList;

public class Warekorb {
	//private Artikel [] liste;
	//Arraylist hat keine feste Größe(vergrößt sich selbast). 
	//Angabe eines Index hinzugügen
	
	private ArrayList<Artikel> liste;
	public Warekorb () {
		liste = new ArrayList<Artikel>(); //leere Liste
	}
	public void addArtikel(String bezeichnung, double preis) {
		Artikel art = new Artikel(bezeichnung, preis); // erzeugt einen neuen Artikel
		liste.add(art);
	
	}
	public double berechnePreis() {
		double gesamtPreis = 0;
		for (int i = 0 ; i<liste.size(); i++) {
			gesamtPreis = gesamtPreis + liste.get(i).getPreis();
			// liste.get(i) gibt ein Artikelobjekt zurück
			//liste.get(i).getPreis() gibt des Preis des Artikel zurück
		}
		
		
		//Alternative Schleife
		/*for(Artikel a:liste) {
		  gesamtPreis = gesamtPreis + liste.get(i).getPreis();
		  }
		 */
		return gesamtPreis;
	}
}
