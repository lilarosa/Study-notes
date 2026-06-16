package selektion;

import java.util.Scanner;

public class ZahlInfo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("ZahlInfo");
		System.out.println("Zahl:");
		int zahl = input. nextInt();
		if (zahl<0 && zahl%2 ==0) {
			System.out.println("Eingegebene Zahl ist kleiner 0 und gerade ");
			
		}
		else if (zahl<0 && zahl%2 ==1) {
			System.out.println("Eingegebene Zahl ist kleiner 0 und ungerade ");
		}
		else if (zahl>0 && zahl%2 ==0) {
			System.out.println("Eingegebene Zahl ist größer 0 und gerade ");
		}
		else if (zahl>0 && zahl%2 ==1) {
			System.out.println("Eingegebene Zahl ist größer 0 und ungerade ");
		}
		else 
			
			System.out.println("Eingegebene Zahl ist 0");
		   input.close();

	}

}
