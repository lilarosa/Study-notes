# Week 1 - Java Praxisplan (IHK + Betrieb)

Projekt: Lagerverwaltung (Bestand + Auftrag)
Pfad: `courses/java/Java2025/src/ihk/lagerverwaltung`

## Ziel der Woche

- OOP Wissen in ein kleines Fachmodell umsetzen
- Geschäftsregeln als Code schreiben (Bestand reservieren, Auftrag bestaetigen)
- Testen als Routine etablieren

## Tagesplan

1. Tag 1
- Code lesen: `model/*`
- Neue Regel: Produktpreis darf nicht negativ sein (bereits enthalten, verstehen)
- Uebung: neues Feld `category` zu `Product`

2. Tag 2
- Service-Logik verstehen: `InventoryService`
- Uebung: Methode `removeProduct(sku)` einbauen
- Fehlerfall testen (unbekannte SKU)

3. Tag 3
- Auftragsprozess in `OrderService`
- Uebung: Rabattregel (z.B. 5% ab 500 EUR)

4. Tag 4
- Testdatei erweitern: `LagerSelfTest`
- Mindestens 3 neue Tests schreiben (stock, total, invalid input)

5. Tag 5
- Kleine Refaktorierung (Methoden aufteilen, klare Namen)
- Kurze Dokumentation: Was waere fuer IHK Diagramm geeignet (Klassendiagramm + Ablauf)

## Starten

- Demo: `ihk.lagerverwaltung.app.LagerApp`
- Test: `ihk.lagerverwaltung.test.LagerSelfTest`
