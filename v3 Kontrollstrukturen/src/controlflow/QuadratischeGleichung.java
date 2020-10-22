package controlflow;

import static util.Printer.print;
import static util.Printer.printf;

public class QuadratischeGleichung {

    public static void main(String[] args) {
        double a = 1, b = 1, c = 1;
        // b=2 1 Lsg, , b=3 2 Lsgen
        double d = b * b - 4 * a * c;
        if (d < 0) {
            print("keine Lösung");
        } else if (d == 0)
            printf("1 Lösung  : " + "%g%n ", -b / (2 * a));
        else
            printf("2 Lösungen: %g,"
                            + " %g%n ",
                    (-b + Math.sqrt(d)) / (2 * a),
                    (-b - Math.sqrt(d)) / (2 * a));
    }
}
