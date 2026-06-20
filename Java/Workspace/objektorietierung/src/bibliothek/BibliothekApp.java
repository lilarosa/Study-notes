package bibliothek;


public class BibliothekApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// AENDERUNG: Buch bekommt nur titel, autor und jahr.
		// GRUND: ausgeliehen wird im Buch-Konstruktor automatisch auf false gesetzt.
		Buch b1 = new Buch("Wind" , "Charli", 1972);
		Buch b2 = new Buch("Love" , "Anna", 1982);
		Buch b3 = new Buch("The Horse" , "Ann", 1932);
		
		Bibliothek centerBibliothek = new  Bibliothek ();
		Benutzer aBenutzer  = new Benutzer("Anna", 1978);
		aBenutzer.anzeigen();
		centerBibliothek.buchHinzufuegen(b1);
		centerBibliothek.buchHinzufuegen(b2);
		centerBibliothek.buchHinzufuegen(b3);
		
		centerBibliothek.alleBuecherAnzeigen();
		centerBibliothek.sucheNachTitel("Wind");
		centerBibliothek.sucheNachTitel("Water");
		b1.ausleihen();
		b1.ausleihen();
		centerBibliothek.verfuegbareBuecherAnzeigen();
		b1.zurueckgeben();
		centerBibliothek.verfuegbareBuecherAnzeigen();

		// AENDERUNG: Die Methode wird ueber die Objektvariable aufgerufen, nicht ueber den Interface-Namen.
		// GRUND: Polymorphie bedeutet: Ausleihbar-Variable zeigt auf ein konkretes Buch-Objekt.
		Ausleihbar ausleihbar1 = new Buch("day", "Marry",1900);
		ausleihbar1.ausleihen();
		ausleihbar1.zurueckgeben();
		

}
}
	
