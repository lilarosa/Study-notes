# Projektplan (CPS: Smartes Anzucht‑Gehäuse)

## 1. Anforderungszerlegung (Funktionsmodule)
1) Sensorik (Eingänge)
- Licht: LDR (Fotowiderstand) / Lichtsensor
- Luftfeuchte: DHT22 (oder DHT11)
- Bodenfeuchte: Bodenfeuchtesensor (analog)
- Abstand: IR‑Distanzmessung (Pflanze → Deckel)

2) Aktorik (Ausgänge)
- Zusatzlicht (Relais oder MOSFET für LED‑Streifen/LED‑Modul)
- Ambient‑Licht (PWM‑Dimmen)
- Pumpe/Magnetventil (Relais + getrennte Versorgung/Entstörung)
- Status‑LED (Grün = „umsetzen/ausräumen möglich“)
- Audio‑Ausgabe (DFPlayer Mini)

3) Anzeige & Zeit
- RTC liefert Datum/Uhrzeit (DS3231)
- Display zeigt Datum + Wachstumstage

## 2. Meilensteine (Empfehlung: 2–3 Wochen)
### M1: Hardwareaufbau & Einzeltests (2–3 Tage)
- Lichtmessung liefert stabile Werte
- DHT‑Werte sind plausibel und verändern sich
- Bodenfeuchte unterscheidet trocken/feucht
- Distanzmessung liefert stabile Werte (cm)
- LCD zeigt Text an

Abnahme: Serielle Ausgabe zeigt alle Sensordaten; LCD zeigt das Datum.

### M2: Regelung & Schwellwerte einstellen (3–5 Tage)
- Licht unter Schwellwert → Zusatzlicht EIN; über Schwellwert → AUS (mit Hysterese gegen Flattern)
- Boden trocken → Pumpe für feste Dauer EIN (mit Mindestintervall gegen häufiges Schalten)
- Abstand < 5 cm → grüne LED EIN

Abnahme: Abdunkeln/Anleuchten, Bodenfühler testen, Distanzsensor mit Karton annähern → System reagiert korrekt.

### M3: Audio‑Durchsagen & Wachstumstage‑Logik (2–3 Tage)
- 08:00 „Guten Morgen“, 12:00 „Guten Mittag“, 19:00 „Guten Abend“ (pro Tag jeweils nur 1×)
- Wachstumstage zählen ab dem Startdatum (EEPROM); Reset per Taste möglich

Abnahme: RTC‑Zeit verstellen → Durchsagen triggern; Neustart verliert Wachstumstage nicht; Taste setzt Startdatum zurück.

### M4: Gehäuse‑Integration & Zuverlässigkeit (2–4 Tage)
- Stromversorgung: Logik 5V und Lastversorgung getrennt (gemeinsame Masse)
- Wasserschutz: Pumpe/Schläuche dicht, Kabelführung sauber
- 48h Laufzeit ohne Hänger/Fehltrigger

Abnahme: 2 Tage Dauerlauf, Log plausibel, Bewässerung triggert nicht unkontrolliert.

## 3. Risiken & Gegenmaßnahmen
- Relais/Pumpe stören und verursachen Resets: getrennte Versorgung, gemeinsame Masse, ggf. Optokoppler‑Relais + Puffer/Entstörkondensatoren
- Korrosion bei Bodenfühlern: bevorzugt kapazitiven Bodenfeuchtesensor verwenden
- Lichtschwellwerte sind umgebungsabhängig: vor Ort messen und Hysterese anpassen

## 4. End‑Deliverables (für Bericht/Email/Portfolio)
- Systemarchitektur (Sensor → Regelung → Aktor)
- Verdrahtungsplan + BOM
- Arduino‑Code (konfigurierbare Schwellwerte/Module)
- Demo‑Video (Auto‑Licht, Auto‑Bewässerung, Display, Audio, Distanz‑Hinweis)
