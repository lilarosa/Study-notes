public class Hauptprogramm {
public static void main(String[] args) {
    // Erstellen eines Auto-Objekts
    Auto meinAuto = new Auto();
    
    // Zuweisen von Werten zu den Attributen des Auto-Objekts
    //meinAuto.name = "Golf";
    meinAuto.setName("Golf"); // Verwendung der setName-Methode, um den Namen zu setzen
    meinAuto.setFarbe("Rot"); // Verwendung der setFarbe-Methode, um die Farbe zu setzen
    meinAuto.setPs(150); // Verwendung der setPs-Methode, um die PS zu setzen
    meinAuto.setHubraum(2.0); // Verwendung der setHubraum-Methode, um den Hubraum zu setzen

    Auto auto2 = new Auto();
    auto2.setName("Polo");
    auto2.setFarbe("Blau");
    auto2.setPs(100);
    auto2.setHubraum(1.4);
    
    // Ausgabe der Informationen des Autos
    System.out.println("Name: " + meinAuto.getName());
    System.out.println("Farbe: " + meinAuto.getFarbe());
    System.out.println("PS: " + meinAuto.getPs());
    System.out.println("Hubraum: " + meinAuto.getHubraum());
    System.out.println("Name: " + auto2.getName());
    System.out.println("Farbe: " + auto2.getFarbe());
    System.out.println("PS: " + auto2.getPs());
    System.out.println("Hubraum: " + auto2.getHubraum());
}
}
