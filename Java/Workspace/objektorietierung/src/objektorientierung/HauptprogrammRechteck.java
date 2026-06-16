package objektorientierung;

public class HauptprogrammRechteck {

	public static void main(String[] args) {
		//Objekt mit dem Konstruktor erzeugen
				Rechteck rechteck1 = new Rechteck();
				rechteck1.setSeiteAB(4.0, 5.0);
				rechteck1.showFlaeche();
				
				Rechteck rechteck2 = new Rechteck(3.4, 5.6);
				rechteck2.showFlaeche("Die Flache von rechteck2 ist: ");
	}

}
