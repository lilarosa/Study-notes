# Schwellwerte kalibrieren (empfohlen)

## 1) Serielle Ausgabe öffnen
In der Arduino IDE den „Serial Monitor“ öffnen, Baudrate `115200`. Du siehst etwa:
- `LDR=...`: Rohwert Licht
- `SOIL=...`: Rohwert Bodenfeuchte
- `IR=... DistCm=...`: IR‑Rohwert und berechneter Abstand

## 2) Zusatzlicht‑Schwellwerte (LDR) einstellen
1. „Normales Licht“ messen: `LDR` notieren (z. B. 520)
2. Abdunkeln, bis Zusatzlicht nötig wäre: `LDR` notieren (z. B. 300)
3. Setzen:
- `LDR_ON_THRESHOLD` nahe „zu dunkel“ (z. B. 320–360)
- `LDR_OFF_THRESHOLD` 30–80 höher als ON (z. B. 400–460) → Hysterese gegen Flattern

Hinweis: Wenn deine Verdrahtung so ist, dass „hell = kleiner Wert“, muss die Logik invertiert werden (kann ich dir bei Bedarf anpassen).

## 3) Bodenfeuchte‑Schwellwerte (SOIL) einstellen
1. Sensor in Luft/ trockener Erde: `SOIL` notieren (trocken)
2. Sensor in feuchter Erde/ Wasser (Achtung Kurzschluss vermeiden): `SOIL` notieren (feucht)
3. Richtung bestimmen:
- Wenn „trocken > feucht“ → `SOIL_DRY_IS_HIGH = true`
- Wenn „trocken < feucht“ → `SOIL_DRY_IS_HIGH = false` (Standard)
4. Setzen:
- `SOIL_DRY_THRESHOLD` nahe „trocken“
- `SOIL_WET_THRESHOLD` nahe „feucht“ (für spätere Erweiterung; aktuell triggert die Pumpe zeitgesteuert über „dry“)

## 4) IR‑Distanz kalibrieren
Die Kennlinie hängt vom Sensor ab:
- `sharpGp2y0a21ToCm()` ist für Sharp GP2Y0A21 (10–80 cm) ausgelegt
- Bei anderen IR‑Sensoren oder Ultraschall (HC‑SR04) muss die Umrechnung angepasst werden

Lineal bei 5 cm / 10 cm / 20 cm vor den Sensor halten und prüfen, ob `DistCm` plausibel ist.
