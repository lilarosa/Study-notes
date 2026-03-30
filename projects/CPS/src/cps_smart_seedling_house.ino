/*
  CPS Projekt: Smartes Anzucht‑Mini‑Gewächshaus (Arduino)

  Standard‑Hardware (kann unten per Makros deaktiviert werden):
  - RTC: DS3231 (Lib: RTClib by Adafruit)
  - Display: I2C 1602 LCD (Lib: LiquidCrystal_I2C)
  - Luftfeuchte: DHT22 (Lib: DHT sensor library by Adafruit)
  - Audio: DFPlayer Mini (Lib: DFRobotDFPlayerMini)
  - Abstand: Sharp GP2Y0A21 IR‑Distanz (analog)

  In der Arduino IDE über Library Manager installieren:
  - RTClib
  - LiquidCrystal_I2C
  - DHT sensor library + Adafruit Unified Sensor
  - DFRobotDFPlayerMini
*/

#include <Arduino.h>
#include <EEPROM.h>

// ===== Feature‑Schalter (wenn Modul fehlt: 0) =====
#define USE_RTC 1
#define USE_LCD 1
#define USE_DHT 1
#define USE_DFPLAYER 1

// ===== Pinbelegung (siehe docs/wiring.md) =====
static const uint8_t PIN_LDR = A0;         // LDR (Spannungsteiler)
static const uint8_t PIN_SOIL = A1;        // Bodenfeuchte (analog)
static const uint8_t PIN_IR_DIST = A2;     // IR‑Distanz (analog)
static const uint8_t PIN_DHT = 2;          // DHT22 Datenpin

static const uint8_t PIN_PUMP = 5;         // Pumpenrelais
static const uint8_t PIN_GROW_LIGHT = 6;   // Zusatzlicht (Relais/MOSFET)
static const uint8_t PIN_AMBIENT = 9;      // Ambient‑LED (PWM)
static const uint8_t PIN_READY_LED = 10;   // grüne Status‑LED
static const uint8_t PIN_RESET_BTN = 7;    // Reset‑Taster (INPUT_PULLUP)

// DFPlayer SoftwareSerial (UNO/Nano)
static const uint8_t PIN_DFPLAYER_TX = 3;  // Arduino -> DFPlayer RX
static const uint8_t PIN_DFPLAYER_RX = 4;  // Arduino <- DFPlayer TX

// ===== Schwellwerte & Parameter (vor Ort kalibrieren) =====
// Licht: LDR Analogwert 0..1023 (abhängig von Verdrahtung; hier: heller = größer)
static const int LDR_ON_THRESHOLD = 380;      // darunter: „zu dunkel“ → Zusatzlicht EIN
static const int LDR_OFF_THRESHOLD = 430;     // darüber: „hell genug“ → Zusatzlicht AUS (Hysterese)
static const int LDR_NIGHT_THRESHOLD = 220;   // darunter: „dunkel“ → Ambient‑LED EIN

// Bodenfeuchte: Analogwert 0..1023 (Richtung je nach Sensor unterschiedlich)
static const bool SOIL_DRY_IS_HIGH = false;   // true: größer = trockener; false: kleiner = trockener
static const int SOIL_DRY_THRESHOLD = 380;    // Trocken‑Schwellwert (Trigger Bewässerung)
static const int SOIL_WET_THRESHOLD = 430;    // Feucht‑Schwellwert (für spätere Logik)

// Bewässerungslogik
static const unsigned long PUMP_ON_MS = 4000;             // Pumpenlaufzeit pro Zyklus
static const unsigned long PUMP_MIN_INTERVAL_MS = 2UL * 60UL * 1000UL; // Mindestabstand zwischen Zyklen

// Abstandshinweis
static const float READY_DISTANCE_CM = 5.0f;  // < 5 cm → grüne LED an

// Ambient‑LED Helligkeit (0..255)
static const uint8_t AMBIENT_BRIGHTNESS = 80;

// Audio‑Zeitpunkte (24‑Stunden‑Format)
static const uint8_t MORNING_HOUR = 8;
static const uint8_t NOON_HOUR = 12;
static const uint8_t EVENING_HOUR = 19;

// ====== Serielle Logs (optional) ======
static const bool ENABLE_SERIAL = true;

#if USE_RTC
#include <Wire.h>
#include <RTClib.h>
RTC_DS3231 rtc;
#endif

#if USE_LCD
#include <LiquidCrystal_I2C.h>
// Häufige I2C‑Adresse: 0x27 oder 0x3F (falls falsch: hier ändern)
LiquidCrystal_I2C lcd(0x27, 16, 2);
#endif

#if USE_DHT
#include <DHT.h>
static const uint8_t DHT_TYPE = DHT22;
DHT dht(PIN_DHT, DHT_TYPE);
#endif

#if USE_DFPLAYER
#include <SoftwareSerial.h>
#include <DFRobotDFPlayerMini.h>
SoftwareSerial dfSerial(PIN_DFPLAYER_RX, PIN_DFPLAYER_TX); // RX, TX
DFRobotDFPlayerMini dfPlayer;
#endif

enum Greeting : uint8_t { GREET_MORNING = 0, GREET_NOON = 1, GREET_EVENING = 2 };

struct PersistData {
  uint16_t magic;
  uint16_t startYear;
  uint8_t startMonth;
  uint8_t startDay;
  uint16_t lastGreetYear[3];
  uint8_t lastGreetMonth[3];
  uint8_t lastGreetDay[3];
};

static const uint16_t PERSIST_MAGIC = 0xC351; // Magic für Persistenz (CPS v1)
PersistData persist;

// Laufzeit‑Status
bool growLightOn = false;
bool pumpOn = false;
unsigned long pumpStartedAtMs = 0;
unsigned long lastPumpFinishedAtMs = 0;

// Periodische Tasks
unsigned long lastSensorReadMs = 0;
unsigned long lastDisplayMs = 0;
unsigned long lastControlMs = 0;
unsigned long lastGreetCheckMs = 0;

// Letzte Messwerte
int ldrRaw = 0;
int soilRaw = 0;
int irRaw = 0;
float airHumidity = NAN;
float airTempC = NAN;
float distCm = NAN;

static void setGrowLight(bool on) {
  growLightOn = on;
  digitalWrite(PIN_GROW_LIGHT, on ? HIGH : LOW);
}

static void setPump(bool on) {
  pumpOn = on;
  digitalWrite(PIN_PUMP, on ? HIGH : LOW);
}

static void setAmbient(bool on) {
  if (on) {
    analogWrite(PIN_AMBIENT, AMBIENT_BRIGHTNESS);
  } else {
    analogWrite(PIN_AMBIENT, 0);
  }
}

static bool soilIsDry(int raw) {
  if (SOIL_DRY_IS_HIGH) return raw >= SOIL_DRY_THRESHOLD;
  return raw <= SOIL_DRY_THRESHOLD;
}

static bool soilIsWet(int raw) {
  if (SOIL_DRY_IS_HIGH) return raw <= SOIL_WET_THRESHOLD;
  return raw >= SOIL_WET_THRESHOLD;
}

static float sharpGp2y0a21ToCm(int adcRaw) {
  // Näherungsformel für GP2Y0A21 (10–80 cm); andere Sensoren benötigen Kalibrierung
  // voltage = adc * (5.0/1023); distance ≈ 27.86 / (voltage - 0.42)
  float voltage = (float)adcRaw * (5.0f / 1023.0f);
  if (voltage <= 0.43f) return NAN;
  float cm = 27.86f / (voltage - 0.42f);
  if (cm < 0.0f || cm > 200.0f) return NAN;
  return cm;
}

static bool sameDate(uint16_t y1, uint8_t m1, uint8_t d1, uint16_t y2, uint8_t m2, uint8_t d2) {
  return y1 == y2 && m1 == m2 && d1 == d2;
}

#if USE_RTC
static DateTime nowDateTime() {
  return rtc.now();
}
#else
static uint32_t fakeSeconds = 0;
static DateTime nowDateTime() {
  // Ohne RTC: grobe Simulation via millis() (nicht genau)
  fakeSeconds = millis() / 1000UL;
  return DateTime(2026, 1, 1, 0, 0, 0) + TimeSpan(fakeSeconds);
}
#endif

static void persistLoadOrInit() {
  EEPROM.get(0, persist);
  if (persist.magic != PERSIST_MAGIC) {
    memset(&persist, 0, sizeof(persist));
    persist.magic = PERSIST_MAGIC;
    DateTime now = nowDateTime();
    persist.startYear = now.year();
    persist.startMonth = now.month();
    persist.startDay = now.day();
    EEPROM.put(0, persist);
  }
}

static void persistSave() {
  EEPROM.put(0, persist);
}

static int growthDayNumber() {
  DateTime now = nowDateTime();
  DateTime start(persist.startYear, persist.startMonth, persist.startDay, 0, 0, 0);
  DateTime today(now.year(), now.month(), now.day(), 0, 0, 0);
  TimeSpan delta = today - start;
  long days = delta.days();
  if (days < 0) days = 0;
  return (int)days + 1;
}

static void resetGrowthStartToToday() {
  DateTime now = nowDateTime();
  persist.startYear = now.year();
  persist.startMonth = now.month();
  persist.startDay = now.day();
  for (uint8_t i = 0; i < 3; i++) {
    persist.lastGreetYear[i] = 0;
    persist.lastGreetMonth[i] = 0;
    persist.lastGreetDay[i] = 0;
  }
  persistSave();
}

#if USE_DFPLAYER
static void playGreeting(Greeting g) {
  // Konvention: 001=Guten Morgen, 002=Guten Mittag, 003=Guten Abend
  uint16_t track = 1;
  if (g == GREET_NOON) track = 2;
  if (g == GREET_EVENING) track = 3;
  dfPlayer.play(track);
}
#endif

static void checkAndGreet() {
  DateTime now = nowDateTime();
  uint8_t hour = now.hour();
  uint8_t minute = now.minute();

  // Prüfe 1× pro Minute; Trigger nur bei Minute == 0 (zur vollen Stunde)
  if (minute != 0) return;

  Greeting g;
  bool should = false;
  if (hour == MORNING_HOUR) { g = GREET_MORNING; should = true; }
  else if (hour == NOON_HOUR) { g = GREET_NOON; should = true; }
  else if (hour == EVENING_HOUR) { g = GREET_EVENING; should = true; }
  if (!should) return;

  if (sameDate(persist.lastGreetYear[g], persist.lastGreetMonth[g], persist.lastGreetDay[g],
               now.year(), now.month(), now.day())) {
    return;
  }

#if USE_DFPLAYER
  playGreeting(g);
#endif

  persist.lastGreetYear[g] = now.year();
  persist.lastGreetMonth[g] = now.month();
  persist.lastGreetDay[g] = now.day();
  persistSave();
}

static void readSensors() {
  ldrRaw = analogRead(PIN_LDR);
  soilRaw = analogRead(PIN_SOIL);
  irRaw = analogRead(PIN_IR_DIST);
  distCm = sharpGp2y0a21ToCm(irRaw);

#if USE_DHT
  airHumidity = dht.readHumidity();
  airTempC = dht.readTemperature();
#endif

  if (ENABLE_SERIAL) {
    Serial.print(F("LDR="));
    Serial.print(ldrRaw);
    Serial.print(F(" SOIL="));
    Serial.print(soilRaw);
    Serial.print(F(" IR="));
    Serial.print(irRaw);
    Serial.print(F(" DistCm="));
    if (isnan(distCm)) Serial.print(F("nan"));
    else Serial.print(distCm, 1);
#if USE_DHT
    Serial.print(F(" Hum="));
    if (isnan(airHumidity)) Serial.print(F("nan"));
    else Serial.print(airHumidity, 1);
    Serial.print(F(" TempC="));
    if (isnan(airTempC)) Serial.print(F("nan"));
    else Serial.print(airTempC, 1);
#endif
    Serial.println();
  }
}

static void updateControl() {
  // 1) Abstandshinweis‑LED
  bool ready = (!isnan(distCm) && distCm <= READY_DISTANCE_CM);
  digitalWrite(PIN_READY_LED, ready ? HIGH : LOW);

  // 2) Zusatzlicht (mit Hysterese)
  if (!growLightOn && ldrRaw <= LDR_ON_THRESHOLD) {
    setGrowLight(true);
  } else if (growLightOn && ldrRaw >= LDR_OFF_THRESHOLD) {
    setGrowLight(false);
  }

  // 3) Ambient‑LED (dunkel oder Nachtzeitfenster)
  DateTime now = nowDateTime();
  bool nightBySensor = (ldrRaw <= LDR_NIGHT_THRESHOLD);
  bool nightByTime = (now.hour() >= 20 || now.hour() < 6);
  setAmbient(nightBySensor || nightByTime);

  // 4) Bewässerung (zeitgesteuert + Mindestintervall gegen häufiges Schalten)
  unsigned long nowMs = millis();
  if (pumpOn) {
    if (nowMs - pumpStartedAtMs >= PUMP_ON_MS) {
      setPump(false);
      lastPumpFinishedAtMs = nowMs;
    }
    return;
  }

  bool canStart = (nowMs - lastPumpFinishedAtMs >= PUMP_MIN_INTERVAL_MS);
  if (!canStart) return;

  // Pumpe läuft „feste Dauer“; daher reicht der Trocken‑Schwellwert als Trigger.
  // WET‑Schwellwert ist für spätere Erweiterung („bis feucht“) gedacht.
  if (soilIsDry(soilRaw)) {
    setPump(true);
    pumpStartedAtMs = nowMs;
  }
}

static void updateDisplay() {
#if USE_LCD
  DateTime now = nowDateTime();
  int dayNo = growthDayNumber();

  char line1[17];
  char line2[17];

  snprintf(line1, sizeof(line1), "%04u-%02u-%02u",
           (unsigned)now.year(), (unsigned)now.month(), (unsigned)now.day());

  // 1602 ist eng; kurze Anzeige (Englisch) ist robust.
  // Beispiel: "Day 12 D 4.8"
  if (!isnan(distCm)) {
    snprintf(line2, sizeof(line2), "Day %d D%2d.%1d",
             dayNo, (int)distCm, (int)((distCm - (int)distCm) * 10.0f));
  } else {
    snprintf(line2, sizeof(line2), "Day %d L%4d", dayNo, ldrRaw);
  }

  lcd.setCursor(0, 0);
  lcd.print(line1);
  for (uint8_t i = strlen(line1); i < 16; i++) lcd.print(' ');

  lcd.setCursor(0, 1);
  lcd.print(line2);
  for (uint8_t i = strlen(line2); i < 16; i++) lcd.print(' ');
#endif
}

static void handleResetButton() {
  static bool lastPressed = false;
  static unsigned long pressedAt = 0;

  bool pressed = (digitalRead(PIN_RESET_BTN) == LOW);
  unsigned long nowMs = millis();

  if (pressed && !lastPressed) {
    pressedAt = nowMs;
  }
  if (!pressed && lastPressed) {
    pressedAt = 0;
  }
  lastPressed = pressed;

  if (pressed && pressedAt != 0 && (nowMs - pressedAt >= 3000UL)) {
    resetGrowthStartToToday();
    pressedAt = 0;
  }
}

void setup() {
  pinMode(PIN_PUMP, OUTPUT);
  pinMode(PIN_GROW_LIGHT, OUTPUT);
  pinMode(PIN_AMBIENT, OUTPUT);
  pinMode(PIN_READY_LED, OUTPUT);
  pinMode(PIN_RESET_BTN, INPUT_PULLUP);

  setPump(false);
  setGrowLight(false);
  setAmbient(false);
  digitalWrite(PIN_READY_LED, LOW);

  if (ENABLE_SERIAL) {
    Serial.begin(115200);
    delay(200);
    Serial.println(F("CPS Smart Seedling House booting..."));
  }

#if USE_RTC
  Wire.begin();
  if (!rtc.begin()) {
    if (ENABLE_SERIAL) Serial.println(F("RTC not found."));
  } else {
    // Wenn RTC Strom verloren hat: einmalig auf Compile‑Zeit stellen
    if (rtc.lostPower()) {
      rtc.adjust(DateTime(F(__DATE__), F(__TIME__)));
      if (ENABLE_SERIAL) Serial.println(F("RTC adjusted to compile time."));
    }
  }
#endif

#if USE_LCD
  lcd.init();
  lcd.backlight();
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("CPS Seedling");
  lcd.setCursor(0, 1);
  lcd.print("Initializing");
#endif

#if USE_DHT
  dht.begin();
#endif

#if USE_DFPLAYER
  dfSerial.begin(9600);
  if (!dfPlayer.begin(dfSerial)) {
    if (ENABLE_SERIAL) Serial.println(F("DFPlayer init failed."));
  } else {
    dfPlayer.volume(22); // 0..30
  }
#endif

  persistLoadOrInit();
  lastPumpFinishedAtMs = 0;
}

void loop() {
  unsigned long nowMs = millis();

  handleResetButton();

  if (nowMs - lastSensorReadMs >= 1000UL) {
    lastSensorReadMs = nowMs;
    readSensors();
  }

  if (nowMs - lastControlMs >= 300UL) {
    lastControlMs = nowMs;
    updateControl();
  }

  if (nowMs - lastDisplayMs >= 1000UL) {
    lastDisplayMs = nowMs;
    updateDisplay();
  }

  if (nowMs - lastGreetCheckMs >= 1000UL) {
    lastGreetCheckMs = nowMs;
    checkAndGreet();
  }
}
