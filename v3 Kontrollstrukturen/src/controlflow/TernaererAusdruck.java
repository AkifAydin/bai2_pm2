package controlflow;

public class TernaererAusdruck {

    /**
     * Methode berechnet den Betrag einer Zahl
     * mithilfe eines ternären Ausdrucks
     *
     * @param x, Zahl
     * @return Betrag von x
     */
    public static double abs(double x) {
        return x >= 0 ? x : -x;
    }
}
