package bibliothek;

public interface Ausleihbar {
	// AENDERUNG: Interface-Methoden sind hier nicht static und haben keinen Methodenrumpf.
	// GRUND: Jede ausleihbare Klasse, z.B. Buch oder spaeter DVD, soll ihre eigene Logik schreiben.
	void ausleihen();
	void zurueckgeben();
}
