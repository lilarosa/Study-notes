package objektorientierung;

public class Hauptprogramm {

	public static void main(String[] args) {
		//Objekte der Klasse Auto
				Auto auto1 = new Auto();  //neues Objekt er den Konstruktor
				auto1.setName("Lotus");
				auto1.setFarbe("orange");
				auto1.setPs(250);
				auto1.setHubraum(5.4);
			
				Auto auto2 = new Auto();
				auto2.setName("Spider XL");
				auto2.setFarbe("grau");
				auto2.setPs(300);
				auto2.setHubraum(5.1);

				
				System.out.println("ein Auto: ");
				System.out.println("Farbe:" + auto2.getFarbe());
				
	}

}
