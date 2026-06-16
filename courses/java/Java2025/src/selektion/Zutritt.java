package selektion;

import java.util.Scanner;

public class Zutritt {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Wie alt bist du?");
		int alter = sc.nextInt();
		
		if (alter<16) {
			
			System.out.println("Zutritt verweigert.");
		} else {
			if (alter<18) {
			System.out.println("Zutritt bis 24 Uhr.");
			} else {System.out.println("Zutritt open end.");
		}
		

	}
        sc.close();
}
}
