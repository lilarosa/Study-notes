package variablen_datentypen_operatoren;

public class Operatoren {

	public static void main(String[] args) {
		
		// arithmetischen Operatoren auf ganze Zahlen
       int x = 1;
       int y = 2;
       int z = x+y;
       System.out.println("Addition x und y: " + z);
       
       int differenz = x-y;
       System.out.println("Differenz x  und y: " + differenz);
       
       int produkt = x*y;
       System.out.println("produkt x  und y: " + produkt);
       
       int quotient = x/y;
       System.out.println("quotient x  und y: " + quotient);
       
       //modulo Operator
       
       int d = 25;
       int e = 12;
       int division= d / e; // 2
       int rest = d % e ; //1
       System.out.println("die Division von " + d + " und " + e + " ergibt:" + division + " Rest " + rest);
       
       // Inkrement- / Dekrementoperator
       
       int inkr = 10;
       System.out.println(inkr++); //10 
       System.out.println(inkr); //11
       
       int inkr2 = 10;
       System.out.println(++inkr2); //11
       
       
	}

}
