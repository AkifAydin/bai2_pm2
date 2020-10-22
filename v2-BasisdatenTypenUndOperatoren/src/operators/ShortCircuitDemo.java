package operators;

import static util.Printer.print;

public class ShortCircuitDemo {
    public static void main(String[] args) {
        // short-circuit Operatoren vermeiden Fehler
        // der zweite logische Ausdruck wird nur ausgewertet,
        // wenn iObj != null ist. Da null kein Typ ist, liefert der Versuch
        // eine Methode auf null anzuwenden immer einen Laufzeitfehler
        Integer iObj = null;
        if ((iObj != null) && (iObj.intValue() > 0)) {
            doSomething();
        }
        // der zweite Ausdruck wird immer ausgewertet
        if ((iObj != null) & (iObj.intValue() > 0)) {
            doSomething();
        }
        // short-circuit Operatoren vermeiden ueberfluessige Auswertungen
        //  Ist b <= 1, dann macht es keinen Sinn die zweite Bdg.
        // auszuwerten.
        int b = 0;
        if ((1 < b) && (b < 10)) print(b);
    }

    private static void doSomething() {
        System.out.println("do something");
    }

}
