package variablen_datentypen_operatoren;

public class CastOperator {

	public static void main(String[] args) {
      
		byte b = 10;
		char c = 'a'; //Unicodezeichen
		long l;
		double d;
		
		// implizite Umwandlung
		l = b;
		l = c; // Umwandlung eines Zeichens in eine Zahl -> Unicode des Zeichens wird vwewendet
	    System.out.println(l);
	    
	    d = b; //10.0
	    d = c; //97.0
	    System.out.println(d);
	    
	    //z = d; Fehlermeldung: double kann nicht in long gespeichert werden
	    
	    //explizite Umwandlung
	    b = (byte)l;
	    l = (long) d; // Datenverlust : alles nack dem Lomma wird abgeschnitten
	    System.out.println("b = " + b + ",c = " + c + ",l = " + l);
	    
	    d= 80000;
	    c=(char)d; 
	    System.out.println(c);
	    
	    
	    
	    
	    
		
	}

}
