package selektion;

import java.util.Scanner;

public class AlterZutritt {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Bitte alter eingeben: ");
		int alter = scan.nextInt();
		
		if(alter < 16) {
			System.out.println("Zutritt verweigert");
		}
		else if(alter < 18){
			System.out.println("Zutritt bis 24 Uhr");
		}
		else {
			System.out.println("Zutritt openend");
		}
          scan.close();
	}
		

	}


