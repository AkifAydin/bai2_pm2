package console;

import java.util.Scanner;

public class ReadWithScanner {

    public static void main(String[] args) {
        //readLinesWithScanner();
        //readAndTestTypeWithScanner();
        //readCsv();
        readChars();
    }


    private static void readLinesWithScanner() {
        Scanner sc = new Scanner(System.in);

        // Um in der Konsole das Ende der Eingabe zu markieren muss ^D (Windows)
        // ^Z(Linux) eingegeben werden
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if ("exit".equals(line)) break;
            System.out.println(line);
        }
        sc.close();
        System.out.println("bye");
    }

    private static void readAndTestTypeWithScanner() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // prüft auf long
            if (sc.hasNextLong()) {
                long l = sc.nextLong();
                System.out.println("long " + l);
            }
            // Prüft, ob noch eine Eingabe vorhanden ist
            else if (sc.hasNext()) {
                // Liest die Eingabe bis zum nächsten Trennzeichen
                // Der Default für Trennzeichen sind die Leerzeichen
                String s = sc.next();
                System.out.println("next is " + s);
                if ("exit".equals(s)) break;
            }
        }
        sc.close();
        System.out.println("bis bald");
    }

    // Lesen von Komma-Separierten Eingaben
    private static void readCsv() {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(","); // Trennzeichen für das Einlesen von Kommasepararierten Eingabe
        // Um in der Konsole das Ende der Eingabe zu markieren muss ^D (Windows)
        // ^Z(Linux) eingegeben werden
        // Gibt es noch ein weiteres Trennzeichen in der Eingabe
        while (sc.hasNext()) {
            // Lies die Zeichenkette bis zum nächsten Trennzeichen und gebe diese aus
            System.out.println(sc.next());
        }
    }

    // Zeichen lesen
    private static void readChars() {
        // Exakt müsste es Einzeichenketten lesen heißen
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("");
        // Um in der Konsole das Ende der Eingabe zu markieren muss ^D (Windows)
        // ^Z(Linux) eingegeben werden
        while (sc.hasNext()) {
            String c = sc.next();
            // Test auf Zeilenumbruch
            if (c.charAt(0) == '\n' || c.charAt(0) == '\r') {
                System.out.println("X");
            } else {
                System.out.println(c);
            }
        }
    }
}
