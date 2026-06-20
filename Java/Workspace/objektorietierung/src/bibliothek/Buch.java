package bibliothek;


public class Buch implements Ausleihbar {
	private String titel;
	private String autor;
	private int jahr;
	// AENDERUNG: boolean statt Boolean.
	// GRUND: Fuer einen einfachen true/false-Zustand reicht der primitive Typ boolean.
	private boolean ausgeliehen;
	
	// AENDERUNG: Der Konstruktor bekommt kein ausgeliehen als Parameter mehr.
	// GRUND: Eine neu erstellte Buch-Instanz soll laut Aufgabe automatisch verfuegbar sein.
	public Buch (String titel, String autor,int jahr) {
		this.titel = titel;
		this.autor = autor;
		this.jahr = jahr;
		this.ausgeliehen = false; 
	}
	
	public String getTitel() {
		return titel;
	}
	public String getAutor() {
		return autor;
	}
	public int getJahr() {
		return jahr;
	}
	
	public boolean getAusgeliehen() {
		return ausgeliehen;
	}
	// AENDERUNG: anzeigen() braucht keinen Buch-Parameter.
	// GRUND: Ein Buch-Objekt kann seine eigenen Attribute direkt mit this verwenden.
	public void anzeigen() {
		String status = ausgeliehen ? "ausgeliehen" : "verfuegbar";
		System.out.println("Buch: " + titel + " | Autor: " + autor + " | Jahr: " + jahr + " | Status: " + status);
	}
	
	@Override
	public void ausleihen() {
		// AENDERUNG: Die Bedingung wurde umgedreht.
		// GRUND: Ausleihen ist nur moeglich, wenn das Buch noch nicht ausgeliehen ist.
		if(!ausgeliehen) {
			ausgeliehen = true;
			System.out.println(titel + " wurde ausgeliehen.");
		} else {
			System.out.println(titel + " ist schon ausgeliehen.");
		}
		
	}

	@Override
	public void zurueckgeben() {
		// AENDERUNG: Die Bedingung wurde umgedreht.
		// GRUND: Zurueckgeben ist nur sinnvoll, wenn das Buch gerade ausgeliehen ist.
		if (ausgeliehen) {
			ausgeliehen = false;
			System.out.println(titel + " wurde zurueckgegeben.");
		}
		else {
			System.out.println(titel + " war nicht ausgeliehen.");
		}
	}
}
