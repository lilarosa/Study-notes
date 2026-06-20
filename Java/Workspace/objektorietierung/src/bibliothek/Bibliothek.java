package bibliothek;

import java.util.ArrayList;

public class Bibliothek {
	// AENDERUNG: Die ArrayList wird direkt erzeugt.
	// GRUND: Sonst ist buecher null und buecher.add(...) wirft eine NullPointerException.
	private ArrayList<Buch> buecher = new ArrayList<>();
	
	public void buchHinzufuegen(Buch buch) {
		buecher.add(buch);
	}
	public void alleBuecherAnzeigen() {
		for(Buch buch: buecher) {
			// AENDERUNG: Nicht das Objekt selbst drucken, sondern seine anzeigen()-Methode verwenden.
			// GRUND: System.out.println(buch) zeigt sonst nur eine technische Objektreferenz.
			buch.anzeigen();
		}
		
	}
	public void verfuegbareBuecherAnzeigen() {
		for(Buch buch: buecher) {
			// AENDERUNG: Verfuegbar bedeutet: nicht ausgeliehen.
			// GRUND: getAusgeliehen() == true bedeutet gerade, dass das Buch nicht verfuegbar ist.
			if(!buch.getAusgeliehen()) {
				buch.anzeigen();	
			}
			
		}
	}
	
	public void sucheNachTitel(String titel) {
		// AENDERUNG: Der Suchbegriff kommt aus dem Parameter, nicht aus Scanner.
		// GRUND: Die App ruft sucheNachTitel("Wind") auf; diese Eingabe soll die Methode benutzen.
		boolean gefunden = false;
		for(Buch buch: buecher) {
			if(buch.getTitel().equals(titel)) {
				buch.anzeigen();
				gefunden = true;
			}
		}

		if(!gefunden) {
			System.out.println("Dieses Buch wurde nicht gefunden: " + titel);
		}
	}
}
	
