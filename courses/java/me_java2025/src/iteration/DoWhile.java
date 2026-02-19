package iteration;

public class DoWhile {

	public static void main(String[] args) {
		
		System.out.println("Schleife 1: ");
		int x = 6;
		
		do {
			System.out.println(x);
			x++;
		}
		while(x <= 10);
		
		System.out.println("Schleife 2: ");
		int y = 6;
		do {
			System.out.println(y);
			y++;
			
		}
		while (y <= 5);
		
		System.out.println("Schleife 3: ");
		int k = 6;
		do {
			System.out.println(k-3);
			k++;
			
		}
		while (k <= 13);
		
		System.out.println("Schleife 4: ");
		int z = 10;
		do {
			System.out.println(z);
			z--;
			
		}
		while (z >= 3);
	}
	

}
