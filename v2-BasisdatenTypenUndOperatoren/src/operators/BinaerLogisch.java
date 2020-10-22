package operators;

import static util.Printer.print;

public class BinaerLogisch {

    public static void main(String[] args) {

        boolean y1 = true, y2 = false;
        int x = 7;
        //y1 = 0 && 15 || x;   // Fehler keine logischen Operatoren auf Zahlen
        x = 0 & 15 | x;        // ok
        y1 = y1 || y2;       // ok
        y1 = y1 & y2;        // ok
        print(y1);
    }

}
