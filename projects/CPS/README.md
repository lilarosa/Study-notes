# CPS Projekt: Smartes Anzucht‑Mini‑Gewächshaus (Arduino)

## Ziel
Ein smartes Anzucht‑Haus (kleines Gewächshaus), das mit Arduino mehrere Sensoren ausliest und automatisch Licht, Bewässerung, Anzeige und Audio steuert:

- Bei zu wenig Licht automatisch Zusatzbeleuchtung (Grow‑LED); bei Dunkelheit zusätzlich optional Ambient‑LED
- (Luft‑)Feuchte / Bodenfeuchte messen und eine kleine Pumpe/Sprühvorrichtung automatisch schalten
- Anzeige im Gehäuse: aktuelles Datum + „Wachstumstag Nr. …“
- Lautsprecher‑Durchsage: „Guten Morgen / Guten Mittag / Guten Abend“ zu festen Uhrzeiten
- Infrarot‑Abstandssensor misst die Distanz zur Oberkante: < 5 cm → grüne LED (Pflanze kann umgesetzt werden)

## Inhalt
- `docs/project-plan.md`: Projektplan (Meilensteine/Abnahme)
- `docs/bom.md`: Stückliste (BOM)
- `docs/wiring.md`: Verdrahtung & Pinbelegung
- `docs/calibration.md`: Schwellwerte kalibrieren (sehr empfohlen)
- `docs/cps-graphic-mapping.md`: Zuordnung der CPS‑Grafik zum Projekt
- `src/cps_smart_seedling_house.ino`: Arduino‑Code (Hauptprogramm)

## Quickstart
1. Hardware nach `docs/bom.md` bereitstellen und nach `docs/wiring.md` verdrahten.
2. In der Arduino IDE die Bibliotheken installieren (siehe Kommentarblock oben in `src/cps_smart_seedling_house.ino`).
3. Arduino per USB versorgen und Sketch flashen.
4. Beim ersten Start wird das Startdatum für „Wachstumstag 1“ in EEPROM gespeichert; zum Neustart der Zählung die Reset‑Taste 3 Sekunden gedrückt halten.

## Hinweise
Standardmäßig ist das Projekt auf folgende Module ausgelegt:
- RTC: DS3231 (Datum/Uhrzeit)
- Display: I2C 1602 LCD (Datum & Wachstumstage)
- Audio: DFPlayer Mini + Lautsprecher (Tracks 001/002/003.mp3)
- Abstand: Sharp GP2Y0A21 IR‑Distanzsensor (Analog)

Wenn du andere Module verwendest (z. B. HC‑SR04, OLED, Buzzer statt DFPlayer), sag mir die genaue Modellbezeichnung – dann passe ich Pins/Code 1:1 an deine Hardware an.
