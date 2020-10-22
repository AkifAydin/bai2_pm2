package controlflow;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EingabeVerarbeitungMitBreakUndContinue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long start = System.currentTimeMillis();
        long end;
        Set<Integer> geradeZahlen = new HashSet<>();
        System.out.println("Geben Sie möglichst viele unterschiedliche gerade Zahlen ein!");
        while (true) {
            end = System.currentTimeMillis();
            // Bedingung, die die Schleife beendet
            if ((end - start) > 30000)
                break;
            if (scanner.hasNextInt()) {
                int zahl = scanner.nextInt();
                if (zahl % 2 != 0) {
                    System.out.printf("Die Zahl %d ist nicht durch 2 teilbar! Nächster Versuch!%n", zahl);
                    // Mit dem nächsten Schleifendurchlauf starten
                    continue;
                }
                if (!geradeZahlen.add(zahl)) {
                    System.out.printf("%d leider schon vorhanden! Nächster Versuch!%n", zahl);
                    continue;
                }
                System.out.printf("Toll! %d ist eine neue gerade Zahl.%n", zahl);
                System.out.printf("Sie haben %d gerade Zahlen in %.3f Sekunden eingegeben%n", geradeZahlen.size(), (end - start) / 1000.0);
            } else {
                System.out.println("Die Eingabe ist keine ganze Zahl! Nächster Versuch!");
                // Eingabe lesen und ignorieren
                scanner.next();
            }
        }
    }
}
