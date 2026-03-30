# Stückliste (BOM, Empfehlung)

## Controller
- Arduino UNO / Nano (UNO ist komfortabler zu verdrahten, Nano ist kompakter)

## Sensoren
- LDR (Fotowiderstand) + 10k Widerstand (Spannungsteiler)
- DHT22 (Luftfeuchte/Temperatur) (alternativ DHT11)
- Kapazitiver Bodenfeuchtesensor (Analog‑Ausgang)
- IR‑Distanzsensor: Sharp GP2Y0A21YK0F (10–80 cm, Analog‑Ausgang)
- RTC: DS3231 (I2C)

## Aktoren
- Zusatzbeleuchtung: 12V LED‑Streifen + MOSFET‑Modul (oder Relais‑Modul)
- Ambient‑Licht: 5V/12V LED‑Streifen + MOSFET (PWM‑fähig)
- Pumpe: 5–12V Mini‑Pumpe (Netzteil passend auswählen) + Relais‑Modul (empfohlen: optisch getrennt)
- Status‑LED: grüne LED (+ 220Ω) oder RGB‑LED

## Anzeige & Audio
- Display: I2C 1602 LCD (am einfachsten) oder OLED (z. B. SSD1306)
- Audio: DFPlayer Mini + MicroSD‑Karte + 8Ω 0,5–3W Lautsprecher

## Stromversorgung & Sonstiges
- stabiles 5V Netzteil (Arduino + Sensoren)
- Lastnetzteil (Pumpe/LED‑Streifen, Spannung/Strom nach Last)
- Breadboard/Dupont‑Kabel/Klemmen
- Gehäusematerial: Acryl/Holz/3D‑Druck
- optional: 1× Taster (Wachstumstage zurücksetzen)

## DFPlayer: Dateinamen für Audio
MP3‑Dateien ins SD‑Root (oder `mp3`‑Ordner, je nach Modul‑Doku), Beispiel:
- `001.mp3`: Guten Morgen
- `002.mp3`: Guten Mittag
- `003.mp3`: Guten Abend
