package selektion;

import java.util.Scanner;

public class AlterTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Bitte alter eingeben: ");
		int alter = scan.nextInt();
		
		String zutritt = alter<16 ? "Zutritt verweigert": (alter < 18  ? "Zutritt bis 22 Uhr"  : "Zutritt bis 24 Uhr");
		System.out.println(zutritt);
		scan.close();
		
		// 三元表达式， 只有一个判断条件，判断为真，执行第一个，判断为假执行第二个-如果多个判断，可以用嵌套方式。如果条件很多，用if else

	}

}
