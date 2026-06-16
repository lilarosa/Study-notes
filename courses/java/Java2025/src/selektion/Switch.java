package selektion;

public class Switch {

	public static void main(String[] args) {
		int note = 3; // Order durch Benutzereingabe
		
		/*if(note == 1)
			System.out.println("Sehr gut");
		else if(note == 2)
			System.out.println("gut");
		else if(note == 3)
			System.out.println("befriedigend");
		*/
		
		switch(note){	
		case 1:
			System.out.println("Sehr gut");
			break;
		case 2:	
			System.out.println("gut");
			break;
		case 3:	
			System.out.println("befriedigend");
			break;
		case 4:
			System.out.println("ausreichend");
			break;
		case 5:
			System.out.println("mangelhalft");
			break;
		case 6:
			System.out.println("ungenugend");
			break;
			default:
			System.out.println("Fehler");
				
				
		}
		

}
}
