package controlflow;

import static util.Printer.printf;

/**
 * @author birgit
 * Berechnung des groessten gemeinsamen Teilers nach Euklid
 */
public class EuklidGGT {
    /**
     * main Methode
     *
     * @param args Parameter beim Programmaufruf
     */
    public static void main(String[] args) {
        int m = 27;
        int n = 18;
        int mcp = m;
        int ncp = n;
        int r = m % n;

        while (r > 0) {
            m = n; // kleinere Zahl
            n = r; // Rest
            r = m % n;
        }
        printf("GGT von %d und %d ist " + "%d%n", mcp, ncp, n);

    }


}
