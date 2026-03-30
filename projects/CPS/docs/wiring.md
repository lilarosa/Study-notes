# Verdrahtung & Pinbelegung (Standard)

> Unten ist die Standard‑Pinbelegung aus `src/cps_smart_seedling_house.ino`. Du kannst die Konstanten bei Bedarf anpassen.

## I2C
- DS3231 RTC: SDA → A4, SCL → A5 (UNO/Nano)
- I2C 1602 LCD: SDA → A4, SCL → A5 (teilt sich den Bus mit der RTC)

## Sensoren (analog)
- LDR‑Spannungsteiler → A0
- Bodenfeuchte (analog) → A1
- IR‑Distanz (Sharp GP2Y0A21, analog) → A2

## Sensoren (digital)
- DHT22 Datenpin → D2 (10k Pull‑Up nach 5V; viele Module haben den bereits)

## Aktoren
- Zusatzlicht (Relais/MOSFET) → D6
- Pumpen‑Relais → D5
- Ambient‑LED PWM → D9
- „Umsetzen möglich“‑LED (grün) → D10

## Audio (DFPlayer Mini)
- DFPlayer TX → Arduino D4 (SoftwareSerial RX)
- DFPlayer RX → Arduino D3 (SoftwareSerial TX; oft stabiler mit 1k in Serie)
- DFPlayer VCC → 5V, GND gemeinsame Masse, SPK_1/SPK_2 an Lautsprecher

## Taster
- Wachstumstage‑Reset‑Taster → D7 (`INPUT_PULLUP`, gedrückt = nach GND)

## Stromversorgung (Empfehlung)
- Arduino/Sensoren über stabiles 5V Netzteil
- Pumpe/LED‑Streifen über separates Netzteil (5V/12V je nach Last)
- Beide Netzteile müssen **eine gemeinsame Masse** haben (GND verbinden)
