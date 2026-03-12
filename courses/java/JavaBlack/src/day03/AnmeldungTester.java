package day03;

import java.util.Scanner;

public class AnmeldungTester {

    public static void main(String[] args) {
        String benutzername = "admin";
        String passwort = "1234";
        int versuche = 0;

        Scanner scanner = new Scanner(System.in);

        while (versuche < 3) {
            System.out.println("Geben Sie Ihren Benutzernamen ein:");
            String inputBenutzername = scanner.nextLine();

            System.out.println("Geben Sie Ihr Passwort ein:");
            String inputPasswort = scanner.nextLine();

            if (inputBenutzername.equals(benutzername) && inputPasswort.equals(passwort)) {
                System.out.println("Anmeldung erfolgreich!");
                scanner.close();
                return;
            }

            System.out.println("Falscher Benutzername oder Passwort. Versuchen Sie es erneut.");
            versuche++;
        }

        System.out.println("Zu viele Fehlversuche. Zugriff gesperrt.");
        scanner.close();
    }
}