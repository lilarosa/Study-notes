package iteration;

import java.util.Scanner;

public class EinOrderZweiTest {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int zahl;
        int maxVersuche = 3; // 总共机会 3 次

        for (int i = 1; i <= maxVersuche; i++) {
            System.out.println("Wählen Sie Zahl (1/2):");
            zahl = input.nextInt();

            if (zahl == 1 || zahl == 2) {
                System.out.println("Sie haben Zahl " + zahl + " gewählt");
                break; // 正确输入 → 提前结束
            } else {
                if (i == maxVersuche) {
                    System.out.println("Fehler eingeben");
                    System.out.println("Game Over!");
                } else {
                    int rest = maxVersuche - i;
                    System.out.println("Fehler! Sie haben nur " + rest + " Mal Chancen.");
                }
            }
        }

        input.close();
    }
}