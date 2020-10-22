package controlflow;

import static util.Printer.print;

public class ListeKleinBuchstaben {

    public static void main(String[] args) {

        for (char c = 0; c < 128; c++) { // c lokale Variable der
            // for Schleife
            if (Character.isLowerCase(c))
                print("Ascii " + (int) c + " Zeichen " + c);
        }

        // print(" Zeichen " + c); // c ist nicht definiert
    }

    public static void alternative1() {

        char c = 0;
        for (; c < 128; c = (char) (c + 1)) { // Initial. leer,
            if (Character.isLowerCase(c))
                print("Ascii " + (int) c + " Zeichen " + c);
        }

        print("Ascii " + (int) c + " Zeichen " + c);
        // c definiert und modifiziert
    }

    public static void alternative2() {
        char c = 0;  // entspricht a
        for (; ; ) { // alle Ausdrücke sind leer.
            if (c >= 128)
                break;
            if (Character.isLowerCase(c))
                print("Ascii " + (int) c + " Zeichen " + c);
            c = (char) (c + 1);
        }

    }

}